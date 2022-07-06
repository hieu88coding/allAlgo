package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import allAlgo.Algorithm;
import allAlgo.BubbleSort;
import allAlgo.HeapSort;
import allAlgo.InsertionSort;
import allAlgo.MergeSort;
import allAlgo.QuickSort;
import allAlgo.SelectionSort;
import allAlgo.Sort;
import allAlgo.MainFrame;

public class SortController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Integer> nums=MainFrame.getInstance().getNums();
		int speed=MainFrame.getInstance().getJsSpeed();
		int elements=MainFrame.getInstance().getJsElements();
		MainFrame.getInstance().setSpeed(speed);
		MainFrame.getInstance().setElements(elements);
		MainFrame.getInstance().generateList();
		
		Algorithm alg=getSelectedAlgorithm(nums);
		MainFrame.getInstance().setAlg(alg);
		alg.addSubscriber(MainFrame.getInstance());
		alg.start();
	}
	
	private Algorithm getSelectedAlgorithm(List<Integer> nums) {
		Algorithm alg=null;
		Sort sort=MainFrame.getInstance().getCmbSort();
		switch(sort) {
			case BubbleSort:alg=new BubbleSort(nums);break;
			case SelectionSort:alg=new SelectionSort(nums);break;
			case QuickSort:alg=new QuickSort(nums);break;
			case MergeSort:alg=new MergeSort(nums);break;
			case InsertionSort:alg=new InsertionSort(nums);break;
			case HeapSort:alg=new HeapSort(nums);break;
		}
		return alg;
	}

}
