package com.javarush.task.test;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regex_test {
    public static void main(String[] args) {
        String text = "19846   Шорты пляжные синие           159.00  12";
        Pattern pattern = Pattern.compile("\\d*\\s*([А-Яа-я\\s*]+)");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            System.out.println(text.substring(matcher.start(1), matcher.end(1)));
        }
    }

}
