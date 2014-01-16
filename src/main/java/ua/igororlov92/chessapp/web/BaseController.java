package ua.igororlov92.chessapp.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/")
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String mainPage() {
		logger.info("Inside main page");
		return "index"; 
	}

	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcome() {
		logger.info("Inside welcome");
		return "welcome"; 
	}
}