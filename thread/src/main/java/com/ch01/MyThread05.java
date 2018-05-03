package com.ch01;

public class MyThread05 extends Thread{
	private int i = 5 ;
	
	public MyThread05() {
		super();
	}
	public MyThread05(String name) {
		super();
		this.setName(name);
	}

	public synchronized void run(){
		while(i>0){
			i --;
			System.out.println("mm="+Thread.currentThread().getName()+"\ti="+i);
		}
	}
}
