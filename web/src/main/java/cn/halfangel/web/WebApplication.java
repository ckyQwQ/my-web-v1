package cn.halfangel.web;

import cn.halfangel.rpc.TestApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan("cn.halfangel.rpc")
@ComponentScan("cn.halfangel.mq")
@SpringBootApplication
public class WebApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(WebApplication.class, args);
        TestApplication t = context.getBean(TestApplication.class);
        t.start();
    }
}
