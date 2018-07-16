package com.fly.javademo.lock;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestLock {

	public List<String> list = new ArrayList<String>();

	public Lock lock = new ReentrantLock();
	
	public Condition notFull=lock.newCondition();
	public Condition notEmpty=lock.newCondition();


	class Product implements Runnable {

		public Product() {
		}

		@Override
		public void run() {
			try {
				lock.lock();
				if (list.size() >= 10) {
					System.out.print(Thread.currentThread().getName()+": wait \n");;
					notFull.await();
				}
				list.add("a");
				System.out.print(Thread.currentThread().getName()+": put:"+list.size()+ "\n");
				notEmpty.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}

	}
	class Consumer implements Runnable {

		public Consumer() {
		}

		@Override
		public void run() {
			try {
				lock.lock();
				if (list.size() == 0) {
					System.out.print(Thread.currentThread().getName()+": wait \n");
					notEmpty.await();
				}
				System.out.print(Thread.currentThread().getName()+": take:"+list.remove(0)+ "\n");
				notFull.signalAll();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			lock.unlock();
		}

	}
	public static void main(String[] args){
		TestLock tl=new TestLock();
		Product p=tl.new Product();
		Consumer c=tl.new Consumer();
		for(int i=0;i<30;i++){
            new Thread(p,"producer-"+i).start();
        }
        for(int i=0;i<30;i++){
            new Thread(c,"consumer-"+i).start();
        }
	}
}
