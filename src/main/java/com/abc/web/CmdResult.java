package com.abc.web;

public class CmdResult {
	public CmdResult(String cid,int ecode,Object obj)
	{
		cmdid=cid;
		errCode=ecode;
		objResult=obj;
	}
	public String cmdid;
	public String session;
	public int errCode;
	public Object objResult;

}
