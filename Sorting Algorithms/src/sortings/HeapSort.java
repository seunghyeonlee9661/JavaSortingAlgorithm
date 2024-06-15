package sortings;

import main.Sort;

public class HeapSort extends Sort {

	public HeapSort(int[] list) {
		super(list);
	}

	public void sort() {
		int[] list = super.getList();

		for (int i = list.length - 1; i >= 0; i--) {
			heapify(list, i);
			if (list[0] > list[i]) {
				swap(0, i);
			}
		}
	}

	public void heapify(int[] list, int i) {
		int index = (i / 2) - 1;
		while (index >= 0) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;

			if (list[left] >= list[right] && list[index] < list[left]) {
				swap(index, left);
			} else if (list[right] > list[left] && list[index] < list[right]) {
				swap(index, right);
			}
			index--;
		}
	}
}
