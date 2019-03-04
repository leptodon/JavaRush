package com.javarush.task.task16.task1630;

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static String firstFileName;
    public static String secondFileName;
    static BufferedReader fileName = new BufferedReader(new InputStreamReader(System.in));
    static {
        try {
            firstFileName = fileName.readLine();
            secondFileName = fileName.readLine();
            fileName.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) throws InterruptedException {
        systemOutPrintln(firstFileName);
        systemOutPrintln(secondFileName);
    }

    public static void systemOutPrintln(String fileName) throws InterruptedException {
        ReadFileInterface f = new ReadFileThread();
        f.setFileName(fileName);
        f.start();
        f.join();
        //add your code here - добавьте код тут
        System.out.println(f.getFileContent());
    }

    public interface ReadFileInterface {

        void setFileName(String fullFileName);

        String getFileContent();

        void join() throws InterruptedException;

        void start();
    }

    public static class ReadFileThread extends Thread implements ReadFileInterface
    {

        private String fileName;
        private String fileContent = "";
        @Override
        public void setFileName(String fullFileName) {
           this.fileName = fullFileName;
        }

        @Override
        public String getFileContent() {
            return fileContent;
        }

        @Override
        public void run() {
            try {
                BufferedReader input = new BufferedReader(new FileReader(fileName));
                    String getCont;
                ArrayList<String> list = new ArrayList<>();
                        while ((getCont = input.readLine()) != null) {
                            list.add(getCont);
                        }
                fileContent = String.join(" ", list);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
