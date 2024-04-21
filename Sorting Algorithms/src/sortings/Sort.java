package sortings;

import java.util.ArrayList;

public abstract class Sort {
	private ArrayList<Integer> list;
	private int size;
	
	public Sort(ArrayList<Integer> list) {
		this.list = list;		
		this.size = list.size();
	}	

	public ArrayList<Integer> getList() {
		return list;
	}
	
	public void setList(ArrayList<Integer> list) {
		this.list = list;
	}

	public int getSize() {
		return size;
	}

	public abstract void sort();
	
	public String toString() {
		return list.toString();
		
	}
	
	public void swap(int i, int j) {
		int tmp = list.get(j);					
		list.set(j,list.get(i));					
		list.set(i,tmp);
	}

}
