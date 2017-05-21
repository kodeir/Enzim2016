package com.kodeir.enzim2016.commons;

import java.io.File;
import java.io.IOException;
import java.util.logging.*;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public class EnzimLogger extends Logger {

    public EnzimLogger(String name) {
        this(name, 1000000, (byte)10, "."+ File.separator+"logs"+File.separator);
    }

    public EnzimLogger(String name, int fileSize, byte filesCount, String path){
        this(name, fileSize, filesCount, path, Level.INFO, Level.INFO);
    }

    public EnzimLogger(String name, int fileSize, byte filesCount, String path, Level fileLevel, Level consoleLevel){
        super(name, null);
        if (checkPath(path)){
            setLogger(name, fileSize, filesCount, path, fileLevel, consoleLevel);
        } else {
            System.out.println("Error creating logger as " + name + " at " + path);
        }
    }

    private boolean checkPath(String path) {
        if (!EnzimFiler.checkExists(path)){
            return EnzimFiler.createDir(path);
        } else {
            return true;
        }
    }

    private void setLogger(String name, int fileSize, byte filesCount, String path, Level fileLevel, Level consoleLevel) {
        try {
            //file handler
            FileHandler fileHandler = new FileHandler(path + name + ".%g" + ".log", fileSize, filesCount, true);
            fileHandler.setFormatter(new SimpleFormatter());
            fileHandler.setLevel(fileLevel);

            //console handler
            ConsoleHandler consoleHandler = new ConsoleHandler();
            consoleHandler.setLevel(fileLevel);

            this.addHandler(fileHandler);
            this.addHandler(consoleHandler);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void closeHandlers(){
        for (Handler h: this.getHandlers()){
            h.close();
        }
    }


}
