package allAlgo;

import java.util.Collections;
import java.util.List;

import allAlgo.MainFrame;

public class BubbleSort extends Algorithm {

	public BubbleSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort(){	
		for(int i=0;i<numSize;i++) {
			Boolean isSwapped=false;
			for(int j=0;j<numSize-i-1;j++) {
				if(numbers.get(j)>numbers.get(j+1)) {
					Collections.swap(numbers, j, j+1);
					isSwapped=true;
				}	
				updateView(sub,j,j+1,-1);
			}
			if(!isSwapped)
				break;
		}
	}

}
