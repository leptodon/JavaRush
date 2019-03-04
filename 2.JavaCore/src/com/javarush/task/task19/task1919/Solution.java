package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Float> map = new TreeMap<String, Float>();
        try (BufferedReader fr = new BufferedReader(new FileReader(args[0]))) {
            String[] arr;
            while (fr.ready()) {
                arr = fr.readLine().split("\\s", 2);
                if (!map.containsKey(arr[0])) {
                    map.put(arr[0], Float.parseFloat(arr[1]));
                } else if(map.containsKey(arr[0])){
                    Float tmp = map.get(arr[0]);
                    map.replace(arr[0], tmp, tmp+Float.parseFloat(arr[1]));
                }
            }
        } catch (Exception e) {
        }
        for (Map.Entry x : map.entrySet()) {
            System.out.println(x.getKey() + " " + x.getValue());
        }
    }
}
