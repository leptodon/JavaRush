package com.javarush.task.test;

public class evenDigitsOnly {
    public static void main(String[] args) {
        int n = 642386;
        String a = n+"";
        boolean b = true;
        for (int i = a.length()-1; i >= 0; i--) {
            if (Integer.parseInt((n+"").charAt(i)+"") % 2 != 0) {
                b = false;
                break;
            }
        }
        System.out.println(b);
    }
}
