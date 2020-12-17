package com.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value = "person", description = "人")
public class Person {
    @ApiModelProperty("姓名")
    private String name;
    @ApiModelProperty("年龄")
    private Integer age;
    @ApiModelProperty("性别")
    private String gender;
    @ApiModelProperty("公司")
    private String company;
}
