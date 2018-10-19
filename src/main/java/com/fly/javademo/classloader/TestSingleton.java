package com.fly.javademo.classloader;

public class TestSingleton {
	public static void main(String args[]) {
		Singleton singleton = Singleton.getSingleton();
		Class a=null;
		System.out.println("counter1=" + singleton.counter1);
		System.out.println("counter2=" + singleton.counter2);
	}
}