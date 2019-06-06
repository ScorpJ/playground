package com.imooc;

import java.util.concurrent.Callable;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class ExecutorExample {

	public static void main(String[] args) {
		// ExecutorService executor = Executors.newSingleThreadExecutor();

		// try {
		// executor.submit(new Task());
		// System.out.println("Shutdown executor");
		// executor.shutdown();
		// executor.awaitTermination(5, TimeUnit.SECONDS);
		// } catch (InterruptedException e) {
		// System.err.println("tasks interrupted");
		// } finally {
		// if (!executor.isTerminated()) {
		// System.err.println("cancel non-finished tasks");
		// }
		// executor.shutdownNow();
		// System.out.println("shutdown finished");
		// }

		final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
		final ScheduledFuture<?> beepHandler = scheduler.scheduleAtFixedRate(new BeepTask(), 2, 2, TimeUnit.SECONDS);

		scheduler.schedule(new Runnable() {
			public void run() {
				beepHandler.cancel(true);
				scheduler.shutdown();
			}
		}, 10, TimeUnit.SECONDS);

	}

	static class Task implements Runnable {
		public void run() {
			try {
				Long duration = (long) (Math.random() * 20);
				System.out.println("Running Task!");
				TimeUnit.SECONDS.sleep(duration);
			} catch (InterruptedException e) {
				System.out.println("sleep interrupted!");
				e.printStackTrace();
			}
		}
	}

	static class BeepTask implements Runnable {
		public void run() {
			System.out.println("beep");
		}
	}
	
	static class MyComputTask implements Callable {

		public Object call() throws Exception {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
