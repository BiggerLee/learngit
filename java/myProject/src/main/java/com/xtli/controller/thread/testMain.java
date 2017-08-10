package com.xtli.controller.thread;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.xtli.controller.thread.mySource.HashMap;
import com.xtli.controller.thread.mySource.LinkedHashMap;

public class TestMain {
	public static void main(String[] args) {
		//Map<String, Object> a = new HashMap<String, Object>(32);
		//Map<String, Object> a = new HashMap<String, Object>(10);
		Map<String, Object> a = new LinkedHashMap<String, Object>();
		a.put("1",1);
		a.put("2",2);
		a.put("3",3);
		a.put("4",4);
		a.put("5",5);
		Iterator<String> it = a.keySet().iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		//System.out.println(a.get("2"));
		/*for(int i = 0;i < 13;i++) {
			a.put(String.valueOf(i),i);
		}*/
		//System.out.println(Integer.highestOneBit((17 - 1) << 1));
	}
}
