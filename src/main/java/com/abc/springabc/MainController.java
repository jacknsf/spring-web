package com.abc.springabc;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;

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
		
		String urlDecode="";
		try {
			urlDecode = URLDecoder.decode( param, "UTF-8" );
		} catch (UnsupportedEncodingException e) {
			
			e.printStackTrace();
		}
		
	
		
		return bp.exec(cmdid, urlDecode);
		
	}

}
