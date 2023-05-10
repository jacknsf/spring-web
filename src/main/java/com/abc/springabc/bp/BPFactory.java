package com.abc.springabc.bp;

public class BPFactory {
	public static BP createBP(String cmdid)
	{
		
		if(null==cmdid || cmdid.isEmpty())
			return null;
		
		String[] arCmd=cmdid.split("-");
		if(arCmd==null || arCmd.length<2)
			return null;
		
		
		if("1".equals(arCmd[0]))
			return new UserBP();
		
		return null;
	}

}
