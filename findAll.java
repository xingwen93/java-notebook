

import java.awt.event.*; 

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultHighlighter;
import javax.swing.text.Highlighter;

import java.awt.*;
import java.nio.Buffer;
import java.util.Iterator;
import java.util.TreeMap;


   
public class findAll extends JDialog 
{
 
    int t;
	JLabel chazhao;
	JTextField shuru;
	JButton chazhaonext,quxiao;
	JCheckBox qufen;
	JRadioButton up,down;
	static int h,w;
	static String search;
	String findposition="它们位于：\n";
	static Highlighter  highlighter;
	
	
	findAll(Frame frame,String title, boolean b)
	 {
		super(frame,title,b);
		
		
		
		
		
		chazhao=new JLabel("查找内容(N):");
		
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
		
		chazhaonext=new JButton("查找");
		chazhaonext.setEnabled(false);

		quxiao=new JButton("取消");
		
		
		
	    this.setSize(405,120);
		this.setLocationRelativeTo(null);

		
		JPanel pane=new JPanel();
		pane.setLayout(null);
		chazhao.setBounds(10, 10, 80, 30);
		shuru.setBounds(10,40,200, 22);
		chazhaonext.setBounds(230,15,120,22);
		quxiao.setBounds(230, 50, 120,22);
		
		
		
		pane.add(chazhao);
		pane.add(shuru);
		pane.add(chazhaonext);
		pane.add(quxiao);
		
		
		this.getContentPane().add(pane);
		
		
		chazhaonext.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
			    search = shuru.getText();
				String textst=writebroad.text.getText();
				
			//高亮标记出查找到的所有内容	
		    	  highlighter =writebroad.text.getHighlighter();
				
				if(textst.contains(search))
				{
					int index=textst.indexOf(search);
					while (true)
					{
						if(index!=-1)
						{
							try{
								highlighter.addHighlight(index,index+search.length(), DefaultHighlighter.DefaultPainter);
								
							}catch(BadLocationException e)
							{
								e.printStackTrace();
							}
							index=textst.indexOf(search,++index);
							
						}
						else
							break;
						
					}
				}
				
				
				
				
				
				
				
				
			     	int count=0;
					//（循环+指定起始位置）
					int t=0;
					for(int i=0;i<textst.length();i++){			
						t=textst.indexOf(search,i);
						if(t!=-1)
						{
				     	count++;//次数增加
						i=t;//指定起始位置
				 
						Rectangle rec = null;
						try {
							rec = writebroad.text.modelToView(i);
						} catch (BadLocationException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						      h=rec.y / rec.height + 1;

								writebroad.text.select(t,t+ search.length());
							   findposition=findposition+("           第   "+h+"  行,   第  "+(t+1)+"   列\n");
				       	}
						
						}
					  JOptionPane.showMessageDialog(null,findposition+(" \n 出现的次数共："+count+"次"),"消息对话框",JOptionPane.PLAIN_MESSAGE);
				      writebroad.findflag=true;
					  dispose();
			
			}
			
		 

		 });


		 quxiao.addActionListener(new ActionListener(){
		 public void actionPerformed(ActionEvent e)
		 {     
			 dispose();
			 highlighter.removeAllHighlights();
			
		 }
		 });



	}
	
} 
		
	
 
 
	
	

	


 

 

 