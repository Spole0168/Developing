package com.ch01.test01;

public class Test01Main {
	public static void main(String[] args) {
		MyThread mt = new MyThread();
		mt.start();
//		mt.start();  该线程状态已经变成运行，再次启动就报错。
		System.out.println("mian END");
		
	}
}
