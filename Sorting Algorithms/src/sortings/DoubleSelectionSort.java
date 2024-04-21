package sortings;

import java.util.ArrayList;

public class DoubleSelectionSort extends Sort  {	
	public DoubleSelectionSort(ArrayList<Integer> list) {
		super(list);		
	}

	@Override
	public void sort() {
		int size = super.getSize();	
		int least, least_j;
		int most, most_j;
		ArrayList<Integer> list = super.getList();
		
		for(int i = 0; i<size-i ; i++) {
//			System.out.println("");
//			System.out.print("i : ");
//			System.out.println(i);
//			System.out.println(list);
			
			least_j = i;		
			most_j = size-1-i;
			least = list.get(least_j);	
			most = list.get(most_j);			
			
			for(int j = i; j< size-i; j++) {
				if(list.get(j) < least) {			
					least = list.get(j);
					least_j = j;
				}
				if(list.get(j) > most) {
					most = list.get(j);
					most_j = j;					
				}
			}			
			if(least_j != i) {
//				System.out.print("least swap >> least(" );
//				System.out.print(least_j);
//				System.out.print(":" );
//				System.out.print(list.get(least_j));
//				System.out.print(") target(" );
//				System.out.print(i);
//				System.out.print(":" );
//				System.out.print(list.get(i));
//				System.out.println(")" );
				swap(i,least_j);
				
			}
			if(most_j != size-1-i) {
				if(most_j == i) {
					most_j = least_j;
				}
//				System.out.print("most swap >> most(" );
//				System.out.print(most_j);
//				System.out.print(":" );
//				System.out.print(list.get(most_j));
//				System.out.print(") target(" );
//				System.out.print(size-1-i);
//				System.out.print(":" );
//				System.out.print(list.get(size-1-i));
//				System.out.println(")" );
				swap(size-1-i,most_j);
			}
		}		
	}	
}
