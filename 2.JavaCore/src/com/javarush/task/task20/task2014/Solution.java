package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        System.out.println(new Solution(4));
        FileOutputStream fos = new FileOutputStream("d:/1.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        Solution saveData = new Solution(5);
        oos.writeObject(saveData);
        fos.close();
        oos.close();
        FileInputStream fis = new FileInputStream("d:/1.txt");
        ObjectInputStream ois = new ObjectInputStream(fis);
        Solution object = (Solution)ois.readObject();
        fis.close();
        ois.close();
        System.out.println(object.temperature);
    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;

    public Solution(int temperature) {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
