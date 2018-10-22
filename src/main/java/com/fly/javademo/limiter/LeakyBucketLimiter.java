package com.fly.javademo.limiter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LeakyBucketLimiter extends AbstractRateLimiter{
	public Lock lock=new ReentrantLock();
	public long lastTime=0;
	public double water=0;
	public int capacity=20;
	public LeakyBucketLimiter(){}
	public LeakyBucketLimiter(int rate){super.rate=rate;}
	@Override
	public boolean doAcquire() {
		try{
			lock.lock();
			long now=System.currentTimeMillis();
			double outWater=(now-lastTime)/1000*rate;
			if(outWater>0){
				lastTime=now;
			}
			water=Math.max(0, water-outWater);
			if(water<=capacity){
				water++;
				return true;
			}else{
				return false;
			}
		}finally{
			lock.unlock();
		}
	}

}
