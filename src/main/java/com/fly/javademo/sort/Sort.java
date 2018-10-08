package com.fly.javademo.sort;

import java.util.Arrays;
import java.util.Random;

public class Sort {
	
	public static void swap(int[] args,int a,int b){
		int s=args[a];
		args[a]=args[b];
		args[b]=s;
	}
	
	
	public static void maopaoSort(int[] args){
		for(int i=0;i<args.length;i++){
			for(int j=i+1;j<args.length;j++){
				if(args[i]>args[j]){
					swap(args, i, j);
				}
			}
		}
		
	}
	
	public static int[] buildArgs(int length){
		Random r=new Random();
		int[] a=new int[length];
		for(int i=0;i<length;i++){
			a[i]=r.nextInt(100);
		}
		return a;
	}
	
	public static void quickSort(int[] args,int low,int high){
		int pivot;
		if(low<high){
			
		}
	}

	public static void main(String[] args) {
		int[] a=buildArgs(10);
		System.out.println(Arrays.toString(a));
		maopaoSort(a);
		System.out.println(Arrays.toString(a));
	}

}
