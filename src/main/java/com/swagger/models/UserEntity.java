package com.swagger.models;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("用户基本信息")
public class UserEntity {

    @ApiModelProperty("用户唯一ID")
    private Integer id;

    @ApiModelProperty("姓名")
    private String username;

    @ApiModelProperty("年龄")
    private Integer age;

    @ApiModelProperty("性别> 0:女 1:男")
    private String sex;

    @ApiModelProperty("地址")
    private String address;

}
