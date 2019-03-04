package com.javarush.task.task14.task1419;

import java.io.File;
import java.io.FileInputStream;
import java.lang.instrument.IllegalClassFormatException;
import java.rmi.NotBoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.zip.DataFormatException;

/* 
Нашествие исключений
*/

public class Solution {
    public static List<Exception> exceptions = new ArrayList<Exception>();

    public static void main(String[] args) {
        initExceptions();

        for (Exception exception : exceptions) {
            System.out.println(exception);
        }
    }

    public static int getAreaValue(int x, int y) {
        if (x < 0 || y < 0) throw new IllegalArgumentException();

        return x*y;
    }
    private static void initExceptions() {   //it's first exception
        try {
            float i = 1 / 0;

        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
           int[] arr = new int[5];
           arr[5]=10;
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int[] arr = new int[5];
            arr[3]= 'a';
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
            int[] arr = new int[-2];
        } catch (Exception e) {
            exceptions.add(e);
        }
        try {
           byte b = Byte.parseByte("123456");
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            ArrayList<Integer> AL = new ArrayList<Integer>(10);
            AL.add(11, 10);
        }catch (Exception e) {
            exceptions.add(e);
        }


        try {
            Scanner file=new Scanner(new File("C:\\1\\text.txt"));
            while(!file.next().equals("equaller")){
                file.next();
            }
        } catch (Exception e) {
            exceptions.add(e);
        }

        try {
            int result = getAreaValue(-1, 100);
        } catch (Exception e) {
            exceptions.add(e);
        }
        exceptions.add(new NotBoundException());
        exceptions.add(new DataFormatException());
        exceptions.add(new IllegalClassFormatException());
        //напишите тут ваш код

    }
}
