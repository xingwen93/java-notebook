

import java.util.Calendar;

public class timeinfor {

	Calendar cal=Calendar.getInstance();
	  
	
	int month=cal.get(Calendar.MONTH);
	int day=cal.get(Calendar.DAY_OF_MONTH);
	int hour=cal.get(Calendar.HOUR);
	int min=cal.get(Calendar.MINUTE);
   
	
  
    String temptime=("主人 现在是: "+month+"月"+day+"日"+"  "+hour+"时"+min+"分");
    String temptime2=(month+"月"+day+"日  "+hour+"时"+min+"秒");
   
}
