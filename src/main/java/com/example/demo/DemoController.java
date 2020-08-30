package com.example.demo;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class DemoController {
    @Value("${message}")
    private String message;

    @GetMapping("get")
   public String get() {
      return message;
   }

	@RequestMapping("/")
	public String index() {
		return message;
	}

}
