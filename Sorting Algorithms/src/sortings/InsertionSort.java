package sortings;

import main.Sort;

public class InsertionSort extends Sort {

	public InsertionSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = getList();

		for (int i = 1; i < list.length; i++) {
			int target = i;
			for (int j = i - 1; j >= 0; j--) {
				if (list[target] < list[j]) {
					swap(target--, j);
				} else {
					break;
				}
			}
		}
	}
}
