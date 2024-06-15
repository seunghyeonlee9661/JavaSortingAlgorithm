package sortings;

import java.util.Arrays;

import main.Sort;

public class MergeSort extends Sort {

	public MergeSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		super.setList(divide(list));
	}

	private int[] divide(int[] list) {
		if (list.length > 1) {
			return merge(divide(Arrays.copyOfRange(list, 0, list.length / 2)),
					divide(Arrays.copyOfRange(list, list.length / 2, list.length)));
		} else
			return list;
	};

	private int[] merge(int[] left, int[] right) {
		int[] result = new int[left.length + right.length];
		int j = 0;
		int cnt = 0;

		for (int i = 0; i < left.length; i++) {
			while (j < right.length && left[i] > right[j]) {
				result[cnt++] = right[j++];
			}
			result[cnt++] = left[i];
		}

		while (j < right.length) {
			result[cnt++] = right[j++];
		}
		return result;
	}

}
