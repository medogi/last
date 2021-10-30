package com.example.demo;

import org.hibernate.Session;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {


		SpringApplication.run(DemoApplication.class, args);
		meow();



	}


public static void meow(){
	System.out.println("meow mewo");
}

}
