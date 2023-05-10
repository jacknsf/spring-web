package com.abc.springabc.bp;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.abc.springabc.dao.UserDao;
import com.abc.springabc.entity.User;
import com.abc.springabc.tools.MybatisUntils;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.abc.springabc.CmdResult;

public class UserBP extends BP {
	
	@Override
	public String exec(String cmdid,String Param)
	{
		try
		{
			if("1-1".equals(cmdid))
			{
				CmdResult ret=new CmdResult("1-1",0,getUserList());
				return new ObjectMapper().writeValueAsString(ret);
			
			}
		
		
		
			return "UserBP";
		}
		catch(Exception ex)
		{
			return "";
		}
	}
	
	public List<User> getUserList()
	{
		
		List<User> userList=null;
		
        SqlSession sqlSession = MybatisUntils.getSqlSession();
        
        try
        {
      
        UserDao userDao = sqlSession.getMapper(UserDao.class);
        userList = userDao.getUserList();

    
        }
        catch(Exception ex)
        {
        	
        }
        finally {
      
        sqlSession.close();
        }
        
        return userList;
	}

}
