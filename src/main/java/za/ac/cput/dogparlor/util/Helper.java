package za.ac.cput.dogparlor.util;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Helper {

    public static boolean isValidEmail(String value) {
        Pattern pattern = Pattern.compile("^(.+)@(.+)$");
        Matcher matcher = pattern.matcher(value);
        return matcher.matches();
    }

    public static boolean isNullOrEmpty(String value) {
        return (value == null || value.isEmpty());
    }

    public static boolean isNumeric(String value) {
        boolean flag = false;
        try {
            Integer.parseInt(value);
        } catch (NumberFormatException ex) {
            flag = true;
        }
        return flag;
    }

    public static String generateID() {
        return UUID.randomUUID().toString();
    }

    public static String getCustomerID() {
        int year = LocalDateTime.now().getYear();
        int month = LocalDateTime.now().getMonthValue();
        int day = LocalDateTime.now().getDayOfMonth();
        int hour = LocalDateTime.now().getHour();
        int minute = LocalDateTime.now().getMinute();
        int second = LocalDateTime.now().getSecond();
        int nano = LocalDateTime.now().getNano();

        return String.valueOf(year) + month + day + hour + minute + second + nano;
    }

}
