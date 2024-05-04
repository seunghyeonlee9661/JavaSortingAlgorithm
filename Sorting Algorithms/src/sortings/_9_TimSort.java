package sortings;

import main.Sort;

public class _9_TimSort extends Sort {
	static int RUN_SIZE = 8;

	public _9_TimSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int size = this.getSize();

		System.out.print("INSERTION");
		for (int i = 0; i < size; i += RUN_SIZE) {
			insertionSort(list, i, Math.min((i + RUN_SIZE - 1), (size - 1)));
		}
		System.out.print(list);

		while (RUN_SIZE < size) {

			for (int left = 0; left < size; left += 2 * RUN_SIZE) {
				int mid = left + RUN_SIZE;
				int right = Math.min((left + 2 * RUN_SIZE - 1), (size - 1));

				merge(list, left, mid, right);
			}

			RUN_SIZE *= 2;
		}

	}

	public void insertionSort(int[] list, int left, int right) {
		for (int i = left + 1; i < right; i++) {
			int least = i;

			for (int j = i - 1; j >= left; j--) {
				if (list[least] < list[j]) {
					swap(least--, j);
				} else {
					break;
				}
			}
		}
	}

	private void merge(int[] list, int left, int mid, int right) {

		int i = left;
		while (i <= mid) {
			if (list[i] > list[mid + 1]) {
				swap(i, mid + 1);
				for (var j = mid + 1; j < right; j++) {
					if (list[j] > list[j + 1]) {
						swap(j, j + 1);
					}
				}
			}
			i++;
		}
	}
}
