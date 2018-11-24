package com.hellofresh.exceptions;


import org.apache.log4j.Logger;

/**
 * ApplicationException.java
 * Handle all application related exceptions
 *
 * @author Nilanthi
 * @version 1.0-SNAPSHOT
 * @since 21/11/2018
 */
public class ApplicationException extends TestAutomationException {

    Logger log = Logger.getLogger(ApplicationException.class);

    public ApplicationException(String message) {
        super(message);
        log.error(message);
    }

}

