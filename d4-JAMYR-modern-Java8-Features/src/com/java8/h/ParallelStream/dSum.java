package com.java8.h.ParallelStream;

public class dSum {

	private int total;

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}
	
	public void performSum(int input) {
		total += input;
//		total = total + input;
	}

}
