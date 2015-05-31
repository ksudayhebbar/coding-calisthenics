package com.app.fibfact;

public class fibonacciAndFact {

	public int genFibonacciSeries(int number) {
		if (number == 1 || number == 2) {
			return 1;
		}
		int fibo1 = 1, fibo2 = 1, fibonacci = 1;
		for (int i = 3; i <= number; i++) {
			fibonacci = fibo1 + fibo2; // Fibonacci number is sum of previous
										// two Fibonacci number
			System.out.println(fibonacci);
			fibo1 = fibo2;
			fibo2 = fibonacci;

		}
		return fibonacci;
	}

	public int factorial(int n) {
		int fact = 1; // this will be the result
		for (int i = 1; i <= n; i++) {
			fact *= i;
		}
		return fact;
	}

	public int fact(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		int f = n * fact(n - 1);
		System.out.println(" N " + n + " " + f);

		return f;
	}

	public int fib(int n) {
		if (n == 0)
			return 0;
		else if (n == 1)
			return 1;

		return fib(n - 1) + fib(n - 2);
	}
}
