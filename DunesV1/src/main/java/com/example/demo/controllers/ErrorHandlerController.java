package com.example.demo.controllers;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ErrorHandlerController implements ErrorController{

	@RequestMapping("/error")
	@ResponseBody
	public ModelAndView getErrorPath() {
		ModelAndView mv = new ModelAndView("error.jsp");
		return mv;
	}
	
}
