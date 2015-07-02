import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
    
public class record
{
	public static void main(String[] args)
	{
		CustFrame nframe = new CustFrame("英雄聯盟代打小幫手 By Dragon 20130704",300,300);
	}
}

class CustFrame
{
	private String TitleName;
	private JFrame frameA;
	private JFrame frameB;
	private int width, height; // 視窗大小
	
	private final int fill[]  =  { GridBagConstraints.BOTH,
					            GridBagConstraints.VERTICAL,
					            GridBagConstraints.HORIZONTAL,
					            GridBagConstraints.NONE};
	private final int anchor[] = { GridBagConstraints.CENTER,
								GridBagConstraints.EAST,
					            GridBagConstraints.SOUTHEAST,
					            GridBagConstraints.SOUTH,
					            GridBagConstraints.SOUTHWEST,
					            GridBagConstraints.WEST,
					            GridBagConstraints.NORTHWEST,
					            GridBagConstraints.NORTH,
					            GridBagConstraints.NORTHEAST};
	private JLabel label;
	private JButton button;
	private JTextField text;
	private JPasswordField pass;
	private JCheckBox checkbox;
	private JRadioButton radiobutton;
	private ImageIcon icon;
	private int element_size;
	
	private int att[][];
	private ArrayList<JComponent> GUIComponentA;
	private ArrayList<JComponent> GUIComponentB;
	CustFrame(String TitleName, int w, int h)
	{
		this.height = h;
		this.width = w;
		this.TitleName = TitleName;
		frameA();
	}
	private void frameA()
	{
		frameA = new JFrame();
		frameA.setTitle(TitleName);
		frameA.setSize(width,height);
		frameA.setLayout(new GridBagLayout());
		frameA.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		frameA.setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);
		frameA.setResizable(false);
		ImageIcon frameicon = new ImageIcon(CustFrame.class.getResource("Pic/FrameIcon.jpg"));
		frameA.setIconImage(frameicon.getImage());
		screenSize = null;
		int a[][] = {{0, 0, 1, 1, 0, 0, fill[0], anchor[0]},
	            	{1, 0, 1, 1, 0, 0, fill[0], anchor[0]},
	            	{0, 1, 1, 1, 0, 0, fill[0], anchor[0]},
	                {1, 1, 1, 1, 0, 0, fill[0], anchor[0]}, 
	                {0, 2, 2, 1, 0, 0, fill[2], anchor[0]}, 
	                {0, 3, 2, 1, 0, 0, fill[2], anchor[0]}};
		att = a;
		String n[] = {"帳號","test","密碼","test","登入", "關於作者"};
		GUIComponentA = new ArrayList<JComponent>(n.length);
		
		for(int i=0;i<n.length;i++)
		{
			if(i==0 || i== 2)
						{label = new JLabel(n[i]); 				GUIComponentA.add(label);}
			else if(i==1)
						{text = new JTextField(n[i], 8); 		GUIComponentA.add(text);}
			else if(i==3)
						{pass = new JPasswordField(n[i], 8); 	GUIComponentA.add(pass);}
			else
			{
				button = new JButton(n[i]);
				GUIComponentA.add(button);
				if(i==4){button.addActionListener(new BtnLoginListener());}
				else if(i==5)
						{button.addActionListener(new BtnAuthorListener());}
			}
		}
		for (int i=0;i<GUIComponentA.size();i++)
        {
            addComponent(i,0);
        }
		frameA.setVisible(true);
	}
	private void addComponent(int i,int mode)
	{
        GridBagConstraints c = new GridBagConstraints();
        int a[] = att[i];        
        c.gridx = a[0];
        c.gridy = a[1];
        c.gridwidth = a[2];
        c.gridheight = a[3];
        c.weightx = a[4];
        c.weighty = a[5];
        c.fill = a[6];
        c.anchor = a[7];
        if(mode == 0) frameA.add(GUIComponentA.get(i), c);
        else if(mode == 1) frameB.add(GUIComponentB.get(i), c);
    }
	class BtnLoginListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			text = (JTextField)GUIComponentA.get(1);
			String str = text.getText();
			pass = (JPasswordField)GUIComponentA.get(3);
			char chr[] = pass.getPassword();
			String str2 = new String(chr);
			if(str.compareTo("")==0 || str2.compareTo("")==0)
	        {
	        	JOptionPane.showMessageDialog(frameA, "請輸入帳號！");
	        }
	        else if(str.compareTo("test")==0 && str2.compareTo("test")==0)
	        {
	        	frameB(640,480);
	        	frameA.setVisible(false);
	        }
	        else
	        {
	        	JOptionPane.showMessageDialog(frameA, "帳號或密碼錯誤！");
	        }
		}
	}
	class BtnAuthorListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			icon = new ImageIcon(CustFrame.class.getResource("Pic/AuthorIcon.jpg"));
			JOptionPane.showMessageDialog(null,"E-mail: yuh926323@gmail.com\n Copyright © 2013.07.04 By Dragon","作者",JOptionPane.INFORMATION_MESSAGE,icon);
		}
	}
	private void frameB(int width,int height)
	{
		frameB = new JFrame();
		frameB.setTitle(TitleName);
		frameB.setSize(width,height);
		frameB.setLayout(new GridBagLayout());
		frameB.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize(); 
		frameB.setLocation(screenSize.width/2 - width/2, screenSize.height/2 - height/2);
		frameB.setResizable(false);
		ImageIcon frameicon = new ImageIcon(CustFrame.class.getResource("Pic/FrameIcon.jpg"));
		frameB.setIconImage(frameicon.getImage());
		frameB.setVisible(true);
		screenSize = null;
		int a[][] = {{0, 0, 1, 1, 0, 0, fill[2], anchor[0]},
	            	{1, 0, 1, 1, 0, 0, fill[2], anchor[0]},
	            	{2, 0, 1, 1, 0, 0, fill[2], anchor[0]},
	                {3, 0, 1, 1, 0, 0, fill[2], anchor[0]}, 
	                {4, 0, 1, 1, 0, 0, fill[2], anchor[0]}, 
	                {5, 0, 1, 1, 0, 0, fill[2], anchor[0]},
	                
	                {0, 1, 1, 1, 0, 0, fill[2], anchor[0]},
	                {1, 1, 5, 1, 0, 0, fill[2], anchor[0]},
	                {7, 1, 1, 1, 0, 0, fill[2], anchor[0]},
	                
	                {0, 2, 1, 1, 0, 0, fill[2], anchor[0]},
	                {1, 2, 2, 1, 0, 0, fill[2], anchor[0]},
	                {3, 2, 3, 1, 0, 0, fill[2], anchor[0]},
	                {6, 2, 1, 1, 0, 0, fill[2], anchor[0]},
	                
	                {0,15, 2, 1, 0, 0, fill[2], anchor[0]},
	                {5,15, 1, 1, 0, 0, fill[2], anchor[0]},
	                {6,15, 1, 1, 0, 0, fill[2], anchor[0]},
	                {7,15, 1, 1, 0, 0, fill[2], anchor[0]}};
		att = a;
		String n[] = {"遊戲ID","","金額","","原始分數","",
		//0 label text label text label text
					"訂單：","","資料鎖定",
		//6 label text button
					"啟用","勝/敗","0-100/Bo3/Bo5","增減分數",
		//9 label label label label
					"關於作者","結算","清空","離開"
		//13 button button button button
		};
		GUIComponentB = new ArrayList<JComponent>(n.length);
		for(int i=0;i<n.length;i++)
		{
			if(i==0 || i== 2 || i==4 || i == 6 || (i>=9 && i<=12))
						{label = new JLabel(n[i], SwingConstants.CENTER); 					GUIComponentB.add(label);}
			else if(i==1 || i== 3 || i==5 || i==7)
						{text = new JTextField(n[i], (i!=7?8:24)); 	GUIComponentB.add(text);}
			else
			{
				button = new JButton(n[i]);							GUIComponentB.add(button);
				if(i==8){button.addActionListener(new BtnCharacterLockListener());}
				else if(i==13){button.addActionListener(new BtnAuthorListener());}
				else if(i==14){button.addActionListener(new BtnTotalListener());}
				else if(i==15){button.addActionListener(new BtnResetListener());}
				else if(i==16){button.addActionListener(new BtnExitListener());}
			}
		}
		for(int i=0;i<GUIComponentB.size();i++)
        {
            addComponent(i,1);
        }
		element_size = GUIComponentB.size(); // 記錄加入迴圈產生東西以前的元件數量
		int b[][]={ { 0, 3, 1, 1, 0, 0, fill[2], anchor[0]},
	            	{ 1, 3, 1, 1, 0, 0, fill[2], anchor[0]},
	            	{ 2, 3, 1, 1, 0, 0, fill[2], anchor[0]},
	                { 3, 3, 1, 1, 0, 0, fill[2], anchor[0]}, 
	                { 4, 3, 1, 1, 0, 0, fill[2], anchor[0]}, 
	                { 5, 3, 1, 1, 0, 0, fill[2], anchor[0]},
	                { 6, 3, 1, 1, 0, 0, fill[2], anchor[0]},
	                { 7, 3, 1, 1, 0, 0, fill[2], anchor[0]}
	                };
		String name[]={"啟用","勝","敗","0-100","Bo3","Bo5","","保存設置"};
		ButtonGroup radioGroupA[] = new ButtonGroup[10];
		ButtonGroup radioGroupB[] = new ButtonGroup[10];
		for(int i=0;i<10;i++)
		{
			for(int j=0;j<8;j++)
			{
				if(j==0){checkbox = new JCheckBox(name[j]); GUIComponentB.add(checkbox); checkbox.addItemListener(new CheckBoxHandler());}
				else if(j==1 || j==2)
				{
					radiobutton = new JRadioButton(name[j], false);
					radiobutton.setHorizontalAlignment(SwingConstants.CENTER);
					if(j==1){radioGroupA[i] = new ButtonGroup(); radiobutton.setSelected(true);}
					radioGroupA[i].add(radiobutton);
					radiobutton.setEnabled(false);
					GUIComponentB.add(radiobutton);
				}
				else if(j>=3 && j<=5)
				{
					radiobutton = new JRadioButton(name[j], false);
					radiobutton.setHorizontalAlignment(SwingConstants.CENTER);
					if(j==3){radioGroupB[i] = new ButtonGroup(); radiobutton.setSelected(true);}
					radioGroupB[i].add(radiobutton);
					radiobutton.setEnabled(false);
					radiobutton.addItemListener(new RadioHandler());
					GUIComponentB.add(radiobutton);
				}
				else if(j==6){text = new JTextField(name[j]); 	GUIComponentB.add(text); text.setEnabled(false);}
				else
				{
					button = new JButton(name[j]);	GUIComponentB.add(button);
					button.addActionListener(new BtnSaveLockListener());
					button.setEnabled(false);
				}
			}
		}
		for(int i=0;i<GUIComponentB.size()-element_size;i++)
        {
			GridBagConstraints c = new GridBagConstraints();
	        c.gridx = b[i%8][0];
	        c.gridy = b[i%8][1]+(i/8);
	        c.gridwidth = b[i%8][2];
	        c.gridheight = b[i%8][3];
	        c.weightx = b[i%8][4];
	        c.weighty = b[i%8][5];
	        c.fill = b[i%8][6];
	        c.anchor = b[i%8][7];
	        frameB.add(GUIComponentB.get(element_size+i), c);
        }
	}
	class BtnCharacterLockListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			button = (JButton)GUIComponentB.get(8);
			String str = button.getText();
			if( str.compareTo("資料鎖定")==0 )
			{
				button.setText("解除鎖定");
				text = (JTextField)GUIComponentB.get(1);
				text.setEnabled(false);
				text = (JTextField)GUIComponentB.get(3);
				text.setEnabled(false);
				text = (JTextField)GUIComponentB.get(5);
				text.setEnabled(false);
				text = (JTextField)GUIComponentB.get(7);
				text.setEnabled(false);
			}
			else
			{
				button.setText("資料鎖定");
				text = (JTextField)GUIComponentB.get(1);
				text.setEnabled(true);
				text = (JTextField)GUIComponentB.get(3);
				text.setEnabled(true);
				text = (JTextField)GUIComponentB.get(5);
				text.setEnabled(true);
				text = (JTextField)GUIComponentB.get(7);
				text.setEnabled(true);
			}
		}
	}
	class CheckBoxHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			int temp = 0;
			for(int i=0;i<10;i++)
			{
				temp = element_size+i*8;
				checkbox = (JCheckBox)GUIComponentB.get(temp);
				if(event.getSource() == checkbox)
				{
					break;	
				}
			}
			for(int i=1;i<8;i++)
			{
				if(i==6)
				{
					radiobutton = (JRadioButton)GUIComponentB.get(temp+3);
					GUIComponentB.get(temp+i).setEnabled(radiobutton.isSelected()?checkbox.isSelected():false);
				}
				else GUIComponentB.get(temp+i).setEnabled(checkbox.isSelected());
			}
		}
	}
	class RadioHandler implements ItemListener
	{
		public void itemStateChanged(ItemEvent event)
		{
			int temp = 0;
			for(int i=0;i<10;i++)
			{
				for(int j=3;j<6;j++)
				{
					temp = element_size+i*8+j;
					radiobutton = (JRadioButton)GUIComponentB.get(temp);
					if(event.getSource() == radiobutton)
					{
						break;
					}
				}
				if(event.getSource() == radiobutton)
				{
					break;
				}
			}
			if(radiobutton.getText().compareTo("0-100") == 0)
			{
				GUIComponentB.get(temp+3).setEnabled(true);
			}
			else
			{
				text = (JTextField)GUIComponentB.get(temp+(radiobutton.getText().compareTo("Bo3")==0?2:1));
				text.setEnabled(false);
				text.setText("");
			}
		}
	}
	class BtnTotalListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int option = JOptionPane.showConfirmDialog(frameB, "確認將所有資料儲存為文字檔嗎？","結算", JOptionPane.YES_NO_OPTION);
			if(option == JOptionPane.YES_OPTION)
			{
				text = (JTextField)GUIComponentB.get(1);
				String name = text.getText();
				text = (JTextField)GUIComponentB.get(3);
				String money = text.getText();
				text = (JTextField)GUIComponentB.get(5);
				String ori_score = text.getText();
				text = (JTextField)GUIComponentB.get(7);
				String order = text.getText();
				String str[] = {"遊戲ID:"+name+"\t\t金額:"+money+"\t原始分數:"+ori_score+"\r\n",
								"訂單："+order+"\r\n",
								"","","","","","","","","","",""};
				int JDialog;
				int win=0,lose=0;
				int score=0,temp_score=0,temp_win=0,temp_lose=0,correct_score=0;
				score = Integer.parseInt(ori_score);
				boolean status = false, BO=false, enter_bo=false;
				for(int i=0;i<10;i++)
				{
					for(int j=0;j<6;j++)
					{
						if(j==0)
						{
							checkbox = (JCheckBox)GUIComponentB.get(element_size+i*8+j);
							if(!checkbox.isSelected())
							{
								break;
							}
						}
						else if(j==1)
						{
							radiobutton = (JRadioButton)GUIComponentB.get(element_size+i*8+j);
							if(radiobutton.isSelected())
							{
								status = true;
								win++;
								str[i+2] += "【勝利】";
							}
							else
							{
								status = false;
								lose++;
								str[i+2] += "【戰敗】";
							}
						}
						else if(j==3)
						{
							radiobutton = (JRadioButton)GUIComponentB.get(element_size+i*8+j);
							text = (JTextField)GUIComponentB.get(element_size+i*8+6);
							if(radiobutton.isSelected())
							{
								temp_score = Integer.parseInt(text.getText());
								if(status)
								{
									score += temp_score;
									if(score >= 100)
									{
										score = 100;
										BO = true;
									}
								}
								else
								{
									score -= temp_score;
								}
								str[i+2] += ", "+(status?"+":"-")+temp_score+" = ";
								str[i+2] += score;
								if(BO)
								{
									str[i+2] += "\t 進入BO!";
									BO = false;
								}
							}
						}
						else if(j==4)
						{
							radiobutton = (JRadioButton)GUIComponentB.get(element_size+i*8+j);
							if(radiobutton.isSelected() && !enter_bo)
							{
								enter_bo = true;
								temp_win = 0;
								temp_lose = 0;
							}
							if(radiobutton.isSelected() && enter_bo)
							{
								if(status) temp_win++; else temp_lose++;
								if(temp_win >= 2)
								{
									str[i+2] += "\t\t從BO3中晉級！";
									score = 0;
									enter_bo = false;
								}
								else if(temp_lose >= 2)
								{
									JDialog = JOptionPane.showConfirmDialog(frameB, "偵測到BO3落敗，請問要進行分數補正嗎？","分數修訂", JOptionPane.YES_NO_OPTION);
									if(JDialog == JOptionPane.YES_OPTION)
									{
										correct_score = Integer.parseInt(JOptionPane.showInputDialog("輸入落敗後分數"));
									}
									str[i+2] += "\t\t從BO3中失敗！落敗分數:"+correct_score+"分";
									score = correct_score;
									enter_bo = false;
								}
							}
						}
						else if(j==5)
						{
							radiobutton = (JRadioButton)GUIComponentB.get(element_size+i*8+j);
							if(radiobutton.isSelected() && !enter_bo)
							{
								enter_bo = true;
								temp_win = 0;
								temp_lose = 0;
							}
							if(radiobutton.isSelected() && enter_bo)
							{
								if(status) temp_win++; else temp_lose++;
								if(temp_win >= 3)
								{
									str[i+2] += "\t\t從BO5中晉級！";
									score = 0;
									enter_bo = false;
								}
								else if(temp_lose >= 3)
								{
									JDialog = JOptionPane.showConfirmDialog(frameB, "偵測到BO5落敗，請問要進行分數補正嗎？","分數修訂", JOptionPane.YES_NO_OPTION);
									if(JDialog == JOptionPane.YES_OPTION)
									{
										correct_score = Integer.parseInt(JOptionPane.showInputDialog("輸入落敗後分數"));
									}
									str[i+2] += "\t\t從BO5中失敗！落敗分數:"+correct_score+"分";
									score = correct_score;
									enter_bo = false;
								}
							}
						}
					}
					str[i+2] += "\r\n";
				}
				str[12] = "打了"+(win+lose)+"場\t"+win+"勝"+lose+"敗\t"+"總勝差: "+(win-lose)+" 場";
				try
				{
					File file = new File(".");
					String path = file.getCanonicalPath();
					String fs = System.getProperty("file.separator");
					String fileName = path + fs + money + "-" + name + ".txt";
					FileWriter f = new FileWriter(fileName);
					
					for(int i=0;i<str.length;i++)
					{
						f.write(str[i]);
					}
					f.close();
				}
				catch(IOException ioe)
				{
					JOptionPane.showMessageDialog(frameB, ioe);
				}
				JOptionPane.showMessageDialog(null, "檔案已建立完成！");
			}
		}
	}
	class BtnResetListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			for(int i=0;i<10;i++)
			{
				for(int j=0;j<8;j++)
				{
					if(j==0){checkbox = (JCheckBox)GUIComponentB.get(element_size+i*8+j); checkbox.setSelected(false); checkbox.setEnabled(true);}
					else if(j>=1 && j<=5){radiobutton = (JRadioButton)GUIComponentB.get(element_size+i*8+j); if(j==1 || j==3){radiobutton.setSelected(true);}else{radiobutton.setSelected(false);} radiobutton.setEnabled(false);}
					else if(j==6){text = (JTextField)GUIComponentB.get(element_size+i*8+j); text.setText(""); text.setEnabled(false);}
					else if(j==7){button = (JButton)GUIComponentB.get(element_size+i*8+j); button.setText("保存設置"); button.setEnabled(false);}
				}
			}
		}
	}
	class BtnExitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			System.exit(0);
		}
	}
	class BtnSaveLockListener implements ActionListener
	{
		public void actionPerformed(ActionEvent event)
		{
			int temp = 0;
			for(int i=0;i<10;i++)
			{
				temp = element_size+i*8+7;
				button = (JButton)GUIComponentB.get(temp);
				if(event.getSource() == button)
				{
					break;	
				}
			}
			if(button.getText().compareTo("保存設置")==0)
			{
				button.setText("解除鎖定");
				for(int i=1;i<8;i++)
				{
					GUIComponentB.get(temp-i).setEnabled(false);
				}
			}
			else
			{
				button.setText("保存設置");
				temp -= 7;
				checkbox = (JCheckBox)GUIComponentB.get(temp); 
				for(int i=0;i<7;i++)
				{
					if(i==6)
					{
						radiobutton = (JRadioButton)GUIComponentB.get(temp+3);
						GUIComponentB.get(temp+i).setEnabled(radiobutton.isSelected()?checkbox.isSelected():false);
					}
					else GUIComponentB.get(temp+i).setEnabled(checkbox.isSelected());
				}
			}
		}
	}
}