package ua.igororlov92.chessapp.util;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import ua.igororlov92.chessapp.services.InitialStartupService;


/**
 * Run once at startup.
 */
public class StartupJob {

	@Autowired
	private InitialStartupService initialStartupService;

	private static final Logger logger = Logger.getLogger(StartupJob.class);

	public void execute() {

		logger.info("Running startup jobs.");

		initialStartupService.createInitialDbDataIfNeeded();
		
	}
	
}
