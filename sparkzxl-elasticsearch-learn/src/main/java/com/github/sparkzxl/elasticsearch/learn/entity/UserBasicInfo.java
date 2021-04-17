package com.github.sparkzxl.elasticsearch.learn.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * description:用户信息
 *
 * @author zhouxinlei
 * @date 2021-04-17 14:26:41
 */
@Data
@ApiModel("用户信息")
public class UserBasicInfo implements Serializable {

    private static final long serialVersionUID = 7803928709677328182L;

    @ApiModelProperty(value = "主键")
    private Long id;

    @ApiModelProperty(value = "账号")
    private String account;

    @ApiModelProperty(value = "姓名")
    private String name;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "上级id")
    private long superiorId;

}
