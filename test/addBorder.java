package com.javarush.task.test;

public class addBorder {
    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        String[] picture = {"aa", "**", "zz"};
        String[] framedPicture = new String[picture.length + 2];

        for(int i = 0 ; i < picture.length ; i++) {
            framedPicture[i+1] = '*' + picture[i] + '*';
        }

        framedPicture[0] = framedPicture[picture.length + 1] = framedPicture[1].replaceAll(".","*");
        for (String x : framedPicture) {
            System.out.println(x);
        }
        System.out.println((System.currentTimeMillis()-a));
    }

}
