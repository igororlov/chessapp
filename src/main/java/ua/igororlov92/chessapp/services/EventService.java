package ua.igororlov92.chessapp.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.repositories.EventRepository;

@Service
public class EventService {
	
	@Value("#{chessappConfig['test.configValue']}")
	private String testValue;
	
	@Autowired
	private EventRepository eventRepository;
	
	private static final Logger logger = LoggerFactory.getLogger(EventService.class);
	
	public List<Event> testGetEvents() {
		
		logger.debug("Inside Event Service");
		logger.debug("Test: " + testValue);
		
		List<Event> events = new ArrayList<Event>();
		for (Event event : eventRepository.findAll()) {
			events.add(event);
		}
		return events;
	}
}
