package com.github.sparkzxl.product.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * description:
 *
 * @author zhouxinlei
 * @date 2021-04-05 17:28:58
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class ProductDto implements Serializable {

    private static final long serialVersionUID = 2608504049640451810L;
    
    private Long id;

    private String name;

    private Integer stock;


}
