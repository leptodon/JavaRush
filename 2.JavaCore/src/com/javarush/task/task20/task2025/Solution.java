package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Collections;

/*
Алгоритмы-числа
*/
public class Solution {

    public static ArrayList<Long> list = new ArrayList<>();
    public static int count = 0;
    public static long fullCount = 0;
    public static long[] getNumbers(long N) {
        long[] result = null;
            if (N > 0) {
                String len = "";
                long length;
                while (len.length() < (N + "").length()) {
                    if ((N + "").length() == 19) {
                        length = 19;
                    } else {
                        len += "9";
                    }
                }
                length = (getPow(Long.parseLong(len)) + "").length();

                int l = 10;
                long[][] pow = new long[(int) length + 1][l];
                pow[0][0] = 0;
                pow[0][1] = 1;
                pow[0][2] = 2;
                pow[0][3] = 3;
                pow[0][4] = 4;
                pow[0][5] = 5;
                pow[0][6] = 6;
                pow[0][7] = 7;
                pow[0][8] = 8;
                pow[0][9] = 9;
                for (int i = 1; i <= length; i++) {
                    for (int j = 0; j < 10; j++) {
                        pow[i][j] = (long) Math.pow(pow[0][j], i);
                    }
                }
                for (long r = 1; r < N; r++) {
                    if (!isNext(r)) {
                        switch (count) {
                            case 2:
                                r += 10;
                                break;
                            case 3:
                                r += 100;
                                break;
                            case 4:
                                r += 1000;
                                break;
                            case 5:
                                r += 10000;
                                break;
                            case 6:
                                r += 100000;
                                break;
                            case 7:
                                r += 1000000;
                                break;
                            case 8:
                                r += 10000000;
                                break;
                            case 9:
                                r += 100000000;
                                break;
                            case 10:
                                r += 1000000000;
                                break;
                            case 11:
                                r += 10000000000L;
                                break;
                            case 12:
                                r += 100000000000L;
                                break;
                            case 13:
                                r += 1000000000000L;
                                break;
                            case 14:
                                r += 10000000000000L;
                                break;
                            case 15:
                                r += 100000000000000L;
                                break;
                            case 16:
                                r += 1000000000000000L;
                                break;
                            case 17:
                                r += 10000000000000000L;
                                break;
                            case 18:
                                r += 100000000000000000L;
                                break;
                            case 19:
                                r += 1000000000000000000L;
                                break;
                        }
                        if (count > 11) {
                            //r += 1000000000000000000L;
                            System.out.println(">10");
                        }
                        count = 0;
                    }else {
                        count=0;
                        long tmp = getPow(r, pow);
                        long newTmp = getPow(tmp, pow);
                        if (tmp == r && !list.contains(tmp)) {
                            list.add(tmp);
                        }
                        if (newTmp == tmp && !isNext(newTmp) && !list.contains(tmp)) {
                            list.add(tmp);
                        }
                    }
                }
                Collections.sort(list);
                list.remove(N);
                result = new long[list.size()];
                for (int k = 0; k < list.size(); k++) {
                    result[k] = list.get(k);
                }
            }else{
                result = new long[1];
                result[0]=0;
                return result;
            }
        return result;
    }

    public static boolean isNext(long number) {
        fullCount++;
        boolean isNext = false;
        count = 0;
        try {
            long num = number; //Входящее число
            long digit;
            long digit2;
            if(((number+"").length()>3)&&(number+"").contains("0")) {
                num = Long.parseLong((number + "").replaceAll("0", ""));
            }
            while (num > 0) {
                count++;
                digit = num % 10;
                digit2 = num / 10;
                if (digit >= digit2 % 10 | digit == 0) {
                    isNext = true;
                } else {
                    isNext = false;
                    break;
                }
                num /= 10;
            }
        } catch (Exception e) {
            System.out.println("Ошибка в isNext");
        }

        return isNext;
    }


    public static long getPow(long number, long[][] pow) {
        long sum = 0;
        try {
            long step = (number + "").length();
            long a = number;

            for (long j = 0; j < step; j++) {
                while (a > 0) {
                    long c = a % 10;
                    sum += pow[(int) step][(int) (a % 10)];
                    a /= 10;
                }
            }

        } catch (Exception e) {
            System.out.println("Ошибка в getPow(num, pow)");
        }
        return sum;
    }

    public static long getPow(long number) {
        long sum = 0;
        try {
            long step = (number + "").length();
            long a = number;

            for (long j = 0; j < step; j++) {
                while (a > 0) {
                    sum += Math.pow(a % 10, step);
                    a /= 10;
                }
            }
        } catch (Exception e) {
            System.out.println("Ошибка в getPow(num)");
        }

        return sum;
    }

    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        for (long x : getNumbers(2147483647)) {
            System.out.println(x);
        }
        long b = System.currentTimeMillis();
        System.out.println(Integer.MAX_VALUE);
        //System.out.println(fullCount);
        System.out.println("memory: " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (1024 * 1024) + " mb");
        System.out.println("Time fo find is = " + (b - a) + "ms");
    }
}
