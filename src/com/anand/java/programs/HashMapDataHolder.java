package com.anand.java.programs;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Class holds the HashMap data structure and holds and operations on the data
 * structure
 * 
 * @author Anand A
 * @version 1.0
 *
 */
public class HashMapDataHolder {

	/**
	 * Map of Object -> List<Object>
	 */
	private static Map<Object, List<Object>> hashMapDataStorage = null;
	/**
	 * Singleton Instance of HashMapDataHolder
	 */
	private static HashMapDataHolder hashMapDataHolder = new HashMapDataHolder();

	/**
	 * Private Constructor
	 */
	private HashMapDataHolder() {
		hashMapDataStorage = new ConcurrentHashMap<Object, List<Object>>();
	}

	/**
	 * Method Provides an instance of HashMapDataHolder
	 * 
	 * @return an instance of HashMapDataHolder
	 */
	public static HashMapDataHolder getInstance() {
		return hashMapDataHolder;
	}

	/**
	 * Inserts a object into HashMap against specified key. If some data is already
	 * present in HashMap, the new data will be added to the list
	 * 
	 * @param key  key against which data is to be inserted
	 * @param data the data to be inseted into hashmap
	 */
	public void insertData(Object key, Object data) {
		if (isValidKey(key)) {
			if (hashMapDataStorage.containsKey(key))
				hashMapDataStorage.get(key).add(data);
			else
				hashMapDataStorage.put(key, new ArrayList<Object>() {
					/**
					 * Default serialId
					 */
					private static final long serialVersionUID = 1L;

					{
						add(data);
					}
				});
			System.out.println("Successfully Inserted [" + String.valueOf(data) + "] Into HashMap Against Key ["
					+ String.valueOf(key) + "]");
		} else
			System.out.println("Invalid Key. Cannot Insert Data Into HashMap");
	}

	/**
	 * Retrieves data present in HashMap against a specified key
	 * 
	 * @param key the key against which the data is to be fetched
	 * @return data stored against key
	 */
	public List<Object> getData(Object key) {
		if (isValidKey(key))
			return hashMapDataStorage.get(key);
		else
			System.out.println("Invalid Key. Cannot Fetch Data From HashMap");
		return null;
	}

	/**
	 * Validates whether a key is valid or not. A key cannot be null and must be an
	 * instance of String or Integer
	 * 
	 * @param key the key to be validated
	 * @return true if key is valid other wise return false
	 */
	private boolean isValidKey(Object key) {
		if (key == null)
			return false;

		String className = key.getClass().getName();

		switch (className) {
		case "java.lang.String":
		case "java.lang.Integer":
			return true;
		default:
			return false;
		}

	}
}
