package sortings;

import java.util.PriorityQueue;

import main.Sort;

public class _07_HeapSort extends Sort {

	public _07_HeapSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int size = this.getSize();

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < size; i++) {
			heap.add(list[i]);
		}

		for (int i = 0; i < size; i++) {
			list[i] = heap.poll();
		}

	}
}
