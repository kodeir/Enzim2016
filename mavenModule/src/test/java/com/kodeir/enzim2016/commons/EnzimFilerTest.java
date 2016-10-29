package com.kodeir.enzim2016.commons;

import com.kodeir.enzim2016.Enzim;
import org.junit.AfterClass;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

import static org.junit.Assert.*;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public class EnzimFilerTest {

    static String testDirectory01 = "./testDir01";
    static String testDirectory02 = "./testDir02";
    static String testDirectory03 = "./testDir03";

    @AfterClass
    public static void clean() throws Exception{
        Files.deleteIfExists(Paths.get(testDirectory01));
        Files.deleteIfExists(Paths.get(testDirectory02));
        Files.deleteIfExists(Paths.get(testDirectory03));
    }

    @Test
    public void testCreateDir() throws Exception {
        assertTrue(EnzimFiler.createDir(testDirectory01));
    }

    @Test
    public void testDeleteDirRecursively() throws Exception {
        EnzimFiler.createDir(testDirectory02);
        assertTrue(EnzimFiler.deleteDirRecursively(testDirectory02));
    }
}