package sortings;

import java.util.ArrayList;

public class _4_InsertionSort extends Sort {

	public _4_InsertionSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		int size = super.getSize();
		ArrayList<Integer> list = super.getList();

		for (int i = 1; i < size; i++) {
			int target = i;
			for (int j = i - 1; j >= 0; j--) {
				if (list.get(target) < list.get(j)) {
					swap(target--, j);
				} else {
					break;
				}
			}
		}
	}
}
