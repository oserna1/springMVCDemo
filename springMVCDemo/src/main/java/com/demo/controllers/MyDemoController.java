package com.demo.controllers;

import java.util.Random;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.demo.model.Account;

@Controller
@SessionAttributes("aNewAccount")
public class MyDemoController {
	
	@ModelAttribute
	public void addAccountToModel(Model model) {
		System.out.println("Making sure account object is on model ");
		if(!model.containsAttribute("aNewAccount")) {
			Account a = new Account();
			model.addAttribute("aNewAccount", a);
		}
	}
	
	@RequestMapping(value="/createAccount")
	public String createAccount(@ModelAttribute ("aNewAccount") Account account) {
		
		System.out.println(account.getFirstName() + " " + account.getLastName() + account.getAge() + " " + account.getAddress() + " " + account.getEmail());
		return "createAccount";
	}
	
	@RequestMapping(value="/validateCreate")
	public String validateCreate(@Valid @ModelAttribute ("aNewAccount") Account account, BindingResult result) {
		
		if(result.hasErrors()) {
			System.out.println("Form has errors");
			return "createAccount";
		}
		System.out.println(account.getFirstName() + " " + account.getLastName() + account.getAge() + " " + account.getAddress() + " " + account.getEmail());
		return "redirect:accountCreated";
	}
	
	@RequestMapping(value="/accountCreated")
	public String performCreate(@ModelAttribute ("aNewAccount") Account account){
		
		System.out.println("Welcome: " + " " + account.getFirstName() + " " + account.getLastName());
		return "accountCreated";
	}
		
	
}
