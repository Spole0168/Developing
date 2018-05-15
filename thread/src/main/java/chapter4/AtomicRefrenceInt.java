package chapter4;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created by 13 on 2017/5/6.
 */
public class AtomicRefrenceInt {

	public static class ChongZhiTask implements Runnable {
		AtomicReference<Long> money = null;

		public ChongZhiTask(AtomicReference<Long> money) {
			super();
			this.money = money;
		}

		public void run() {
			while (true) {
				Long m = money.get();
				if (m < 20) {
					if (money.compareAndSet(m, m + 20)) {
						System.out.println("余额小于20元,充值成功,余额:" + money.get()
								+ "元");
						break;
					}
				} else {
					System.out.println("余额大于20,无需充值");
					break;
				}
			}
		}
	}

	public static class XiaoFeiTask implements Runnable {
		AtomicReference<Long> money = null;

		public XiaoFeiTask(AtomicReference<Long> money) {
			super();
			this.money = money;
		}

		public void run() {
			while (true) {
				Long m = money.get();
				if (m > 10) {
					System.out.println("金额大于10元");
					if (money.compareAndSet(m, m - 10)) {
						System.out.println("成功消费10元,余额:" + money.get() + "元");
						break;
					}
				} else {
					System.out.println("没有足够的金额");
					break;
				}
			}
		}
	}

	// 运行中可能不会出现书中提到的情况
	public static void main(String args[]) {
		final AtomicReference<Long> money = new AtomicReference<Long>();
		money.set(19L);
		ExecutorService fixedThreadPool = Executors.newFixedThreadPool(100);
		ChongZhiTask chongZhiTask = new ChongZhiTask(money);
		XiaoFeiTask xiaoFeiTask = new XiaoFeiTask(money);
		for(int i =0;i<10;i++){
			fixedThreadPool.execute(chongZhiTask);
			fixedThreadPool.execute(xiaoFeiTask);
		}
		
	}

}
