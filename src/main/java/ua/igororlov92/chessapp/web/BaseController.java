package ua.igororlov92.chessapp.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.repositories.EventRepository;

@Controller
@RequestMapping("/base")
public class BaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(BaseController.class);
	
	// TODO why doesn't go inside this method???
	@RequestMapping(method = RequestMethod.GET)
	public String mainPage() {
		logger.info("Inside main page");
		return "redirect:/welcome"; 
	}

	@RequestMapping(value="/welcome", method = RequestMethod.GET)
	public String welcomePage() {
		
		logger.info("Inside welcome");
		
		return "welcome"; 
	}
}