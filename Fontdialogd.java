

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;



public class Fontdialogd extends JDialog implements ActionListener,ListSelectionListener{

	Fontnames fonts;
	String name[]; 
	JTextField fontstylete,fontsizete;
	JTextField size;
	JComboBox FontC,Size,ColorC,pianyiEm;
	JList fontstylelist,fontsizelist;
	JButton button1,button2;
	JCheckBox jcb1,jcb2,wutexiao;
	JRadioButton jrb1,jrb2;
	JLabel viewla;
	int font_size,font_style_bold,font_styple_italic;
	String  font_type;
	String selectedfont;
	Font selectedstyle;
	int selectedsize;
	int i=20;
	String fst,s;
    Container  con=this.getContentPane();
    String[] styles = { "常规", "加粗", "斜体", "加粗斜体" };
    String[] sizes = { "10", "14", "18", "22", "26", "30" };
    static Font font;
    HashMap<TextAttribute, Object> hm2 = new HashMap<TextAttribute, Object>(); 
	public Fontdialogd(JFrame own,String title,boolean b)
	{
		
		super(own,title ,b);
		this.setResizable(false);
	   //居中 
		int windowW=470;
		int windowH=370;
		Dimension tool=Toolkit.getDefaultToolkit().getScreenSize();
        int screenW=tool.width;
        int screenH=tool.height;
        this.setLocation(screenW/2-windowW/2, screenH/2-windowH/2);
        
		this.setSize(470,370);
		
		JPanel p=new JPanel();
		p.setLayout(new GridLayout(2,1));
		
		JPanel p1=new JPanel();
		p1.setLayout(new GridLayout(1,4));
		
		JPanel p2=new JPanel();
		p2.setLayout(new GridLayout(1,2));
		
		JPanel fontpane=new JPanel();
		fontpane.setLayout(new GridLayout(3,1));
		fontpane.setBorder(BorderFactory.createEmptyBorder(0,5,0,5));
		
		JPanel colorpane=new JPanel();
		colorpane.setLayout(new GridLayout(3,1));
		colorpane.setSize(10,5);
		colorpane.setBorder(BorderFactory.createEmptyBorder(10,50,0,30));
		
		 Box fontbox=Box.createVerticalBox();
		 
		 FontC=new JComboBox();
		 JLabel fontla=	new JLabel("字体");
	     fontbox.add(fontla);
	//	 Font.setPreferredSize(new  Dimension(2,25));
	     fontbox.add(Box.createVerticalStrut(5));
	     fontbox.add(FontC);
	     
	     fontpane.add(fontbox);
	     
		 fonts=new Fontnames();
		 name=fonts.getFont();
		
		 FontC.addItem("楷体");
		
		for(int i=0;i<name.length;i++)
			FontC.addItem(name[i]);
	    FontC.addActionListener(this);
	
       
        JPanel Fontsize=new JPanel();
   	     
        Fontsize.setBorder(BorderFactory.createEmptyBorder(5,10, 5, 0));
        
        fontsizelist=new JList(sizes);
     
        fontsizelist.addListSelectionListener(this);
        fontsizelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontsizelist.setVisibleRowCount(6);
        fontsizete=new JTextField(sizes[0]);
        JScrollPane jspfontsize = new JScrollPane(fontsizelist);
        Fontsize.setLayout(new BoxLayout(Fontsize, BoxLayout.PAGE_AXIS));
        Fontsize.add(fontsizete);
        Fontsize.add(jspfontsize);
        
        JPanel Fontstyle=new JPanel();
        Fontstyle.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 0));
        
        fontstylelist=new JList(styles);
        
        fontstylelist.setName("style");
        fontstylelist.addListSelectionListener(this);
        fontstylelist.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        fontstylelist.setVisibleRowCount(6);
        fontstylete=new JTextField(styles[0]);
        JScrollPane jspfontstyle = new JScrollPane(fontstylelist);
        Fontstyle.setLayout(new BoxLayout(Fontstyle, BoxLayout.PAGE_AXIS));
        Fontstyle.add(fontstylete);
        Fontstyle.add(jspfontstyle);
        
        button1=new JButton("确定");
        
        button1.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str=writebroad.text.getText();
				JLabel strla=new JLabel(str);
				writebroad.text.setFont(viewla.getFont());
				writebroad.text.setForeground(viewla.getForeground());
			    if(jcb1.isSelected())
			    { 
			    	hm2.put(TextAttribute.UNDERLINE, TextAttribute.UNDERLINE_ON);  // 定义下划线 
		             font = new Font(hm2); 
		            writebroad.text.setFont(font);
			    }
			    else if(jcb2.isSelected())
			    {
			    	
			    	hm2.put(TextAttribute.STRIKETHROUGH, TextAttribute.STRIKETHROUGH_ON);  // 定义删除线 
		            font = new Font(hm2); 
		            writebroad.text.setFont(font);
			    }
			    else if(jrb1.isSelected())
			    {
			       writebroad.text.setFont(font);
			       String ss=writebroad.text.getText();
			       writebroad.text.setText(new letertochange().ChangetoLO(ss));
			    }
			    else if(jrb2.isSelected())
			    {
			    	
			    	writebroad.text.setFont(font);
				    String ss=writebroad.text.getText();
				    writebroad.text.setText(new letertochange().ChangetoUP(ss));
			    }
			  
               setVisible(false);
			}
        	
        });
        button2=new JButton("取消");
        button2.addActionListener(new ActionListener()
        {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO Auto-generated method stub
				 dispose();
			}
        	
        });
        JPanel Buttontwo=new JPanel();
        Box box=Box.createVerticalBox();
       
        box.add(button1); 
        box.add(Box.createVerticalStrut(7));
        box.add(button2);
        Buttontwo.add(box);
        Buttontwo.setBorder(BorderFactory.createEmptyBorder(10,10,0,5));
       
        JPanel xiaoguo=new JPanel();
        xiaoguo.setBorder(BorderFactory.createEmptyBorder(0, 5, 0, 5));
        xiaoguo.setBorder(BorderFactory.createTitledBorder(BorderFactory.createLineBorder(Color.CYAN),"效果"));
        jcb1=new JCheckBox("下划线(U)");
        jcb2=new JCheckBox("删除线(S)");
        wutexiao=new JCheckBox("无特效");
        
        jrb1=new JRadioButton("全部大写(A)");
        jrb2=new JRadioButton("全部小写(S)");
        
        ButtonGroup g=new ButtonGroup();
        g.add(jcb1);
        g.add(jcb2);
        g.add(wutexiao);
        wutexiao.setSelected(true);
        
        
        
        jcb1.addItemListener(new jchandler());
        jcb2.addItemListener(new jchandler());
        
        jrb1.addItemListener(new jchandler());
        jrb2.addItemListener(new jchandler());
        
        Box boxleft=Box.createVerticalBox();
        Box boxright=Box.createVerticalBox();
        Box boxH=Box.createHorizontalBox();
        boxH.add(boxleft);
        boxH.add(Box.createHorizontalStrut(10));
        boxH.add(boxright);
      
        boxleft.add(jcb1);  
        boxright.add(jrb1);
      
        boxleft.add(jcb2); 
        boxleft.add(wutexiao);
        boxright.add(jrb2);
       
        boxright.add(jrb1);
        
        boxright.add(jrb2);
        
        xiaoguo.add(boxH);
        
        p2.add(xiaoguo);
        
        
        //颜色常量
        final Color[] colors = { Color.BLACK, Color.BLUE, Color.CYAN, Color.DARK_GRAY,
	            Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, Color.MAGENTA,
	            Color.ORANGE, Color.PINK, Color.RED, Color.WHITE, Color.YELLOW };
	    String[] colornames = { "BLACK", "BLUE", "CYAN", "DARK_GRAY", "GRAY",
	            "GREEN", "LIGHT_GRAY", "MAGENTA", "ORANGE", "PINK", "RED", "WHITE",
	            "YELLOW" };
      
	   
	    
        ColorC = new JComboBox();
       
        for(int i=0;i<colornames.length;i++)
	        ColorC.addItem(colornames[i]);
	     ColorC.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		viewla.setForeground(colors[ColorC.getSelectedIndex()]);
        	}
        });
        Box boxcolor=Box.createVerticalBox();
        
        boxcolor.add(new JLabel("颜色"));
        boxcolor.createVerticalStrut(5);
        boxcolor.add(ColorC);
        
        colorpane.add(boxcolor);
        p2.add(colorpane);
               
       
        
        JPanel view=new	 JPanel();
        view.setBorder(BorderFactory.createLoweredBevelBorder());
        view.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        viewla=new JLabel("---        字体的预览AAaa         ----");
        viewla.setFont(new Font("楷体",Font.BOLD,20));
        view.add(viewla, BorderLayout.CENTER);
        
       
       
        
        
        p1.add(fontpane);
        p1.add(Fontsize);
        p1.add(Fontstyle);
        p1.add(Buttontwo);
        p.add(p1);
        p.add(p2);
     
        con.add(p,BorderLayout.CENTER);
        con.add(view,BorderLayout.SOUTH);
        
        
        
	}
      
        
	
	class jchandler implements ItemListener
	{

		@Override
		public void itemStateChanged(ItemEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==jcb1)
			{
				viewla.setFont(font);
				if(jcb1.isSelected())
			       viewla.setText("<html><u>---        字体的预览AAaa         ----</u></html>");
			    else
				   viewla.setText("---        字体的预览AAaa         ----");
			 }
			else if(e.getSource()==jcb2)
			{
				viewla.setFont(font);
			  if(jcb2.isSelected())
			    viewla.setText("<html><strike>---        字体的预览AAaa         ----</html></strike>");
		   	  else
				viewla.setText("---        字体的预览AAaa         ----");
		    }
			
			
			else if(e.getSource()==jrb1)
			{
				viewla.setFont(font);
			  if(jrb1.isSelected())
			    viewla.setText("---        字体的预览AAAA         ----");
		   	  else
				viewla.setText("---        字体的预览AAaa         ----");
		    }
			else if(e.getSource()==jrb2)
			{
				viewla.setFont(font);
			  if(jrb2.isSelected())
			    viewla.setText("---        字体的预览aaaa         ----");
		   	  else
				viewla.setText("---        字体的预览AAaa         ----");
		    }
				
			}
			   
		}



	@Override
	public void actionPerformed(ActionEvent e)
	{
	
		    s=name[FontC.getSelectedIndex()];
			hm2.put(TextAttribute.FAMILY, s);
			font = new Font(hm2); 
            viewla.setFont(font);
			
		}
	



	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		// TODO Auto-generated method stub
	       if(arg0.getSource()==fontsizelist)
			{
	    	i=Integer.valueOf(sizes[fontsizelist.getSelectedIndex()]);
			hm2.put(TextAttribute.SIZE,i);
			 font = new Font(hm2); 
            viewla.setFont(font);
            fontsizete.setText(String.valueOf(i));
		}
	       else if(arg0.getSource()==fontstylelist)
	      {
				fst=styles[fontstylelist.getSelectedIndex()];
				if(fst.equals("常规"))
					
                 	viewla.setFont(new Font(s,Font.PLAIN,i));	
		    	else if(fst.equals("加粗")	)	
						viewla.setFont(new Font(s,Font.BOLD,i));	
			    else if(fst.equals("斜体"))
						viewla.setFont(new Font(s,Font.ITALIC,i));	
				else if(fst.equals("加粗斜体")	)
						viewla.setFont(new Font(s,Font.BOLD+Font.ITALIC,i));	
					fontstylete.setText(fst);	
						
			}
	}


	 
	}
	  	
	

    
	
	

