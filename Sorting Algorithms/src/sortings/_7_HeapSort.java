package sortings;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class _7_HeapSort extends Sort {

	public _7_HeapSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		ArrayList<Integer> list = super.getList();
		int size = this.getSize();

		PriorityQueue<Integer> heap = new PriorityQueue<Integer>();

		for (int i = 0; i < size; i++) {
			heap.add(list.get(i));
		}

		for (int i = 0; i < size; i++) {
			list.set(i, heap.poll());
		}

	}
}
