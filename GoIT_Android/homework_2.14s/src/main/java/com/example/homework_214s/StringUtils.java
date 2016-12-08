package com.example.homework_214s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

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
        return new ArrayList<>(hashSet);
    }

    //2-24
    public String transformToUpper(String s){
        return s.toUpperCase();
    }

    public String generateRandomPassword(int size) {
        char[] chars = "abcdefghijklmnopqrstuvwxyz".toCharArray();
        StringBuilder sb = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            char c = chars[random.nextInt(chars.length)];
            sb.append(c);
        }
        return sb.toString();
    }
}
