package com.example.demo;

import com.example.demo.conttoller.Controller;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext contex = SpringApplication.run(DemoApplication.class, args);
		MyRepository bean = contex.getBean(MyRepository.class);



		Controller c=new Controller(bean );

	}

}
