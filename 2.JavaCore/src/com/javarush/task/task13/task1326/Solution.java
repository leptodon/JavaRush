package com.javarush.task.task13.task1326;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;

/*
Сортировка четных чисел из файла
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<Integer> array = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(fileName.readLine()), StandardCharsets.UTF_8))){
            String line;
            while ((line = reader.readLine() )!= null){
                array.add(Integer.parseInt(line));
            }
        }
        catch (IOException e){

        }
        for (int j = array.size()-1; j>=0;j--){
            if(array.get(j)%2!=0){
                array.remove(j);
            }
        }
        Collections.sort(array);

        for(int x : array){
            System.out.println(x);
        }

    }
}
