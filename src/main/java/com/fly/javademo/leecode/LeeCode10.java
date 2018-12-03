package com.fly.javademo.leecode;

import java.util.HashMap;
import java.util.Map;

public class LeeCode10 {

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

	public int lengthOfLongestSubstring(String s) {
		if(s==null||s.length()==0){
			return 0;
		}
		if(s.length()==1){
			return 1;
		}
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		int ans=0;
		for(int i=0,j=0;i<s.length();i++){
			char a=s.charAt(i);
			if(map.containsKey(a)){
				j=Math.max(map.get(a),j);
			}
			map.put(a, i+1);
			ans = Math.max(i - j + 1,ans);
		}
		return ans;
	}
	
	public String longestPalindrome(String s) {
		String d="";
		Map<Character,Integer> map=new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			int j=s.indexOf(s.charAt(i),i);
			if(j!=-1){
			}
		}
        return d;
    }
	public static void main(String[] args){
		System.out.println("aaaaa".indexOf("a",1));
	}
}
