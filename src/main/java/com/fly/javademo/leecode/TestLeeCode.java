package com.fly.javademo.leecode;

import java.util.HashMap;
import java.util.Map;

public class TestLeeCode {

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			map.put(target - nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			if (map.containsKey(nums[i]) && (map.get(nums[i]) != i)) {
				return new int[] { i, map.get(nums[i]) };
			}
		}
		return null;
	}

	public class ListNode {
		int val;
		ListNode next;

		ListNode(int x) {
			val = x;
		}
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		int a = l1.val + l2.val;
		ListNode ln = new ListNode(a > 9 ? a - 10 : a);
		if (l1.next != null) {
			ln.next = addTwoNumbers(l1.next, l2.next);
		}
		return ln;
	}

	public static int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		if(s.length()==1){
			return 1;
		}
		String a="";
		for(int i=0;i<s.length();i++){
			for(int j=i+1;j<s.length();j++){
				String d=s.substring(i, j);
				if(d.contains(s.charAt(j)+"")){
					if(d.length()>=a.length()){
						a=d;
					}
					break;
				}else{
					if(d.length()>=a.length()){
						a=d+s.charAt(j);
					}
				}
			}
		}
		return a.length();
	}
	public static void main(String[] args){
		System.out.println(lengthOfLongestSubstring("aab"));
	}
}
