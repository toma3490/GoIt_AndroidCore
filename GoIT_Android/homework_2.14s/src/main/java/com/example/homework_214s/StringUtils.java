package com.example.homework_214s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class StringUtils {

    private String string1;
    private String string2;
    private String string3;

    private static List<Character> listChar = new ArrayList<>();

    // 2-14
    public static List<Character> toCharList(String string){
        for(char c : string.toCharArray()) {
            listChar.add(c);
        }
        return listChar;
    }

    public int getQuantityOfMatches(char c){
        int counter = 0;
        for (char check : listChar) {
            if (check == c) {
                counter++;
            }
        }
        return counter;
    }

    //2-20 сначала в лист добавить свои строки, потом этот лист на вход методу
    public List<String> deleteEquals(List<String> strings){
        HashSet<String> hashSet = new HashSet<>(strings);
        List<String> uniqueStrings = new ArrayList<>(hashSet);
        return uniqueStrings;
    }

    //2-24
    public String transformToUpper(String s){
        return s.toUpperCase();
    }

}
