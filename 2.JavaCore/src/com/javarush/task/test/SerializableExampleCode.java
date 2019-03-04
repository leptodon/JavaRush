package com.javarush.task.test;

import java.io.*;

public class SerializableExampleCode {
}

class Person implements Serializable{
private int id;
private String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }


    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return id + " : " + name;
    }
}

class WriteObject{
    public static void main(String[] args) {
        Person person1 = new Person(1, "Bob");
        Person person2 = new Person(2, "Mike");
        try {
            FileOutputStream fos = new FileOutputStream("C:\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\test\\people.bin");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(person1);
            oos.writeObject(person2);
            oos.close();
            fos.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class ReadObject{
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\JavaRushTasks\\2.JavaCore\\src\\com\\javarush\\task\\test\\people.bin");
            ObjectInputStream ois = new ObjectInputStream(fis);
            Person person1 = (Person) ois.readObject();
            Person person2 = (Person) ois.readObject();

            System.out.println(person1);
            System.out.println(person2);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}