


import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.StringTokenizer;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

//实现菜单里  替换功能 对话框
public class tihuan extends JDialog implements ActionListener {
	
	JLabel chazhao,tihuanwei;
	JTextField shuru,shuru2;
	JButton chazhaonext,tihuan,quxiao,quanbu;
	JCheckBox qufen;
	JRadioButton up,down;
	public tihuan(JFrame own,String title,boolean bo)
	{
		super(own,title,bo);
	
		chazhao=new JLabel("查找内容(N):");
		tihuanwei=new JLabel("替换为：");
		qufen=new JCheckBox("区分大小写");
		shuru=new JTextField();
		shuru2=new JTextField();
		
		shuru2.addKeyListener(new java.awt.event.KeyAdapter() {   
			
    	    public void keyPressed(KeyEvent eee) {
    	    	tihuan.setEnabled(true);
	    		quanbu.setEnabled(true);
	    		
    	     if (eee.getKeyCode() == KeyEvent.VK_ENTER)  
    	     {
    	    	 
    	    
    	    	 setVisible(false);
    	     }}
    	   });
		shuru.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent ee){
                	shuru.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
	     }
      
		});
		shuru.addMouseListener(new MouseAdapter()
		{
			@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			     	
    	            shuru.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		}
		});
		shuru2.addMouseMotionListener(new MouseMotionAdapter(){
            public void mouseMoved(MouseEvent ee){
            	
                shuru2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(255, 0, 0)));
	     }
      
		});
		shuru2.addMouseListener(new MouseAdapter()
		{
			@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
				shuru2.setBorder(javax.swing.BorderFactory.createLineBorder(Color.blue));
		}
		});
		
		chazhaonext=new JButton("查找下一个");
		chazhaonext.addActionListener(this);
		
		tihuan=new JButton("替换");
		tihuan.setEnabled(false);
		tihuan.addActionListener(this);
		quanbu=new JButton("全部替换");
		quanbu.setEnabled(false);
		quanbu.addActionListener(this);
		quxiao=new JButton("取消");
		
		quxiao.addActionListener(this);
		JPanel fanxiang=new JPanel();
	    fanxiang.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.LIGHT_GRAY),"方向"));
		up=new JRadioButton("向上");
		down=new JRadioButton("向下");
		down.setSelected(true);
		
		ButtonGroup g=new ButtonGroup();
		g.add(up);
		g.add(down);
		Box box=Box.createHorizontalBox();
		box.add(up);
		box.add(Box.createHorizontalStrut(8));
		box.add(down);
		down.setSelected(true);
		fanxiang.add(box);
	
		
		
        this.setSize(485,185);
		this.setLocationRelativeTo(null);
	
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		chazhao.setBounds(10, 10, 80, 30);
		shuru.setBounds(83,15,200, 22);
		tihuanwei.setBounds(10,40,80,30);
		shuru2.setBounds(83,45, 200, 22);
		
		chazhaonext.setBounds(300,15,120,22);
		tihuan.setBounds(300,45, 120,22);
		quanbu.setBounds(300,75,120,22);
		quxiao.setBounds(300,105,120,22);
		qufen.setBounds(10,100, 110, 30);
		
		fanxiang.setBounds(125, 80, 160, 60);
		
		pane.add(chazhao);
		pane.add(shuru);
		pane.add(tihuanwei);
		pane.add(shuru2);
		pane.add(chazhaonext);
		pane.add(tihuan);
		pane.add(quanbu);
	    pane.add(quxiao);
		pane.add(qufen);
		pane.add(fanxiang);
		this.getContentPane().add(pane);
		
		
		

		chazhaonext.addActionListener(new ActionListener()
		 {

			String str3 = shuru.getText();
		 public void actionPerformed(ActionEvent e)
		 {
         
			 int a =0, b =0;
			 if(!shuru.getText().equals(str3))
				 writebroad.text.setCaretPosition(0);
		 int FindStartPos=writebroad.text.getCaretPosition();
		 String str1, str2, str4, strA, strB;
		 str1 = writebroad.text.getText();
		 str2 = str1.toLowerCase();
		 str3 = shuru.getText();
		 str4 = str3.toLowerCase();

		 //"区分大小写"的CheckBox被选中
		 
			 strA = str1;
			 strB = str3;
		

		 if(up.isSelected())
		 {

		 if(writebroad.text.getSelectedText()==null)
		 
			 a = strA.lastIndexOf(strB, FindStartPos-1);
		 else
		   a = strA.lastIndexOf(strB, FindStartPos-shuru.getText().length()-1);
		 
		 }
		 
		else if(down.isSelected())
		 {
          if(writebroad.text.getSelectedText()==null)
		     a = strA.indexOf(strB, FindStartPos);
		 
		 
		 else
			 a=strA.indexOf(strB,FindStartPos-shuru.getText().length()+1);
		
		 }
		
		 
	 if(a > -1)
       {
		
		 if(up.isSelected())
		 {
			 writebroad.text.setCaretPosition(a);
			 b = shuru.getText().length();
			 writebroad.text.select(a, a + b);
			 
			 
		  }
		 
		 else if(down.isSelected())
		 {
			 writebroad.text.setCaretPosition(a);
			 b = shuru.getText().length();
			 writebroad.text.select(a, a + b);
			
			 
	      }
		 
	  }

		 else
			 JOptionPane.showMessageDialog(null, "找不到您查找的内容!", "记事本",JOptionPane.INFORMATION_MESSAGE);
	 }
		 });

	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
	    
		  
			
			
			
			   String search = shuru.getText();
				String textst=writebroad.text.getText();
				String replace=shuru2.getText();
				String newText;  
			
		   if(arg0.getSource()==quanbu)
		  { 
			    
			newText=textst.replace(search, replace);
			
			writebroad.text.setText(newText);
			
			JOptionPane.showMessageDialog(null, "系统已经为您全部替换");
			
			setVisible(false);
	      }
		   
		   else if(arg0.getSource()==tihuan)
			  { 
			   
				newText=textst.replaceFirst(search, replace);
				
				writebroad.text.setText(newText);
				
				JOptionPane.showMessageDialog(null, "系统已经为您替换了一个符合的字符串");
				
				
		      }
    
		else if(arg0.getSource()==quxiao)
		{
				dispose();
		}
		}
		
	
}



