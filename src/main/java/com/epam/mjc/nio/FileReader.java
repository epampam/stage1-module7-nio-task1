package com.epam.mjc.nio;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class FileReader {

    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();

        try {
            Path path = file.toPath();
            BufferedReader reader = Files.newBufferedReader(path);

            profile.setName(reader.readLine().substring(6).trim());
            profile.setAge(Integer.parseInt(reader.readLine().substring(5).trim()));
            profile.setEmail(reader.readLine().substring(7).trim());
            profile.setPhone(Long.parseLong(reader.readLine().substring(7).trim()));

            reader.close();
        } catch (FileNotFoundException e) {
            System.err.println("File not found: " + file.getAbsolutePath());
            return null;
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.err.println("Unexpected error: " + e.getMessage());
            return null;
        }

        return profile;
    }
}