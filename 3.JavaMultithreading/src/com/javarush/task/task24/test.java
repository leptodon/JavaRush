package com.javarush.task.task24;

import java.math.BigDecimal;
import java.math.BigInteger;

public class test {
  public static void main(String[] args) {
    System.out.println(factorial(8));
  }
  public static int getNum(int value) {
    value = Math.abs(value);
    return value>>2; // put your implementation here

  }

  public static boolean isPalindrome(String text) {
    return text.replaceAll("[^a-zA-Z0-9]", "").equalsIgnoreCase(new StringBuilder().append(text.replaceAll("[^a-zA-Z0-9]", "")).reverse().toString());
  }

  public static BigInteger factorial(int value) {
    BigInteger val = new BigInteger("1");
    for (int i = 2; i <= value; i++) {
      val = val.multiply(BigInteger.valueOf(i));
    }
    return val;
  }
}
