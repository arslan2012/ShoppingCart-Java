package homework7;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class _2013211392_阿尔斯兰_7_BuyUI extends JFrame implements ActionListener {
	_2013211392_阿尔斯兰_7_ShoppingCartUI shoppingcartUI;
	private static final long serialVersionUID = 1L;
	private JTextField isbn = new JTextField(20);
	private JTextField sum = new JTextField(3);
	private JButton buy = new JButton("加入购物车");

	public _2013211392_阿尔斯兰_7_BuyUI() throws HeadlessException {
		setTitle("Homework7 Buy");
		setLayout(new GridLayout(_2013211392_阿尔斯兰_7_MainUI.controller.getBookCatalog().books.size()+5,1));
		for (int i=0;i < _2013211392_阿尔斯兰_7_MainUI.controller.getBookCatalog().books.size();i++){
			add(new JLabel(_2013211392_阿尔斯兰_7_MainUI.controller.getBookCatalog().books.get(i).toString(),JLabel.CENTER));
		}
		add(new JLabel("ISBN:",JLabel.CENTER));
		add(isbn);
		add(new JLabel("数量:",JLabel.CENTER));
		add(sum);
		add(buy);
		buy.addActionListener(this);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,270);//Frame的长和宽分别是250像素和220像素
		setLocation(500,470);//框架左上角相对于屏幕左上角的位置
		//设置内容框格的颜色
		getContentPane().setBackground(Color.yellow);
		_2013211392_阿尔斯兰_7_Sale sales = new _2013211392_阿尔斯兰_7_Sale();
		_2013211392_阿尔斯兰_7_MainUI.controller.setSale(sales);
		shoppingcartUI = new _2013211392_阿尔斯兰_7_ShoppingCartUI(sales);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		try{
			Integer.parseInt(sum.getText());
			isbn.getText();
			try{
				_2013211392_阿尔斯兰_7_MainUI.controller.buyBook(Integer.parseInt(sum.getText()), isbn.getText());
				shoppingcartUI.setVisible(true);
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "添加失败，请检查 1.ISBN号是否有误 或者 2.该类型书是否已经设置策略", "警告 ", JOptionPane.INFORMATION_MESSAGE);
			}
		}catch(Exception e1){
			JOptionPane.showMessageDialog(null, "数量输入有误！", "警告 ", JOptionPane.INFORMATION_MESSAGE);
		}
	}

}
