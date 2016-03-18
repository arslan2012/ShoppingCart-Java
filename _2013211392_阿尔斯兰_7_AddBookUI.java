package homework7;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class _2013211392_阿尔斯兰_7_AddBookUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String[] booktype = {"非教材类计算机图书","教材类图书","连环画类图书","养生类图书","其他" };
	private JComboBox<String> comboTypesList = new JComboBox<>(booktype);
	private JTextField isbn = new JTextField(20);
	private JTextField name = new JTextField(20);
	private JTextField price = new JTextField(6);
	private JButton add = new JButton("添加");

	public _2013211392_阿尔斯兰_7_AddBookUI() throws HeadlessException {
		setTitle("Homework7 AddBook");
		setLayout(new GridLayout(5,2));
		add(new JLabel("ISBN:",JLabel.CENTER));
		add(isbn);
		add(new JLabel("书名:",JLabel.CENTER));
		add(name);
		add(new JLabel("价格:",JLabel.CENTER));
		add(price);
		add(new JLabel("种类:",JLabel.CENTER));
		add(comboTypesList);
		add(add);
		add.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,270);//Frame的长和宽分别是250像素和220像素
		setLocation(500,470);//框架左上角相对于屏幕左上角的位置
		//设置内容框格的颜色
		getContentPane().setBackground(Color.yellow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			_2013211392_阿尔斯兰_7_MainUI.controller.addBook(isbn.getText(),Double.parseDouble(price.getText()),name.getText(),comboTypesList.getSelectedIndex()+1);
			JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "输入有误！", "警告 ", JOptionPane.INFORMATION_MESSAGE);
		}

	}

}
