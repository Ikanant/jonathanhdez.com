package com.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/WebServices")
public class WebServicesController {

	@Autowired
	private AtomicLong counter;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String webServicesHome(HttpServletRequest request, HttpSession session){
		String api = request.getParameter("api");
		
		// List of Web Services
		if(api!=null){
			switch (api){
				case "01":
					return "webServices/01_IsPalindrome";
				case "02":
					return "webServices/02_HasUniqueChars";
				case "11":
					return "webServices/11_BubbleSort";
				case "12":
					return "webServices/12_InsertionSort";
				default:
					return "webServices/00_WebServices";
			}
		}
		else{
			counter.set(0);
			return "webServices/00_WebServices";
		}
	}
}