package com.fly.javademo.limiter;

public abstract class AbstractRateLimiter implements RateLimiter{
	//每秒支持多少并发
	public int rate;
	public void acquire() {
		while(true){
			if(doAcquire()){
				return;
			}
			try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
		}
	}
	
	public abstract boolean doAcquire();
}
