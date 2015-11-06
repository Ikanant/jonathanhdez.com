package com.app.mainControllers;

import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.webserviceModels.Greeting;

@Controller
@RequestMapping("/WebServices")
public class WebServicesController {

	@Autowired
	private AtomicLong counter;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String webServicesHome(HttpServletRequest request, HttpSession session){
		String api = request.getParameter("api");

		if(api!=null){
			switch (api){
				case "01":
					return "webServices/01_Greeting";
				case "02":
					return "webServices/02_IsPalindrome";
				case "03":
					return "webServices/03_StringCharCount";
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