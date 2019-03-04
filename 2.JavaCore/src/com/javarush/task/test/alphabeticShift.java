package com.javarush.task.test;

public class alphabeticShift {
    public static void main(String[] args) {
        String inputString = "crazy";
        String tmp = "";
        for (int i = 0; i < inputString.length(); i++) {
            if (inputString.charAt(i)=='z') {
                tmp+="a";
            }else{
                tmp+=(char)(inputString.charAt(i)+1);
            }
        }
        System.out.println(tmp);
    }
}
