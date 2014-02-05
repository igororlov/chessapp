package ua.igororlov92.chessapp.api;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.dto.EventDto.CreateEventDto;
import ua.igororlov92.chessapp.model.dto.EventDto.ReadEventDto;
import ua.igororlov92.chessapp.model.dto.FormFieldDto.ReadFormFieldDto;
import ua.igororlov92.chessapp.model.dto.helpers.EventHelper;
import ua.igororlov92.chessapp.repositories.EventRepository;

@Controller
@RequestMapping("/eventsApi")
public class EventsAPIController {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private EventHelper eventHelper;
	
	private static final Logger logger = LoggerFactory.getLogger(EventsAPIController.class);
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody ReadEventDto getOneAsJSON(@PathVariable Long id) {
 
		Event event = eventRepository.findOne(id);
		if (event == null) {
			throw new IllegalArgumentException("Event not found for id " + id);
		}
		
		return eventHelper.toDto(event);
	}
	
	@RequestMapping(value="/{id}/formFields", method = RequestMethod.GET)
	public @ResponseBody List<ReadFormFieldDto> getFormFieldsForOneAsJSON(@PathVariable Long id) {
 
		Event event = eventRepository.findOne(id);
		if (event == null) {
			throw new IllegalArgumentException("Event not found for id " + id);
		}

		return eventHelper.toDto(event).formFields; // TODO refactor
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ReadEventDto addOneAsJSON(@RequestBody CreateEventDto dto) {
 
		logger.debug("Received event: " + dto.name);
 
		ReadEventDto readEventDto = new ReadEventDto();
		readEventDto.name = dto.name;
		
		return readEventDto;
	}
	
	
}
