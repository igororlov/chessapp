package ua.igororlov92.chessapp.services;

import org.apache.log4j.Logger;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.model.UserAccount;
import ua.igororlov92.chessapp.repositories.EventRepository;
import ua.igororlov92.chessapp.repositories.UserAccountRepository;

@Service
public class InitialStartupService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	private static final Logger logger = Logger.getLogger(InitialStartupService.class);
	
	
	public void createInitialDbDataIfNeeded() {
		
		logger.debug("Creating default event.");
		
		if (eventRepository.count() == 0) {
			Event event = new Event();
			event.setName("Test event 1");
			event.setDescription("Some test description 1");
			eventRepository.save(event);
			
			Event event2 = new Event();
			event2.setName("Test event 2");
			event2.setDescription("Some test description 2");
			eventRepository.save(event2);
		}
		
		if (userAccountRepository.count() == 0) {
			UserAccount userAccount1 = new UserAccount();
			userAccount1.setFirstName("Igor");
			userAccount1.setLastName("Orlov");
			userAccount1.setBirthDate(new LocalDate("1992-07-18"));
			userAccountRepository.save(userAccount1);
			
			UserAccount userAccount2 = new UserAccount();
			userAccount2.setFirstName("Olga");
			userAccount2.setLastName("Dolzhykova");
			userAccount2.setBirthDate(new LocalDate("1980-01-22"));
			userAccountRepository.save(userAccount2);
		}
	}
}
