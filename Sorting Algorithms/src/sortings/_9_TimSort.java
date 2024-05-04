package sortings;

import java.util.ArrayList;

public class _9_TimSort extends Sort {
	static int RUN_SIZE = 8;

	public _9_TimSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		ArrayList<Integer> list = super.getList();
		int size = this.getSize();

		for (int i = 0; i < size; i += RUN_SIZE) {
			insertionSort(list, i, Math.min((i + RUN_SIZE - 1), (size - 1)));
		}

		for (int runSize = RUN_SIZE; runSize < size; runSize = 2 * runSize) {

			for (int left = 0; left < size; left += 2 * runSize) {

				int mid = left + runSize - 1;
				int right = Math.min((left + 2 * runSize - 1), (size - 1));
				merge(list, left, mid, right);
			}
		}

	}

	public void insertionSort(ArrayList<Integer> list, int left, int right) {
		System.out.print("INSERTION :");
		System.out.println(list.subList(left, right));
		for (int i = left + 1; i < right; i++) {
			int target = i;

			for (int j = i - 1; j >= left; j--) {
				if (list.get(target) < list.get(j)) {
					swap(target--, j);
				} else {
					break;
				}
			}
		}
	}

	private void merge(ArrayList<Integer> list, int left, int mid, int right) {
		System.out.print("MERGE :");
		System.out.println(list.subList(left, right));

		int i = left;
		while (i <= mid) {
			if (list.get(i) > list.get(mid + 1)) {
				swap(i, mid + 1);
				for (var j = mid + 1; j < right; j++) {
					if (list.get(j) > list.get(j + 1)) {
						swap(j, j + 1);
					}
				}
			}
			i++;
		}

		System.out.println(">>>>");
		System.out.println(list.subList(left, right));
	}
}
