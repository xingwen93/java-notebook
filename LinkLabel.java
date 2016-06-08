

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

import javax.swing.JLabel;

public class LinkLabel extends JLabel {

	/** 超链接显示的文字 */
	private String text;
	/** 保存连接 */
	private URL link = null;
	/** 保存标签的默认颜色 */
	private Color preColor = null;

	/** * 构造一个超链接 *  vText 显示的文字 *  vLink 连接地址 */
	public LinkLabel(String vText, String vLink) {
		super("<html>" + vText + "</html>");
		this.text = vText;
		LinkLabel.this.setFont(new Font("楷体",Font.BOLD,15));
		LinkLabel.this.setForeground(Color.red);
		try {
			if (!vLink.startsWith("http://"))
				vLink = "http://" + vLink;
			this.link = new URL(vLink);
		} catch (MalformedURLException err) {
			err.printStackTrace();
		}
		this.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent e) {
				LinkLabel.this.setCursor(Cursor
						.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
				if (preColor != null)
					LinkLabel.this.setForeground(preColor);
				LinkLabel.this.setText("<html>" + text + "</html>");
					
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				LinkLabel.this.setCursor(Cursor
						.getPredefinedCursor(Cursor.HAND_CURSOR));
				preColor = LinkLabel.this.getForeground();
				LinkLabel.this.setForeground(Color.BLUE);
				LinkLabel.this.setText("<html><u>" + text + "</u></html>");
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					Desktop.getDesktop().browse(link.toURI());
				} catch (IOException err) {
					err.printStackTrace();
				} catch (URISyntaxException err) {
					err.printStackTrace();
				}
			}
		});
	}
}