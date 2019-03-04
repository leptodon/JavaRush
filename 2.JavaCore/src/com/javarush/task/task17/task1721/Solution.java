package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String input = reader.readLine();
        String fileName1;
        String fileName2;

        if(!input.isEmpty()){
            fileName1=input;
            String line;
            BufferedReader linesFile1 = new BufferedReader(new FileReader(new File(fileName1)));
            while ((line = linesFile1.readLine())!=null) {
                allLines.add(line);
            }
            fileName2=reader.readLine();
            BufferedReader linesFile2 = new BufferedReader(new FileReader(new File(fileName2)));
            while ((line = linesFile2.readLine())!=null) {
                forRemoveLines.add(line);
            }
            linesFile1.close();
            linesFile2.close();
        }

        try {
            Solution s = new Solution();
            s.joinData();
        } catch (CorruptedDataException e) {

        }
        System.out.println(allLines + " " + forRemoveLines);
    }

    public void joinData() throws CorruptedDataException {
        for (int i =0; i<forRemoveLines.size(); i++) {
            if (allLines.contains(forRemoveLines.get(i))) {
                allLines.remove(forRemoveLines.get(i));
            } else {
                allLines.clear();
                throw new CorruptedDataException();
            }
        }
    }
}
