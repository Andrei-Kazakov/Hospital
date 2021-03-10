package by.epam.hospital.utils;

import java.util.ResourceBundle;

public class PagesManager {

    private final static ResourceBundle resourceBundle = ResourceBundle.getBundle("pages-config");

    private PagesManager() {

    }

    public static String getProperty(String key) {
        return resourceBundle.getString(key);
    }

}