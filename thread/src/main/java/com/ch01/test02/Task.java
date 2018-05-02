package com.ch01.test02;

import java.util.Random;

public class Task implements Runnable{

	public void run() {
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
