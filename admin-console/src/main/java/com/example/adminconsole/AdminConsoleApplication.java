package com.example.adminconsole;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({
        "org.ff4j.aop",
        "com.example.adminconsole"
})
public class AdminConsoleApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminConsoleApplication.class, args);
    }

}
