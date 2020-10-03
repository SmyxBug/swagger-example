package com.swagger.controller;

import com.swagger.models.UserEntity;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

@Api(tags = "用户管理请求入口")
@RestController
@RequestMapping("/user")
public class UserController {

    @ApiOperation("创建用户")
    @PostMapping
    public UserEntity create(@RequestBody UserEntity userEntity) {
        return userEntity;
    }

    @ApiOperation("根据用户id查看指定用户详细信息")
    @GetMapping("/users/{id}")
    public UserEntity findById(@PathVariable Long id) {
        return new UserEntity(id.intValue(), "呵呵", 20, "男", "上海市浦东新区");
    }

    @ApiOperation("根据用户类型和手机号获取用户名")
    @ApiImplicitParams({
            // 其余属性并无他用需要自行Google或者查看相关api文档
            @ApiImplicitParam(name = "type", value = "用户类型"),
            @ApiImplicitParam(name = "cellphone", value = "手机号码")
    })
    @PostMapping("/getUserName")
    public String getUserName(String type, String cellphone) {
        return "smyx";
    }

}
