package allAlgo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.GridLayout;import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Hashtable;
import java.util.List;

import javax.swing.ComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import allAlgo.ElementsController;
import allAlgo.ShuffleController;
import allAlgo.SortController;
import allAlgo.SpeedController;
import allAlgo.StopController;
import allAlgo.Algorithm;
import allAlgo.Sort;
import allAlgo.ISubscriber;

public class MainFrame extends JFrame implements ISubscriber{
	private static MainFrame instance=null;
	private Algorithm alg;
	private List<Integer> nums;
	
	private Rectangle rect;
	private JButton btnSort;
	private JButton btnShuffle;
	private JButton btnStop;
	private JComboBox<Sort> cmbSort;
	private JSlider jsSpeed;
	private JSlider jsElements;
	private JLabel lblSpeed;
	private JLabel lblElements;
	
	private static int SPEED;
	private static int ELEMENTS=200;
	
	public static MainFrame getInstance() {
		if(instance==null)
			instance=new MainFrame();
		return instance;
	}
	
	private MainFrame() {
		setLayout(new BorderLayout());	
		this.setTitle("Sorting Visualization");
		
		nums=generateList();	
		rect=new Rectangle(nums);
		
		setSize(850,550);
		setResizable(false);
		setLocationRelativeTo(null);
		
		JPanel controls=new JPanel();
		controls.setLayout(new FlowLayout());
		controls.setBorder(new EmptyBorder(10, 10, 10, 10));
		
		cmbSort=new JComboBox<Sort>();
		populateComboBox();
		btnSort=new JButton("Sort");
		btnShuffle=new JButton("Shuffle");
		btnStop=new JButton("Stop");
		btnStop.setEnabled(false);
			
		jsSpeed=new JSlider(1,100);
		jsElements=new JSlider(2,400);
		jsSpeed.setPaintLabels(true);
		jsElements.setPaintLabels(true);
		setPaintLabels();
		lblSpeed=new JLabel("Speed (ms)");
		lblElements=new JLabel("Elements");
		JPanel speed=new JPanel();
		speed.setLayout(new GridLayout(2,1));
		speed.add(lblSpeed);
		lblSpeed.setHorizontalAlignment(SwingConstants.CENTER);
		speed.add(jsSpeed);
		JPanel elements=new JPanel();
		elements.setLayout(new GridLayout(2,1));
		elements.add(lblElements);
		lblElements.setHorizontalAlignment(SwingConstants.CENTER);
		elements.add(jsElements);
			
		controls.add(speed);
		controls.add(elements);
		controls.add(cmbSort);
		controls.add(btnSort);
		controls.add(btnShuffle);
		controls.add(btnStop);
		
		add(rect,BorderLayout.CENTER);
		add(controls,BorderLayout.SOUTH);
		btnSort.addActionListener(new SortController());
		btnShuffle.addActionListener(new ShuffleController());
		jsElements.addChangeListener(new ElementsController());
		jsSpeed.addChangeListener(new SpeedController());
		btnStop.addActionListener(new StopController());
	}
	
	private void setPaintLabels() {
		Hashtable position = new Hashtable();
		position.put(1, new JLabel("1"));
		position.put(25, new JLabel("25"));
		position.put(50, new JLabel("50"));
		position.put(75, new JLabel("75"));
		position.put(100, new JLabel("100"));	
		jsSpeed.setLabelTable(position);
		
		Hashtable position2 = new Hashtable();
		position2.put(2, new JLabel("2"));
		position2.put(100, new JLabel("100"));
		position2.put(200, new JLabel("200"));
		position2.put(300, new JLabel("300"));
		position2.put(400, new JLabel("400"));	
		jsElements.setLabelTable(position2);
		 
	}

	private void populateComboBox() {		
		cmbSort.addItem(Sort.BubbleSort);
		cmbSort.addItem(Sort.SelectionSort);
		cmbSort.addItem(Sort.InsertionSort);
		cmbSort.addItem(Sort.QuickSort);
		cmbSort.addItem(Sort.MergeSort);
		cmbSort.addItem(Sort.HeapSort);
	}

	public List<Integer> generateList() {
		List<Integer> toReturn=new ArrayList<Integer>();
		for(int i=1;i<=ELEMENTS;i++)
			toReturn.add(i);
		Collections.shuffle(toReturn);
		return toReturn;
	}
	
	public Rectangle getRect() {
		return rect;
	}
	
	public List<Integer> getNums() {
		return nums;
	}
	
	public void setNums(List<Integer> nums) {
		this.nums = nums;
		rect.setNums(nums);
	}

	@Override
	public void update(int red, int blue,int green) {
		rect.updateNums(red, blue,green);
		try {
			Thread.sleep(SPEED);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public Sort getCmbSort() {
		return (Sort) cmbSort.getSelectedItem();
	}
	
	public void setSpeed(int speed) {
		SPEED = speed;
	}
	
	public int getJsSpeed() {
		return jsSpeed.getValue();
	}
	
	public int getJsElements() {
		return jsElements.getValue();
	}
	
	public void setElements(int elements) {
		ELEMENTS = elements;
	}
	
	public void setAlg(Algorithm alg) {
		this.alg = alg;
	}
	
	public Algorithm getAlg() {
		return alg;
	}

	@Override
	public void setViewControls(boolean val) {
		btnSort.setEnabled(val);
		btnShuffle.setEnabled(val);
		jsElements.setEnabled(val);
		btnStop.setEnabled(!val);
	}
	
}
