package com.xl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
@EnableConfigurationProperties({Evn.class})
@RefreshScope
public class SpringCloudConfigClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringCloudConfigClientApplication.class, args);
    }

    @Value("${env.name}")
    String foo;

    @Autowired
    Evn evn;

    @RequestMapping(value = "/hello")
    public String hi(){
        return "sdfdsfd"+foo;
    }

    @RequestMapping(value = "/hi")
    public String hii(){
        String str = evn.getName()+evn.getPassword();
        return str;
    }

}
