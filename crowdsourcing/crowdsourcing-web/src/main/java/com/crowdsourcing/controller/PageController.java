package com.crowdsourcing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String welcomePage() {
		return "index";
	}
	
	@RequestMapping("/unauthorized")
	public String unauthorizedPage(Model model) {
		model.addAttribute("errorInfo", "未授权");
		return "failure";
	}
	
	@RequestMapping("/404")
	public String notFoundPage() {
		return "error/404";
	}
	
	@RequestMapping("/405")
	public String incorrectRequestPage() {
		return "error/405";
	}
	
	@RequestMapping("/500")
	public String ExceptionPage() {
		return "error/500";
	}
	
}
