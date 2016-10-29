package com.kodeir.enzim2016.commons;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public class EnzimLoggerTest {

    private static String testLogDirectory = "./testDir";
    private String testLogName = "testName";
    private String lofFileEnding = ".0.log";

    @BeforeClass
    public static void create() throws Exception{
        EnzimFiler.createDir(testLogDirectory);
    }

    @AfterClass
    public static void clean() throws Exception{
        EnzimFiler.deleteDirRecursively(testLogDirectory);
    }

    @Test
    public void testConstructorName() throws Exception {
        EnzimLogger logger = new EnzimLogger(testLogName);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + lofFileEnding)));
    }

    @Test
    public void testFullConstructor() throws Exception {
        EnzimLogger logger = new EnzimLogger(testLogName, 1000, (byte)2, testLogDirectory, Level.INFO, Level.FINE);
        logger.closeHandlers();
        assertTrue(Files.exists(Paths.get(testLogDirectory + testLogName + lofFileEnding)));
    }

}