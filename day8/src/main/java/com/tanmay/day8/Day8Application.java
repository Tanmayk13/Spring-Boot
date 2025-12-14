package com.tanmay.day8;

import com.tanmay.day8.config.JWTUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Day8Application {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Day8Application.class, args);
        JWTUtils jwtUtils = context.getBean(JWTUtils.class);

        String token = jwtUtils.generateToken("Tanmay");

        System.out.println(token);
        System.out.println(jwtUtils.extractUserName(token));
        System.out.println(jwtUtils.isTokenValid(token));
	}

}
