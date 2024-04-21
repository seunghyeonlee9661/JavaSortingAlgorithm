package sortings;

import java.util.ArrayList;

public class InsertionSort extends Sort{	
	
	public InsertionSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		int size = super.getSize();
		ArrayList<Integer> list = super.getList();
		
		for(int i=1; i<size; i++) {
			int target = i;			
			for(int j=i-1; j>= 0; j--) {
				if(list.get(target) < list.get(j)) {
//					System.out.print("  swap: ");
//					System.out.print(list.get(target));
//					System.out.print(" < ");
//					System.out.println(list.get(j));
					swap(target--,j);
				}else {
//					System.out.print("  pass: ");
//					System.out.print(list.get(target));
//					System.out.print(" > ");
//					System.out.println(list.get(j));
					break;
				}
			}
		}
	}
}
