package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new FileReader(args[0]))) {
            String line;
            String pattern = "dd MM yyyy";
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
            while (br.ready()) {
                if(!(line = br.readLine()).isEmpty()) {
                    String name = line.replaceAll("\\s\\d+", "");
                    Date date = simpleDateFormat.parse(line.replaceAll("(\\D+)\\s+", ""));
                    PEOPLE.add(new Person(name, date));
                }else {

                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
