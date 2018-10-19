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
	
	public static void quickSort(int[] args,int low,int high){
		int pivot=0;
		if(low<high){
			pivot=quickSortPivot(args, low, high);
			quickSort(args, low, pivot);
			quickSort(args, pivot+1, high);
		}
	}
	
	public static int quickSortPivot(int[] args,int low,int high){
		int pivot=low;
		int index=pivot+1;
		for(int i=index;i<=high;i++){
			if(args[i]<args[pivot]){
				swap(args, i, index);
				index++;
			}
		}
		swap(args, pivot, index-1);
		return index-1;
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
	public static void shellSort(int[] args){
		int d=args.length;
		for(int gap=d/2;gap>0;gap=(gap/2)){
			for(int i=gap;i<d;i++){
				int n=args[i];
				int j=0;
				for(j=i-gap;j>=0&&args[j]>n;j=j-gap){
					args[j+gap]=args[j];
				}
				args[j+gap]=n;
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
	
	public static int[] buildArgs(){
		Random r=new Random();
		int[] a=new int[r.nextInt(20)];
		for(int i=0;i<a.length;i++){
			a[i]=r.nextInt(100);
		}
		return a;
	}
	
	
	
	
	

	public static void main(String[] args) {
		int[] a=buildArgs();
		System.out.println(Arrays.toString(a));
//		quickSort(a,0,a.length-1);
		shellSort(a);
		System.out.println(Arrays.toString(a));
	}

}
