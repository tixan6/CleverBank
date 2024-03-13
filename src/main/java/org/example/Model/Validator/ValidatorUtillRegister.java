package org.example.Model.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class ValidatorUtillRegister {
    private static Pattern pattern = null;

    private static final String REGEX_PHONE = "^(\\+375|80)(29|44|25|33)(\\d{3})(\\d{2})\\d{2}$";
    private static final String REGEX_FIO = "\\D{2,80}";
    private static final String REGEX_PASSPORT = "^HB\\d{16}$";
    private static final String REGEX_EMAIL = "^\\D{3,75}\\@\\D{3,18}\\.\\D{1,5}$";
    private static final String REGEX_PASSWORD = "^\\w{3,32}$";
    public static boolean checkFio(String str)
    {
        pattern = Pattern.compile(REGEX_FIO);
        return pattern.matcher(str).matches();
    }
    public static boolean checkAge(int age)
    {
        return age >= 18;
    }
    public static boolean checkPHONE(String phone)
    {
        pattern = Pattern.compile(REGEX_PHONE);
        return pattern.matcher(phone).matches();
    }
    public static boolean checkPassport(String passport)
    {
        pattern = Pattern.compile(REGEX_PASSPORT);
        return pattern.matcher(passport).matches();
    }
    public static boolean checkEmail(String email)
    {
        pattern = Pattern.compile(REGEX_EMAIL);
        return pattern.matcher(email).matches();
    }
    public static boolean checkPassword(String password)
    {
        pattern = Pattern.compile(REGEX_PASSWORD);
        return pattern.matcher(password).matches();
    }

}
