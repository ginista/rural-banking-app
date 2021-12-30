package com.aginfotech.rural_finapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.aginfotech.rural_finapp.model.Customer;
import com.aginfotech.rural_finapp.services.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

	@Autowired
	CustomerService customerService;

	// Add New Customer
	@PreAuthorize("hasRole('ROLE_group1')")
	@PostMapping
	public String addCustomer(@ModelAttribute("newCustomer") Customer customer, RedirectAttributes rattrs,
			ModelMap model) {
		Customer result = null;
		List<String> errorList = new ArrayList<>();
		result = customerService.saveCustomer(customer, errorList);
		if (result != null) {
			rattrs.addFlashAttribute("message", "Customer with ID: " + result.getId() + " Created Successfully!!");
		} else if (errorList.size() == 0) {
			rattrs.addFlashAttribute("message", "Customer Creation Failed!!");
		} else {
			model.addAttribute("newCustomer", customer);
			model.put("message", errorList.get(0));
			return "customer/add";
		}
		return "redirect:/";
	}

	// View Customer
	@PreAuthorize("hasRole('ROLE_group1')")
	@PostMapping("search")
	public String searchCustomer(ModelMap model, @RequestParam("searchBy") String searchBy,
			@RequestParam("value") String value) {
		System.out.println("Reached search");
		Customer result = null;
		if (searchBy != null) {
			if (searchBy.equalsIgnoreCase("customerId")) {
				result = customerService.getCustomerById(Long.valueOf(value));
				System.out.println(result);
			} else if (searchBy.equalsIgnoreCase("mobNum")) {
				result = customerService.getCustomerByMobNum(value);
			} else if (searchBy.equals("email")) {
				result = customerService.getCustomerByEmailId(value);
			}
			if (result != null) {
				model.put("customer", result);
				return "customer/show";
			} else {
				model.put("message", "No Customer Data Found!!");
			}
		}
		return "customer/search";
	}

	@PreAuthorize("hasRole('ROLE_group1')")
	@GetMapping("modify")
	public String modifyCustomerForm(Model model, @RequestParam("customerId") Long customerId) {
		Customer customer = customerService.getCustomerById(customerId);
		model.addAttribute("modifyCustomer", customer);
		return "customer/modify";
	}

	@PreAuthorize("hasRole('ROLE_group1')")
	@PostMapping("modify")
	public String modifyCustomer(@ModelAttribute("modifyCustomer") Customer customer, RedirectAttributes rattrs,
			ModelMap model) {
		System.out.println(customer);
		Customer original = customerService.getCustomerById(customer.getId());
		if (original != null) {
			original.setMobileNumber(customer.getMobileNumber());
			original.setEmail(customer.getEmail());
			original.setAddress(customer.getAddress());
			List<String> errorList = new ArrayList<>();
			Customer result = customerService.updateCustomer(original, errorList);
			if (result != null) {
				rattrs.addFlashAttribute("message",
						"Customer details for the Customer ID: " + customer.getId() + " is modified Successfully!!");
			} else if (errorList.size() == 0) {
				rattrs.addFlashAttribute("message",
						"Modify Customer Details for the Customer ID: " + customer.getId() + " Failed!!");
			} else {
				model.addAttribute("modifyCustomer", customer);
				model.put("message", errorList.get(0));
				return "customer/modify";
			}
		} else {
			rattrs.addFlashAttribute("message", "Invalid Customer ID!!");
		}
		return "redirect:/";
	}
}
