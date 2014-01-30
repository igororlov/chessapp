package ua.igororlov92.chessapp.web;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.repositories.EventRepository;
import ua.igororlov92.chessapp.services.EventService;

@Controller
@RequestMapping("/events")
public class EventsController {
	
	private final static String eventsViewsFolder = "events/";
	
	@Autowired
	private EventService eventService;
	
	@Autowired
	private EventRepository eventRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(EventsController.class);
	
	//TODO create 2 POST methods for event creation and registration
	
	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView getEventsPage(
			@RequestParam(value = "period", required = false) String period) {
		
		ModelAndView modelAndView = new ModelAndView(eventsViewsFolder + "events");
		List<Event> events = null;
		
		if (period != null && period.equals("past")) {
			events = eventService.getAllPastEvents();
		} else {
			events = eventService.getAllFutureEvents();
		}
		
		modelAndView.addObject("events", events);
		
		return modelAndView; 
	}

	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getOneEventPage(@PathVariable("id") Long id) {
		
		ModelAndView modelAndView = new ModelAndView(eventsViewsFolder + "oneEvent");
		
		Event event = eventRepository.findOne(id);
		modelAndView.addObject("event", event);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/new", method = RequestMethod.GET)
	public ModelAndView newEventPage() {

		ModelAndView modelAndView = new ModelAndView(eventsViewsFolder + "newEvent");
		
		return modelAndView; 
	}
	
	@RequestMapping(value="/{id}/register", method = RequestMethod.GET)
	public ModelAndView getOneEventRegisterForm(@PathVariable("id") Long id) {

		ModelAndView modelAndView = new ModelAndView(eventsViewsFolder + "registerForEvent");
		
		Event event = eventRepository.findOne(id);
		modelAndView.addObject("event", event);
		
		return modelAndView;
	}
	
	@RequestMapping(value="/{id}", method = RequestMethod.DELETE)
	public void deleteOneEventPage(@PathVariable("id") Long id) {
		logger.debug("Inside delete one event page, id " + id);
	}
	
	
	
}
