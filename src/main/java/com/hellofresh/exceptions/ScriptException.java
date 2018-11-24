package com.hellofresh.exceptions;

import org.apache.log4j.Logger;

/**
 * ScriptException.java
 * Handle all script (page objects/test scripts) related exceptions
 *
 * @author Nilanthi
 * @version 1.0-SNAPSHOT
 * @since 21/11/2018
 */
public class ScriptException extends TestAutomationException {

    Logger log = Logger.getLogger(ApplicationException.class);

    public ScriptException(String message) {
        super(message);
        log.error(message);
    }
}
