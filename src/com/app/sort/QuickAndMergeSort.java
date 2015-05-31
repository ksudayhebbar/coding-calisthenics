package com.app.sort;

public class QuickAndMergeSort {
	private int[] a;
	private int[] helper;

	public QuickAndMergeSort() {

	}

	public QuickAndMergeSort(int[] array) {
		this.a = array;
	}

	public void sort() {
		int left = 0;
		int right = a.length - 1;
		quickSort(left, right);
	}

	public void mSort() {
		this.helper = new int[a.length];
		mergesort(0, a.length - 1);
	}

	private void mergesort(int low, int high) {
		if (low < high) {
			// Get the index of the element which is in the middle
			int middle = low + (high - low) / 2;
			// Sort the left side of the array
			mergesort(low, middle);
			// Sort the right side of the array
			mergesort(middle + 1, high);
			// Combine them both
			merge(low, middle, high);
		}

	}

	private void merge(int low, int middle, int high) {
		// Copy both parts into the helper array
		for (int i = low; i <= high; i++) {
			helper[i] = a[i];
		}
		int i = low;
		int j = middle + 1;
		int k = low;
		// Copy the smallest values from either the left or the right side back
		// to the original array
		while (i <= middle && j <= high) {
			if (helper[i] <= helper[j]) {
				a[k] = helper[i];
				i++;
			} else {
				a[k] = helper[j];
				j++;
			}
			k++;
		}
		// Copy the rest of the left side of the array into the target array
		while (i <= middle) {
			a[k] = helper[i];
			k++;
			i++;
		}

	}

	private void quickSort(int left, int right) {
		if (left >= right)
			return;
		int pivot = a[right];

		int partition = partition(left, right, pivot);
		quickSort(left, partition - 1);
		quickSort(partition + 1, right);

	}

	private int partition(int left, int right, int pivot) {
		int leftCur = left - 1;
		int rightCur = right;
		while (leftCur < rightCur) {
			while (a[++leftCur] < pivot)
				;
			while (rightCur > 0 && a[--rightCur] > pivot)
				;
			if (leftCur >= rightCur) {
				break;

			} else {
				swap(leftCur, rightCur);

			}

		}
		swap(leftCur, right);
		return leftCur;
	}

	private void swap(int leftCur, int rightCur) {
		int temp = a[leftCur];
		a[leftCur] = a[rightCur];
		a[rightCur] = temp;
	}

	public void display() {
		for (int ai : a) {
			System.out.println(ai);
		}
	}
}
