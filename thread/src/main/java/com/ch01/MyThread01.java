package com.ch01;

public class MyThread01 extends Thread{
	
	public MyThread01() {
		super();
		this.setName("AAAA");
		System.out.println("this.getName()"+this.getName());
		System.out.println("Thread.currentThread().getName()"+Thread.currentThread().getName());
		
	}

	public void run(){
		System.out.println("MyThread");
		System.out.println("this.getName()"+this.getName());
		System.out.println("Thread.currentThread().getName()"+Thread.currentThread().getName());
	}
}
