package com.app.sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class SortAndDuplicate {

	public static List<Integer> duplicate(List<Integer> list) {
		Set<Integer> tempSet = new HashSet<Integer>();
		for (Integer i : list) {
			tempSet.add(i);
		}

		list.clear();
		list.addAll(tempSet);
		return list;
	}

	public static void sort(int[] a) {
		if (a == null || a.length <= 1)
			return;

		int i = 0, j = a.length - 1;
		while (i <= j) {
			while (a[i] < 0 && i <= j)
				i++;
			while (a[j] > 0 && i <= j)
				j--;
			if (i < j) {
				swap(a, i, j);
			}

			i++;
			j--;
		}
		for (i = 0; i < a.length; i++) {
			for (j = 0; j < a.length; j++) {
				if ((a[i] > 0) && a[j] > 0) {
					if ((a[i]) < a[j]) {
						swap(a, i, j);
					}
				}
			}
		}

	}

	private static void swap(int[] a, int i, int j) {
		int temp = a[i];
		if(temp>0){
		System.out.println("temp"+temp);
		a[i] = a[j];
		System.out.println("a[j]"+a[j]);
		a[j] = temp;
		}else{
			 temp = a[j];
			 a[j] = a[i];
			 a[i] = temp;
		}

	}

	public void sortWithAbs(int a[]) {

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < a.length; j++) {
				if (Math.abs(a[i]) > Math.abs(a[j])) {
					swap(a, i, j);
				}

			}
		}
	}

	public static void main(String[] args) {
		List<Integer> l = new ArrayList<Integer>();
		l.add(1);
		l.add(1);
		l.add(2);
		l.add(2);
		l.add(3);
		l.add(3);
		l.add(4);
		l.add(4);
		l.add(5);
		l.add(5);

		System.out.println(SortAndDuplicate.duplicate(l));
		int[] a = { -1, 2, 1, 12, -9, 3, -4, 4, -3, 21, 52, 4, -2 };

		SortAndDuplicate.sort(a);
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

}
