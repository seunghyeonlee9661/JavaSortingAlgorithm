package sortings;

import java.util.PriorityQueue;

import main.Sort;

public class _10_IntroSort extends Sort {
	public _10_IntroSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int depth = (int) (Math.log(list.length) * 2);

		intro(list, depth, 0, list.length - 1);
	}

	private void intro(int[] list, int depth, int start, int end) {
		System.out.println("__________________________________________________________________");
		System.out.println("DEPTH :" + depth);
		System.out.print("LIST : [");
		for (int i = start; i < end; i++)
			System.out.print(list[i] + ", ");
		System.out.println(list[end] + "]");

		if (list.length <= 1) {
			System.out.println("REATURN (list.length <= 1)");
			return;
		} else if (depth == 0) {
			System.out.println("HEAPSORT");
			heapsort(list, start, end);
		} else {
			if (start >= end) {
				System.out.println("REATURN (start >= end)");
				return;
			}
			System.out.println("QUICK SORT");
			int pivot = partition(list, start, end);
			System.out.println("pivot = " + pivot);
			intro(list, depth - 1, start, pivot);
			intro(list, depth - 1, pivot + 1, end);
		}

	}

	private void heapsort(int[] list, int start, int end) {
		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = start; i < end; i++) {
			heap.add(list[i]);
		}

		for (int i = start; i < end; i++) {
			list[i] = heap.poll();
		}
	}

	private int partition(int[] list, int start, int end) {
		int pivot = list[(start + end) / 2];

		System.out.println("PIVOT:" + pivot + " | START:" + start + " | END:" + end);

		while (true) {
			while (list[start] < pivot)
				start++;
			while (list[end] > pivot && start <= end)
				end--;
			if (start >= end)
				return end;
			swap(start, end);
		}
	}

}
