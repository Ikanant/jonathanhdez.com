package com.app.controllers;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.app.models.BubbleSortString;
import com.app.models.InsertionSortString;
import com.app.models.Palindrome;
import com.app.models.UniqueChars;
import com.app.services.SortServices;
import com.app.services.StringServices;

@RestController
@RequestMapping("/api")
public class RestControllers {
	
	@Autowired
	private AtomicLong counter;
	
	@RequestMapping(value = "/isPalindrome", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public Palindrome isPalindrome(@RequestParam(value="str", defaultValue="") String str){
		return new Palindrome(counter.incrementAndGet(), str, StringServices.checkPalindrome(str));
	}

	@RequestMapping(value = "/hasUniqueChars", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public UniqueChars hasUniqueChars(@RequestParam(value="str", defaultValue="") String str){
		return new UniqueChars(counter.incrementAndGet(), str, StringServices.hasUniqueChars(str));
	}
	
	@RequestMapping(value = "/bubbleSort", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public BubbleSortString bubbleSort(@RequestParam(value="str", defaultValue="") String str){
		BubbleSortString sortedString = SortServices.bubbleSort(str);
		sortedString.setId(counter.incrementAndGet());
		return sortedString;
	}
	
	@RequestMapping(value = "/insertionSort", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public InsertionSortString insertionSort(@RequestParam(value="str", defaultValue="") String str){
		InsertionSortString sortedString = SortServices.insertionSort(str);
		sortedString.setId(counter.incrementAndGet());
		return sortedString;
	}
}
