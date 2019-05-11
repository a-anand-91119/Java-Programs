package com.anand.java.programs;

import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		Object key = "Key1";
		Object data = new String("Data1");
		Object data1 = new Integer("200");
		
		HashMapDataHolder.getInstance().insertData(key, data);
		HashMapDataHolder.getInstance().insertData(key, data1);
		
		System.out.println();
		
		List<Object> dataFromMap = HashMapDataHolder.getInstance().getData(key);
		
		for(Object object : dataFromMap)
			System.out.println(String.valueOf(object));
	}

}
