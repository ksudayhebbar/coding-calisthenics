package com.app.number.game;

import java.util.Random;
import java.util.Scanner;

/*
 * Number game developed by uday 
 * since it has recursive function I didn't return the junit test case. 
 * this approach used is divide and conquer similar to binary search.
 * How to run 
 *  Run Main method with the upper limit i.e. 10 or 100 and 
 *  it goes on asking whether number is lower than this number you have say "yes" or "no". 
 * you find imaged number in asking the least  number of questions. 
 */

public class MemorizedNumber {
	private int number[];

	public MemorizedNumber() {

	}

	public MemorizedNumber(int rem) {
		number = new int[rem];
		for (int i = 0; i < rem; i++) {
			number[i] = i;
		}
		System.out.print("Guess a number between 0 and : " + rem);
		guessMyNumber(0, number.length - 1);
	}

	private int guessMyNumber(int f, int l) {
		Random random = new Random();
		int middle;
		int first = f;
		int last = l;
		middle = random.nextInt((last - first)) + first;
		return inputData(first, middle, last);

	}

	public int inputData(int f, int number, int l) {
		System.out.println();
		System.out.println("Is it your number " + number);
		Scanner input = new Scanner(System.in);
		String nextLine = input.nextLine();
		if (nextLine.equalsIgnoreCase("Y")) {
			System.out.println(" your number is " + number);
			nextLine = input.nextLine();
			if (nextLine.equalsIgnoreCase("Y")) {
				guessMyNumber(0, this.number.length - 1);
			} else {
				System.out.println("Bye Bye");
				Runtime.getRuntime().exit(0);
			}
			return -1;
		}
		System.out.println("Is it your nummber is lower than this number");
		nextLine = input.nextLine();
		if (nextLine.equalsIgnoreCase("Y")) {
			guessMyNumber(f, number);
		} else {
			guessMyNumber(number, l);

		}
		return -1;

	}

	public static void main(String[] args) {
		MemorizedNumber memorizedNumber = new MemorizedNumber(100);

	}

}
