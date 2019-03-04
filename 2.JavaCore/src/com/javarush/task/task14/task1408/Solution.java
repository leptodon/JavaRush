package com.javarush.task.task14.task1408;

/* 
Куриная фабрика
*/

import java.util.HashMap;

public class Solution {
    public static void main(String[] args) {
        Hen hen = HenFactory.getHen(Country.BELARUS);
        hen.getCountOfEggsPerMonth();
/*
        Hen ukrHen = HenFactory.getHen(Country.UKRAINE);
        System.out.println(ukrHen.getDescription());
        Hen rusHen = HenFactory.getHen(Country.RUSSIA);
        System.out.println(rusHen.getDescription());
        Hen molHen = HenFactory.getHen(Country.MOLDOVA);
        System.out.println(molHen.getDescription());
        System.out.println(hen.getDescription());*/
    }

    static class HenFactory {

        static Hen getHen(String country){
            Hen hen = null;
            switch (country){
                case Country.BELARUS:
                    hen = new BelarusianHen();
                    break;
                case Country.MOLDOVA:
                    hen = new MoldovanHen();
                    break;
                case Country.RUSSIA:
                    hen = new RussianHen();
                    break;
                case Country.UKRAINE:
                    hen = new UkrainianHen();
                    break;
            }
            return hen;
        }
    }


}
abstract class Hen{
    public abstract int getCountOfEggsPerMonth();
    public String getDescription(){
        return "Я - курица.";
    }
}