package com.javarush.task.task19.task1916;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try (BufferedReader file1input = new BufferedReader(new FileReader(reader.readLine()));
                 BufferedReader file2input = new BufferedReader(new FileReader(reader.readLine()))) {
                while (file1input.ready()) {
                    list1.add(file1input.readLine());
                }
                while (file2input.ready()) {
                    list2.add(file2input.readLine());
                }
                while (list1.size() > 0 | list2.size() > 0) {
                    if (list2.size() == 0) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                        list1.remove(0);
                    } else if (list1.size() == 0) {
                        lines.add(new LineItem(Type.ADDED, list2.get(0)));
                        list2.remove(0);
                    } else if (list1.get(0).equals(list2.get(0))) {
                        lines.add(new LineItem(Type.SAME, list1.get(0)));
                        list1.remove(0);
                        list2.remove(0);
                    } else {
                        if (list2.get(0).equals(list1.get(1))) {
                            lines.add(new LineItem(Type.REMOVED, list1.get(0)));
                            list1.remove(0);
                        } else {
                            lines.add(new LineItem(Type.ADDED, list2.get(0)));
                            list2.remove(0);
                        }
                    }
                }
/*                for (LineItem x : lines) {
                    System.out.println(x.type.toString()+" "+x.line);
                }*/
            } catch (Exception e) {
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}
