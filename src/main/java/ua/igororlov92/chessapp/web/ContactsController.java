package ua.igororlov92.chessapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/contacts")
public class ContactsController {
	
	private static final Logger logger = LoggerFactory.getLogger(ContactsController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getContactsPage() {
		logger.info("Inside contacts page");
		return "contacts"; 
	}
}
