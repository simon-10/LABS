package edu.mum.cs.cs425.demos.elibrary_springsec_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
//@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class ElibrarySpringsec1Application {

    public static void main(String[] args) {
        SpringApplication.run(ElibrarySpringsec1Application.class, args);
    }

}
