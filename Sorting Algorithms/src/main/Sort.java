package main;

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

	public int getSize() {
		return list.length;
	}

	public abstract void sort();

	public void swap(int i, int j) {
		int tmp = list[j];
		list[j] = list[i];
		list[i] = tmp;
	}

}
