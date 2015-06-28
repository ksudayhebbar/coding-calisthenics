package com.app.ab.factory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class ChangeVendingMachine {

	private final int[] denominations = { 200, 100, 50, 20, 10, 5, 2, 1 };

	private List<Integer> moneyBag = new ArrayList<Integer>();

	public ChangeVendingMachine() {
		// TODO Auto-generated constructor stub
	}

	public ChangeVendingMachine(List<Integer> cash) {

		for (Integer money : cash) {
			moneyBag.add(money);
		}
	}

	public boolean vendingMachine(int amount) {
		int tempAmount = amount;
		int[] tempArray = new int[50]; // combination of coins made
		int coinCombiIndex = 0, denomCoinIndex = 0;
		// whilst all denominations havent been visited
		boolean bflag = false;
		while (denomCoinIndex < denominations.length) {

			// if i have the correct change
			if (amount - denominations[denomCoinIndex] == 0) {
				tempArray[coinCombiIndex] = denominations[denomCoinIndex];

				denomCoinIndex++; // increment so that next iteration starts
									// with lower denom
				printCoins(tempArray); // return coins
				bflag = priorityTheConies(tempArray, tempAmount);
				if (bflag) {
					break;
				}
			}

			// checks to see whether new total minus coin (denominator) is still
			// >= 0
			else if (amount - denominations[denomCoinIndex] >= 0) {

				// if so SUBTRACT from total and ADD coin to
				// coin-combination-array
				amount = amount - denominations[denomCoinIndex];
				tempArray[coinCombiIndex] = denominations[denomCoinIndex];
				coinCombiIndex++;

			} else {
				denomCoinIndex++;

			}
		}
		return bflag;
	}

	private boolean priorityTheConies(int[] tempArray, int amount) {
		List<Integer> combList = new ArrayList<Integer>();
		Map<Integer, ArrayList<Integer>> combMap = new HashMap<Integer, ArrayList<Integer>>();

		int count = 0;
		int sum = 0;
		List<Integer> list = new ArrayList<Integer>();
		for (int j = 0; j < tempArray.length; j++) {
			if (tempArray[j] > 0) {
				if (sum != amount) {
					sum += tempArray[j];
					list.add(tempArray[j]);
					count++;
				}
			}
		}
		combMap.put(count, (ArrayList<Integer>) list);

		return findChangeInMoneyBag(combMap);

	}

	private boolean findChangeInMoneyBag(
			Map<Integer, ArrayList<Integer>> combMap) {
		boolean bFlag = false;
		int key = 0;
		for (Map.Entry<Integer, ArrayList<Integer>> list : combMap.entrySet()) {
			if (list.getKey() != 1) {
				for (Integer i : list.getValue()) {
					bFlag = moneyBag.remove(i);

				}
				if (bFlag) {
					key = list.getKey();
				}
			}

		}
		if (bFlag) {
			ArrayList<Integer> arrayList = combMap.get(key);
			for (int j : arrayList) {
				System.out.println(j + "  :");
			}
		}
		return bFlag;
	}

	private void printCoins(int[] tempArray) {
		/*
		 * for (int i = 0; i < tempArray.length - 1; i++) {
		 * 
		 * // to stop my array from printing out any non-denominator coins e.g
		 * if (tempArray[i] > 0) { System.out.print(tempArray[i] + ": "); }
		 * 
		 * if (tempArray[i] != 0) { System.out.println("\n"); }
		 * 
		 * }
		 */
	}

	public static void main(String[] args) {
		Random generator = new Random();
		List<Integer> inti = new ArrayList<Integer>();
		for (int i = 0; i < 1000; i++) {
			inti.add(generator.nextInt(200));
		}

		ChangeVendingMachine changeVendingMachine = new ChangeVendingMachine(
				inti);
		boolean b = changeVendingMachine.vendingMachine(100);
		System.out.println("suscsfully return the coin " + b);
		changeVendingMachine.vendingMachine(2);
	}
}
