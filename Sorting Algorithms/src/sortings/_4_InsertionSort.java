package sortings;

import main.Sort;

public class _4_InsertionSort extends Sort {

	public _4_InsertionSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int size = getSize();
		int[] list = getList();

		for (int i = 1; i < size; i++) {
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
