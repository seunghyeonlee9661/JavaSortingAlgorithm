package main;

import java.util.Arrays;

public abstract class Sort {
	private int[] list;

	public Sort(int[] list) {
		this.list = list;
	}

	public int[] getList() {
		return list;
	}

	public void setList(int[] list) {
		this.list = list;
	}

	public void setList(int index, int value) {
		this.list[index] = value;
	}

	public int getSize() {
		return list.length;
	}

	public abstract void sort();

	public String toString() {
		return Arrays.toString(list);

	}

	public void swap(int i, int j) {
		int tmp = list[j];
		list[j] = list[i];
		list[i] = tmp;
	}

}
