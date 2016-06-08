
import java.awt.Container; 
import java.awt.Cursor;

import java.awt.Frame;

import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;

import javax.swing.JLabel;
import javax.swing.JPanel;


public class about extends JDialog{
	
	
	 
	
	JButton bu;
	String zhuji;
	private Point fp; // 拖曳窗体之前的鼠标位置
	 
	  
	 
	

	public about(Frame framee,String title, boolean b)
    {
			super(framee,title,b);
			
			int windowsWedth = 340;
			  int windowsHeight = 500;
			// 得到显示器屏幕的宽高
			  int width = Toolkit.getDefaultToolkit().getScreenSize().width;
			  int height = Toolkit.getDefaultToolkit().getScreenSize().height;
			//设置窗体在显示器居中显示
			  this.setBounds((width - windowsWedth) / 2,
			    (height - windowsHeight) / 2, windowsWedth, windowsHeight);
		
			 
	
		this.setTitle("关于作者");
		Container con=this.getContentPane();
		con.setLayout(null);
		
		
		this.setLocationRelativeTo(null);
		
		BackgroundPanel labe = new BackgroundPanel();// 创建背景面板
        labe.setImage(getToolkit().getImage(
                getClass().getResource("bg2.jpg")));// 设置面板背景图片
		
	    
		
		labe.setBounds(5, 5, 350,200);
		
		BackgroundPanel xiantiao = new BackgroundPanel();// 创建背景面板
        xiantiao.setImage(getToolkit().getImage(
                getClass().getResource("xiantiao.jpg")));// 设置面板背景图片
		xiantiao.setBounds(-5,210, 350,10);
		
		JPanel pane=new JPanel();
        pane.setOpaque(false);
        BackgroundPanel tubiao = new BackgroundPanel();// 创建背景面板
        tubiao.setImage(getToolkit().getImage(
                getClass().getResource("tubiao.jpg")));// 设置面板背景图片
		tubiao.setBounds(5,240,47,51);
		JLabel info=new JLabel("广东工贸职业技术学院 天河区 软件2班 ");
		JLabel info2=new JLabel("版权所有 @ 2014 马兴文  学号1313213");
		JLabel info3=new JLabel("                         版本 2014.1  ");
		
		
		
		InetAddress a;
		try {
			a = InetAddress.getLocalHost();
			zhuji=("  本产品使用权属于:        " + a.getHostName());
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		
		JLabel info4=new JLabel("                         "+zhuji);
	    LinkLabel l=new LinkLabel("进入我的空间","http://user.qzone.qq.com/1042492275");
		 bu=new JButton("确定");
		
	    info.setBounds(65,240,280,50);
	    info2.setBounds(65,270,280,50);
	    info3.setBounds(65,288,280,50);
	    info4.setBounds(2,400,280,50);
	    bu.setBounds(230,470,100,20);
	    l.setBounds(130,350,280,30);
	    con.add(labe);
	    con.add(xiantiao);
	    con.add(tubiao);
	   con.add(info);
	    con.add(info2);
	    con.add(info3);
	    con.add(l);
	    con.add(info4);
	    con.add(bu);
	    this.setSize(340,500);
	    this.setAlwaysOnTop(true);
	     this.setUndecorated(true);
	     this.addMouseListener(new MouseAdapter() {
	            public void mousePressed(final MouseEvent e) {
	                fp = e.getPoint();
	                
	            }
	        });
	     
	        // 面板的鼠标拖曳事件中移动窗体
	        this.addMouseMotionListener(new MouseMotionAdapter() {
	            public void mouseDragged(final MouseEvent e) {
	                JDialog frame = (JDialog) getRootPane().getParent();
	                Point point = e.getLocationOnScreen();
	                frame.setLocation(point.x - fp.x, point.y - fp.y);
	            }
	        });
	        
	        
	       bu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 {     
				 dispose();
			 }
			 });
	    
	    
	    
	   
	}
	
	
	
}
