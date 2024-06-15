package sortings;

import java.util.LinkedList;
import java.util.Queue;

import main.Sort;

public class RadixSort extends Sort {

	public RadixSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int topRadix = getTopRadix(list);

		Queue<Integer>[] buckets = new LinkedList[10];
		for (int i = 0; i < 10; i++) {
			buckets[i] = new LinkedList<>();
		}

		int radix = 0;
		while (topRadix > radix) {
			int listIdx = 0;

			for (int i : list) {
				int num = (int) (i / Math.pow(10, radix) % 10);
				buckets[num].add(i);
			}

			for (int j = 0; j < 10; j++) {
				while (!buckets[j].isEmpty()) {
					list[listIdx++] = buckets[j].poll();
				}
			}
			radix++;
		}

	}

	public static int getTopRadix(int[] list) {
		int top = 0;
		for (int i : list) {
			if (i > top)
				top = i;
		}
		int radix = 0;
		while (top > 0) {
			top /= 10;
			radix++;
		}
		return radix;
	}

}
