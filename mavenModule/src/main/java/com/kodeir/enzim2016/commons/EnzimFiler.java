package com.kodeir.enzim2016.commons;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by Sergei Riabinin on 29.10.2016.
 */
public class EnzimFiler {

    private static final Logger logger = Logger.getLogger(EnzimFiler.class.getName());

    public static boolean checkExists(String path) {
        return Files.exists(Paths.get(path));
    }

    public static boolean createDir(String path){
        try {
            Files.createDirectory(Paths.get(path));
            return true;
        } catch (IOException e){
            logger.log(Level.SEVERE, "Directory " + path + " was not created", e);
            return false;
        }
    }

    public static boolean deleteDirRecursively(String dir){
        Path path = Paths.get(dir);
        try {
            Files.walkFileTree(path, new SimpleFileVisitor<Path>(){
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attributes) throws IOException{
                    Files.delete(file);
                    return  FileVisitResult.CONTINUE;
                }
                @Override
                public FileVisitResult postVisitDirectory (Path dir, IOException e) throws IOException{
                    Files.delete(dir);
                    return  FileVisitResult.CONTINUE;
                }
            });
            return true;
        } catch (IOException e) {
            logger.log(Level.SEVERE, "Directory " + dir + " was not deleted", e);
            return false;
        }
    }
}
