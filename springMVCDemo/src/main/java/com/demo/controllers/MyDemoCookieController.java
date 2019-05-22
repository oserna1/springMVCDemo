package com.demo.controllers;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MyDemoCookieController {
	
	@RequestMapping(value="/addCookie")
	public String addCookie(HttpServletResponse response) {
		
		//Add a random cookie
		response.addCookie(new Cookie("myRandomCookie", "aCookieIAdded"));
		
		System.out.println("Cookie added");
		
		return "demoPage";
	}
	
	
	@RequestMapping(value="/getCookie")
	public String getCooke(@CookieValue("myRandomCookie")  String myCookie) {
		System.out.println("Cookie retrived:" + myCookie);
		
		return "demoPage";
	}

}
