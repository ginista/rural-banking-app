package com.aginfotech.rural_finapp.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.aginfotech.rural_finapp.model.Customer;

@Controller
public class HomeController {

	@GetMapping("/login")
	public String login(){
		return "login";
	}
	@GetMapping("/contactus")
	public String contactus(){
		return "contactus";
	}

	@PreAuthorize("hasRole('ROLE_group1')")
	@GetMapping("/")
	public String home() {
		return "home";
	}



	@PreAuthorize("hasRole('ROLE_group1')")
	@GetMapping("customer/search")
	public String searchCustomer() {
		return "customer/search";
	}

	@PreAuthorize("hasRole('ROLE_group1')")
	@GetMapping("customer/add")
	public String addCustomerForm(Model model) {
		model.addAttribute("newCustomer", new Customer());
		return "customer/add";
	}

}
