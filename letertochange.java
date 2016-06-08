//Ó¢ÎÄ×ÖÄ¸µÄ±ä»»

public class letertochange {

	static public String ChangetoUP(String s){
		  char[] c=s.toCharArray();
		  for(int i=0;i<s.length();i++)
		  {
		   if(c[i]>='a'&&c[i]<='z')
			   c[i]=Character.toUpperCase(c[i]);
		   
		   }
		  return String.valueOf(c);
		  }
	static public String ChangetoLO(String s){
			  char[] c=s.toCharArray();
			  for(int i=0;i<s.length();i++)
			  {
			   if(c[i]>='A'&&c[i]<='Z')
				   c[i]=Character.toLowerCase(c[i]);
			   
			   }
			  return String.valueOf(c);
			  }
      




}
