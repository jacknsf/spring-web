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
			else if("1-2".equals(cmdid))
			{
				
				int userid= new ObjectMapper().readValue(Param, int.class);
				CmdResult ret=new CmdResult("1-2",0,getUserById(userid));
				return new ObjectMapper().writeValueAsString(ret);
				
			}
			else if("1-3".equals(cmdid))
			{
				int userid= new ObjectMapper().readValue(Param, int.class);
				deleterUser(userid);
				CmdResult ret=new CmdResult("1-3",0,"OK");
				return new ObjectMapper().writeValueAsString(ret);
				
			}
			else if("1-4".equals(cmdid))
			{
				User user= new ObjectMapper().readValue(Param, User.class);
				addUser(user);
				CmdResult ret=new CmdResult("1-4",0,"OK");
				return new ObjectMapper().writeValueAsString(ret);
						
				
			}
			else if("1-5".equals(cmdid))
			{
				User user= new ObjectMapper().readValue(Param, User.class);
				updateUser(user);
				CmdResult ret=new CmdResult("1-5",0,"OK");
				return new ObjectMapper().writeValueAsString(ret);
						
				
			}
		
		
			return "UserBP";
		}
		catch(Exception ex)
		{
			return "";
		}
	}
	
	public void addUser(User user)
	{
		SqlSession sqlSession = MybatisUntils.getSqlSession();
        
        try
        {
        	UserDao userDao = sqlSession.getMapper(UserDao.class);
        	userDao.addUser(user);
        	sqlSession.commit();
        }
        catch(Exception ex)
        {
        	
        }
        finally {
        	sqlSession.close();
        }
	}
	
	public void updateUser(User user)
	{
		SqlSession sqlSession = MybatisUntils.getSqlSession();
        
        try
        {
        	UserDao userDao = sqlSession.getMapper(UserDao.class);
        	userDao.updateUser(user);
        	sqlSession.commit();
        }
        catch(Exception ex)
        {
        	
        }
        finally {
        	sqlSession.close();
        }
		
	}
	
	public void deleterUser(int id)
	{
		
		
        SqlSession sqlSession = MybatisUntils.getSqlSession();
        
        try
        {
        	UserDao userDao = sqlSession.getMapper(UserDao.class);
        	userDao.deleterUser(id);
        	sqlSession.commit();
        }
        catch(Exception ex)
        {
        	
        }
        finally {
        	sqlSession.close();
        }
        
	}
	
	public User getUserById(int id)
	{
		
		User user=null;
		
        SqlSession sqlSession = MybatisUntils.getSqlSession();
        
        try
        {
        	UserDao userDao = sqlSession.getMapper(UserDao.class);
        	user = userDao.getUserById(id);
        }
        catch(Exception ex)
        {
        	
        }
        finally {
        	sqlSession.close();
        }
        
        return user;
        
		
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
