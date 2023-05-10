package com.abc.springabc;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.springabc.bp.BP;
import com.abc.springabc.bp.BPFactory;
import com.abc.springabc.bp.UserBP;

@Controller
@RequestMapping("/main")
public class MainController {
	static Logger logger = Logger.getLogger(MainController.class);
	
	@RequestMapping("/cmd")
    @ResponseBody
    public String cmd(String cmdid, String param,String session) {
		
		
		
		logger.debug("cmdid: "+cmdid+" param: "+param);
		
		
		BP bp=BPFactory.createBP(cmdid);
		if(null==bp)
			return "";
	
		
		return bp.exec(cmdid, param);
		
	}

}
