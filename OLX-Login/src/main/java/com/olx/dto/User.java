package com.olx.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data

@ApiModel(value = "Stock dto")
public class User {
	@ApiModelProperty(value = " User  first Name ")

	private String fName;
	@ApiModelProperty(value = " User  last Name ")

	private String lName;
	@ApiModelProperty(value = " User  uname ")

	private String userName;
	@ApiModelProperty(value = " User  password")

	private String pass;
	@ApiModelProperty(value = " User  email id ")

	private String email;
	@ApiModelProperty(value = " User  phone number ")

	private long phoneNum;
}
