package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	@Value("${message}")
    private String message;

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@GetMapping("get")
   public String get() {
      return message;
   }

   public void run(String... varl) throws Exception {
      System.out.println(String.format("\nMessage:\n%s\n",message));
   }

}
