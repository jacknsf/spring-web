package com.abc.springabc;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.abc.springabc.bp.BP;
import com.abc.springabc.bp.BPFactory;
import com.abc.springabc.bp.UserBP;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/cmd")
    @ResponseBody
    public String cmd(String cmdid, String param,String session) {
		
		
		
		
		
		BP bp=BPFactory.createBP(cmdid);
		if(null==bp)
			return "";
		
	
		
		return bp.exec(cmdid, param);
		
	}

}
