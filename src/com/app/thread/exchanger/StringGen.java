package com.app.thread.exchanger;

import java.util.HashMap;
import java.util.Map;

public class StringGen {

	public static void digitReplace(String[] args) {
		String str = "Which of the remaining 5,998 Cylons are the final five";
		String[] split = str.split("\\W");
		Map<Integer, String> numberMap = new HashMap<Integer, String>();
		numberMap.put(5, " five ");
		numberMap.put(9, " nine ");
		numberMap.put(8, " eight ");
		StringBuffer resultString = new StringBuffer();
		
		
		for (int i = 0; i < split.length - 1; i++) {
			String stemp1 = split[i];
			if (stemp1.matches("\\d+")) {
				for (int j = 0; j < stemp1.length(); j++) {
					Character c = stemp1.charAt(j);
					Integer Integer = java.lang.Integer.parseInt(c.toString());
					String s = numberMap.get(Integer);
					resultString.append(s);
				}

			} else {
				StringBuffer sb = new StringBuffer(stemp1);

				resultString.append(sb.reverse().toString() + " ");
			}

		}
		System.out.println(resultString.toString());
	}
}
