package com.hellofresh.exceptions;

import com.hellofresh.util.ScreenCapture;

/**
 * TestAutomationException.java
 * Parent of all custom exceptions defined in framework level
 *
 * @author Nilanthi
 * @since 21/11/2018
 */
public class TestAutomationException extends Exception {

    public TestAutomationException(String message) {
        super(message);

        try {
            ScreenCapture.captureScreenshot();
        } catch (TestAutomationException e) {
            e.printStackTrace();
        }
    }
}
