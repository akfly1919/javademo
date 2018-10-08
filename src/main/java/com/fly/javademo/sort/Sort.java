package com.fly.javademo.sort;

import java.util.Arrays;
import java.util.Random;
/**
 * https://www.cnblogs.com/onepixel/articles/7674659.html
 * @author fly
 *2018年10月8日 下午6:36:03
 */
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
	
	public static void selectSort(int[] args){
		for(int i=0;i<args.length;i++){
			int min=i;
			for(int j=i+1;j<args.length;j++){
				if(args[j]<args[min]){
					min=j;
				}
			}
			swap(args,i,min);
		}
		
	}
	public static void insertSort(int[] args){
		
		for(int i=1;i<args.length;i++){
			int current=args[i];
			int preIndex=i-1;
			while(preIndex>=0&&args[preIndex]>current){
				args[preIndex+1]=args[preIndex];
				preIndex--;
			}
			args[preIndex+1]=current;
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
		insertSort(a);
		System.out.println(Arrays.toString(a));
	}

}
