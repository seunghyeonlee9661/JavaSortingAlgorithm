package main;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import sortings._01_BubbleSort;
import sortings._02_SelectionSort;
import sortings._03_DoubleSelectionSort;
import sortings._04_InsertionSort;
import sortings._05_MergeSort;
import sortings._06_QuickSort;
import sortings._07_HeapSort;
import sortings._08_TreeSort;
import sortings._09_TimSort;
import sortings._10_IntroSort;
import sortings._11_RadixSort;
import sortings._12_ShellSort;
import sortings._13_SleepSort;
import sortings._14_GravitySort;

public class Main {
	public static void main(String[] args) {
		int[] list = generateArr(30);
		Scanner input = new Scanner(System.in);

		int[] answer = new int[list.length];
		for (int i = 0; i < list.length; i++)
			answer[i] = list[i];
		Arrays.sort(answer);

		boolean exit = true;

		while (exit) {
			System.out.print("Select Sorting! : ");
			switch (input.nextInt()) {
			case 0: {
				exit = false;
				break;
			}
			case 1: {
				System.out.println("Bubble Sorting! :");
				show(new _01_BubbleSort(list));
				break;
			}
			case 2: {
				System.out.println("Selection Sorting! :");
				show(new _02_SelectionSort(list));
				break;
			}

			case 3: {
				System.out.println("Double Selection Sorting! :");
				show(new _03_DoubleSelectionSort(list));
				break;
			}
			case 4: {
				System.out.println("Insertion Sorting! :");
				show(new _04_InsertionSort(list));
				break;
			}

			case 5: {
				System.out.println("Merge Sorting! :");
				show(new _05_MergeSort(list));
				break;
			}
			case 6: {
				System.out.println("Quick Sorting! :");
				show(new _06_QuickSort(list));
				break;
			}

			case 7: {
				System.out.println("Heap Sorting! :");
				show(new _07_HeapSort(list));
				break;
			}

			case 8: {
				System.out.println("Tree Sorting! :");
				show(new _08_TreeSort(list));
				break;
			}

			case 9: {
				System.out.println("Tim Sorting! :");
				show(new _09_TimSort(list));
				break;
			}

			case 10: {
				System.out.println("Intro Sorting! :");
				show(new _10_IntroSort(list));
				break;
			}

			case 11: {
				System.out.println("Radix Sorting! :");
				show(new _11_RadixSort(list));
				break;
			}

			case 12: {
				System.out.println("Shell Sorting! :");
				show(new _12_ShellSort(list));
				break;
			}

			case 13: {
				System.out.println("Sleep Sorting! :");
				show(new _13_SleepSort(list));
				break;
			}

			case 14: {
				System.out.println("Gravity Sorting! :");
				show(new _14_GravitySort(list));
				break;
			}
			default:
				System.out.println("Worng Input!!");
				break;
			}

			for (int i = 0; i < list.length; i++)
				if (list[i] != answer[i]) {
					System.out.println("틀렸음 (" + i + ") :" + list[i] + "/" + answer[i]);

					System.out.print("[");
					for (int j : answer) {

						System.out.print(j + ", ");
					}
					System.out.println("]");
					return;
				}
			System.out.println("맞았음");
		}

	}

	private static int[] generateArr(int size) {
		Random rand = new Random();
		Set<Integer> set = new HashSet<>();
		while (set.size() < size) {
			int randInt = rand.nextInt(1000);
			set.add(randInt);
		}

		return set.stream().mapToInt(Integer::intValue).toArray();
	}

	private static void show(Sort sort) {
		System.out.println("Before");
		System.out.println(sort);
		sort.sort();
		System.out.println("");
		System.out.println("After");
		System.out.println(sort);

	}

}