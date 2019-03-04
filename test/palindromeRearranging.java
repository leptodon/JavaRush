package com.javarush.task.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class palindromeRearranging {
    public static void main(String[] args) {
        System.out.println(palindromeRearranging("aabbcedd"));
    }

    static boolean palindromeRearranging(String s) {
        return new HashSet<String>(Arrays.asList(s.split(""))).stream().mapToInt(i->
                (int)Arrays.stream(s.split("")).filter(j->j.equals(i)).count()%2).sum()<=1;}
}
