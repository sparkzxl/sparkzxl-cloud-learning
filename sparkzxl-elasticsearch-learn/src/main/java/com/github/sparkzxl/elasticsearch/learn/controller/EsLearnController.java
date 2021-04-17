package com.github.sparkzxl.elasticsearch.learn.controller;

import cn.hutool.core.lang.Snowflake;
import cn.hutool.core.util.IdUtil;
import cn.hutool.extra.pinyin.PinyinUtil;
import com.github.javafaker.Faker;
import com.github.sparkzxl.core.annotation.ResponseResult;
import com.github.sparkzxl.core.utils.ListUtils;
import com.github.sparkzxl.elasticsearch.contants.BaseElasticsearchConstant;
import com.github.sparkzxl.elasticsearch.learn.entity.UserBasicInfo;
import com.github.sparkzxl.elasticsearch.learn.service.IEsUserBasicInfoService;
import com.github.sparkzxl.log.annotation.WebLog;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;

/**
 * description: es管理
 *
 * @author zhouxinlei
 * @date 2021-04-17 14:29:15
 */
@ResponseResult
@WebLog
@RequestMapping("elasticsearch")
@RestController
@Api(tags = "es curd管理")
public class EsLearnController {

    @Autowired
    private IEsUserBasicInfoService esUserBasicInfoService;

    @ApiOperation("保存")
    @PostMapping("/save")
    public boolean saveUserInfo() {
        Faker fakerWithCN = new Faker(Locale.CHINA);
        List<UserBasicInfo> userBasicInfoList = new ArrayList<>();
        Snowflake snowflake = IdUtil.getSnowflake(0, 10);
        for (int i = 0; i < 100; i++) {
            String name = fakerWithCN.name().fullName();
            UserBasicInfo userBasicInfo = new UserBasicInfo();
            userBasicInfo.setName(name);
            String pinyin = StringUtils.deleteWhitespace(PinyinUtil.getPinyin(name));
            userBasicInfo.setAccount(pinyin);
            userBasicInfo.setId(snowflake.nextId());
            userBasicInfoList.add(userBasicInfo);
        }
        return esUserBasicInfoService.saveDocBatch("user_basic_info", userBasicInfoList);
    }

    @ApiOperation("更新")
    @PutMapping("/update")
    public boolean updateUserInfo(@RequestBody UserBasicInfo userBasicInfo) {
        return esUserBasicInfoService.updateDoc("user_basic_info", userBasicInfo.getId().toString(), userBasicInfo);
    }

    @ApiOperation("删除")
    @DeleteMapping("/delete")
    public boolean deleteUserInfo(@RequestParam("id") String id) {
        return esUserBasicInfoService.deleteDocById("user_basic_info", id);
    }

    @ApiOperation("查询")
    @GetMapping("/get")
    public UserBasicInfo getUserInfo(@RequestParam("id") String id) {
        return esUserBasicInfoService.searchDocById("user_basic_info", id, UserBasicInfo.class);
    }

    @ApiOperation("分组查询")
    @GetMapping("/group")
    public Map<String, List<UserBasicInfo>> getUserInfoGroup(@RequestParam("ids") String ids) {
        List<String> idList = ListUtils.stringToList(ids);
        return esUserBasicInfoService.searchDocsMapByIdList("user_basic_info", idList, UserBasicInfo.class);
    }

    @ApiOperation("根据字段分组查询")
    @GetMapping("/groupByField")
    public Map<String, List<UserBasicInfo>> groupByField(@RequestParam("ids") String ids, @RequestParam("field") String field) {
        List<String> idList = ListUtils.stringToList(ids);
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        searchSourceBuilder.query(QueryBuilders.termsQuery(BaseElasticsearchConstant.ES_ID, idList));
        return esUserBasicInfoService.searchDocsGroupMap("user_basic_info", searchSourceBuilder, field, UserBasicInfo.class);
    }

    @ApiOperation("全部")
    @GetMapping("/listAll")
    public List<UserBasicInfo> getUserInfoList() {
        return esUserBasicInfoService.searchAllDoc("user_basic_info", UserBasicInfo.class);
    }

}
