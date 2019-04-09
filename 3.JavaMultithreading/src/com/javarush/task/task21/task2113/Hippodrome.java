package com.javarush.task.task21.task2113;

import java.util.ArrayList;
import java.util.List;

public class Hippodrome {
    private List<Horse> horses;

    static Hippodrome game;
    public static void main(String[] args) throws InterruptedException {
        ArrayList<Horse> list = new ArrayList<>();
        list.add(new Horse("Black", 3.0, 0.0));
        list.add(new Horse("Red", 3.0, 0.0));
        list.add(new Horse("White", 3.0, 0.0));
        game = new Hippodrome(list);
        game.run();
        game.printWinner();
    }

    public List<Horse> getHorses() {
        return horses;
    }

    public Hippodrome(List list) {
        horses = list;
    }

    public void run() throws InterruptedException {
        for (int i = 1; i <= 100; i++) {
            move();
            print();
            Thread.sleep(200);
        }
    }
    public void move(){
        for (Horse x : horses) {
            x.move();
        }
    }
    public void print(){
        for (Horse x : horses) {
            x.print();
        }
        for (int i = 0; i < 10; i++) {
            System.out.println();
        }
    }
    public Horse getWinner(){
        double dist = 0.0;
        for (Horse x : horses) {
            if (dist==0.0) {
               dist = x.getDistance();
            } else if(x.getDistance()>dist){
                dist = x.getDistance();
            }
        }
        for (Horse i : horses) {
            if (i.getDistance() == dist) {
                return i;
            }
        }
        return null;
    }
    public void printWinner(){
        System.out.println("Winner is "+getWinner().getName()+"!");
    }
}
