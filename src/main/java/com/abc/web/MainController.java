package com.abc.web;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.web.bp.BP;
import com.abc.web.bp.BPFactory;
import com.abc.web.bp.UserBP;

@Controller
@RequestMapping("/main")
public class MainController {
	static Logger logger = Logger.getLogger(MainController.class);
	
	@Autowired
	private BPFactory m_bpFactory;

	
	@RequestMapping("/cmd")
    @ResponseBody
    public String cmd(String cmdid, String param,String session) {
		
		
		
		logger.debug("cmdid: "+cmdid+" param: "+param);
		
		
		BP bp=m_bpFactory.createBP(cmdid);
		if(null==bp)
			return "";
	
		
		return bp.exec(cmdid, param);
		
	}

}
