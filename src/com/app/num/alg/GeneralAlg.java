package com.app.num.alg;

public class GeneralAlg {

	public static int sum(int a, int b) {
		while (a > 0) {
			--a;
			++b;
		}
		
		while (a < 0) {
			++a;
			--b;
		}
		
		return b;
	}
	
	public static int square(int num)
	{
		int result = 0;

		int n = (num > 0) ? num : -num;

		for(int i = 0; i < n; ++i)
		{
			result += n;
		}

		return (num % 2 == 0) ? result : -result;
	}

	public static void main(String[] args) {
		System.out.println(sum(15,20));
		System.out.println(square(2));
	}

}
