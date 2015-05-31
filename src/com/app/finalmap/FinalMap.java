package com.app.finalmap;

import java.lang.instrument.UnmodifiableClassException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class FinalMap<K, V> {
	private final HashMap<K, V> map;

	public FinalMap(Map<? extends K, ? extends V> m) {
		map = new HashMap<K, V>(m);
	}

	public int size() {

		return map.size();
	}

	public boolean isEmpty() {

		return map.isEmpty();
	}

	public boolean containsKey(Object key) {

		return map.containsKey(key);
	}

	public boolean containsValue(Object value) {

		return map.containsValue(value);
	}

	public V get(Object key) {

		return map.get(key);
	}

	public V remove(Object key) {

		return null;
	}

	public void clear() {

	}

	public Set<K> keySet() {

		return map.keySet();
	}

	public Collection<V> values() {

		return map.values();
	}

	public Set<java.util.Map.Entry<K, V>> entrySet() {

		return map.entrySet();
	}

	public String toString() {

		return map.toString();
	}

	public static void main(String[] args) {
		/*
		 * Map<String, String> str = new HashMap<String, String>(); str.put("A",
		 * "AValue"); str.put("B", "BValue"); str.put("C", "CValue");
		 * str.put("D", "DValue");
		 * 
		 * FinalMap<String, String> finalMap = new FinalMap<String,
		 * String>(str);
		 * 
		 * System.out.println(finalMap.toString());
		 * 
		 * final StringBuffer sb = new StringBuffer("KKKKK");
		 * 
		 * sb.append("aaa");
		 * 
		 * System.out.println(sb);
		 */
		String s = "11111111000001111000011111011111111111111111111";
		

	}
}
