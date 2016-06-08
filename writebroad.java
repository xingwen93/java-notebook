
import java.awt.BorderLayout;  

import java.awt.Container;
import java.awt.Cursor;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;

import java.awt.Point;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.KeyStroke;

import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

public class writebroad extends JFrame implements MouseListener,ActionListener{

	JMenuBar menubar;
	static JMenuItem print;
	JMenu file,editor,format,visible,help,zidingyi,zidingyibeijing,shubiao;
	JMenuItem newfile,open,save,othersave,exit,
	jianqie, fuzhi, zhantie,shanchu, chazhaoxia,
    swap,zhuandao,tongji,allselect,time,	findall,autohuanhang,ziti,
    zhuangtai,  chakanbanzhu,  guanyu,zidingyicolor,xuanzebeijing,chuizhi,shizhijia,moren,shoushi,shuipin;
	JPopupMenu popupmenu;
	JMenuItem jianqie2,fuzi2,zhantie2,shanchu2,recover,vUnicode;
	static JMenuItem chexiao2,chexiao;
	Clipboard clipboard=this.getToolkit().getSystemClipboard();
	 JFileChooser filedialog;
	JLabel position, timetip;
	JPanel infor;
	static JTextArea text;
	String filesavename;
    boolean flag=false;
   static  boolean findflag=false;
   
    
    ImageIcon imageIcon ;
    static UndoManager undomg = new UndoManager(); 
  
    
    
    
    
    
    public writebroad()
    {
    	  
    	
    	this.setTitle("记事本");
    	
    	//Icon img = new ImageIcon(getClass().getResource("bg.jpg"));   
		//Image img = kit.getImage("image//1.png"); 
		
    	//设置鼠标的图片
   
    	this.getContentPane().setCursor(getMyCursor());
    	
    	
    	
        Toolkit tk=Toolkit.getDefaultToolkit();
        		Image image=tk.createImage("title2.png");
        		this.setIconImage(image);
        
    	this.addWindowListener(new WindowAdapter()
    	{  
    	      public void windowClosing( WindowEvent e )
    	      { 
    	    	  int result=JOptionPane.showConfirmDialog(null, "是否将更改的文件保存？", "记事本", JOptionPane.YES_NO_CANCEL_OPTION);
    				if(result==JOptionPane.YES_OPTION)
    				{
    					othersave.doClick();
    				}
    				else if(result==JOptionPane.CANCEL_OPTION)
    				{
    				    return;
    				}
    			
    	     }
    	} );
		
		
		
		
        menubar=new JMenuBar();
        popupmenu=new JPopupMenu();
        filedialog=new JFileChooser(".");
        
      
        
        
        
   
          
         text = new JTextArea() {  
         
          public void paint(Graphics g) { 
        	   imageIcon = new ImageIcon(imagechooser.temp); 
        	  g.drawImage(imageIcon.getImage(), 0, 0,this.getWidth(),this.getHeight(), this);  
              super.paint(g);  
           }  
         };
         
        text.setFont(new Font("楷体",Font.BOLD,15));
        
    	text.add(popupmenu);
    	
        text.addMouseListener(this);
        
        //查找全部标记时，点击文本域，取消标记
        text.addMouseListener(new MouseAdapter()
        {
        	public void mousePressed(MouseEvent e)
        	{
        		if(findflag==true)
   	        	 findAll.highlighter.removeAllHighlights();
        	}
        });
        		  
        	
        text.addKeyListener(new KeyListener()
       {

    	@Override
    	public void keyPressed(KeyEvent arg0) {
    		// TODO Auto-generated method stub
          
    		
    		
    		if(arg0.getSource()!=null)
    		{
    			if(filesavename!=null)
    			{
    				writebroad.this.setTitle(filesavename+"**--记事本");
    				return;
    			}
    			else
    			{
    				writebroad.this.setTitle("未命名**--记事本");
    			    return;
    			}
    			
    		}
    	}
    	@Override
    	public void keyReleased(KeyEvent arg0) {
    		// TODO Auto-generated method stub
    		
    	}

    	@Override
    	public void keyTyped(KeyEvent arg0) {
    		// TODO Auto-generated method stub
    		
    	}
     });
        
        
        
    	file=new JMenu("文件(F)");
        file.setMnemonic('F');
        
    	editor=new JMenu("编辑(E)");
    	editor.addMouseListener(new MouseAdapter()
    	{
    		public void mousePressed(MouseEvent ee)
    		{
    			
    			zhuandao.setEnabled(canZhuandao());
    		}
    		
    	});
    	editor.setMnemonic('E');
    	
    	format=new JMenu("格式(O)");
    	format.setMnemonic('O');
    	
    	visible=new JMenu("查看(V)");
    	visible.setMnemonic('V');
    	
    	help=new JMenu("帮助(H)");
    	help.setMnemonic('H');
    	
   	    newfile=new JMenuItem("新建(N)");
    	
   	   newfile.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
   	    newfile.addActionListener(new ActionListener()
        {

   			@Override
   			public void actionPerformed(ActionEvent arg0) 
   			{
   				// TODO Auto-generated method stub
   				int result=JOptionPane.showConfirmDialog(null, "是否将更改的文件保存？", "记事本", JOptionPane.YES_NO_CANCEL_OPTION);
   				
   				if(result==JOptionPane.YES_OPTION)
   				{
   					othersave.doClick();
   				}
   				else if(result==JOptionPane.CANCEL_OPTION)
   				{
   				   return;
   				}
   				writebroad.this.setTitle("未命名**--记事本");
	            text.setText(null);	
   			}

        });
    

   	  
   	 
      open=new JMenuItem("打开(O)");
      open.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O,InputEvent.CTRL_MASK));
      open.addActionListener(this);

	
      save=new JMenuItem("保存(S)");
      save.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
      save.addActionListener(this);
      
      othersave=new JMenuItem("另存为(A)");
      othersave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
      othersave.addActionListener(this);
    
      
     
      print=new JMenuItem("打印(P)");
      print.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_P,InputEvent.CTRL_MASK));
      print.addActionListener(new writebroadMain());
      exit=new JMenuItem("退出(E)");
      exit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.CTRL_MASK));
      exit.addActionListener(new ActionListener()
      {

 			@Override
 			public void actionPerformed(ActionEvent arg0) 
 			{
 				int result=JOptionPane.showConfirmDialog(null, "是否将更改的文件保存？", "记事本", JOptionPane.YES_NO_CANCEL_OPTION);
 				
 				if(result==JOptionPane.YES_OPTION)
 				{
 					othersave.doClick();
 				}
 				else if(result==JOptionPane.CANCEL_OPTION)
 				{
 				   return;
 				}
 				System.exit(0);
 			}

      });
         
      chexiao=new JMenuItem("撤销(Z)");
      chexiao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.CTRL_MASK));
     
     text.getDocument().addUndoableEditListener(new UndoableEditListener()
     {

		@Override
		public void undoableEditHappened(UndoableEditEvent arg0) {
			// TODO Auto-generated method stub
			undomg.addEdit(arg0.getEdit());
		}
    	 
     });  
     chexiao.addActionListener(new ActionListener() {  
           public void actionPerformed(ActionEvent evt) {  
               if(undomg.canUndo()) {  
                   undomg.undo();  
               } else {  
                  JOptionPane.showMessageDialog(null,"系统无内容可以撤销了，导致无法撤销","警告",JOptionPane.WARNING_MESSAGE);  
            	  
               }  
           }  
       });  
 
     
      
      
     
     jianqie=new JMenuItem("剪切(T)");
     jianqie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.CTRL_MASK));
     jianqie.addActionListener(new operater());
 	 
     fuzhi=new JMenuItem("复制(C)");
     fuzhi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.CTRL_MASK));
	 fuzhi.addActionListener(new operater());
	 
     zhantie=new JMenuItem("粘贴(P)");
     zhantie.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.CTRL_MASK));
	 zhantie.addActionListener(new operater());
	 
     shanchu=new JMenuItem("删除(D)");
     shanchu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
	 shanchu.addActionListener(new operater());
	 
	 findall=new JMenuItem("查找全部(A)");
	 findall.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
	 findall.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			findAll f=new findAll(null,"查找全部",true);
			f.setVisible(true);
		}
    	 
     });
	 chazhaoxia=new JMenuItem("查找下一个(N)");
	 chazhaoxia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
	 chazhaoxia.addActionListener(new ActionListener()
     {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			text.setCaretPosition(0);
			MyFind f=new MyFind(null,"查找",true);
			f.setVisible(true);
		}
    	 
     });
	 swap=new JMenuItem("替换(R)");
	 swap.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.CTRL_MASK));
	 swap.addActionListener(new ActionListener()
     {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tihuan t=new tihuan(null,"替换",true);
				t.setVisible(true);
			}
	    	 
	     });
	 zhuandao=new JMenuItem("转到(N)");
	 
	 zhuandao.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_N,InputEvent.CTRL_MASK));
	 zhuandao.addActionListener(new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			zhuandao dialog=new zhuandao(writebroad.this,"转到行",true);
			dialog.setVisible(true);
			
		}
		 
	 });
	 
	 allselect=new JMenuItem("全选(A)");
	 allselect.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
	 allselect.addActionListener(new operater());
	 popupmenu.add(allselect);
	 
	 tongji=new JMenuItem("统计(T)");
	 tongji.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_T,InputEvent.CTRL_MASK));
	 tongji.addActionListener(new operater());
	 tongji.addActionListener(new ActionListener()
     {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				tongji ji=new tongji(null,"统计",true);
				ji.setVisible(true);
			}
	    	 
	     });
	 time=new JMenuItem("时间/日期(D)");
	 time.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.CTRL_MASK));
	 time.addActionListener(new ActionListener()
	 {
		public void actionPerformed(ActionEvent arg0) {
		  	// 获得当前光标位置  
			int cur = text.getCaretPosition();  
			// 得到光标之后的字符串  
			String tailString = text.getText().substring(cur);  
			// 得到光标之前的字符串  
			String headString = text.getText().substring(0,cur);  
			// 拼接字符串 并输出  
			text.setText(headString + new timeinfor().temptime2 + tailString); 
		}
		 
	 });
	 autohuanhang=new JMenuItem("自动转行(W)");
	 autohuanhang.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.CTRL_MASK));
	
	 autohuanhang.addActionListener(new ActionListener()
	 {
     	public void actionPerformed(ActionEvent arg0) {
	      		text.setLineWrap(true);
	      		JOptionPane.showMessageDialog(null, "系统已根据窗口的大小进行换行");
			}
			 
		 });
	 
	 
	 ziti=new JMenuItem("字体(F)");
	 ziti.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F,InputEvent.CTRL_MASK));
	 ziti.addActionListener(new ActionListener()
	 {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			Fontdialogd di=new Fontdialogd(null,"字体",true);
			di.setVisible(true);
			
			
		}
		 
	 });
	 zhuangtai=new JMenuItem("状态栏(S)");
	 zhuangtai.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S,InputEvent.CTRL_MASK));
	 zhuangtai.addActionListener(new ActionListener()
	 {
		public void actionPerformed(ActionEvent e)
		{
		     infor.setVisible(true);
		    
		}
	 });

	 
	 chakanbanzhu=new JMenuItem("查看帮助(H)");
    chakanbanzhu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.CTRL_MASK));
    
    guanyu=new JMenuItem("关于记事本(A)");
    guanyu.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A,InputEvent.CTRL_MASK));
    guanyu.addActionListener(new ActionListener()
    {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			about about=new about(null,"关于作者",true);
			about.setVisible(true);
		}
   	 
    });
    zidingyi=new JMenu("自定义设计(D)");
    zidingyi.setMnemonic('D');
    zidingyibeijing=new JMenu("其他(O)");
    zidingyibeijing.setMnemonic('O');
    
   
   
    zidingyicolor=new JMenuItem("背景颜色(F1)");
    zidingyicolor.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F1,0));
    zidingyicolor.addActionListener(new ActionListener() {  
        
    	public void actionPerformed(ActionEvent evt) {  
    		
    		     
    		   Color newColor=JColorChooser.showDialog(null,"背景调色板",text.getBackground());
       	   	   text.setBackground(newColor);
       	   	   if(newColor==null)
       	   	   {
       	   		   JOptionPane.showMessageDialog(null, "您未选择任何颜色,系统已为您设为无色");
       	   	   }
       	   	    
       	   	    
     }  
}); 
 
  
  
   
    xuanzebeijing=new JMenuItem("选择图片背景(F2)");
    xuanzebeijing.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F2,0));
    xuanzebeijing.addActionListener(new ActionListener() {  
        
    	public void actionPerformed(ActionEvent evt) {  
 
    		imagechooser im=new imagechooser(null,"请选择背景图片",true);
			im.setVisible(true);
			zidingyicolor.setEnabled(false);
			JOptionPane.showMessageDialog(null, "您已选择了背景图样式，系统已关闭背景颜色操作");
        }  
}); 
	
	
	//chart.setBackgroundImage(image);
    shubiao=new JMenu("个性鼠标(S)");
    shubiao.setMnemonic('S');
    shizhijia=new JMenuItem("十字架");
    shizhijia.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_J,InputEvent.SHIFT_MASK));
    shoushi=new JMenuItem("手势");
    shoushi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_H,InputEvent.SHIFT_MASK));
    shuipin=new JMenuItem("水平");
    shuipin.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_W,InputEvent.SHIFT_MASK));
    chuizhi=new JMenuItem("垂直");
    chuizhi.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_E,InputEvent.SHIFT_MASK));
    moren=new JMenuItem("默认样式");
    moren.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_M,InputEvent.SHIFT_MASK));
    shizhijia.addActionListener(this);
    moren.addActionListener(this);
    shoushi.addActionListener(this);
    shuipin.addActionListener(this);
    chuizhi.addActionListener(this);
    
    
    
   
    
   
   
    chexiao2=new JMenuItem("撤销(Z)");
    popupmenu.add(chexiao2);
    popupmenu.addSeparator();
 
    chexiao2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_Z,InputEvent.SHIFT_MASK));
    
    chexiao2.addActionListener(new ActionListener() {  
        
        	public void actionPerformed(ActionEvent evt) {  
                if(undomg.canUndo()) {  
                    undomg.undo();  
                } else {  
                   JOptionPane.showMessageDialog(null,"系统无内容可以撤销","警告",JOptionPane.WARNING_MESSAGE);  
                	
                }  
            }  
    }); 
   
    
    jianqie2=new JMenuItem("剪切(J)");
    popupmenu.add(jianqie2);
    jianqie2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X,InputEvent.SHIFT_MASK));
    jianqie2.addActionListener(new operater());
    
    fuzi2=new JMenuItem("复制(C)");
    popupmenu.add(fuzi2);
    fuzi2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_C,InputEvent.SHIFT_MASK));
    fuzi2.addActionListener(new operater());
  
    zhantie2=new JMenuItem("粘贴(P)");
    popupmenu.add(zhantie2);
    popupmenu.addSeparator();
    zhantie2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V,InputEvent.SHIFT_MASK));
    zhantie2.addActionListener(new operater());
    
    
    shanchu2=new JMenuItem("删除(D)");
    popupmenu.add(shanchu2);
    popupmenu.addSeparator();
    shanchu2.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_D,InputEvent.SHIFT_MASK));
    shanchu2.addActionListener(new operater());
    
   
    recover=new JMenuItem("恢复到撤消前状态(R)");
    popupmenu.add(recover);
    recover.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,InputEvent.SHIFT_MASK));
    recover.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent evt) {  
            if(undomg.canRedo()) {  
                undomg.redo();  
            } else {  
             //   JOptionPane.showMessageDialog(null,"您未撤销内容了，导致系统无法继续恢复","警告",JOptionPane.WARNING_MESSAGE);  
                  recover.setEnabled(false);
            
            }  
        }  
    });  
    vUnicode =new JMenuItem("选中单个字符显示Unicode控制字符(U)");
    popupmenu.add(vUnicode);
    vUnicode.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_U,InputEvent.SHIFT_MASK));
    vUnicode.addActionListener(new ActionListener() {  
        public void actionPerformed(ActionEvent evt) {  
        	
        	String s=text.getSelectedText();
     	if(s==null)
     	{
     		JOptionPane.showMessageDialog(null,"您未选中任何内容");
     		return;
     		
     	}
     	else if(s.length()>1)
     		{
     		JOptionPane.showMessageDialog(null,"请用鼠标选择一个字符");
     		return;
     		}
     	
 
     	// 获得当前光标位置  
        final int cur = text.getCaretPosition()+s.length();  
         // 得到光标之后的字符串  
         String tailString = text.getText().substring(cur);  
         // 得到光标之前的字符串  
         String headString = text.getText().substring(0,cur);  
         // 拼接字符串 并输出  
     	char[] c=s.toCharArray();

     	for(int i=0;i<c.length;i++)

     	{
           text.setText(headString + "\n"+c[i]+"控制字符是:" +(int)c[i]+ "\n"+tailString); 
     	

     	}
        	}
        
    });  
    
    
    
    
    
  
    JScrollPane js=new JScrollPane(text,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
  
        position=new JLabel();
        timetip=new JLabel();
        timetip.setText(new timeinfor().temptime);
        
        infor=new JPanel();
        infor.setVisible(false);
        infor.setLayout(new GridLayout(1,2));
        
        infor.add(timetip);
    	infor.add(position);
    	timetip.setFont(new Font("宋体",Font.PLAIN,12));
    	position.setFont(new Font("宋体",Font.PLAIN,12));
    	
    	
    	Container con=this.getContentPane();
    	con.add(menubar,BorderLayout.NORTH);
    	con.add(js,BorderLayout.CENTER);
    	con.add(infor,BorderLayout.SOUTH);
    	
    	menubar.add(file);
    	menubar.add(editor);
    	menubar.add(format);
    	menubar.add(visible);
    	menubar.add(help);
    	menubar.add(zidingyi);
    
    	file.add(newfile);
    	file.add(open);
    	file.add(save);
    	file.add(othersave);
    	file.addSeparator();
        
    	file.add(print);
    	file.addSeparator();
    	file.add(exit);
    	editor.add(chexiao);
    	editor.addSeparator();
    	editor.add(jianqie);
    	editor.add(fuzhi);
    	editor.add(zhantie);
    	editor.add(shanchu); 
    	editor.addSeparator();
    	
    	 fuzhi.setEnabled(canCutCopy());
		jianqie.setEnabled(canCutCopy()); 
		zhantie.setEnabled(canPaste());
		 
		editor.add(findall);
    	editor.add(chazhaoxia);
    	editor.add(swap);
    	editor.add(zhuandao);
    	editor.addSeparator();
    	editor.add(allselect);
    	editor.add(tongji);
    	editor.addSeparator();
    	editor.add(time);
        format.add(autohuanhang);
        format.add(ziti);
        visible.add(zhuangtai); 
        help.add(guanyu);
        help.addSeparator();
       help.add(chakanbanzhu);
       
       zidingyi.add(zidingyicolor);
       zidingyi.add(zidingyibeijing);
       zidingyibeijing.add(xuanzebeijing);
        zidingyibeijing.add(shubiao);
      
        shubiao.add(moren);
        shubiao.add(shoushi);
        shubiao.add( shizhijia);
        shubiao.add(shuipin);
        shubiao.add(chuizhi);
    
    	
       this.setSize(800,600);
    }
    	
     
    
    //设置鼠标的图片
    private Cursor getMyCursor() {
		// TODO Auto-generated method stub
		Image img = new ImageIcon(this.getClass().getResource("1.png")).getImage();
		  return this.getToolkit().createCustomCursor(img,new Point(16,16),"mycursor"); 
	}
  

	



	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
		 
		if(arg0.getButton()==MouseEvent.BUTTON3)
		{
			int x=arg0.getX();
			int y=arg0.getY();
			popupmenu.show(arg0.getComponent(),x,y);
			jianqie2.setEnabled(canCutCopy());
			
			
			
			fuzi2.setEnabled(canCutCopy());
			
			zhantie2.setEnabled(canPaste());
			
		
			
		}
		if(arg0.getButton()==MouseEvent.BUTTON1||arg0.getButton()==MouseEvent.BUTTON3)
		{
			int  LocationX=arg0.getX();
			int  LocationY=arg0.getY();
			position.setText("                    | 智能插入: 第"+LocationX+"行  第"+LocationY+"列");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    
	class operater implements ActionListener
	{

		@Override
		public void actionPerformed(ActionEvent e ) {
			// TODO Auto-generated method stub
			
			 if(e.getSource()==jianqie||e.getSource()==jianqie2)
			{
				text.cut();
			}
			else if(e.getSource()==fuzhi||e.getSource()==fuzi2)
			{
				text.copy();
			}
			else if(e.getSource()==zhantie||e.getSource()==zhantie2)
			{
				text.paste();
				
			}
			else if(e.getSource()==allselect)
			{
				text.selectAll();
				
			}
			else if(e.getSource()==shanchu||e.getSource()==shanchu2)
			{
				if(text.getSelectedText()!=null)
					text.replaceSelection("");
				else 
					JOptionPane.showMessageDialog(null, "您未选中任何内容");
			}
		}
		
	}
	//判断能否使用剪切和复制功能，如果文本区中有选中的内容，可以剪切和复制
	private boolean canCutCopy()
	{
		boolean flag=false;
		
		if(text.getSelectedText()!=null && !text.getSelectedText().equals(""))
		{
			flag=true;
		}
		
		return flag;
	}
	private boolean canZhuandao()
	{
		boolean flag=false;
		
		if(text.getText()!=null&& !text.getText().equals(""))
		{
			flag=true;
		}
		
		return flag;
	}
	
	//判断剪贴板中是否有内容，如果有内容，则可以使用粘贴功能
   private boolean canPaste()
   {
	   boolean flag = false;
	   
	
	   
	   Transferable content = clipboard.getContents(this);    //获得剪贴板的内容
	   
	   try 
	   {
		    if (content.getTransferData(DataFlavor.stringFlavor) instanceof String)     //如果剪贴板中的数据是字符串
		    {
			     flag = true;
		    }
	   } 
	   catch (Exception e) 
	   {
	   }
	   return flag;
  }
   
   
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
	
		if(e.getSource()==open)
	  	{
			int result=JOptionPane.showConfirmDialog(this, "是否将更改的文件保存？", "记事本", JOptionPane.YES_NO_CANCEL_OPTION);
			
			if(result==JOptionPane.YES_OPTION)
			{
				othersave.doClick();
			}
			else if(result==JOptionPane.CANCEL_OPTION)
			{
			   return;
			}
	
			 String s;
	          
	          if(filedialog.showOpenDialog(this)==JFileChooser.APPROVE_OPTION)
	          {
	          	try
	          	{
	          		text.setText(null);
	          		File file=filedialog.getSelectedFile();
	          		
	          		String filename=file.getName(); 
	          		
	          		FileReader file_reader=new FileReader(file);
	          		
	          		BufferedReader in=new BufferedReader(file_reader);
	          		
	          		while((s=in.readLine())!=null)
	          		{
	          			text.append(s+"\n");
	          		}
	          		
	          		in.close();
	          		
	          		file_reader.close();
	          		
	          		writebroad.this.setTitle(filename);
	          	}
	          	catch(Exception e1)
	          	{
	          		System.out.println(e.toString());
	          	}
	          }
	  	}
		
		if(e.getSource()==save&&filesavename!=null)//保存
        {
           try
           {
        	   FileWriter fw=new FileWriter(filesavename);//t102output.txt你想要存放的文件名，可以任意。
               fw.write(text.getText());                
               fw.close();
               writebroad.this.setTitle(filesavename);
           }catch(Exception  ex)
           {
               ex.printStackTrace();
           }
        }
		
		if(e.getSource()==othersave||(e.getSource()==save&&filesavename==null))
	  	{
	  		
		 if(filedialog.showSaveDialog(this)==JFileChooser.APPROVE_OPTION)
         {
	          	try
	          	{
	          		File file=filedialog.getSelectedFile();
	          		
	                filesavename=file.getName();
	          		
	          		FileWriter tofile=new FileWriter(file);
                    
	          		String s=text.getText();
                   
                   tofile.write(s);
                   
                    tofile.close();
                    
                    writebroad.this.setTitle(filesavename);
	          	}
	          	catch(Exception e2)
	          	{
	          		System.out.println(e.toString());
	          	}
         }
		
	  	} 
		
		
		      
		   
		     else if(e.getSource()==shizhijia){
	        	  text.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
	        	 
	          }
	          else if(e.getSource()==moren){
	        	  text.setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
	        	  
	          }
	          else if(e.getSource()==shoushi){
	        	  text.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	        	  
	          }
	          else if(e.getSource()==shuipin){
	        	  text.setCursor(Cursor.getPredefinedCursor(Cursor.W_RESIZE_CURSOR));
	        	  
	          }
	          else if(e.getSource()==chuizhi){
	        	  text.setCursor(Cursor.getPredefinedCursor(Cursor.N_RESIZE_CURSOR));
	        	  
	          }
	}}

