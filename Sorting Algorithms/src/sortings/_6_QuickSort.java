package sortings;

import main.Sort;

public class _6_QuickSort extends Sort {

	public _6_QuickSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int size = this.getSize();
		divide(list, 0, size - 1);
	}

	public void divide(int[] list, int min, int max) {
		if (min < max) {
			int pivot = getPivot(list, min, max);
			divide(list, min, pivot);
			divide(list, pivot + 1, max);
		}
		return;
	}

	private int getPivot(int[] list, int min, int max) {
		int pivot = list[(min + max) / 2];

		while (true) {
			while (list[min] < pivot)
				min++;
			while (list[max] > pivot && min <= max)
				max--;
			if (min >= max)
				return max;

			swap(min, max);
		}
	}

}
