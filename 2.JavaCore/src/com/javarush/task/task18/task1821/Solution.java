package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader file = new FileReader(args[0]);
        TreeMap<Character, Integer> map = new TreeMap<>();
        char[] charArr = new char[new FileInputStream(args[0]).available()];
        file.read(charArr);
        for (int i = 0; i < charArr.length; i++) {
            if (i == 0) {
                map.put(charArr[i], 1);
            } else {
                if (map.containsKey(charArr[i])) {
                    for (Map.Entry m : map.entrySet()) {
                        if (m.getKey().equals(charArr[i])) {
                            map.merge(charArr[i], 1, Integer::sum);
                        }
                    }
                } else {
                    map.put(charArr[i], 1);
                }
            }

        }
        file.close();
        for (Map.Entry c : map.entrySet()) {
            System.out.println(c.getKey()+ " " + c.getValue());
        }
    }
}
