package com.xtli.controller.algorithm;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;



public class HashMapLoop {
	public static void main(String args[]) {
		HashMap<Integer, String> map = new HashMap<Integer, String>();
		for(int i=0;i<100;i++) {
			map.put(i, "第"+i+"个");
		}
		Long a1 =System.nanoTime();
		//方法1：先获取keyset，然后循环取出value
		List<Integer> returnResult1 = new ArrayList<Integer>();
		Set<Integer> keySet = map.keySet();
		Iterator<Integer> it = keySet.iterator();
		while(it.hasNext()) {
			returnResult1.add(it.next());
		}
		
		Long a2 =System.nanoTime();
/*		//方法2：直接取出values
		List<String> returnResult2 = new LinkedList<String>();
		Collection<String> values =  map.values();
		Iterator<String> it2 = values.iterator();
		while(it.hasNext()) {
			returnResult2.add(it2.next());
		}*/
		Long a3 =System.nanoTime();
		//方法3：取出entrySet
		List<Integer> returnResult3 = new LinkedList<Integer>();
		Set<Entry<Integer, String>> eSet  =  map.entrySet();
		Iterator<Entry<Integer, String>> it3 = eSet.iterator();
		while(it3.hasNext()) {
			returnResult3.add(it3.next().getKey());
		}
		Long a4 =System.nanoTime();
		System.out.println("方法一花费时间:"+(a2-a1)/1000+"微秒");
/*		System.out.println("方法二花费时间:"+(a3-a2)/1000+"微秒");
*/		System.out.println("方法三花费时间:"+(a4-a3)/1000+"微秒");
	}
//	100000数量量时
//	方法一花费时间:9560微秒
//	方法三花费时间:3117微秒
//	100数据量时
//	方法一花费时间:130微秒
//	方法三花费时间:177微秒
//只是循环key值时，当数据量比较大时，方法三省时。
//当数据量小时，方法三比方法一耗时

}

