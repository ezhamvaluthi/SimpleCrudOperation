package com.application.crud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
public class CrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudApplication.class, args);
	}
        
        @Controller
        	public class IndexController {
		@RequestMapping("/")
		public String webmvc(){
		  return "forward:/index.html";			
		}
	}

}
