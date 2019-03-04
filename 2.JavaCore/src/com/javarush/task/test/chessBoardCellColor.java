package com.javarush.task.test;

public class chessBoardCellColor {
    public static void main(String[] args) {
        String cell1 = "B1";
        String cell2 = "B2";
        boolean ce1 = false;
        boolean ce2 = false;
            if((cell1.charAt(0)+cell1.charAt(1))%2==1){
                ce1 = false;
            }else {
                ce1 = true;
            }
            if((cell2.charAt(0)+cell2.charAt(1))%2==1){
                ce2 = false;
            }else {
                ce2 = true;
            }
            if((ce1 && ce2) || (!ce1 && !ce2)){
                System.out.println("TRUE");
            }else {
                System.out.println("FALSE");
            }
            System.out.println(ce1 + " " + ce2);

    }
}
