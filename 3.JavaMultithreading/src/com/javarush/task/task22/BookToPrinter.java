package com.javarush.task.task22;

import java.util.LinkedHashMap;
import java.util.Map;

public class BookToPrinter {
    public static void main(String[] args) {
        Map<Integer, Integer> front = new LinkedHashMap<>();
        Map<Integer, Integer> back = new LinkedHashMap<>();

        int totalPage = 638;
        int startPage = 281;
        int total = (totalPage-startPage)/4;
        while (startPage <= totalPage) {
            front.put(startPage + 3, startPage);
            startPage++;
            back.put(startPage + 1, startPage);
            startPage+=3;
        }

        for (Map.Entry f : front.entrySet()) {
            System.out.printf("%d,%d,", (int)f.getKey(), (int)f.getValue());
        }
        System.out.println();
        for (Map.Entry b : back.entrySet()) {
            System.out.printf("%d,%d,",(int)b.getValue(),(int)b.getKey());
        }
        System.out.println();
        System.out.println("Total list A4 = "+ total);
        System.out.println("Finish");
    }
}
