package com.springboot.app.ams;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.File;

import com.springboot.app.ams.controllers.ArticleController;
@SpringBootApplication
public class Workshop2Application {

	public static void main(String[] args) {
		new File(ArticleController.uploadDirectory).mkdir();
		SpringApplication.run(Workshop2Application.class, args);
		System.out.println("Spring boot MVC JPA layer");
	}

}
