package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {
    public static Map<String, String> properties = new HashMap<>();

    public void fillInPropertiesMap() throws Exception {
        String fileName = "";
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        fileName = reader.readLine();
        reader.close();
        FileInputStream fis = new FileInputStream(fileName);
        load(fis);
        fis.close();
    }

    public void save(OutputStream outputStream) throws Exception {
        Properties prop = new Properties();
        if (!properties.isEmpty()) {
            for (Map.Entry x : properties.entrySet()) {
                prop.setProperty(x.getKey().toString(), x.getValue().toString());
            }
        }
        prop.store(outputStream, "");
        outputStream.flush();
    }

    public void load(InputStream inputStream) throws Exception {
        Properties prop = new Properties();
        prop.load(inputStream);
        if (!prop.isEmpty()) {
            for (Map.Entry<Object, Object> x: prop.entrySet()) {
                properties.put(x.getKey().toString(), x.getValue().toString());
            }
        }
        inputStream.close();
    }

    public static void main(String[] args) throws Exception {
        File yourFile = File.createTempFile("myfile", ".properties");
        Solution s = new Solution();
        s.fillInPropertiesMap();
/*        for (Map.Entry x : properties.entrySet()) {
            System.out.println(x.getKey() + " : " + x.getValue());

        }*/
        FileOutputStream fos = new FileOutputStream(yourFile);
        s.save(fos);
    }
}
