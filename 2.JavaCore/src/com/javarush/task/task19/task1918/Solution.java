/*
package com.javarush.task.task19.task1918;

*/
/*
Знакомство с тегами
*//*


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader fileReader = new BufferedReader(new FileReader("d:/1.txt"))) {
            String str = "";
            while (fileReader.ready()) {
                str += fileReader.readLine();
            }
            String teg = "";
            if(args.length>0){
                teg = args[0];
            } else {
                teg = "span";
            }
            //Pattern pattern = Pattern.compile("<[a-zA-Z][A-Za-z0-9]*");
            String[] s = str.split("span");
            //String[] d = str.split("</span>");
            System.out.println("sad");
        }
    }
}*/
