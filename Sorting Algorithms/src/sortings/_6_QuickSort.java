package sortings;

import java.util.ArrayList;

public class _6_QuickSort extends Sort {

	public _6_QuickSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		ArrayList<Integer> list = super.getList();
		int size = this.getSize();
		pivotSort(list, 0, size - 1);
	}

	public void pivotSort(ArrayList<Integer> list, int min, int max) {
		if (min < max) {
			int pivot = partition(list, min, max);
			pivotSort(list, min, pivot);
			pivotSort(list, pivot + 1, max);
		}
		return;
	}

	private int partition(ArrayList<Integer> list, int min, int max) {
		int pivot = list.get((min + max) / 2);

		while (true) {
			while (list.get(min) < pivot)
				min++;
			while (list.get(max) > pivot && min <= max)
				max--;
			if (min >= max)
				return max;

			swap(min, max);
		}
	}

}
