package org.jt.studentManagementSystem.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {
    @Bean
    OpenAPI openAPI() {// Here we create an object of openApi class.
       /* var info=new Info();
        info.setTitle("Student Management System");
        info.setDescription("Manage Student Recodrd");
        info.setVersion("v2");*/
        return new OpenAPI().info(getInfo());
    }
    private Info getInfo(){
        var info=new Info();
        info.setTitle("Student Management System");
        info.setDescription("Manage Student Recodrd");
        info.setVersion("v2");
        return info;
    }

}
