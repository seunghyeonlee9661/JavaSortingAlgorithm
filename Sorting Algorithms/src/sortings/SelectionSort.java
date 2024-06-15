package sortings;

import main.Sort;

public class SelectionSort extends Sort {

	public SelectionSort(int[] list) {
		super(list);
	}

	public void sort() {
		int size = getSize();
		int[] list = getList();
		int least;

		for (int i = 0; i < size - 1; i++) {
			least = i;

			for (int j = i + 1; j < size; j++) {
				if (list[j] < list[least])
					least = j;
			}
			if (least != i)
				swap(i, least);
		}
	}
}
