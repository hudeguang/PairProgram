package forth;

import java.awt.event.*;
import java.awt.*;
import javax.swing.*;

public class Rectangle extends JFrame implements ActionListener
{
	private JButton button1;
	private JTextField text_num;
	private JTextField text_max;
	private JTextArea print;
	private JLabel label_num;
	private JLabel label_max;
	private JScrollPane jsp;
	private JCheckBox add1,sub,mul,div,more,point;
	homework hk1,hk2;
	char[] ope=new char[4];
	int n=0;
	
	public Rectangle()
	{
		super("四则运算自动生成");
		this.setSize(520,250);
		this.setLocation(300,240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.getContentPane().setLayout(new GridLayout(1, 2));
		Container c1 = new Container();
		Container c2 = new Container();
		c1.setLayout(new GridLayout(6, 2));
		c2.setLayout(new GridLayout(1, 1));
		
		button1 = new JButton("生成题目");

		button1.addActionListener(this);
		
		label_num =new JLabel("题目数量");
		label_max = new JLabel("最大数值");
		text_num = new JTextField(5);
		text_max = new JTextField(5);
		print = new JTextArea();
		
		add1 = new JCheckBox("+");
		sub = new JCheckBox("-");
		mul = new JCheckBox("*");
		div = new JCheckBox("/");
		more = new JCheckBox("多项式");
		point = new JCheckBox("小数点");
		print.setEditable(true);
		jsp = new JScrollPane(print);
		
		c1.add(label_num);
		c1.add(text_num);
		c1.add(label_max);
		c1.add(text_max);
		c1.add(add1);
		c1.add(sub);
		c1.add(mul);
		c1.add(div);
		c1.add(point);
		c1.add(more);
		c1.add(button1);
		
		
		c2.add(jsp);
		this.add(c1);
		this.add(c2);
		this.setVisible(true);
	}
	public void actionPerformed(ActionEvent e)
	{
		print.setText("");
		if(add1.isSelected())
		{
			ope[n]='+';
			n+=1;
		}
		if(sub.isSelected())
		{
			ope[n]='-';
			n+=1;
		}
		if(mul.isSelected())
		{
			ope[n]='*';
			n+=1;
		}
		if(div.isSelected())
		{
			ope[n]='/';
			n+=1;
		}
		hk2=new homework(n);
		if(text_num.getText().equals(""))
		{
			if(text_max.getText().equals(""))
			{
				print.append("请输入题目数量和最大值！");
			}
			else {print.append("请输入题目数量！");}
		}
		else
		{
			if(text_max.getText().equals(""))
			{
				print.append("请输入最大值！");
			}
			else 
			{
				if(n==0)
				{print.append("请选择运算符！");}
				else
				{
					int num=Integer.parseInt(text_num.getText());
					int Max=Integer.parseInt(text_max.getText());
					hk1=new homework(Max);
					if(!point.isSelected())
					{
						if(!more.isSelected())
						{
							for(int i=0;i<num;i++)
							{
								String str=String.valueOf(hk1.PRandom()+1)
										+ope[hk2.PRandom()]
											+String.valueOf(hk1.PRandom()+1)+"=";
								print.append(str+"\n");
							}
						}
						else
						{
							{
								for(int i=0;i<num;i++)
								{
									String str="("+String.valueOf(hk1.PRandom()+1)
											+ope[hk2.PRandom()]
												+String.valueOf(hk1.PRandom()+1)+")"
												+ope[hk2.PRandom()]
												+String.valueOf(hk1.PRandom()+1)+"=";
									print.append(str+"\n");
								}
							}
						}
					}
					else
					{
						if(!more.isSelected())
						{
							for(int i=0;i<num;i++)
							{
								String str=String.valueOf(hk1.DRandom())
										+ope[hk2.PRandom()]
											+String.valueOf(hk1.DRandom())+"=";
								print.append(str+"\n");
							}
						}
						else
						{
							{
								for(int i=0;i<num;i++)
								{
									String str="("+String.valueOf(hk1.DRandom())
											+ope[hk2.PRandom()]
												+String.valueOf(hk1.DRandom())+")"
												+ope[hk2.PRandom()]
												+String.valueOf(hk1.DRandom())+"=";
									print.append(str+"\n");
								}
							}
						}
					}
					n=0;
				}
			}
		}
			
	}

	
	public static void main(String[] args) 
	{
		new Rectangle();
	}
}
