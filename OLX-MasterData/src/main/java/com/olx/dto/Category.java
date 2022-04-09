package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@ApiModel(value = "Stock dto")
public class Category {
    @ApiModelProperty(value = " Cateogory Id ")

    private int id;
    @ApiModelProperty(value = " cateogry name ")

    private String categoryName;
}
