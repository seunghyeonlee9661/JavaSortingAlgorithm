package sortings;

import java.util.ArrayList;

import main.Sort;

public class SleepSort extends Sort {

	public SleepSort(int[] list) {
		super(list);
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		ArrayList<Thread> threads = new ArrayList<>();
		ArrayList<Integer> result = new ArrayList<Integer>();
		int index = 0;

		for (int num : list) {
			Thread thread = new Thread(() -> {
				try {
					Thread.sleep(num);
					result.add(num);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			});
			threads.add(thread);
			thread.start();
		}

		for (Thread thread : threads) {
			try {
				thread.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		for (int i = 0; i < result.size(); i++) {
			list[i] = result.get(i);
		}
	}

}
