package com.sam09.roleeditor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(basePackages = {
		"com.sam09.roleeditor.openapi",
		"com.sam09.roleeditor"
})
public class RoleEditorApplication {

	public static void main(String[] args) {
		SpringApplication.run(RoleEditorApplication.class, args);
	}

}
