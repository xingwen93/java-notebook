

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.text.BadLocationException;

//实现菜单里  转到功能 对话框
public class zhuandao extends JDialog implements ActionListener {
	
	JLabel hanghao;
	JTextField shuru;
	JButton zhuandao,quxiao;
	
	public zhuandao (JFrame own,String title,boolean bo)
	{
		
		super(own,title,bo);
	
		hanghao=new JLabel("行号:");
		
		shuru=new JTextField();
		shuru.addKeyListener(new java.awt.event.KeyAdapter() {   
			
    	    public void keyPressed(KeyEvent eee) {
    	     
    	     if (eee.getKeyCode() == KeyEvent.VK_ENTER)  
    	     {
    	    	 

    				String s = shuru.getText();
    				try{
    					 hangshu = Integer.parseInt(s);
    					 
    					 
    					 
    					 int linenum = 0;
    		             linenum = writebroad.text.getLineOfOffset(writebroad.text.getText().length());
    		                   
    		                   
    		                
    		                
    					 if(hangshu>linenum+1)
    					{
    						 
    						 JOptionPane.showMessageDialog(null, "您所输入的行数超出了您当前文本内容的行数，请重新输入");
    						
    						 return;
    				   }

    					int position=writebroad.text.getLineStartOffset(hangshu);
    				    
    					JOptionPane.showMessageDialog(null, "系统已经为您自动转到了第"+hangshu+"行");
    				     writebroad.text.setCaretPosition(position-1);
    					setVisible(false);
    				 }
    				catch(NumberFormatException ee)
    		      	{
    					JOptionPane.showMessageDialog(null, "违法数字格式!请重新输入");
    		    		ee.printStackTrace();
    		    	}  
    				catch (BadLocationException e1)
    				{
    						// TODO Auto-generated catch block
    					    
    						dispose();
    						JOptionPane.showMessageDialog(null, "系统已经为您自动转到了第"+hangshu+"行");
    						
    				}
    		     }
    	    }
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
		
		
		zhuandao=new JButton("转到");
		
		zhuandao.addActionListener(this);
		quxiao=new JButton("取消");
		quxiao.addActionListener(this);
		
		
		this.setSize(330,145);
		this.setLocationRelativeTo(null);
	
		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		hanghao.setBounds(10, 10, 50, 30);
		shuru.setBounds(10, 40, 300, 25);
		zhuandao.setBounds(110,70,90,20);
		quxiao.setBounds(210, 70, 90,20);
		pane.add(hanghao);
		pane.add(shuru);
		pane.add(zhuandao);
		pane.add(quxiao);
		this.getContentPane().add(pane);
		
		
		
	
	}

	int hangshu ;
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
		if(arg0.getSource()==zhuandao)
		{   
			String s = shuru.getText();
			try{
				 hangshu = Integer.parseInt(s);
				 
				 
				 
				 int linenum = 0;
	             linenum = writebroad.text.getLineOfOffset(writebroad.text.getText().length());
	                   
	                   
	                
	                
				 if(hangshu>linenum+1)
				{
					 
					 JOptionPane.showMessageDialog(null, "您所输入的行数超出了您当前文本内容的行数，请重新输入");
					
					 return;
			   }

				int position=writebroad.text.getLineStartOffset(hangshu);
			    
				JOptionPane.showMessageDialog(null, "系统已经为您自动转到了第"+hangshu+"行");
			     writebroad.text.setCaretPosition(position-1);
				setVisible(false);
			 }
			catch(NumberFormatException ee)
	      	{
				JOptionPane.showMessageDialog(null, "违法数字格式!请重新输入");
	    		ee.printStackTrace();
	    	}  
			catch (BadLocationException e1)
			{
					// TODO Auto-generated catch block
				    
					dispose();
					JOptionPane.showMessageDialog(null, "系统已经为您自动转到了第"+hangshu+"行");
					
			}
	    	 }
    
		else if(arg0.getSource()==quxiao)
		{
				dispose();
		}
		}
		
	
}
