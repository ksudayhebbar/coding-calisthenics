package com.app.str.permuation;

public class StringUtil {
	public static String reverseRecursively(String str) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}

		return reverseRecursively(str.substring(1)) + str.charAt(0);

	}
	
	public static String reverseRecursivelyremovealChar(String str,String chars) {

		// base case to handle one char string and empty string
		if (str.length() < 2) {
			return str;
		}
		return chars;

		//return chars.equals(str.charAt(0))?reverseRecursivelyremovealChar(str.substring(1)) + str.charAt(0);

	}

	public void truncationOFString() {
		String s = "11111111000001111000011111011111111111111111111";

		while (s.length() != 0) {
			int indexoF0 = s.indexOf("0");
			s = s.substring(indexoF0, s.length());
			int indexoF1 = s.indexOf("1");
			if (indexoF1 > 0) {
				s = s.substring(indexoF1 - 1, s.length());
				indexoF0 = s.indexOf("0", indexoF1);
				String result;
				if (indexoF0 > 0) {
					result = s.substring(0, indexoF0);
				} else {
					result = s.substring(0, s.length());
				}
				System.out.println(result);
				s = s.substring(result.length(), s.length());
			} else {
				break;
			}
		}
	}

	public static void main(String[] args) {

	}
}
