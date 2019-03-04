package com.javarush.task.task15.task1502;

/* 
ООП - Наследование животных
*/

public class Solution {
    //добавьте классы Goose и Dragon тут

    public static void main(String[] args) {
        Goose goo = new Goose();
        System.out.println(goo.getSize());
        System.out.println(new Dragon().toString());
    }

    public static class BigAnimal {
        protected String getSize() {
            return "как динозавр";
        }
    }

    public static class SmallAnimal {
        String getSize() {
            return "как кошка";
        }
    }

    public static class Goose extends SmallAnimal {
        public String getSize(){
            SmallAnimal small = new SmallAnimal();
            String sm = small.getSize();
            return "Гусь маленький, " + sm;
        }
    }

    public static class Dragon extends BigAnimal{
        public String getSize(){
            BigAnimal big = new BigAnimal();
            String bg = big.getSize();
            return "Дракон большой, " + bg;
        }
    }
}

