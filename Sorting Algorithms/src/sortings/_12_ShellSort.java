package sortings;

import main.Sort;

public class _12_ShellSort extends Sort {

	public _12_ShellSort(int[] list) {
		super(list);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int gap = list.length / 2;

		while (gap > 0) {
			for (int left = 0; left < gap; left++) {
				for (int i = left + gap; i < list.length; i += gap) {
					int target = i;
					for (int j = i - gap; j >= left; j -= gap) {
						if (list[target] < list[j])
							swap(target--, j);
						else
							break;

					}
				}

			}
			gap /= 2;
		}
	}

}
