package com.javarush.task.test;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class FromPartToFile {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        TreeMap<Integer, byte[]> treeMap = new TreeMap<>();
        String directory = ""; // директория где хранятся файлы
        String fileNameWithoutPart = ""; // полное названия файлов без части

        while (true) {
            String fileName = reader.readLine();
            if (fileName.equals("end")) break;
            BufferedInputStream fis = new BufferedInputStream(new FileInputStream(fileName));
            String[] file = fileName.split("\\."); // разбиваем название файла на составные части по точке
            int partNumber = Integer.parseInt(file[file.length - 1].replaceAll("[a-zA-Z =]+", "")); // берем последнее значение массива (где partNumber) и заменяем все, кроме цифр, на пустые значения, тем самым получая номер части

            // находим путь и название файла без partN
            directory = fileName.substring(0, fileName.lastIndexOf("\\"));
            fileNameWithoutPart = fileName.substring(fileName.lastIndexOf("/") + 1);
            fileNameWithoutPart = fileNameWithoutPart.substring(0, fileNameWithoutPart.lastIndexOf("."));

            // считываем побайтово в буфер файл, потом заносив в мэпу номер части вместе с буфером
            while (fis.available() > 0) {
                byte[] buffer = new byte[fis.available()];
                int count = fis.read(buffer);
                treeMap.put(partNumber, buffer);
            }
            fis.close();
        }
        reader.close();
        // /Users/di/Desktop/lion.avi.part3

        File file = new File(directory, fileNameWithoutPart);
        //BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fileNameWithoutPart)));
        // создаем поток для записи и записываем последовательно массивы байт в файл
        BufferedOutputStream fos = new BufferedOutputStream(new FileOutputStream(file));
        for (Map.Entry<Integer, byte[]> i : treeMap.entrySet()) {
            fos.write(i.getValue());
        }
        fos.close();

    }
}