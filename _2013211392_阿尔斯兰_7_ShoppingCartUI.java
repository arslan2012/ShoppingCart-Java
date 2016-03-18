package homework7;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _2013211392_阿尔斯兰_7_ShoppingCartUI extends JFrame implements _2013211392_阿尔斯兰_7_Observer{
	private static final long serialVersionUID = 1L;
	private final _2013211392_阿尔斯兰_7_Subject subject;
	private JPanel panel;

	public _2013211392_阿尔斯兰_7_ShoppingCartUI(final _2013211392_阿尔斯兰_7_Subject subject) throws HeadlessException {
		this.subject = subject;
        this.subject.registerObserver(this);
        setTitle("Homework7 ShoppingCart");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,270);//Frame的长和宽分别是250像素和220像素
		setLocation(800,740);//框架左上角相对于屏幕左上角的位置
	    update(this.subject.getItems());
	}

	@Override
	public void update(ArrayList<_2013211392_阿尔斯兰_7_SaleLineItem> items) {
		double sum = 0;
		try {remove(panel);}
				catch(Exception e1){ ;}
		panel = new JPanel();
		add(panel);
		panel.setLayout(new GridLayout(items.size()+1,1));
		for (int i=0;i < items.size();i++){
			panel.add(new JLabel(items.get(i).toString(),JLabel.CENTER));
			sum+=items.get(i).getSubTotal();
		}
		panel.add(new JLabel("总价:"+Double.toString(sum),JLabel.CENTER));
		//设置内容框格的颜色
	    panel.setBackground(Color.yellow);
	}
}
