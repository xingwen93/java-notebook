//ÏµÍ³×ÖÌå

import java.awt.GraphicsEnvironment;

public class Fontnames {

	String font[];
   
	public String[]  getFont()
	{
		GraphicsEnvironment get=GraphicsEnvironment.getLocalGraphicsEnvironment();
	    font=get.getAvailableFontFamilyNames();
		return font;
		
	}
	
}
