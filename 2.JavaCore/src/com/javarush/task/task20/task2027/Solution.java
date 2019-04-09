package com.javarush.task.task20.task2027;

import java.util.ArrayList;
import java.util.List;

/* 
Кроссворд
*/
public class Solution {
    public static void main(String[] args) {
/*        int[][] crossword = new int[][]{
                {'f', 'd', 'e', 'r', 'l', 'k'},
                {'u', 's', 'a', 'm', 'e', 'o'},
                {'l', 'n', 'g', 'r', 'o', 'v'},
                {'m', 'l', 'p', 'r', 'r', 'h'},
                {'p', 'o', 'e', 'e', 'j', 'j'}
        };

        detectAllWords(crossword, "home", "same");*/
        int[][] crossword = new int[][]{
                {'f', 'e', 'e', 'e', 'l', 'e'},
                {'u', 's', 'n', 'n', 'n', 'o'},
                {'l', 'e', 'n', 'o', 'n', 'e'},
                {'m', 'm', 'n', 'n', 'n', 'h'},
                {'p', 'e', 'e', 'e', 'j', 'e'},
        };
        List<Word> words = (detectAllWords(crossword, "one"));
        for (Word word:words) {
            System.out.println(word);
        }
        /*
Ожидаемый результат
home - (5, 3) - (2, 0)
same - (1, 1) - (4, 1)
         */
    }

    public static List<Word> detectAllWords(int[][] crossword, String... words) {
        ArrayList<Word> list = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            Word a;
            if ((a = getHorizontal(crossword, words[i])) != null) {
                list.add(a);
            } else if((a = getVertical(crossword, words[i])) != null){
                list.add(a);
            }else if((a = getDiag(crossword, words[i])) != null){
                list.add(a);
            } else if ((a = getReverseDiag(crossword, words[i])) != null) {
                list.add(a);
            }
        }
        //System.out.println(list.toString());
       // System.out.println(list.size());
        return list;
    }

    public static class Word {
        private String text;
        private int startX;
        private int startY;
        private int endX;
        private int endY;

        public Word(String text) {
            this.text = text;
        }

        public void setStartPoint(int i, int j) {
            startX = i;
            startY = j;
        }

        public void setEndPoint(int i, int j) {
            endX = i;
            endY = j;
        }

        @Override
        public String toString() {
            return String.format("%s - (%d, %d) - (%d, %d)", text, startX, startY, endX, endY);
        }
    }


    private static Word containStr(String word, StringBuilder str, int indexL) {
        Word word1 = new Word(word);
        if (str.toString().contains(word)) {
            word1.setStartPoint(str.indexOf(word), indexL);
            word1.setEndPoint((str.indexOf(word) + word.length() - 1), indexL);
            return word1;
        } else if (str.reverse().toString().contains(word)) {
            str.delete(0, str.length());
            return word1;
        } else {
            str.delete(0, str.length());
            return null;
        }
    }

    private static Word containStr(String word, StringBuilder str, int indexL, int indexC, boolean reverse) {
        Word word2 = new Word(word);
        if (reverse) {
            int endStrL = indexL + str.length() - 1;
            int endStrC = indexC - str.length() + 1;
            if (str.toString().contains(word)) {
                word2.setStartPoint(indexC - (str.indexOf(word)), indexL + (str.indexOf(word)));
                word2.setEndPoint(endStrC + (str.length() - word.length()) - str.indexOf(word), endStrL - (str.length() - word.length()) + str.indexOf(word));
                return word2;
            } else if (str.reverse().toString().contains(word)) {
                int index = str.indexOf(word);
                word2.setStartPoint(endStrC+index, endStrL-index);
                word2.setEndPoint(indexC -(str.length()-word.length())+index, indexL +(str.length()-word.length())-index);
                return word2;
            }
        }else {
            int endStrL = indexL + str.length() - 1;
            int endStrC = indexC + str.length() - 1;
            if (str.toString().contains(word)) {
                word2.setStartPoint(indexC+str.indexOf(word),indexL+str.indexOf(word));
                word2.setEndPoint(endStrC-(str.length()-word.length())+str.indexOf(word),endStrL-(str.length()-word.length())+str.indexOf(word));
                return word2;
            } else if (str.reverse().toString().contains(word)) {
                word2.setStartPoint(endStrC-str.indexOf(word),endStrL-str.indexOf(word));
                word2.setEndPoint(indexC+(str.length()-word.length())-str.indexOf(word), indexL+(str.length()-word.length())-str.indexOf(word));
                return word2;
            }
            //System.out.println("str = "+str.toString()+" | startSrtL = "+startSrtL+" | startStrC = "+startStrC+" | endStrL= "+endStrL+" | endStrC = "+endStrC);
        }
        return null;
    }

    public static Word getHorizontal(int[][] crossword, String word) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < crossword.length; i++) {
            for (int j = 0; j < crossword[0].length; j++) {
                str.append((char) crossword[i][j]);
            }
            Word a = containStr(word, str, i);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public static Word getVertical(int[][] crossword, String word) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < crossword[0].length; i++) {
            for (int j = 0; j < crossword.length; j++) {
                str.append((char) crossword[j][i]);
            }
            Word a = containStr(word, str, i);
            if (a != null) {
                return a;
            }
        }
        return null;
    }

    public static Word getDiag(int[][] crossword, String word) {
        StringBuilder str = new StringBuilder();
        for (int i = crossword.length - 2; i >= 0; i--) {
            if (i == 0) {
                for (int g = 0; g < crossword[0].length; g++) {
                    for (int j = 0, k = g; (k < crossword[0].length) && (j < crossword.length); k++, j++) {
                        str.append((char) crossword[j][k]);
                    }
                    Word a = containStr(word, str, 0, g, false);
                    if (a != null) {
                        return a;
                    }
                    str.delete(0, str.length());
                }
            } else {
                for (int j = 0, k = i; k < crossword.length; k++, j++) {
                    str.append((char) crossword[k][j]);
                }
                Word a = containStr(word, str, i, 0, false);
                if (a != null) {
                    return a;
                }
                str.delete(0, str.length());

            }
        }
        return null;
    }

    public static Word getReverseDiag(int[][] crossword, String word) {
        StringBuilder str = new StringBuilder();
        for (int i = crossword.length - 2; i >= 0; i--) {
            if (i == 0) {
                for (int g = crossword[0].length - 1; g >= 0; g--) {
                    for (int j = 0, k = g; (k >= 0) && (j < crossword.length); k--, j++) {
                        str.append((char) crossword[j][k]);
                    }
                    Word a;
                    if (g == crossword[0].length - 1) {
                        a = containStr(word, str, i, 5, true);
                    } else {
                        a = containStr(word, str, 0, g, true);
                    }
                    if (a != null) {
                        return a;
                    }
                    str.delete(0, str.length());
                }
            } else {
                for (int j = crossword[0].length - 1, k = i; k < crossword.length; k++, j--) {
                    str.append((char) crossword[k][j]);
                }
                Word a = containStr(word, str, i, 5, true);
                if (a != null) {
                    return a;
                }
                str.delete(0, str.length());
            }
        }
        return null;
    }
}