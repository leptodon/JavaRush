package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static java.lang.Thread.interrupted;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Infinity());
        threads.add(new Except());
        threads.add(new Hurrah());
        threads.add(new Mes());
        threads.add(new ReadN());
   }
    public static void main(String[] args) throws InterruptedException {
    }

    private static class Infinity extends Thread{
        @Override
        public void run() {
            while (true) {

            }
        }
    }

    private static class Except extends Thread{

        @Override
        public void run() {
            while (true) {
                try {
                    sleep(1);
                } catch (InterruptedException e) {
                    System.out.println("InterruptedException");
                }
            }
        }
    }


    private static class Hurrah extends Thread{
        @Override
        public void run() {
            while (true) {
                try {
                    System.out.println("Ура");
                    sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class Mes extends Thread implements Message{
        private boolean isCancel = false;

        @Override
        public void showWarning() {
            this.isCancel = true;
        }

        @Override
        public void run() {
            while (!isCancel) {
                try {
                        sleep(1000);
                        System.out.println("Live");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static class ReadN extends Thread{
        private BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        String input = "";


        @Override
        public void run() {
            try {
                while (!(input = reader.readLine()).equals("N")) {
                    count += Integer.parseInt(input);
                }
            } catch (Exception e) {
            }
            System.out.println(count);
        }
    }
}