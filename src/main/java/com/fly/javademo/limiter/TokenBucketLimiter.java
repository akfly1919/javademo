package com.fly.javademo.limiter;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TokenBucketLimiter extends AbstractRateLimiter{
	public Lock lock=new ReentrantLock();
	public long lastTime=0;
	public double token=0;
	public int capacity=10;
	public TokenBucketLimiter(){}
	public TokenBucketLimiter(int rate){super.rate=rate;}
	@Override
	public boolean doAcquire() {
		try{
			lock.lock();
			long now=System.currentTimeMillis();
			double inToken=(now-lastTime)/1000*rate;
			if(inToken>0){
				lastTime=now;
			}
			token=Math.min(token+inToken, capacity);
			if(token-1>=0){
				token--;
				return true;
			}else{
				return false;
			}
		}finally{
			lock.unlock();
		}
	}

}
