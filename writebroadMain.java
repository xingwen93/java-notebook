
import java.awt.event.ActionEvent;    
import java.awt.event.ActionListener;
import java.awt.print.PrinterJob;



import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class writebroadMain implements ActionListener{

	 
	 
	
	public static void main(String args[]) throws InterruptedException 
	{ 
		
		writebroad my=new writebroad();
	    my.setVisible(true);
	    my.setLocationRelativeTo(null);
	    my.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	   
	    }
	   
	   
	static void  setLookAndFeel(String skin){
	    	try {
	    	UIManager.setLookAndFeel(skin);
	    	} catch (ClassNotFoundException e) {
	    	e.printStackTrace();
	    	} catch (InstantiationException e) {
	    	e.printStackTrace();
	    	} catch (IllegalAccessException e) {
	    	e.printStackTrace();
	    	} catch (UnsupportedLookAndFeelException e) {
	    	e.printStackTrace();
	    	}
	    	}

	

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==writebroad.print)
		{   PrinterJob job = PrinterJob.getPrinterJob(); // 获得打印对象
	        if (!job.printDialog()) { // 打开打印对话框
	            return; // 单击打印对话框的取消按钮或关闭打印对话框结束程序的执行
	        }
	        job.setJobName("打印对话框"); // 设置打印任务的名称
	        String jobName = job.getJobName(); // 获得 打印任务的名称
	        JOptionPane.showMessageDialog(null,"打印任务的名称是：  " + jobName);
	}
		
	
	
	}
}
