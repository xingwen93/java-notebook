
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class MyFind extends JDialog
{
	JLabel chazhao;
	JTextField shuru;
	JButton chazhaonext,quxiao;
	JCheckBox qufen;
	JRadioButton up,down;
	
	MyFind(Frame frame,String title, boolean b)
	 {
		super(frame,title,b);
		chazhao=new JLabel("查找内容(N):");
		qufen=new JCheckBox("区分大小写");
		shuru=new JTextField();
		shuru.addKeyListener(new java.awt.event.KeyAdapter() {   
			
		    public void keyPressed(KeyEvent eee) {
		    	chazhaonext.setEnabled(true);
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
		
		chazhaonext=new JButton("查找下一个");
		chazhaonext.setEnabled(false);

		quxiao=new JButton("取消");
		
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
		
		
	    this.setSize(490,155);
		this.setLocationRelativeTo(null);

		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		chazhao.setBounds(10, 10, 80, 30);
		shuru.setBounds(83,15,200, 22);
		chazhaonext.setBounds(300,15,120,22);
		quxiao.setBounds(300, 50, 120,22);
		qufen.setBounds(10,70, 110, 30);
		fanxiang.setBounds(125, 50, 160, 60);
		
		pane.add(chazhao);
		pane.add(shuru);
		pane.add(chazhaonext);
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


		 quxiao.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
		 {     
			 dispose();
		 }
		 });



	} 
} 
		
	
 
 
	
	

	


 

 

 