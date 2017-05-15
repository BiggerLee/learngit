package com.xtli.controller.thread;

import java.util.Map;

import com.xtli.controller.thread.mySource.HashMap;

public class testMain {
	public static void main(String[] args) {
		Map<String, Object> a = new HashMap<String, Object>(32);
		//Map<String, Object> a = new HashMap<String, Object>(10);
		a.put("1",1);
		a.put("1",2);
		System.out.println(a.get("1"));
		//System.out.println(a.get("2"));
		/*for(int i = 0;i < 13;i++) {
			a.put(String.valueOf(i),i);
		}*/
		//System.out.println(Integer.highestOneBit((17 - 1) << 1));
	}
}
