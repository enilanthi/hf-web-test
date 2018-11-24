package com.hellofresh.exceptions;

import com.hellofresh.util.ScreenCapture;
import org.apache.log4j.Logger;

/**
 * TestAutomationException.java
 * Parent of all custom exceptions defined in framework level
 *
 * @author Nilanthi
 * @version 1.0-SNAPSHOT
 * @since 21/11/2018
 */
public class TestAutomationException extends Exception{

    public TestAutomationException(String message) {
        super(message);

        try {
            ScreenCapture.captureScreenshot();
        } catch (TestAutomationException e) {
            e.printStackTrace();
        }
    }
}
