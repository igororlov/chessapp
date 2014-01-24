package ua.igororlov92.chessapp.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.services.EventService;

@Controller
@RequestMapping("/events")
public class EventsController {
	
	@Autowired
	private EventService eventService;
	
	private static final Logger logger = LoggerFactory.getLogger(EventsController.class);
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEventsPage() {
		
		logger.info("Inside events page");
		ModelAndView modelAndView = new ModelAndView("events");
		
		List<Event> events = eventService.testGetEvents();
		modelAndView.addObject("events", events);
		
		return modelAndView; 
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public String getOneEventPage(@PathVariable("id") Long id) {
		logger.info("Inside one event page, id " + id);
		return "oneEvent"; // TODO rename 
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public String newEventPage() {
		// TODO add protection
		logger.info("Inside new event page");
		return "newEvent"; 
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteOneEventPage(@PathVariable("id") Long id) {
		logger.info("Inside delete one event page, id " + id);
	}
	
	@RequestMapping(value="/{id}/register", method = RequestMethod.GET)
	public String getOneEventRegisterForm() {
		logger.info("Inside register for event page");
		return "registerForEvent"; 
	}
	
	//TODO create 2 POST methods for event creation and registration
	
}
