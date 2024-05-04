package sortings;

import java.util.ArrayList;

public class _1_BubbleSort extends Sort {
	
	public _1_BubbleSort(ArrayList<Integer> list) {
		super(list);		
	}	
	public void sort() {	
		int size = super.getSize();			
		ArrayList<Integer> list = super.getList();
		
		for(int i = 0; i<size -1 ; i++) {			
			for(int j = 0; j< (size-i)-1; j++) {						
				if(list.get(j) > list.get(j+1)) {
					swap(j,j+1);			
				}
			}
		}
	}	
	

}
