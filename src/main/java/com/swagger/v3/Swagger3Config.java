package com.swagger.v3;

import io.swagger.annotations.ApiOperation;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class Swagger3Config {

    @Resource
    Environment environment;

    @Bean
    public Docket createRestApi() {
        // 获取全局的环境变量判别是在哪个环境
        Profiles profiles = Profiles.of("prod");
        boolean isAccept = environment.acceptsProfiles(profiles);
        // 配置每个请求的全局属性 例如：header 参数里面放置token等
        List<RequestParameter> params = new ArrayList<>();
        RequestParameter token = new RequestParameterBuilder().name("token")
                .description("全局token,请求header必带")
                .in(ParameterType.HEADER)
                .required(true)
                .build();
        params.add(token);
        return new Docket(DocumentationType.OAS_30)
//                .ignoredParameterTypes(Integer.class, Long.class) // 忽略展示部分参数
                .enable(!isAccept) // 配置是否可以浏览器访问接口信息 一般通过SpringBoot yml 文件去判定当前在扫描环境下
                .apiInfo(apiInfo())
                .globalRequestParameters(params)
                .select()
                .apis(RequestHandlerSelectors.withMethodAnnotation(ApiOperation.class)) // 扫描策略：只扫描带有ApiOperation注解的方法 PS：扫描策略有很多自己去Google或者查看相关api文档
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("smyx接口文档")
                .description("这是smyx项目的接口文档,如有需要请联系smyx!!!")
                .contact(new Contact("smyx", "http::localhost:8080", "itchagelives@126.com"))
                .version("1.0.0")
                .build();
    }

    /**
     * swagger请求分组的写法
     * 其实就是配置多个bean一个bean处理一个组别
     */
//    @Bean
//    public Docket userDocket() {
//        Profiles profiles = Profiles.of("prod");
//        boolean isAccept = environment.acceptsProfiles(profiles);
//        return new Docket(DocumentationType.OAS_30)
//                .enable(!isAccept)
//                .apiInfo(apiInfo())
//                .groupName("用户请求模块")
//                .select()
//                .paths(PathSelectors.ant("/user"))
//                .build();
//    }
}
