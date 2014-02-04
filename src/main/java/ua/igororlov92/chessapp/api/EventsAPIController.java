package ua.igororlov92.chessapp.api;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import ua.igororlov92.chessapp.model.dto.EventDto.CreateEventDto;
import ua.igororlov92.chessapp.model.dto.EventDto.ReadEventDto;

@Controller
@RequestMapping("/eventsApi")
public class EventsAPIController {
	
	private static final Logger logger = LoggerFactory.getLogger(EventsAPIController.class);
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public @ResponseBody ReadEventDto getOneAsJSON(@PathVariable Long id) {
 
		ReadEventDto readEventDto = new ReadEventDto();
		
		readEventDto.name = "Test name";
		readEventDto.description = "Test description";
 
		return readEventDto;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody ReadEventDto addOneAsJSON(@RequestBody CreateEventDto dto) {
 
		logger.debug("Received event: " + dto.name);
 
		ReadEventDto readEventDto = new ReadEventDto();
		readEventDto.name = dto.name;
		
		return readEventDto;
	}
}
