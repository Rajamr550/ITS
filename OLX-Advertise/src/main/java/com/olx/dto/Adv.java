package com.olx.dto;

import java.time.LocalDate;

import javax.persistence.Column;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@ApiModel(value = "Adv Dto")
public class Adv {
    private int id;
    private String title;
    private String description;
    private int price;
    private int category;
    private LocalDate createdDate;
    private LocalDate modifiedDate;
    private String active;
    private String username;

//    @ApiModelProperty(value = " Ad Title ")
//
//    private String title;
//    @ApiModelProperty(value = " Ad price ")
//
//    private int price;
//    @ApiModelProperty(value = " Ad Id ")
//
//    private int id;
//    @ApiModelProperty(value = " Ad Description ")
//
//    private String description;
}
