package com.app.mainControllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.webserviceModels.Greeting;
import com.app.webserviceModels.IsPalindrome;

@RestController
@RequestMapping("/api")
public class MyRestController {
	private static final String template = "Hello, %s";
	
	@Autowired
	private AtomicLong counter;
	
	@RequestMapping(value = "/greeting", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name){
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@RequestMapping(value = "/isPalindrome", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public IsPalindrome isPalindrome(@RequestParam(value="str", defaultValue="") String str){
		
		boolean isP = true;
		if(str.length()<=1){
			isP = false;
		}
		else{
			int cond=0;
			while(cond <= str.length()-cond-1){
				if(str.charAt(cond) == str.charAt(str.length()-cond-1)){
					cond++;
				}
				else{
					isP = false;
					break;
				}
			}
		}
		
		
		if(isP){
			return new IsPalindrome(counter.incrementAndGet(), str, true);
		}
		else{
			return new IsPalindrome(counter.incrementAndGet(), str, false);
		}
		
		
	}
	
	@RequestMapping(value = "/stringCharCount", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public String stringCharCount(@RequestParam(value="str", defaultValue="") String str){
		return "{\"id\":1, \"count\":" + str.length() + "}";
	}
}
