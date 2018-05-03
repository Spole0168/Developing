package com.ch01;

import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class TestCh01Case {
	
	@Test
	public void test01(){
		MyThread01 mt = new MyThread01();
		System.out.println("mt.getName()"+mt.getName());
		System.out.println("Thread.currentThread().getName()"+Thread.currentThread().getName());
		mt.start();
//		mt.start();  该线程状态已经变成运行，再次启动就报错。
		System.out.println("mian END");
	}
	@Test
	public void test02(){
		MyThread02 mt2 = new MyThread02();
		mt2.start();
		
		for(int i=0;i<10;i++){
			int num = (int) (Math.random()*1000);
			try {
				TimeUnit.SECONDS.sleep(1);
//				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
	@Test
	public void test03(){
		MyThread03 mt1 = new MyThread03(1);
		MyThread03 mt2 = new MyThread03(2);
		MyThread03 mt3 = new MyThread03(3);
		MyThread03 mt4 = new MyThread03(4);
		MyThread03 mt5 = new MyThread03(5);
		MyThread03 mt6 = new MyThread03(6);
		mt1.start();
		mt2.start();
		mt3.start();
		mt4.start();
		mt5.start();
		mt6.start();
	}
	
	@Test
	public void test04() throws InterruptedException{
		Thread t = new Thread(new MyRunner());
		t.start();
		
		MyThread04 tt = new MyThread04();
//		MyThread04 ta = new MyThread04("A");
//		MyThread04 tb = new MyThread04("B");
//		MyThread04 tc = new MyThread04("C");
//		ta.start();
//		tb.start();
//		tc.start();
//		Thread.currentThread().join();
		Thread t1 = new Thread(tt,"t1");
		Thread t2 = new Thread(tt,"t2");
		Thread t3 = new Thread(tt,"t3");
		t1.start();
		t2.start();
		t3.start();
	}
	@Test
	public void test05(){
		MyThread05 tt = new MyThread05();
		Thread t1 = new Thread(tt,"t1");
		Thread t2 = new Thread(tt,"t2");
		Thread t3 = new Thread(tt,"t3");
		t1.start();
		t2.start();
		t3.start();
	}
	@Test
	public void test06(){
		
	}
}
