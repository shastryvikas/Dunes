package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class homeController {
	
	@RequestMapping("home")
	public String home() {
		
		System.out.print("hi");
		
		return "allUserLogin.jsp";
	}
}
