package com.javarush.task.test;

public class isLucky {
    public static void main(String[] args) {
        int n = 1230;

        int left = 0;
        int right = 0;

        for (int i = 0; i < (n+"").length(); i++) {
            if (i < (((n+"").length())/2)) {
                left+= Integer.parseInt((n+"").charAt(i)+"");
            } else {
                right+= Integer.parseInt((n+"").charAt(i)+"");
            }
        }

        System.out.println(left==right);
    }
}
