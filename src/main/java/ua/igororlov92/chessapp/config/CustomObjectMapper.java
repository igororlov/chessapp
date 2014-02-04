/**
 * 
 */
package ua.igororlov92.chessapp.config;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.hibernate4.Hibernate4Module;
import com.fasterxml.jackson.datatype.joda.JodaModule;

/**
 * Taken from tibet.
 */
@Component("customObjectMapper")
public class CustomObjectMapper extends ObjectMapper {
    
    private static final long serialVersionUID = 1L;
    
    private static final Logger logger = LoggerFactory.getLogger(CustomObjectMapper.class);

    @PostConstruct
    public void setup() {
            logger.debug("Configuring custom Jackson object mapper.");
            
            registerModule(new JodaModule());
            registerModule(new Hibernate4Module());
            
            configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);

            // Return LocalDate as ISO date string (eg. "2013-01-20").
            configure(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS, false);

            configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
    }

}
