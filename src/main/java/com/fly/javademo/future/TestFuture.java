package com.fly.javademo.future;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class TestFuture {

	public static FutureTask<String> buildFutureTask(final int time) {

		return new FutureTask<String>(new Callable<String>() {
			public String call() throws Exception {
				Thread.sleep(time);
				return null;
			}

		});
	}

	public static void main(String[] args) {
		long beg=System.currentTimeMillis();
		ExecutorService executos = Executors.newFixedThreadPool(10);
		FutureTask<String> f1 = buildFutureTask(100);
		FutureTask<String> f2 = buildFutureTask(200);
		FutureTask<String> f3 = buildFutureTask(300);
		FutureTask<String> f4 = buildFutureTask(611110);
		executos.submit(f1);
		executos.submit(f2);
		executos.submit(f3);
		executos.submit(f4);
		try {
			f1.get(500, TimeUnit.MILLISECONDS);
			f2.get(500, TimeUnit.MILLISECONDS);
			f3.get(500, TimeUnit.MILLISECONDS);
			f4.get(500, TimeUnit.MILLISECONDS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(System.currentTimeMillis()-beg);
		executos.shutdown();
	}
}
