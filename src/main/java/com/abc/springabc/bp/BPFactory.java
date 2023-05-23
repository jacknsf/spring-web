package com.abc.springabc.bp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service
public class BPFactory {
	public  BP createBP(String cmdid)
	{
		
		if(null==cmdid || cmdid.isEmpty())
			return null;
		
		String[] arCmd=cmdid.split("-");
		if(arCmd==null || arCmd.length<2)
			return null;
		
		
		if("1".equals(arCmd[0]))
			return new UserBP();
		else if("0".equals(arCmd[0]))
			return sysbp;
		
	
		
		return null;
	}
	
	
	@Autowired
	private SysBP sysbp;
	


}
