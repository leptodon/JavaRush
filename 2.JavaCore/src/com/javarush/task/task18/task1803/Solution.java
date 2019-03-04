package com.javarush.task.task18.task1803;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

/*
Самые частые байты
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        FileInputStream inputStream = new FileInputStream(input);

        //FileInputStream inputStream = new FileInputStream("d:/1.txt");
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int maxVal = 0;
        while (inputStream.available() > 0) {
            int data = inputStream.read();
                if (map.isEmpty()) {
                    map.put(data, 1);
                } else if (map.containsKey(data)) {
                    for (Map.Entry<Integer, Integer> m : map.entrySet()) {
                        if (m.getKey().equals(data)) {
                            map.put(data, m.getValue()+1);
                        }
                    }
                } else {
                    map.put(data, 1);
                }
        }
        inputStream.close();

        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort(Map.Entry.<Integer, Integer>comparingByValue().reversed());

        System.out.print(list.get(0).getKey());

        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getValue().equals(list.get(0).getValue())) {
                System.out.print(" " + list.get(i).getKey());
            }
        }
    }
}
