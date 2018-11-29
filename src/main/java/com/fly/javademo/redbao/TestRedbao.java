package com.fly.javademo.redbao;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class TestRedbao {
	
	public ReentrantLock lock=new ReentrantLock();
	
	public int count=0;

	public void buildRedbao(){}
	public void getRedbao(){
		try{
			lock.lock();
			count++;
			if(count>=20){
				System.out.println(Thread.currentThread().getName()+"没有红包"+System.currentTimeMillis());
				return;
			}
			System.out.println(Thread.currentThread().getName()+"获取到红包"+System.currentTimeMillis());
		}catch(Exception e){
			throw e;
		}finally{
			lock.unlock();
		}
	}
	public static void main(String[] args) {
		final TestRedbao trb=new TestRedbao();
		for (int i=0; i< 100; i++){
            Thread thread = new Thread(new Runnable() {
               public void run() {
            	   trb.getRedbao();
               }
           });
           thread.setName("thread_" + i);
           thread.start();
       }
	}

}
