package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i<args.length; i++){
                        create(args,i);
                    }
                }
                break;
            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        update(args,i);
                    }
                }
                break;
            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        delete(args);
                    }
                }
                break;
            case "-i":
                synchronized (allPeople) {
                    info(args);
                }
                break;
        }
    }

    private static synchronized void create(String[] arr, int i) throws ParseException {
        if (i==1) {
            if(arr[i+1].equals("м")){
                allPeople.add(Person.createMale(arr[i], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+2])))));
                System.out.println((allPeople.size() - 1));
            } else {
                allPeople.add(Person.createFemale(arr[i], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+2])))));
                System.out.println((allPeople.size() - 1));
            }
        } else if (i % 3 == 0 && i!=arr.length-1) {
            if (arr[i + 2].equals("м")) {
                allPeople.add(Person.createMale(arr[i+1], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+3])))));
                System.out.println((allPeople.size() - 1));
            } else {
                allPeople.add(Person.createFemale(arr[i+1], new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+3])))));
                System.out.println((allPeople.size() - 1));
            }
        }

    }

    private static synchronized void update(String[] arr, int i) throws ParseException {
        if (i == 1) {
            if (arr[i + 2].equals("м")) {
                allPeople.get(Integer.parseInt(arr[i])).setName(arr[i + 1]);
                allPeople.get(Integer.parseInt(arr[i])).setSex(Sex.MALE);
                allPeople.get(Integer.parseInt(arr[i])).setBirthDate(new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+3]))));
            } else {
                allPeople.get(Integer.parseInt(arr[i])).setName(arr[i + 1]);
                allPeople.get(Integer.parseInt(arr[i])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(arr[i])).setBirthDate(new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i+3]))));
            }
        } else if(i%4==0 && i!=arr.length-1) {
            if (arr[i + 3].equals("м")) {
                allPeople.get(Integer.parseInt(arr[i + 1])).setName(arr[i + 2]);
                allPeople.get(Integer.parseInt(arr[i + 1])).setSex(Sex.MALE);
                allPeople.get(Integer.parseInt(arr[i + 1])).setBirthDate(new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i + 4]))));
            } else {
                allPeople.get(Integer.parseInt(arr[i + 1])).setName(arr[i + 2]);
                allPeople.get(Integer.parseInt(arr[i + 1])).setSex(Sex.FEMALE);
                allPeople.get(Integer.parseInt(arr[i + 1])).setBirthDate(new Date(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(new SimpleDateFormat("dd/MM/yyyy").parse(arr[i + 4]))));
            }
        }
    }

    private static synchronized void delete(String[] arr){
        for (int i = 1; i < arr.length; i++) {
            allPeople.get(Integer.parseInt(arr[i])).setName(null);
            allPeople.get(Integer.parseInt(arr[i])).setSex(null);
            allPeople.get(Integer.parseInt(arr[i])).setBirthDate(null);
        }
    }

    private static synchronized void info(String[] arr){
        for (int i = 1; i < arr.length; i++) {
            System.out.print(allPeople.get(Integer.parseInt(arr[i])).getName());
            if (allPeople.get(Integer.parseInt(arr[i])).getSex().toString().equals("MALE")) {
                System.out.print(" м ");
            } else {
                System.out.print(" ж ");
            }
            System.out.print(new SimpleDateFormat("dd-MMM-yyy", Locale.ENGLISH).format(allPeople.get(Integer.parseInt(arr[i])).getBirthDate()));
            System.out.println();
        }
    }
}
