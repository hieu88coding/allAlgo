package allAlgo;

import java.util.Collections;
import java.util.List;

public class SelectionSort extends Algorithm {

	public SelectionSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort() {
		for(int i=0;i<numSize-1;i++) {
			int min=numbers.get(i);
			int minInd=i;
			for(int j=i+1;j<numSize;j++) {
				if(min>numbers.get(j)) {
					min=numbers.get(j);
					minInd=j;
				}
				updateView(sub, j, minInd,-1);
			}			
			Collections.swap(numbers, minInd, i);
		}
	}

}
