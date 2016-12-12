package com.android.toma.homework_220s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class StringUtils {

    public static void clearList(List<String> list){
        list.clear();
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
