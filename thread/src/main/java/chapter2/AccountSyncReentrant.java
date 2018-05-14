package chapter2;

/**
 * Created by 13 on 2017/5/4.
 */
public class AccountSyncReentrant implements Runnable {
	private int n = 0;
	
    public AccountSyncReentrant(int n) {
		super();
		this.n = n;
	}

	//直接作用于静态方法 加锁在类上。
    public static synchronized int jieCheng(int n){
    	if(n>1){
    		return n*jieCheng(n-1);
    	}else if(n==1){
    		return 1;
    	}
    	return -1;
    }

    @Override
    public void run() {
    	int jieCheng = jieCheng(n);
    	System.out.println(n+"的阶乘="+jieCheng);
    }

    /**
     * @param args
     * @throws InterruptedException
     */
    public static void main(String args[]) throws InterruptedException {
        Thread thread1 = new Thread(new AccountSyncReentrant(5));
        Thread thread2 = new Thread(new AccountSyncReentrant(8));

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

    }
}
