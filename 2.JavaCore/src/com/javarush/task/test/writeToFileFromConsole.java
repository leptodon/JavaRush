package com.javarush.task.test;

import java.io.*;

public class writeToFileFromConsole {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileOutputStream fileOutputStream = new FileOutputStream("D:/1.txt");
        String txt = reader.readLine();
/*        while (!txt.equals("stop")) {

            fileOutputStream.write(txt.getBytes());
        }*/
        if (!txt.isEmpty()) {
            fileOutputStream.write(txt.getBytes());
        }else {
            System.out.println("Close input?");
            if(txt.equals("Y")){
                fileOutputStream.close();
            }
        }
    }
}
