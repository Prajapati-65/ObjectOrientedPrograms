package com.bridgelabz.Programs;

import java.util.Scanner;

public class SkillTest {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of test case :");
		int n = sc.nextInt();
		int res[] = new int[n];
		for (int i = 0; i < n; i++) {
			int array[] = test();
			sort(array);
			System.out.println();
			int a = caloriesBurnt(array);
			res[i] = a;
		}
		display(res);
	}

	static int[] test() {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of days");
		int n = scanner.nextInt();
		System.out.println("Enter " + n + " values ");
		int a[] = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = scanner.nextInt();
		}
		return a;
	}

	static int[] sort(int a[]) {
		for (int i = 0; i < a.length; i++) {
			for (int j = i; j < a.length; j++) {
				if (a[i] < a[j]) {
					int t = a[i];
					a[i] = a[j];
					a[j] = t;
				}
			}
		}
		return a;
	}

	static void display(int a[]) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
	}

	static int caloriesBurnt(int arr[]) {
		int count = 0;
		int cal = 0;
		for (int i = 0; i < arr.length; i++) {
			int x = 2 * count + arr[i];
			count = count + arr[i];
			cal = cal + x;
		}
		return cal;
	}

}
