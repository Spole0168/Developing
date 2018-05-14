package chapter3;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by 13 on 2017/5/4.
 */
public class CyclicBarrierDemo1 {
    public static class Soldier implements Runnable {
    	private String soldier;
    	private final CyclicBarrier cb;
		public Soldier(CyclicBarrier cb,String soldier) {
			super();
			this.soldier = soldier;
			this.cb = cb;
		}
		@Override
		public void run() {
			try {
				cb.await();
				doWork();
				cb.await();
				doWork();
				cb.await();
				System.out.println(Thread.currentThread().getName());
			} catch (InterruptedException | BrokenBarrierException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
    	
		  void doWork() {
	            try {
	                Thread.sleep(Math.abs(new Random().nextInt() % 10000));
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	            }
	            System.out.println(soldier + ":任务完成");
	        }
		
    }

    public static class BarrierRun implements Runnable {

    	int flag;
        int N;

        public BarrierRun(int flag, int N) {
            this.flag = flag;
            this.N = N;
        }

        @Override
        public void run() {
            if (flag==0) {
                System.out.println("司令:[士兵" + N + "个,集合完毕!");
                flag =1;
            } else if (flag==1){
            	System.out.println("司令:[士兵" + N + "个,任务1 --完成!");
            	flag =2;
            } else if (flag==2){
            	System.out.println("司令:[士兵" + N + "个,任务2 --完成!");
            	flag =3;
            }
        }
    }


    public static void main(String args[]) {
        final int N = 5;
        Thread[] allSoldier = new Thread[N];
        boolean flag = false;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(N, new BarrierRun(0, N));
        System.out.println("集合队伍!");
        for (int i = 0; i < N; i++) {
            System.out.println("士兵" + i + "报道!");
            allSoldier[i] = new Thread(new Soldier(cyclicBarrier, "士兵" + i));
            allSoldier[i].start();
        }
    }
}


