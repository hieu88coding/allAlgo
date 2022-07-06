package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import allAlgo.MainFrame;

public class ShuffleController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		List<Integer> nums=MainFrame.getInstance().generateList();
		MainFrame.getInstance().setNums(nums);
	}

}
