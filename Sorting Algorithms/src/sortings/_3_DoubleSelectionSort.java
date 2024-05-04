package sortings;

import main.Sort;

public class _3_DoubleSelectionSort extends Sort {

	public _3_DoubleSelectionSort(int[] list) {
		super(list);
	}

	public void sort() {
		int size = getSize();
		int[] list = getList();
		int least;
		int most;

		for (int i = 0; i < size - i; i++) {
//			System.out.println("");
//			System.out.print("i : ");
//			System.out.println(i);
//			System.out.println(list);

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
