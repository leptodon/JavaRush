package com.javarush.task.task16.task1603;

import java.util.ArrayList;
import java.util.List;

/* 
Список и нити
*/

public class Solution {
    public static volatile List<Thread> list = new ArrayList<Thread>(5);

    public static void main(String[] args) {

        SpecialThread sp1 = new SpecialThread();
        Thread th1 = new Thread(sp1);
        SpecialThread sp2 = new SpecialThread();
        Thread th2 = new Thread(sp2);
        SpecialThread sp3 = new SpecialThread();
        Thread th3 = new Thread(sp3);
        SpecialThread sp4 = new SpecialThread();
        Thread th4 = new Thread(sp4);
        SpecialThread sp5 = new SpecialThread();
        Thread th5 = new Thread(sp5);

        list.add(th1);
        list.add(th2);
        list.add(th3);
        list.add(th4);
        list.add(th5);
    }

    public static class SpecialThread implements Runnable {
        public void run() {
            System.out.println("it's a run method inside SpecialThread");
        }
    }
}
