package com.app.str.permuation;

public class StringPerm {

	public static void permuation(String prefix, String str) {
		int n = str.length();
		if (n == 0)
			System.out.println(prefix);
		else {
			for (int i = 0; i < n; i++) {
				permuation(prefix + str.charAt(i),
						str.substring(0, i) + str.substring(i + 1, n));
			}
		}
	}

	public static void main(String[] args) {
		permuation("", "ABC");
	}
}
