package com.github.sparkzxl.order.infrastructure.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author zhouxinlei
 * @since 2020-12-07
 */
@Data
@EqualsAndHashCode(callSuper = false)
@TableName("orders")
@ApiModel(value="Orders对象", description="")
public class Orders implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private Integer userId;

    @TableField("product_id")
    private Integer productId;

    @TableField("pay_amount")
    private BigDecimal payAmount;

    @TableField("add_time")
    private LocalDateTime addTime;

    @TableField("last_update_time")
    private LocalDateTime lastUpdateTime;


}
