package com.hellofresh.util;

import com.hellofresh.exceptions.ScriptException;
import com.hellofresh.exceptions.TestAutomationException;
import com.hellofresh.exceptions.UnhandledException;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.net.URL;

/**
 * Facilitate reading test data from json file
 *
 * @author Nilanthi
 * @since 23/11/2018
 */
public class TestDataReader {

    /**
     * Reads test data from the specified json file
     *
     * @param fileName json file to be read
     * @return JSONObject
     * @throws TestAutomationException
     */
    public static JSONObject readTestData(String fileName) throws TestAutomationException {
        JSONParser parser = new JSONParser();
        URL testdataURL = TestDataReader.class.getClassLoader().getResource("testdata/" + fileName);
        JSONObject obj;
        try {
            obj = (JSONObject) parser.parse(new FileReader(testdataURL.getPath()));
            return obj;
        } catch (IOException e) {
            throw new ScriptException(e.getMessage());
        } catch (ParseException e) {
            throw new ScriptException(e.getMessage());
        } catch (Exception e) {
            throw new UnhandledException(e.getMessage());
        }
    }

}
