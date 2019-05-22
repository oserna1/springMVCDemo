package com.demo.controllers;

import java.io.FileOutputStream;
import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
public class MyDemoFormController {
	
	@RequestMapping(value="/myForm")
	public String myForm() {
		
		return "myForm";
	}
	
	@RequestMapping(value="/handleForm")
	public String handleForm(@RequestParam("file") MultipartFile file) {
		
		try {
			if (!file.isEmpty()) {
				byte[] bytes = file.getBytes();
				FileOutputStream fos = new FileOutputStream("C:\\Users\\oscar.a.serna\\Desktop\\myFile.jpg");
				fos.write(bytes);
				fos.close();
				System.out.println("File saved successfully");
			
			}
			else {
				System.out.println("No file available to save.");
			}
		}
		catch(Exception e) {
			System.out.println("Error saving file.");
		}
		
		return "operationComplete";
	}
	
	@ModelAttribute //@ModelAttribute allows for this method to run before any other handler methods
	public void setUserDetails(@RequestParam (value = "userName", required = false) String userName, Model model) {
		
		model.addAttribute("username", userName);
		
		
		
		//Stimulate going off and retrieving role based on userName
		String userRole = "undefined";
		
		if(userName == null) {
			
		}
		else if(userName.equals("Andy")) {
			userRole = "Student";
		}
		else if (userName.equals("John")) {
			userRole = "Teacher";
		}
		else if(userName.equals("Allana")) {
			userRole = "Dean";
		}
		
		model.addAttribute("userRole", userRole);
		
		System.out.println("Model updated with user information");
	}

}
