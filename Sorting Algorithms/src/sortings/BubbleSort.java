package sortings;

import main.Sort;

public class BubbleSort extends Sort {

	public BubbleSort(int[] list) {
		super(list);
	}

	public void sort() {
		int[] list = getList();

		for (int i = 0; i < list.length - 1; i++) {
			for (int j = 0; j < (list.length - i) - 1; j++) {
				if (list[j] > list[j + 1]) {
					swap(j, j + 1);
				}
			}
		}
	}

}
