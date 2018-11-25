package com.hellofresh.exceptions;

import org.apache.log4j.Logger;

/**
 * UnhandledException.java
 * Handles all Unknown exceptions, that are not captured by other exception categories
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class UnhandledException extends TestAutomationException {

    Logger log = Logger.getLogger(ApplicationException.class);

    public UnhandledException(String message) {
        super(message);
        log.error(message);
    }

}
