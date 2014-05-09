package ua.igororlov92.chessapp.services;

import java.util.List;

import org.joda.time.DateTime;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.repositories.EventRepository;

@Service
public class EventService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@SuppressWarnings("unused")
	private static final Logger logger = LoggerFactory.getLogger(EventService.class);
	
	public List<Event> getAllFutureEvents() {
		
		List<Event> events = eventRepository.findByStartTimeAfterOrderByStartTimeAsc(new DateTime());
		return events;
	}
	
	
	
	public List<Event> getAllPastEvents() {
		
		List<Event> events = eventRepository.findByStartTimeBeforeOrderByStartTimeDesc(new DateTime());
		return events;
	}
	
	public Event getUpcomingEvent() {
		
		List<Event> futureEvents = eventRepository.findByStartTimeAfterOrderByStartTimeAsc(new DateTime());
		if (futureEvents.isEmpty()) {
			return null;
		}
		return futureEvents.get(0);
	}
}
