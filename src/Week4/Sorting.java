package Week4;
import java.io.*;
import java.util.*;

public class Sorting {
	private static Random random = new Random();

	// Basically you set up 3 partitions: less than, equals to, and greater than a certain pivot.
	// The equal-to partition doesn't need further sorting because all its elements are already equal.

	private static int[] partition3(int[] a, int start, int end) {
		// write your code here
		int ltpIndex = start; //less than partition 
		int gtpIndex = end; //greater than partition
		int i = start;
		int pivot = a[start];
		
		while (i <= gtpIndex) {
			if (a[i] < pivot) {
				swap(a, i, ltpIndex);
				ltpIndex++;
				i++;
			} else if (a[i] > pivot) {
				swap(a, i, gtpIndex);
				gtpIndex--;
			} else {
				i++;
			}
		}
		
		int[] m = { ltpIndex, gtpIndex };
		return m;
	}

	private static int partition2(int[] a, int start, int end) {
		// anything lesser than pivot will be pushed left of pIndex
		int pivot = a[start];
		int pIndex = start;
		for (int i = start + 1; i <= end; i++) {
			if (a[i] <= pivot) {
				pIndex++;
				swap(a, i, pIndex);

			}
		}
		swap(a, start, pIndex);
		return pIndex;
	}

	private static void swap(int a[], int i, int j) {
		int temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}

	private static void randomizedQuickSort(int[] a, int start, int end) {

		if (start >= end) {
			return;
		}
		int pivot = random.nextInt(end - start + 1) + start;

		// swap the contents of low with the pivot
		// a[start] = a[pivot]
		// a[pivot] = a[start]


		swap(a, start, pivot);
		
		//use partition2
		// pIndex = partition index
		//int pIndex = partition2(a, start, end);
		//randomizedQuickSort(a, start, pIndex - 1);
		//randomizedQuickSort(a, pIndex + 1, end);
		
		// use partition3
		int[] m = partition3(a, start, end);
		randomizedQuickSort(a, start, m[0] - 1);
		randomizedQuickSort(a, m[1] + 1, end);
	}

	public static void main(String[] args) {
		FastScanner scanner = new FastScanner(System.in);
		
		
		 int n = scanner.nextInt(); 
		 int[] a = new int[n]; 
		 for (int i = 0; i < n; i++) { 
			 a[i] = scanner.nextInt(); 
		 }
		 
		 /*
		 System.out.println(n);
		 
		 for (int i=0; i<a.length; i++) {
			 System.out.println(a[i]);
		 }*/
		
		/*
		int n = 5;
		int[] a = { 2, 3, 9, 2, 2 };*/
		randomizedQuickSort(a, 0, n - 1);
		for (int i = 0; i < n; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static class FastScanner {
		BufferedReader br;
		StringTokenizer st;

		FastScanner(InputStream stream) {
			try {
				br = new BufferedReader(new InputStreamReader(stream));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		String next() {
			while (st == null || !st.hasMoreTokens()) {
				try {
					st = new StringTokenizer(br.readLine());
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			return st.nextToken();
		}

		int nextInt() {
			return Integer.parseInt(next());
		}
	}
}
