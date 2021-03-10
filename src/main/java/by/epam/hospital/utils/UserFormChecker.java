package by.epam.hospital.utils;


import java.util.regex.Pattern;

public class UserFormChecker {

    public static boolean userNameCheck(String name) {
        return Pattern.matches("[A-Z][a-z]*|[А-Я][а-я]*", name);
    }

    public static boolean userSurnameCheck(String surname) {
        return Pattern.matches("[A-Z][a-z]*|[А-Я][а-я]*", surname);
    }

    public static boolean userPhoneCheck(String phone) {
        return Pattern.matches("[0-9]{10}", phone);
    }

    public static boolean diagnosisCheck(String diagnosisName) {
        return Pattern.matches("[A-Z][a-z]*|[А-Я][а-я]*", diagnosisName);
    }

}
