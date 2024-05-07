package sortings;

import main.Sort;

public class _14_GravitySort extends Sort {

	public _14_GravitySort(int[] list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		int[] list = super.getList();

		int max = list[0];
		for (int i = 1; i < list.length; i++) {
			if (list[i] > max) {
				max = list[i];
			}
		}

		int[][] beads = new int[list.length][max];
		for (int i = 0; i < list.length; i++) {
			for (int j = 0; j < list[i]; j++) {
				beads[i][j] = 1;
			}
		}

		for (int j = 0; j < max; j++) {
			int sum = 0;
			for (int i = 0; i < list.length; i++) {
				sum += beads[i][j];
				beads[i][j] = 0;
			}

			for (int i = list.length - 1; i >= list.length - sum; i--) {
				list[i] = j + 1;
			}
		}
	}

}
