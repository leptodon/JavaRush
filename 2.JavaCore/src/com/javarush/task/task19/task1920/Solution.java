package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

public class Solution {
    public static void main(String[] args) {
        TreeMap<String, Float> map = new TreeMap<String, Float>();
        TreeSet<Float> allPerson = new TreeSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(args[0]))) {
            String[] arr;
            while (reader.ready()) {
                arr = reader.readLine().split("\\s", 2);
                if (!map.containsKey(arr[0])) {
                    map.put(arr[0], Float.parseFloat(arr[1]));
                    allPerson.add(Float.parseFloat(arr[1]));
                } else if(map.containsKey(arr[0])){
                    Float tmp = map.get(arr[0]);
                    map.replace(arr[0], tmp, tmp+Float.parseFloat(arr[1]));
                    allPerson.add(tmp+Float.parseFloat(arr[1]));
                }
            }
        } catch (Exception e) {
        }
        for (Map.Entry x : map.entrySet()) {
            if(x.getValue().equals(allPerson.last())){
                System.out.println(x.getKey());
            }
        }
    }
}
