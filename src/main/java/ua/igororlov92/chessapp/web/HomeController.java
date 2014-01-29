package ua.igororlov92.chessapp.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.services.EmailService;
import ua.igororlov92.chessapp.services.EventService;

@Controller
@RequestMapping("/home")
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	private EmailService emailService;
	
	@Autowired
	private EventService eventService;
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView homePage() {
		
		ModelAndView modelAndView = new ModelAndView("home/home");
		
		Event upcomingEvent = eventService.getUpcomingEvent();
		
		if (upcomingEvent != null) {
			modelAndView.addObject("upcomingJsp", "banner_upcoming.jsp");
			modelAndView.addObject("upcomingEvent", upcomingEvent);
		} else {
			logger.debug("No upcoming events.");
			modelAndView.addObject("upcomingJsp", "banner_noEvents.jsp");
		}
		
		return modelAndView;
	}
}
