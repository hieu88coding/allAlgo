package allAlgo;

import java.util.Collections;
import java.util.List;

public class HeapSort extends Algorithm {

	public HeapSort(List<Integer> nums) {
		super(nums);
	}

	@Override
	public void sort() {
		heapSort();
	}

	private void heapSort() {
		for(int i=numSize/2-1;i>=0;i--)
			heapify(numSize,i);
		
		for(int i=numSize-1;i>=0;i--) {
			Collections.swap(numbers, 0, i);
			updateView(sub, 0, i, -1);
			heapify(i, 0);
		}
	}

	private void heapify(int currSize, int i) {
		int largest=i;
		int left=2*i+1;
		int right=2*i+2;
		
		if(left<currSize && numbers.get(left)>numbers.get(largest))
			largest=left;
		
		if(right<currSize && numbers.get(right)>numbers.get(largest))
			largest=right;
		
		if(largest!=i) {
			Collections.swap(numbers, i, largest);
			updateView(sub,i, largest, -1);
			heapify(currSize, largest);
		}
	}

}
