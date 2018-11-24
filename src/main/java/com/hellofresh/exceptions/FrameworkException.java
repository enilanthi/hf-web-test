package com.hellofresh.exceptions;


import org.apache.log4j.Logger;

/**
 * FrameworkException.java
 * Handle all framework related exceptions
 *
 * @author Nilanthi
 * @version 1.0-SNAPSHOT
 * @since 21/11/2018
 */
public class FrameworkException extends TestAutomationException {

    Logger log = Logger.getLogger(FrameworkException.class);

    public FrameworkException(String message) {
        super(message);
        log.error(message);
    }

}

