package com.epam.mjc.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
public class FileReader {
    public Profile getDataFromFile(File file) {
        Profile profile = new Profile();
        Path path = file.toPath();
        try (var reader = Files.newBufferedReader(path)) {
            for (String line = reader.readLine(); line != null; line = reader.readLine()) {
                var entry = line.split(": ");
                var key = entry[0];
                var value = entry[1];
                switch (key) {
                    case "Name" -> profile.setName(value);
                    case "Age" -> profile.setAge(Integer.valueOf(value));
                    case "Phone" -> profile.setPhone(Long.valueOf(value));
                    case "Email" -> profile.setEmail(value);
                    default -> throw new IllegalStateException("Unknown key: " + key);
                }
            }
            return profile;
        } catch (IOException e) {

            throw new IllegalArgumentException(e);
        }
    }
}