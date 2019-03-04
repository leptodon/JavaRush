package com.javarush.task.task19.task1922;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) {
        ArrayList<String> list;
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            try (BufferedReader br = new BufferedReader(new FileReader(reader.readLine()))) {
                while (br.ready()) {
                    list = new ArrayList<>();
                    String line = br.readLine();
                    String[] arr = line.split("\\s+");
                    for (int i = 0; i < arr.length; i++) {
                        if (words.contains(arr[i])) {
                            if (list.isEmpty()) {
                                list.add(arr[i]);
                            }else {
                                if (!list.contains(arr[i])) {
                                    list.add(arr[i]);
                                }
                            }
                        }
                    }
                    if (list.size()==2) {
                        System.out.println(line);
                    }
                }
            } catch (Exception e) {
            }
        } catch (Exception e) {
        }


    }
}
