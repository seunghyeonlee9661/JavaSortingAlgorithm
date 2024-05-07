package sortings;

import main.Sort;

public class _01_BubbleSort extends Sort {

	public _01_BubbleSort(int[] list) {
		super(list);
	}

	public void sort() {
		int size = getSize();
		int[] list = getList();

		for (int i = 0; i < size - 1; i++) {
			for (int j = 0; j < (size - i) - 1; j++) {
				if (list[j] > list[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

}
