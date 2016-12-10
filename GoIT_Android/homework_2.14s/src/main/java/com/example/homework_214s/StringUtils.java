package com.example.homework_214s;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class StringUtils {

    private static List<Character> listChar = new ArrayList<>();

    public static void clearList(){
        listChar.clear();
    }

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

    public String generateRandomString(int size) {
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
