package com.xtli.controller;

public class CommonTest {
	public static void main(String[] args) {
		System.out.println("go ads GO SFAA".split("GO|go"));
	}
	    public static double findMaxAverage(int[] nums, int k) {
	    	 double total = 0.0;
		     for(int i = 0;i<k;i++) {
		        total+=nums[i];
		     }
	         if(k == nums.length) { 
		        return total/k;
		     }
	        
	       double tempAve = total;
	       for(int i = 1 ; i < nums.length; i++) {
	           double totalTemp = 0.0;              
	           if(k+i<=nums.length) {
	               for(int j=i;j<k+i;j++){
	                 totalTemp += nums[j];              
	               }
	               if(totalTemp > tempAve) {
	                 tempAve = totalTemp;
	               }
	           }
	       }
		    return (tempAve)/k;
	    }
}
