package sortings;
import java.util.ArrayList;

public class _5_MergeSort extends Sort {

	public _5_MergeSort(ArrayList<Integer> list) {
		super(list);
	}

	@Override
	public void sort() {
		ArrayList<Integer> list = super.getList();
		super.setList(divide(list));
		
	
	}
	private ArrayList<Integer> divide(ArrayList<Integer> list) {
		if(list.size()>1) {
			ArrayList<Integer> left = new ArrayList<Integer>(list.subList(0, list.size()/2));
			ArrayList<Integer> right = new ArrayList<Integer>(list.subList(list.size()/2, list.size()));	
			return merge(divide(left),divide(right));
		}else {
			return list;
		}
	};
	
	private ArrayList<Integer> merge(ArrayList<Integer> left,ArrayList<Integer> right){			
		ArrayList<Integer> result = new ArrayList<Integer>();	
		int rightIndex = 0;
		
		
		for (int leftIndex=0;leftIndex<left.size();leftIndex++) {
			while(rightIndex < right.size() && left.get(leftIndex) > right.get(rightIndex)) {
				result.add(right.get(rightIndex));
				rightIndex++;				
			}	
			result.add(left.get(leftIndex));
		}		
	
		while(rightIndex < right.size()) {
			result.add(right.get(rightIndex));
			rightIndex++;
		}			
		return result;
	}

}
