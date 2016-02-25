package com.app.services;

import java.util.ArrayList;
import java.util.List;

import com.app.models.BubbleSortString;
import com.app.models.InsertionSortString;
import com.app.models.MergeSortString;

public class SortServices {
	
	public static void main(String[] args){
		ArrayList<Character> one = new ArrayList<Character>();
		one.add('6');
		one.add('5');
		one.add('1');
		one.add('2');
		one.add('5');
		one.add('7');
		one.add('9');

		ArrayList<Character> result = new ArrayList<Character>();

		result = mergeSortImpl(one);

		for(char cc:result){
			System.out.print(cc + " ");
		}
	}
	
	public static BubbleSortString bubbleSort(String str){		
		if(str.length()<1)
			return new BubbleSortString(1, "abc", true, 0, 0);
		
		char[] charArray = str.toCharArray();
		
		char tmp;
		int first;
		int second;
		int swapCount = 0;
		
		long start = System.nanoTime();
		for(int i=0; i<charArray.length; i++){			
			for(int j=0; j<charArray.length-i-1; j++){
				first = (int)charArray[j];
				second = (int)charArray[j+1];
				if(first>second){
					tmp = charArray[j];
					charArray[j] = charArray[j+1];
					charArray[j+1] = tmp;
					swapCount++;
				}
			}
		}
		long end = System.nanoTime();		
		double timeElapsed = (double)(end-start)/1000;

		str = new String(charArray);
	
		return new BubbleSortString(1, str, true, swapCount, timeElapsed);
	}
	
	public static InsertionSortString insertionSort(String str){		
		if(str.length()<1)
			return new InsertionSortString(1, "abc", true, 0, 0);
		
		char[] charArray = str.toCharArray();
		
		char tmp;
		int first;
		int second;
		int swapCount = 0;
		
		long start = System.nanoTime();
		for(int i=1; i<charArray.length; i++){
			for(int j=i; j>0; j--){
				tmp = charArray[j];
				first = (int)charArray[j-1];
				second = (int)charArray[j];
				if(first>second){
					tmp = charArray[j];
					charArray[j] = charArray[j-1];
					charArray[j-1] = tmp;
					swapCount++;
				}
			}
		}
		long end = System.nanoTime();		
		double timeElapsed = (double)(end-start)/1000;

		str = new String(charArray);
	
		return new InsertionSortString(1, str, true, swapCount, timeElapsed);
	}

	public static MergeSortString mergeSort(String str){
		char[] charArray = str.toCharArray();
		ArrayList<Character> list = new ArrayList<Character>();
		for(char e: charArray)
			list.add(e);
		
		//mergeSortImpl(new ArrayList);
		
		return null;
	}
	public static ArrayList<Character> mergeSortImpl(ArrayList<Character> toSortList){
		if(toSortList.size()==1){
			return toSortList;
		}
		else{
			ArrayList<Character> left = new ArrayList<Character>();
			ArrayList<Character> right = new ArrayList<Character>();
			for(int i=0; i<toSortList.size(); i++){
				if(i<toSortList.size()/2)
					left.add(toSortList.get(i));
				else
					right.add(toSortList.get(i));
			}

			if(left.size()!=1)
				left = mergeSortImpl(left);
			
			if(right.size()!=1)
				right = mergeSortImpl(right);
			
			return mergeLists(left, right);
		}
	}
	public static ArrayList<Character> mergeLists(ArrayList<Character> leftList, ArrayList<Character> rightList){
		ArrayList<Character> mergedLists = new ArrayList<Character>();
		
		int leftIt = 0;
		int rightIt = 0;
		while(true){
			if(leftIt==leftList.size() && rightIt==rightList.size()){
				break;
			}
			else if(leftIt==leftList.size()){
				for(int i=rightIt; i<rightList.size(); i++){
					mergedLists.add(rightList.get(i));
				}
				break;
			}
			else if(rightIt==rightList.size()){
				for(int i=leftIt; i<leftList.size(); i++){
					mergedLists.add(leftList.get(i));
				}
				break;
			}
			else{
				int first = (int)leftList.get(leftIt);
				int second = (int)rightList.get(rightIt);
				if(first<second){
					mergedLists.add(leftList.get(leftIt));
					leftIt++;
				}
				else{
					mergedLists.add(rightList.get(rightIt));
					rightIt++;
				}
			}
		}
		return mergedLists;
	}
	
//	public static ArrayList<Character> quickSortImpl(ArrayList<Character> toSortList){
//		int wallLoc = 0;
//		int pivLoc = toSortList.size()-1;
//		int lockLoc = 0;
//		
//		int pivVal = 0;
//		
//		while(wallLoc!=pivLoc){
//			pivVal = toSortList.get(pivLoc);
//			for(int it=wallLoc; it<=pivLoc; it++){
//				if(toSortList.get(it) < toSortList.get(piv)){
//					toSortList.get(lock) = 
//				}
//			}
//		}
//	}
}
