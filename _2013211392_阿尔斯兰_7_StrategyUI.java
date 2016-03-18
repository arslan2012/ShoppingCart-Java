package homework7;

import java.awt.Checkbox;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class _2013211392_阿尔斯兰_7_StrategyUI extends JFrame implements ActionListener {
	private static final long serialVersionUID = 1L;
	private String[] booktype = {"非教材类计算机图书","教材类图书","连环画类图书","养生类图书","其他" };
	private String[] strattype = {"百分比折扣策略(每本折扣x%)","绝对值优惠策略(每本优惠x元)","无优惠"};
	private JComboBox<String> comboTypesList_s = new JComboBox<>(booktype);
	private JComboBox<String> comboTypesList_c = new JComboBox<>(booktype);
	private JComboBox<String> comboTypesList_d = new JComboBox<>();
	private JComboBox<String> comboTypesList_u = new JComboBox<>();
	private JComboBox<String> comboStratList = new JComboBox<>(strattype);
	private ArrayList<Checkbox> strats = new ArrayList<Checkbox>();
	private JTextField x = new JTextField(3);
	private JTextField x_u = new JTextField(3);
	private JButton add_s = new JButton("添加");
	private JButton add_c = new JButton("添加");
	private JButton del = new JButton("删除");
	private JButton upd = new JButton("更新");

	public _2013211392_阿尔斯兰_7_StrategyUI() throws HeadlessException {
		setTitle("Homework7 Strategy");
		//setLayout(new GridLayout(3,1));
		/////////////////建立标签页//////////
		JTabbedPane tabbedPane = new JTabbedPane();
		add(tabbedPane);
		JPanel simple = new JPanel(new GridLayout(7, 2));
		JPanel complex = new JPanel(new GridLayout(8, 1));
		JPanel delete = new JPanel(new GridLayout(5, 1));
		JPanel update = new JPanel(new GridLayout(5, 1));
		tabbedPane.addTab("简单策略",null, simple,"Homework7 simple strategy");
		tabbedPane.addTab("复合策略",null, complex,"Homework7 complex strategy");
		tabbedPane.addTab("删除策略",null, delete,"Homework7 delete strategy");
		tabbedPane.addTab("更新策略",null, update,"Homework7 update strategy");
		////////////////简单策略标签页///////
		simple.add(new JLabel("该策略应用到哪种类型的书上",JLabel.CENTER));
		simple.add(comboTypesList_s);
		simple.add(new JLabel("策略:",JLabel.CENTER));
		simple.add(comboStratList);
		simple.add(new JLabel("X的值(单位为%或元)(选择无优惠策略时忽略):",JLabel.CENTER));
		simple.add(x);
		simple.add(add_s);
		add_s.addActionListener(this);
		////////////////复杂策略标签页//////
		complex.add(new JLabel("该策略应用到哪种类型的书上",JLabel.CENTER));
		complex.add(comboTypesList_c);
		int tmp = _2013211392_阿尔斯兰_7_MainUI.controller.getStrategiesType();
		for(int i = 5;i >= 1; i--){
			int tmp2 = tmp%10;
			tmp/=10;
			if (tmp2 != 0){
				strats.add(new Checkbox(booktype[i-1]));
			}
		}
		for(int i = 0;i < strats.size(); i++){
			complex.add(strats.get(i));
		}
		complex.add(add_c);
		add_c.addActionListener(this);
		////////////////删除策略标签页//////
		delete.add(new JLabel("哪种类型书的策略?",JLabel.CENTER));
		tmp = _2013211392_阿尔斯兰_7_MainUI.controller.getStrategiesType();
		for(int i = 5;i >= 1; i--){
			int tmp2 = tmp%10;
			tmp/=10;
			if (tmp2 != 0){
				comboTypesList_d.addItem(booktype[i-1]);
			}
		}
		delete.add(comboTypesList_d);
		delete.add(del);
		del.addActionListener(this);
		////////////////更新策略标签页//////
		update.add(new JLabel("哪种类型书的策略?",JLabel.CENTER));
		tmp = _2013211392_阿尔斯兰_7_MainUI.controller.getStrategiesType();
		for(int i = 5;i >= 1; i--){
			int tmp2 = tmp%10;
			tmp/=10;
			if (tmp2 == 1 ||tmp2 == 2){
				comboTypesList_u.addItem(booktype[i-1]);
			}
		}
		update.add(comboTypesList_u);
		update.add(new JLabel("X的新值(单位为%或元):",JLabel.CENTER));
		update.add(x_u);
		update.add(upd);
		upd.addActionListener(this);
		//////////////////////////////////
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setSize(300,270);//Frame的长和宽分别是250像素和220像素
		setLocation(500,470);//框架左上角相对于屏幕左上角的位置
		//设置内容框格的颜色
		getContentPane().setBackground(Color.yellow);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == add_s){
			boolean flag = true;
			if (comboStratList.getSelectedIndex()!=2){
				try{
					Double.parseDouble(x.getText());
				}catch(Exception e1){
					flag = false;
					JOptionPane.showMessageDialog(null, "X输入有误！", "警告 ", JOptionPane.INFORMATION_MESSAGE);
				}
				if (flag == true){
					_2013211392_阿尔斯兰_7_MainUI.controller.addSimpleStrategy(comboTypesList_s.getSelectedIndex()+1,comboStratList.getSelectedIndex(),Integer.parseInt(x.getText()));
					JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
				}
			}else{
				_2013211392_阿尔斯兰_7_MainUI.controller.addSimpleStrategy(comboTypesList_s.getSelectedIndex()+1,comboStratList.getSelectedIndex(),0);
				JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
			}
		}
		else if(e.getSource() == add_c){
			int tmp = 0;
			for(int i = 0;i < strats.size(); i++){
				if (strats.get(i).getState()){
					for(int j = 0;j < 5; j++){
						if (strats.get(i).getLabel().compareTo(booktype[j])==0){
							tmp = tmp*10+(j+1);
						}
					}
				}
			}
			_2013211392_阿尔斯兰_7_MainUI.controller.addCompositeStrategy(comboTypesList_c.getSelectedIndex()+1, tmp);
			JOptionPane.showMessageDialog(null, "添加成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == del){
			int n = -1;
			for(int j = 0;j < 5; j++){
				if (String.valueOf(comboTypesList_d.getSelectedItem()).compareTo(booktype[j])==0){
					n = j+1;
					break;
				}
			}
			_2013211392_阿尔斯兰_7_MainUI.controller.deleteStrategy(n);
			JOptionPane.showMessageDialog(null, "删除成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		else if(e.getSource() == upd){
			try{
				Double.parseDouble(x_u.getText());
			}catch(Exception e1){
				JOptionPane.showMessageDialog(null, "X输入有误！", "警告 ", JOptionPane.INFORMATION_MESSAGE);
			}
			int n = -1;
			for(int j = 0;j < 5; j++){
				if (String.valueOf(comboTypesList_u.getSelectedItem()).compareTo(booktype[j])==0){
					n = j+1;
					break;
				}
			}
			_2013211392_阿尔斯兰_7_MainUI.controller.updateStrategy(n,Double.parseDouble(x_u.getText()));
			JOptionPane.showMessageDialog(null, "更新成功", "成功", JOptionPane.INFORMATION_MESSAGE);
		}
		this.dispose();
		new _2013211392_阿尔斯兰_7_StrategyUI().setVisible(true);
	}
}
