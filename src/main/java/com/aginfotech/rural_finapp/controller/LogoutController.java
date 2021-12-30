package com.aginfotech.rural_finapp.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/signout")
public class LogoutController {

	@GetMapping
	public String logout(HttpSession session) {
		SecurityContextHolder.clearContext();
		if (session != null)
			session.invalidate();
		return "redirect:/";
	}
}
