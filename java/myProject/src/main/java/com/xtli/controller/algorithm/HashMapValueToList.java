package com.xtli.controller.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;



public class HashMapValueToList {
	public static void main(String args[]) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0;i<100;i++) {
			map.put(i, "第"+i+"个");
		}
		Long a1 =System.nanoTime();
		//方法1：先获取keyset，然后循环取出value
		List<String> returnResult1 = new ArrayList<String>();
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			returnResult1.add(map.get(it.next()));
		}
		Long a2 =System.nanoTime();
		//方法2：直接取出values
		List<String> returnResult2 = new LinkedList<String>();
		Collection<String> values =  map.values();
		Iterator<String> it2 = values.iterator();
		while(it2.hasNext()) {
			returnResult2.add(it2.next());
		}
		Long a3 =System.nanoTime();
		//方法3：取出entrySet
		List<String> returnResult3 = new LinkedList<String>();
		Set<Entry<Integer, String>> eSet  =  map.entrySet();
		Iterator<Entry<Integer, String>> it3 = eSet.iterator();
		while(it3.hasNext()) {
			returnResult3.add(it3.next().getValue());
		}
		Long a4 =System.nanoTime();
		System.out.println("方法一花费时间:"+(a2-a1)/1000+"微秒");
		System.out.println("方法二花费时间:"+(a3-a2)/1000+"微秒");
		System.out.println("方法三花费时间:"+(a4-a3)/1000+"微秒");
		/*System.out.println(returnResult1);
		System.out.println(returnResult2);
		System.out.println(returnResult3);*/

	}
	
//	100000数据时：
//	方法一花费时间:10222微秒
//	方法二花费时间:2920微秒
//	方法三花费时间:4765微秒
//	100个数据时：
//	方法一花费时间:175微秒
//	方法二花费时间:219微秒
//	方法三花费时间:72微秒
	

	/*//先获取keyset，然后循环取出value
	public static List<?> valueToList(HashMap<?,?> map) {
		List<Object> returnResult = new LinkedList<Object>();
		Set<?> keySet = map.keySet();
		Iterator<?> it = keySet.iterator();
		while(it.hasNext()) {
			returnResult.add(map.get(it.next()));
			it.remove();
		}
		return returnResult;
	}
	//取出values
	public static List<?> valueToListV2(HashMap<?,?> map) {
		List<Object> returnResult = new LinkedList<Object>();
		Collection<?> values =  map.values();
		Iterator<?> it = values.iterator();
		while(it.hasNext()) {
			returnResult.add(it.next());
			it.remove();
		}
		return returnResult;
	}
	//获取entrySet
	public static List<?> valueToListV3(HashMap<?,?> map) {
		List<Object> returnResult = new LinkedList<Object>();
		Collection<?> values =  map.entrySet();
		for(Object e: values) {
			Entry<?, ?> entry = (Entry<?, ?>) e;
			returnResult.add(entry.getValue());
		}
		return returnResult;
	}*/
}
