package com.ch01.test02;

public class Test02Main {
	public static void main(String[] args) {
		Task t = new Task();
		Thread th = new Thread(t);
		th.start();
		for(int i=0;i<10;i++){
			int num = (int) (Math.random()*1000);
			try {
				Thread.sleep(num);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(Thread.currentThread().getName());
		}
	}
}
