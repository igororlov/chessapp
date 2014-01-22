package ua.igororlov92.chessapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/users")
public class UsersController {
	
	private static final Logger logger = LoggerFactory.getLogger(UsersController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public String getUsersPage() {
		logger.info("Inside users page");
		return "users"; 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getOneUserPage(@PathVariable("id") Long id) {
		logger.info("Inside one user page: " + id);
		return "oneUser"; // TODO rename  
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteOneUserPage(@PathVariable("id") Long id) {
		logger.info("Inside delete user page " + id);
	}
	
}
