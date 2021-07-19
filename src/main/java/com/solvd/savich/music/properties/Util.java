package com.solvd.savich.music.properties;

import java.io.*;
import java.util.Properties;

public class Util {
    public static final String PATH_TO_PROPERTIES = "src/main/resources/application.properties";

    public static String getPropertiesValue(String key) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)) {
            properties.load(fileInputStream);
            return properties.getProperty(key, "default");
        } catch (IOException e) {
            System.out.println("Error in the program: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        }
        return "default";
    }

    public static void setPropertiesValue(String key, String value) {
        Properties properties = new Properties();
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(PATH_TO_PROPERTIES);
            properties.load(fileInputStream);
            fileOutputStream = new FileOutputStream(PATH_TO_PROPERTIES);
            properties.setProperty(key, value);
            properties.store(fileOutputStream, null);
        } catch (IOException e) {
            System.out.println("Error in the program: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fileOutputStream != null) {
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void setPropertiesValueWithResources(String key, String value) {
        Properties properties = new Properties();
        try (FileInputStream fileInputStream = new FileInputStream(PATH_TO_PROPERTIES)){
            properties.load(fileInputStream);
            try (FileOutputStream fileOutputStream = new FileOutputStream(PATH_TO_PROPERTIES)){
                properties.setProperty(key, value);
                properties.store(fileOutputStream, null);
            }
        } catch (IOException e){
            System.out.println("Error in the program: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        }
    }

    public static void printAll(){
        Properties properties = new Properties();
        try(FileInputStream inputStream = new FileInputStream(PATH_TO_PROPERTIES)){
            properties.load(inputStream);
            properties.forEach((key,value) -> System.out.println("Key : " + key + ", Value : " + value));

           /* for (Object key: properties.keySet()) {
                System.out.println(key +": "+ properties.getProperty(key.toString()));
            }*/

        }  catch (IOException e) {
            System.out.println("Error in the program: file " + PATH_TO_PROPERTIES + " not found");
            e.printStackTrace();
        }
    }
}

