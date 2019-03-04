package com.javarush.task.task16.task1626;

public class Solution {
    public static int number = 5;

    public static void main(String[] args) throws InterruptedException {
        new Thread(new CountdownRunnable(), "Уменьшаем").start();
        new Thread(new CountUpRunnable(), "Увеличиваем").start();

    }

    public static class CountUpRunnable implements Runnable{
        private int countIndexUP = 1;
        long t1 = System.currentTimeMillis();
        @Override
        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexUP += 1;
                    if (countIndexUP > number) {
                        Thread.sleep(500);
                        return;
                    }
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
            System.out.println("Final = " + (System.currentTimeMillis()-t1));
        }
        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexUP;
        }

        //Add your code here - добавь код тут
    }


    public static class CountdownRunnable implements Runnable {
        private int countIndexDown = Solution.number;

        public void run() {
            try {
                while (true) {
                    System.out.println(toString());
                    countIndexDown -= 1;
                    if (countIndexDown == 0) return;
                    Thread.sleep(500);
                }
            } catch (InterruptedException e) {
            }
        }

        public String toString() {
            return Thread.currentThread().getName() + ": " + countIndexDown;
        }
    }
}
