package com.kodeir.enzim2016.commons;

import org.junit.*;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.logging.Level;

import static org.junit.Assert.assertTrue;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public class EnzimLoggerTest {

    private static String testLogDirectory = "."+ File.separator+"testDir";
    private String testLogName = "testName";
    private String lofFileEnding = ".0.log";

    @Before
    public void create() throws Exception{
        EnzimFiler.createDir(testLogDirectory);
    }

    @After
    public void clean() throws Exception{
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