package com.ch01;

public class MyThread04 extends Thread{
	private int i = 5 ;
	
	public MyThread04() {
		super();
	}
	public MyThread04(String name) {
		super();
		this.setName(name);
	}

	public void run(){
		while(i>0){
			i --;
			System.out.println("mm="+Thread.currentThread().getName()+"\ti="+i);
		}
	}
}
