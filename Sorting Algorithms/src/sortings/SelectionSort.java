package sortings;

import java.util.ArrayList;

public class SelectionSort extends Sort  {	
	public SelectionSort(ArrayList<Integer> list) {
		super(list);		
	}

	@Override
	public void sort() {
		int size = super.getSize();	
		int least, least_j;
		ArrayList<Integer> list = super.getList();
		
		for(int i = 0; i<size -1 ; i++) {	
			least = list.get(i);		
			least_j = i;
			
			for(int j = i+1; j< size; j++) {
				if(list.get(j) < least) {			
					least = list.get(j);
					least_j = j;
				}
			}			
			if(least_j != i) {
				swap(i,least_j);
			}
		}
		// TODO Auto-generated method stub
		
	}	
}
