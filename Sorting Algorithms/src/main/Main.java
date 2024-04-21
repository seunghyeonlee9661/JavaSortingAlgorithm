package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;
import sortings.BubbleSort;
import sortings.DoubleSelectionSort;
import sortings.InsertionSort;
import sortings.MergeSort;
import sortings.SelectionSort;
import sortings.Sort;

public class Main {
	public static void main(String[] args) {
		ArrayList<Integer> list = generateArr(11);	
		Scanner input = new Scanner(System.in);
		boolean exit = true;
		
		while(exit) {
			System.out.print("Select Sorting! : ");
			switch (input.nextInt()) {
			case 0:{
				exit = false;
				break;
			}			
			case 1: {
				System.out.println("Bubble Sorting! :");
				show(new BubbleSort(list));		
				break;			
			}
			case 2: {
				System.out.println("Selection Sorting! :");
				show(new SelectionSort(list));		
				break;	
			}

			case 3: {
				System.out.println("Double Selection Sorting! :");
				show(new DoubleSelectionSort(list));		
				break;	
			}
			case 4: {
				System.out.println("Insertion Sorting! :");
				show(new InsertionSort(list));		
				break;	
			}
			
			case 5: {
				System.out.println("Merge Sorting! :");
				show(new MergeSort(list));		
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
		while(list.size() < size) {
			int randInt = rand.nextInt(1000);
			if(!list.contains(randInt)) {
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
