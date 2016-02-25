package com.app.services;

import java.util.ArrayList;
import java.util.List;

public class StringServices {
	public static void main(String[] args){
		System.out.println(hasUniqueChars(""));
	}
	
	public static boolean checkPalindrome(String str){
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
		return isP;
	}
	
	public static boolean hasUniqueChars(String str){
		boolean hasUnique = true;
		if(str.length()<1){
			return false;
		}
		else{
			List<Character> charList = new ArrayList<Character>();
			
			for(int i=0; i<str.length(); i++){
				if(charList.contains(str.charAt(i))){
					hasUnique = false;
					break;
				}
				else
					charList.add(str.charAt(i));
			}
			return hasUnique;
		}
	}
}
