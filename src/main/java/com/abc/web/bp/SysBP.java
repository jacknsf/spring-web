package com.abc.web.bp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.abc.web.CmdResult;
import com.abc.web.SysConfig;
import com.abc.web.entity.User;
import com.fasterxml.jackson.databind.ObjectMapper;

@Service
public class SysBP extends BP {
	
	@Autowired
	private SysConfig m_sys_cfg;

		
	@Override
	public String exec(String cmdid,String Param)
	{
		try
		{
			
			if("0-1".equals(cmdid))
			{
				CmdResult ret=new CmdResult("0-1",0,"java home: "+m_sys_cfg.m_java_home);
				return new ObjectMapper().writeValueAsString(ret);
			
			}
			else if("0-2".equals(cmdid))
			{
				
	
				CmdResult ret=new CmdResult("0-2",0,"system path: "+m_sys_cfg.m_sys_path);
				return new ObjectMapper().writeValueAsString(ret);
				
			}
			else if("0-3".equals(cmdid))
			{
				
	
				CmdResult ret=new CmdResult("0-2",0,"user dir: "+m_sys_cfg.m_user_dir);
				return new ObjectMapper().writeValueAsString(ret);
				
			}

		
		
			return "SysBP";
		}
		catch(Exception ex)
		{
			return "";
		}
	}
	

}
