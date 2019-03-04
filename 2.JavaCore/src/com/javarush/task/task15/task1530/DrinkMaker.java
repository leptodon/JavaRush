package com.javarush.task.task15.task1530;

public abstract class DrinkMaker {
    public abstract void getRightCup();
    public abstract void putIngredient();
    public abstract void pour();

<<<<<<< HEAD
    void makeDrink(){
        getRightCup();
        putIngredient();
        pour();
=======
    public static void makeDrink(){
        TeaMaker tm = new TeaMaker();
        LatteMaker lm = new LatteMaker();
        tm.pour();
        lm.getRightCup();
        tm.putIngredient();
        tm.getRightCup();
        lm.pour();
        lm.putIngredient();
>>>>>>> 19017de... some new
    }
}
