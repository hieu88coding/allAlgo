package allAlgo;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import allAlgo.Algorithm;
import allAlgo.MainFrame;

public class StopController implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
		Algorithm alg=MainFrame.getInstance().getAlg();
		MainFrame.getInstance().setViewControls(true);
		alg.stop();
	}

}
