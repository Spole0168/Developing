package com.ch01;

public class MyThread03 extends Thread{
	private int i ;
	
	public MyThread03(int i) {
		super();
		this.i = i;
	}

	public void run(){
		System.out.println(i);
	}
}
