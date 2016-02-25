package com.app.models;

public class MergeSortString {
	private long id;
	private final String line;
	private final boolean sorted;
	private final int swapCount;
	private final double timeElapsed;
	
	public MergeSortString(long id, String line, boolean sorted, int swapCount, double timeElapsed){
		this.id = id;
		this.line = line;
		this.sorted = sorted;
		this.swapCount = swapCount;
		this.timeElapsed = timeElapsed;
	}

	public long getId() {
		return id;
	}
	public void setId(long id){
		this.id = id;
	}

	public String getLine() {
		return line;
	}

	public boolean getSorted() {
		return sorted;
	}
	public int getSwapCount(){
		return swapCount;
	}
	public double getTimeElapsed(){
		return timeElapsed;
	}
}
