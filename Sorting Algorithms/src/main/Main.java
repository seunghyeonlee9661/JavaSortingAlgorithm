package main;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import sortings._1_BubbleSort;
import sortings._3_DoubleSelectionSort;
import sortings.GravitySort;
import sortings._7_HeapSort;
import sortings._4_InsertionSort;
import sortings._10_IntroSort;
import sortings._5_MergeSort;
import sortings._6_QuickSort;
import sortings.RadixSort;
import sortings._2_SelectionSort;
import sortings.ShellSort;
import sortings.SleepSort;
import sortings.Sort;
import sortings._9_TimSort;
import sortings._8_TreeSort;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = generateArr(50);
		Scanner input = new Scanner(System.in);
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
				show(new _1_BubbleSort(list));
				break;
			}
			case 2: {
				System.out.println("Selection Sorting! :");
				show(new _2_SelectionSort(list));
				break;
			}

			case 3: {
				System.out.println("Double Selection Sorting! :");
				show(new _3_DoubleSelectionSort(list));
				break;
			}
			case 4: {
				System.out.println("Insertion Sorting! :");
				show(new _4_InsertionSort(list));
				break;
			}

			case 5: {
				System.out.println("Merge Sorting! :");
				show(new _5_MergeSort(list));
				break;
			}
			case 6: {
				System.out.println("Quick Sorting! :");
				show(new _6_QuickSort(list));
				break;
			}

			case 7: {
				System.out.println("Heap Sorting! :");
				show(new _7_HeapSort(list));
				break;
			}

			case 8: {
				System.out.println("Tree Sorting! :");
				show(new _8_TreeSort(list));
				break;
			}

			case 9: {
				System.out.println("Tim Sorting! :");
				show(new _9_TimSort(list));
				break;
			}

			case 10: {
				System.out.println("Intro Sorting! :");
				show(new _10_IntroSort(list));
				break;
			}

			case 11: {
				System.out.println("Radix Sorting! :");
				show(new RadixSort(list));
				break;
			}

			case 12: {
				System.out.println("Shell Sorting! :");
				show(new ShellSort(list));
				break;
			}

			case 13: {
				System.out.println("Sleep Sorting! :");
				show(new SleepSort(list));
				break;
			}

			case 14: {
				System.out.println("Gravity Sorting! :");
				show(new GravitySort(list));
				break;
			}
			default:
				System.out.println("Worng Input!!");
				break;
			}
		}
	}

	private static ArrayList<Integer> generateArr(int size) {
		Random rand = new Random();
		ArrayList<Integer> list = new ArrayList<>();
		while (list.size() < size) {
			int randInt = rand.nextInt(1000);
			if (!list.contains(randInt)) {
				list.add(randInt);
			}
		}
		return list;
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