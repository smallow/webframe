package com.smallow.webframe;

import tk.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


//注意这里的MapperScan一定要用tk的不能用org的
@SpringBootApplication
@MapperScan("com.smallow.webframe.modular.*.mapper")
@ComponentScan(basePackages = {"com.smallow.webframe", "org.n3r.idworker"})
public class SpringbootWebframeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootWebframeApplication.class, args);
    }
}
