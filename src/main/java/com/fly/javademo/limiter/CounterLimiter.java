package com.fly.javademo.limiter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class CounterLimiter extends AbstractRateLimiter {
	
	public long lastTime=0;
	public Lock lock=new ReentrantLock();
	public int count=0;

	public CounterLimiter(){}
	public CounterLimiter(int rate){
		super.rate=rate;
	}

	@Override
	public boolean doAcquire() {
		try{
			lock.lock();
			if((System.currentTimeMillis()-lastTime)>1000){
				count=0;
				lastTime=System.currentTimeMillis();
			}
			count++;
			if(count<=rate){
				return true;
			}
			return false;
		}finally{
			lock.unlock();
		}
	}

}
