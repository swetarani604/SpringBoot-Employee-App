package com.cg.SpringJPASample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("com.cg.SpringJPASample.bean")
@ComponentScan("com.cg.SpringJPASample")
@EnableJpaRepositories("com.cg.SpringJPASample")
@SpringBootApplication
public class SpringJpaSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJpaSampleApplication.class, args);
	}
}
