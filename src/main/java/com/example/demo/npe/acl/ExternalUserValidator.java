package com.example.demo.npe.acl;

import java.util.regex.Pattern;

/**
 * Простой валидатор, в реальности можно применить библиотеки
 */
public class ExternalUserValidator {

    private static final Pattern EMAIL_PATTERN = Pattern.compile("^[A-Za-z0-9+_.-]+@(.+)$");

    public static boolean isValid(ExternalUserDTO user) {
        return isNameValid(user.getName()) &&
                isEmailValid(user.getEmail()) &&
                isAgeValid(user.getAge());
    }

    private static boolean isNameValid(String name) {
        return name != null && !name.trim().isEmpty();
    }

    private static boolean isEmailValid(String email) {
        return email != null && EMAIL_PATTERN.matcher(email).matches();
    }

    private static boolean isAgeValid(int age) {
        return age > 0;
    }
}
