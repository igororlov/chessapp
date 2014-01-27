package ua.igororlov92.chessapp.services;

import java.util.HashSet;
import java.util.Set;

import org.apache.log4j.Logger;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.igororlov92.chessapp.model.Event;
import ua.igororlov92.chessapp.model.FormField;
import ua.igororlov92.chessapp.model.FormField.FormFieldType;
import ua.igororlov92.chessapp.model.FormFieldAlternative;
import ua.igororlov92.chessapp.model.UserAccount;
import ua.igororlov92.chessapp.repositories.EventRepository;
import ua.igororlov92.chessapp.repositories.FormFieldAlternativeRepository;
import ua.igororlov92.chessapp.repositories.FormFieldRepository;
import ua.igororlov92.chessapp.repositories.UserAccountRepository;

@Service
public class InitialStartupService {
	
	@Autowired
	private EventRepository eventRepository;
	
	@Autowired
	private UserAccountRepository userAccountRepository;
	
	@Autowired
	private FormFieldRepository formFieldRepository;
	
	@Autowired
	private FormFieldAlternativeRepository formFieldAlternativeRepository;
	
	private static final Logger logger = Logger.getLogger(InitialStartupService.class);
	
	public void createInitialDbDataIfNeeded() {
		
		if (userAccountRepository.count() == 0) {
			
			logger.info("Adding initial values...");
			
			createSystemAdministrator();
			createDefaultFormFields();
			createTestEvent();
		}
	}
	
	private void createSystemAdministrator() {
		
		UserAccount userAccount = new UserAccount();
		userAccount.setFirstName("Igor");
		userAccount.setLastName("Orlov");
		userAccount.setBirthDate(new LocalDate("1992-07-18"));
		userAccount.setEmail("igororlov92@gmail.com");
		userAccount.setEncryptedPassword(UserAccountService.encryptPassword("qwerty"));
		userAccountRepository.save(userAccount);
	}
	
	private void createDefaultFormFields() {
		
		// First name
		FormField firstNameField = new FormField();
		firstNameField.setFormFieldType(FormFieldType.string);
		firstNameField.setName("First name");
		firstNameField.setRequired(true);
		formFieldRepository.save(firstNameField);
		
		// Last name
		FormField lastNameField = new FormField();
		lastNameField.setFormFieldType(FormFieldType.string);
		lastNameField.setName("Last name");
		lastNameField.setRequired(true);
		formFieldRepository.save(lastNameField);
		
		// Birthday
		FormField birthDateField = new FormField();
		birthDateField.setFormFieldType(FormFieldType.date);
		birthDateField.setName("Birth date");
		birthDateField.setRequired(true);
		formFieldRepository.save(birthDateField);
		
		// Parent's name
		FormField parentNameField = new FormField();
		parentNameField.setFormFieldType(FormFieldType.string);
		parentNameField.setName("Parent's name");
		parentNameField.setRequired(false);
		formFieldRepository.save(parentNameField);
		
		// Email
		FormField emailField = new FormField();
		emailField.setFormFieldType(FormFieldType.string);
		emailField.setName("Email");
		emailField.setRequired(true);
		formFieldRepository.save(emailField);
		
		// Address
		FormField addressField = new FormField();
		addressField.setFormFieldType(FormFieldType.string);
		addressField.setName("Address");
		addressField.setRequired(true);
		formFieldRepository.save(addressField);
		
		// Mobile number
		FormField mobileNumberField = new FormField();
		mobileNumberField.setFormFieldType(FormFieldType.string);
		mobileNumberField.setName("Mobile number");
		mobileNumberField.setRequired(true);
		formFieldRepository.save(mobileNumberField);
		
		// Sex
		FormField sexField = new FormField();
		sexField.setFormFieldType(FormFieldType.stringAlternative);
		sexField.setName("Sex");
		sexField.setRequired(false);
		formFieldRepository.save(sexField);
		
		FormFieldAlternative sexManAlternative = new FormFieldAlternative();
		sexManAlternative.setFormField(sexField);
		sexManAlternative.setName("Man");
		formFieldAlternativeRepository.save(sexManAlternative);
		
		FormFieldAlternative sexWomanAlternative = new FormFieldAlternative();
		sexWomanAlternative.setFormField(sexField);
		sexWomanAlternative.setName("Woman");
		formFieldAlternativeRepository.save(sexWomanAlternative);
		
	}
	
	private void createTestEvent() {
		
		UserAccount administrator = userAccountRepository.findByEmail("igororlov92@gmail.com");
		
		Event event = new Event();
		event.setCreatedByUserAccount(administrator);
		event.setCreatedTime(new DateTime());
		event.setDeadlineTime(new DateTime(2014, 2, 15, 12, 0));
		event.setDescription("Test event to make sure events are saved correctly. In future will be removed.");
		event.setStartTime(new DateTime(2014, 2, 17, 12, 0));
		event.setEndTime(new DateTime(2014, 2, 17, 14, 0));
		event.setName("Test event");
		event.setPlace("Oslo, Nedre Ullevål 7, H503");
		event.setWithGroups(false);
		
		Set<FormField> formFields = new HashSet<FormField>();
		formFields.add(formFieldRepository.findByName("First name"));
		formFields.add(formFieldRepository.findByName("Last name"));
		formFields.add(formFieldRepository.findByName("Email"));
		event.setFormFields(formFields);
		
		eventRepository.save(event);
	}
	
}
