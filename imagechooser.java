


import java.awt.BorderLayout; 
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;


public class imagechooser extends JDialog {
  

	
   private JTextField tf_fileName;
    private File imgFile = null;
    private BufferedImage src;
    private String path = null;// 图片的路径
    private String fileName = null;// 原图片的文件名
    private DrawImagePanel imagePanel = null; // 声明图像面板对象
    public static String temp="";
  	
			
    
    public imagechooser(Frame frame,String title, boolean b) {
        super(frame,title,b);
       
        this.setSize( 700, 600); // 设置窗体大小和位置
        
        imagePanel = new DrawImagePanel(); // 创建图像面板对象
       
        add(imagePanel); // 在窗体上添加图像面板对象
        this.setLocationRelativeTo(null);
        
         JPanel panel = new JPanel();
         FlowLayout flowLayout = new FlowLayout();
        flowLayout.setAlignment(FlowLayout.CENTER);
        panel.setLayout(flowLayout);
        getContentPane().add(panel, BorderLayout.NORTH);
        
        JLabel label_1 = new JLabel();
        label_1.setText("选择图片：");
        panel.add(label_1);
        
        tf_fileName = new JTextField();
        tf_fileName.setPreferredSize(new Dimension(200, 25));
        panel.add(tf_fileName);
        
       JButton button_2 = new JButton();
        panel.add(button_2);
        button_2.addActionListener(new ActionListener() {
            public void actionPerformed(final ActionEvent e) {
                JFileChooser fileChooser = new JFileChooser();// 创建文件选择器
                FileFilter filter = new FileNameExtensionFilter(
                        "图像文件（JPG/GIF/BMP)", "JPG", "JPEG", "GIF", "BMP");// 创建过滤器
                fileChooser.setFileFilter(filter);// 设置过滤器
                int i = fileChooser.showOpenDialog(null);// 显示打开对话框
                if (i == JFileChooser.APPROVE_OPTION) {
                    imgFile = fileChooser.getSelectedFile(); // 获取选中图片的File对象
                    path = imgFile.getParent();// 获得图片的路径
                    fileName = imgFile.getName();// 获得原图片文件名
                    tf_fileName.setText(path + "\\" + fileName);// 在文本框中显示图片的完整路径
                   
                    
                   temp=path.replace("\\","/")+"/"+fileName;
                   
                 
                }
               
                if (imgFile != null) {
                    try {
                        src = ImageIO.read(imgFile);// 构造BufferedImage对象
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
                imagePanel.repaint();// 调用paint方法
                
            }
        });
        button_2.setText("选择图片");
        
        final JPanel panel_1 = new JPanel();
       
        
        JButton bu=new JButton("确定");
        bu.addActionListener(new ActionListener(){
			 public void actionPerformed(ActionEvent e)
			 {     
				 
		        writebroad.text.setOpaque(false);  
		        writebroad.text.updateUI();  
				 dispose();
				 
			 }
			 });
        panel_1.add(bu);
         getContentPane().add(panel_1, BorderLayout.SOUTH);
      
    }
    
    // 创建面板类
    class DrawImagePanel extends JPanel {
        public void paint(Graphics g) {
            g.drawImage(src, 0, 0, getWidth(), getHeight(), this); // 绘制指定的图片
        }
    }
}
