package com.mobiquity.rentaldvdstore.helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegistrationValidator {

    private static Pattern pattern;
    private static Matcher matcher;

    private static final String PASSWORD_PATTERN =
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";

    private static final String EMAIL_PATTERN =
            "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    private static final String MOBILENO_PATTERN =
            "^([+]\\d{2})?\\d{10}$";

    public static Boolean validatePasswordPattern(String password) {
        pattern = Pattern.compile(PASSWORD_PATTERN);
        matcher = pattern.matcher(password);
        return matcher.matches();
    }

    public static Boolean validateEmailPattern(String email) {
        pattern = Pattern.compile(EMAIL_PATTERN);
        matcher = pattern.matcher(email);
        System.out.println("Email validation passed");
        return matcher.matches();
    }

    public static Boolean validateMobileNoPattern(String mobile_no) {
        pattern = Pattern.compile(MOBILENO_PATTERN);
        matcher = pattern.matcher(mobile_no);
        return matcher.matches();
    }
}
