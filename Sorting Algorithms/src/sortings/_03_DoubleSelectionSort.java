package sortings;

import main.Sort;

public class _03_DoubleSelectionSort extends Sort {

	public _03_DoubleSelectionSort(int[] list) {
		super(list);
	}

	public void sort() {
		int size = getSize();
		int[] list = getList();
		int least;
		int most;

		for (int i = 0; i < size - i; i++) {
			least = i;
			most = size - 1 - i;

			for (int j = i; j < size - i; j++) {
				if (list[j] < list[least]) {
					least = j;
				}
				if (list[j] > list[most]) {
					most = j;
				}
			}
			if (least != i) {
				swap(i, least);

			}
			if (most != size - 1 - i) {
				if (most == i) {
					most = least;
				}
				swap(size - 1 - i, most);
			}
		}
	}
}
