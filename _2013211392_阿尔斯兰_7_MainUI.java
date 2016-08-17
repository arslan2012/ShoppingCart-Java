package homework7;

import java.awt.*;

import javax.swing.JButton;
import javax.swing.JFrame;

public class _2013211392_阿尔斯兰_7_MainUI extends JFrame{
	public static _2013211392_阿尔斯兰_7_Controller controller;
	
	private static final long serialVersionUID = 1L;
	private _2013211392_阿尔斯兰_7_AddBookUI addbookUI;
	private _2013211392_阿尔斯兰_7_StrategyUI strategyUI;
	private _2013211392_阿尔斯兰_7_BuyUI buyUI;
	
	private JButton addBook = new JButton("添加新书");
	private JButton strategy = new JButton("优惠策略");
	private JButton buy = new JButton("购书");
	public _2013211392_阿尔斯兰_7_MainUI() throws HeadlessException {
		controller = new _2013211392_阿尔斯兰_7_Controller();
		addbookUI = new _2013211392_阿尔斯兰_7_AddBookUI();
		
		setTitle("Homework7 Main");
		setLayout(new GridLayout(3,1));
		add(addBook);
		add(strategy);
		add(buy);
		addBook.addActionListener(event -> addbookUI.setVisible(true));
		strategy.addActionListener(event -> {
	    	strategyUI = new _2013211392_阿尔斯兰_7_StrategyUI();
	    	strategyUI.setVisible(true);
		});
		buy.addActionListener(event -> {
	    	buyUI = new _2013211392_阿尔斯兰_7_BuyUI();
	    	buyUI.setVisible(true);
	    });
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,440);//Frame的长和宽分别是250像素和220像素
		setLocation(300,300);//框架左上角相对于屏幕左上角的位置
		//设置内容框格的颜色
	    getContentPane().setBackground(Color.yellow);
	}
	public static void main(String[] args) {
		_2013211392_阿尔斯兰_7_MainUI mainUI=new _2013211392_阿尔斯兰_7_MainUI();
		mainUI.setVisible(true);
	}
}
