package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException, InterruptedException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fName = "";
        while (!(fName = reader.readLine()).equals("exit")) {

            ReadThread rt = new ReadThread(fName);
            rt.start();
            rt.join();
        }
        reader.close();
        for (Map.Entry f : resultMap.entrySet()) {
            System.out.println(f.getKey() + " " + f.getValue());
        }
    }

    public static class ReadThread extends Thread {
        String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            HashMap<Integer, Integer> map = new HashMap<>();
            int tmp = 0;
            try {
                FileInputStream inputStream = new FileInputStream(fileName);
                while (inputStream.available() > 0) {
                    byte[] buffer = new byte[inputStream.available()];
                    inputStream.read(buffer);
                    for (byte x : buffer) {
                        if (!map.containsKey((int) x)) {
                            map.put((int) x, 1);
                        } else {
                            map.merge((int) x, 1, Integer::sum);
                        }
                    }
                }
                inputStream.close();
            } catch (IOException e) {
            }
            //System.out.println(fileName);
            for (Map.Entry d : map.entrySet()) {
                if ((int) d.getValue() > tmp) {
                    tmp = (int) d.getValue();
                }
                //System.out.println(d.getKey() + " " + d.getValue());
            }
            for (Map.Entry c : map.entrySet()) {
                if ((int) c.getValue() == tmp) {
                    resultMap.put(fileName, (int) c.getKey());
                }
            }
        }
    }
}
