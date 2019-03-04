package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                if (args[2].equals("м")) {
                    allPeople.add(Person.createMale(args[1], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(args[3])))));
                } else {
                    allPeople.add(Person.createFemale(args[1], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(args[3])))));
                }
                System.out.println((allPeople.size()-1));
                break;
            case "-u":
                if (args[3].equals("м")) {
                    allPeople.set(Integer.parseInt(args[1]), Person.createMale(args[2], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(args[4])))));
                } else {
                    allPeople.set(Integer.parseInt(args[1]), Person.createFemale(args[2], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(args[4])))));
                }
                break;
            case "-d":
                allPeople.get(Integer.parseInt(args[1])).setName(null);
                allPeople.get(Integer.parseInt(args[1])).setSex(null);
                allPeople.get(Integer.parseInt(args[1])).setBirthDate(null);
                System.out.println("qqqq");
                break;
            case "-i":
                System.out.print(allPeople.get(Integer.parseInt(args[1])).getName());
                if (allPeople.get(Integer.parseInt(args[1])).getSex().toString().equals("MALE")) {
                    System.out.print(" м ");
                } else {
                    System.out.print(" ж ");
                }
                System.out.print(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(args[1])).getBirthDate()));
                break;
        }
    }
}
