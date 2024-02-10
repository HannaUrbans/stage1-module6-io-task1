package com.epam.mjc.io;

import java.io.BufferedReader;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;


public class FileReader {
    private String name;
    private int age;
    private String email;
    private long phone;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public long getPhone() {
        return phone;
    }

    private static final Logger logger = Logger.getLogger( FileReader.class.getName());



    public void Profile(String name, int age, String email, long phone) {
        this.name = name;
        this.age = age;
        this.email = email;
        this.phone = phone;
    }

    public static Profile getDataFromFile(File file) {
        String fileData = readFileData(file);
        Map<String, String> dataMap = parseData(fileData);

        String name = dataMap.get("Name");
        int age = Integer.parseInt(dataMap.get("Age"));
        String email = dataMap.get("Email");
        long phone = Long.parseLong(dataMap.get("Phone"));

        return new Profile(name, age, email, phone);
    }

    private static String readFileData(File file) {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new java.io.FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                sb.append(line).append("\n");
            }
        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            logger.severe("Stack trace:");
            for (StackTraceElement element : e.getStackTrace()) {
                logger.severe(element.toString());
            }}
        return sb.toString();
    }

    private static Map<String, String> parseData(String fileData) {
        Map<String, String> dataMap = new HashMap<>();
        String[] lines = fileData.split("\n");
        for (String line : lines) {
            String[] parts = line.split(": ");
            if (parts.length == 2) {
                dataMap.put(parts[0], parts[1]);
            }
        }
        return dataMap;
    }

    public void main(String[] args) {
        try {
            File file = new File("src/main/resources/Profile.txt");
            Profile profile = getDataFromFile(file);
            logger.info("Name: " + this.getName());
            logger.info("Age: " + this.getAge());
            logger.info("Email: " + this.getEmail());
            logger.info("Phone: " + this.getPhone());
           // System.out.println("Name: " + profile.getName());
           // System.out.println("Age: " + profile.getAge());
           // System.out.println("Email: " + profile.getEmail());
            //System.out.println("Phone: " + profile.getPhone());

        } catch (Exception e) {
            logger.severe("An error occurred: " + e.getMessage());
            logger.severe("Stack trace:");
            for (StackTraceElement element : e.getStackTrace()) {
                logger.severe(element.toString());
            }
        }
    }
}

//Warning:(44, 53) Call to 'printStackTrace()' should probably be replaced with more robust logging
// рекомендуется использовать библиотеку логирования, такую как java.util.logging для записи информации в журнал.
// Логгеры предоставляют более гибкий и настраиваемый способ управления журналированием в Java приложениях.

