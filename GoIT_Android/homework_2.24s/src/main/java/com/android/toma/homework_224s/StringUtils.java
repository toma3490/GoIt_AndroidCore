package com.android.toma.homework_224s;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class StringUtils {

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
