package com.javarush.task.task20.task2002;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
Читаем и пишем в файл: JavaRush
*/
public class Solution {
    public static void main(String[] args) {
        //you can find your_file_name.tmp in your TMP directory or adjust outputStream/inputStream according to your file's actual location
        //вы можете найти your_file_name.tmp в папке TMP или исправьте outputStream/inputStream в соответствии с путем к вашему реальному файлу
        try {
            File yourFile = File.createTempFile("your_file_name", null);
            OutputStream outputStream = new FileOutputStream("d:/1.txt");
            InputStream inputStream = new FileInputStream("d:/1.txt");
            DateFormat format = new SimpleDateFormat("dd MM yyyy", Locale.ENGLISH);
            Date date = format.parse("02 10 1988");
            JavaRush javaRush = new JavaRush();
            User user = new User();
            user.setFirstName("Vasya");
            user.setLastName("Pupkin");
            user.setBirthDate(date);
            user.setMale(true);
            user.setCountry(User.Country.RUSSIA);

            javaRush.users.add(user);
            //initialize users field for the javaRush object here - инициализируйте поле users для объекта javaRush тут
            javaRush.save(outputStream);
            outputStream.flush();

            JavaRush loadedObject = new JavaRush();
            loadedObject.load(inputStream);
            //here check that the codeGym object is equal to the loadedObject object - проверьте тут, что javaRush и loadedObject равны
            System.out.println(javaRush.equals(loadedObject)?"yes":"no");
            outputStream.close();
            inputStream.close();

        } catch (IOException e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with my file");
        } catch (Exception e) {
            //e.printStackTrace();
            System.out.println("Oops, something is wrong with the save/load method");
        }
    }

    public static class JavaRush {
        public List<User> users = new ArrayList<>();

        public void save(OutputStream outputStream) throws Exception {
            PrintWriter ps = new PrintWriter(outputStream);
            if (!users.isEmpty()) {
                for (User x : users) {
                    if ((x.getFirstName()) != null) {
                        ps.println(x.getFirstName());
                    } else {
                        ps.println("null");
                    }
                    if ((x.getLastName()) != null) {
                        ps.println(x.getLastName());
                    } else {
                        ps.println("null");
                    }
                    if ((x.getBirthDate()) != null) {
                        ps.println(x.getBirthDate());
                    } else {
                        ps.println("null");
                    }
                    if (x.isMale()) {
                        ps.println("true");
                    } else if(!x.isMale()){
                        ps.println("false");
                    }
                    if ((x.getCountry()) != null) {
                        ps.println(x.getCountry());
                    } else {
                        ps.println("null");
                    }
                }
            }

            ps.flush();
        }

        public void load(InputStream inputStream) throws Exception {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            DateFormat format = new SimpleDateFormat("EEE MMM dd HH:mm:ss Z yyyy", Locale.ENGLISH);
            String firstName;
            String lastName;
            Date birthDate;
            boolean isMale;
            String country;
            if(inputStream.available()>0) {
                while (reader.ready()) {
                    User user = new User();
                    firstName = reader.readLine();
                    lastName = reader.readLine();
                    birthDate = format.parse(reader.readLine());
                    isMale = Boolean.parseBoolean(reader.readLine());
                    country = reader.readLine();
                    user.setFirstName(firstName);
                    user.setLastName(lastName);
                    user.setBirthDate(birthDate);
                    if (isMale) {
                        user.setMale(true);
                    } else {
                        user.setMale(false);
                    }
                    switch (country) {
                        case "RUSSIA":
                            user.setCountry(User.Country.RUSSIA);
                            break;
                        case "UKRAINE":
                            user.setCountry(User.Country.UKRAINE);
                            break;
                        case "OTHER":
                            user.setCountry(User.Country.OTHER);
                            break;
                    }
                    users.add(user);
                }
            }
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            JavaRush javaRush = (JavaRush) o;

            return users != null ? users.equals(javaRush.users) : javaRush.users == null;

        }

        @Override
        public int hashCode() {
            return users != null ? users.hashCode() : 0;
        }
    }
}
