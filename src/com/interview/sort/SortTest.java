package com.interview.sort;

import java.time.chrono.MinguoChronology;

public class SortTest {
	 
	void bubbleSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
	}

	void selectSort(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			int min = arr[i];
			int minIndex = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (min > arr[j]) {
					min = arr[j];
					minIndex = j;
				}
			}
			if (minIndex != i) {
				int temp = arr[i];
				arr[i] = min;
				arr[minIndex] = temp;
			}
		}
	}

	void insertSort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = i; j >= 0; j--) {
				if (arr[j] > arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}

		}
	}

	void mergeSort(int[] arr) {
		int[] temp = new int[arr.length];
		mergeSort(arr, temp, 0, arr.length - 1);
	}

	void mergeSort(int[] arr, int[] temp, int start, int end) {
		if (start < end) {
			int middle = (start + end) / 2;
			mergeSort(arr, temp, start, middle);
			mergeSort(arr, temp, middle + 1, end);
			merge(arr, temp, start, middle, end);
		}
	}

	void merge(int[] arr, int[] temp, int start, int middle, int end) {
		int i = start;
		int j = middle + 1;
		int cnt = 0;

		while (i <= middle && j <= end) {
			if (arr[i] < arr[j]) {
				temp[cnt++] = arr[i++];
			} else {
				temp[cnt++] = arr[j++];
			}
		}

		while (i <= middle) {
			temp[cnt++] = arr[i++];
		}
		while (j <= end) {
			temp[cnt++] = arr[j++];
		}

		for (int k = 0; k < cnt; k++) {
			arr[start + k] = temp[k];
		}
	}

	void quickSort(int[] arr) {
		quickSort(arr, 0, arr.length-1);
	}


	void quickSort(int[] arr, int less, int large) {
		if (less >= large) {
			return;
		}
		int pivot = arr[large];
		int end = arr[large];
		arr[large] = pivot;
		arr[(less + large) / 2] = end;

		int i = less;
		int j = large - 1;
		while (i < j) {
			while (arr[i] <= pivot && i < j) {
				i++;
			}
			while (arr[j] >= pivot && i < j) {
				j--;
			}
			if (arr[i] >= arr[j]) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
				i++;
				j--;
			}
		}
 
		if (arr[i] > pivot) {
			arr[large] = arr[i];
			arr[i] = pivot;
		}
		
		quickSort(arr, less, i - 1);
		quickSort(arr, i + 1, large);

	}

	void shellSort(int[] arr) {
		for (int gap = arr.length / 2; gap > 0; gap /= 2) {
			for (int i = 0; i < gap; i++) {
				for (int j = i + gap; j < arr.length; j++) {
					if (arr[j] < arr[j - gap]) {
						int temp = arr[j];
						int k = j - gap;
						while (k >= 0 && arr[k] > temp) {
							arr[k + gap] = arr[k];
							k -= gap;
						}
						arr[k + gap] = temp;
					}
				}
			}
		}
	}

	void heapSort(int[] arr) {
		int lastParent = (arr.length-1)/2;
		for (int i = lastParent; i >=0; i--) {
			maxHeapify(arr, i, arr.length);
		}
		
		for (int i = arr.length-1; i >0 ;i--){
			swap(arr, 0,i);
			maxHeapify(arr, 0, i);
		}
	}

	void swap(int[] arr, int i, int j){
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}
	
	//递归实现
//	void maxHeapify(int[] arr, int index, int heapSize) {
//		int max = index;
//		int left = index * 2 + 1;
//		int right = index * 2 + 2;
//
//		if (left < heapSize && arr[max] < arr[left]) {
//			max = left;
//		}
//
//		if (right < heapSize && arr[max] < arr[right]) {
//			max = right;
//		}
//
//		if (max != index) {
//			int temp = arr[index];
//			arr[index] = arr[max];
//			arr[max] = temp;
//
//			maxHeapify(arr, max, heapSize);
//		}
//
//	}
	
	//循环实现
	
	void maxHeapify(int[] arr, int index, int heapSize) {
		
		
		while(true){
			int max = index;
			int left = 2*index+1;
			int right = 2*index+2;
			if (left < heapSize && arr[max] < arr[left]) {
				max = left;
			}
			if (right <heapSize && arr[max] <arr[right]) {
				max = right;
			}
			
			if (max !=index) {
				swap(arr, index,max);
				index = max;
			}else {
				break;
			}
		}
	}

	public static void main(String[] args) {
		SortTest test = new SortTest();
		int[] arr = {5, 3, 4, 2, 1, 6, 7, 8,9,10 };
		// test.bubbleSort(arr);
		// test.selectSort(arr);
		// test.insertSort(arr);
		// test.mergeSort(arr);
		 test.quickSort(arr);

		//test.shellSort(arr);
		//test.heapSort(arr);
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
