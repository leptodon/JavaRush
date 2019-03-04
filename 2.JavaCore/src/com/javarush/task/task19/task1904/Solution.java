package com.javarush.task.task19.task1904;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) throws IOException, ParseException {
        PersonScannerAdapter personScannerAdapter = new PersonScannerAdapter(new Scanner(new File("d:/1.txt")));
        Person person = personScannerAdapter.read();
        System.out.println(person);
        personScannerAdapter.close();
    }

    public static class PersonScannerAdapter implements PersonScanner
    {
        private Scanner fileScanner;

        PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner=fileScanner;
        }
        public Person read() throws IOException {
            SimpleDateFormat sdFormat = new SimpleDateFormat("ddMMyyyy");
            Date date = null;

            String lName = fileScanner.next();
            String fName = fileScanner.next();
            String sName = fileScanner.next();
            try
            {
                date = sdFormat.parse(fileScanner.next() + fileScanner.next() + fileScanner.next());
            } catch (ParseException e){}

            return new Person(fName, sName, lName, date);
        }
/*        @Override
        public Person read() throws IOException {
            String sc = fileScanner.nextLine();
            String pat = "([а-яА-Я]+)\\s([а-яА-Я]+)\\s([а-яА-Я]+)\\s([\\d\\s]+)";
            Pattern pattern = Pattern.compile(pat);
            Matcher matcher = pattern.matcher(sc);
            String firstName = "";
            String middleName = "";
            String lastName = "";
            SimpleDateFormat format = new SimpleDateFormat("dd MM yyyy");
            Date birthDate = null;
            while (matcher.find()) {
                firstName = matcher.group(2);
                middleName = matcher.group(3);
                lastName = matcher.group(1);
                try {
                    birthDate = format.parse(matcher.group(4));
                } catch (Exception e) {

                }
            }
            return new Person(firstName, middleName, lastName, birthDate);
        }*/

        @Override
        public void close() throws IOException {
            fileScanner.close();
        }
    }
}
