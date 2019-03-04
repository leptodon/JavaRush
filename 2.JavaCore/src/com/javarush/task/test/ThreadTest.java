package com.javarush.task.test;

import java.util.ArrayList;

public class ThreadTest {
    public static ArrayList<Long> list = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        long N = 100000000L;
        long a = System.currentTimeMillis();

        for (long r = 0; r < N; r += N / 100) {
            if((N-r)==(N/100)){
                NewThread nt = new NewThread(r, N / 100);
                nt.start();
                nt.join();
                System.out.println(Thread.activeCount());
            }else {
                new NewThread(r, N / 100).start();
                System.out.println(Thread.activeCount());
            }
        }
        long b = System.currentTimeMillis();

        System.out.println((b-a)+"ms");
        System.out.println(Thread.activeCount());
        System.out.println(list.size());

    }


    public static class NewThread extends Thread {
        private long num;
        private long step;

        NewThread(long num, long step) {
            this.num = num;
            this.step = step;
        }

        @Override
        public void run() {
            if (num == 0) {
                for (long i = num; i < step; i++) {
                    if (isNext(i)) {
                        list.add(i);
                    }
                }
            } else {
                for (long i = num; i < num+step; i++) {
                    if (isNext(i)) {
                        list.add(i);
                    }
                }
            }
        }

        public static boolean isNext(long number) {
            boolean isNext = false;
            try {
                long num = number;
                long digit;
                long digit2;
                while (num > 0) {
                    digit = num % 10;
                    digit2 = num / 10;
                    if (digit >= digit2 % 10) {
                        isNext = true;
                    } else {
                        isNext = false;
                        break;
                    }
                    num /= 10;
                }
            } catch (Exception e) {
                System.out.println("Ошибка в isNext");
            }
            return isNext;
        }
    }
}
