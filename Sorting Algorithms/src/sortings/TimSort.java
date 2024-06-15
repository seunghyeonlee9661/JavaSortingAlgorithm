package sortings;

import main.Sort;

public class TimSort extends Sort {
	static int RUN = 5;

	public TimSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int length = this.getSize();

		for (int i = 0; i < length; i += RUN) {
			insertionSort(list, i, Math.min((i + RUN - 1), (length - 1)));
		}

		for (int size = RUN; size < length; size = 2 * size) {
			for (int left = 0; left < length; left += 2 * size) {
				merge(list, left, left + size - 1, Math.min((left + 2 * size - 1), (length - 1)));
			}
		}

	}

	public void insertionSort(int[] list, int left, int right) {
		for (int i = left + 1; i <= right; i++) {

			int target = i;

			for (int j = i - 1; j >= left; j--) {
				if (list[target] < list[j]) {
					swap(target--, j);
				} else {
					break;
				}
			}
		}
	}

	public static void merge(int[] arr, int min, int middle, int max) {
		int[] result = new int[max - min + 1];
		int j = middle + 1;
		int cnt = 0;

		for (int i = min; i < middle + 1; i++) {

			while (j < max + 1 && arr[i] > arr[j]) {
				result[cnt++] = arr[j++];
			}
			result[cnt++] = arr[i];
		}

		while (j < max + 1) {
			result[cnt++] = arr[j++];
		}

		for (int i : result) {
			arr[min++] = i;
		}
	}
}
