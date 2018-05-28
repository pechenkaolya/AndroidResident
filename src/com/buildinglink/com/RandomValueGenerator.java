package com.buildinglink.com;
import java.util.Random;

public class RandomValueGenerator {
    public static String generateRandomValue(int len, String dic) {
        Random random = new Random();
        String result = "";
        for (int i = 0; i < len; i++) {
            int index = random.nextInt(dic.length());
            result += dic.charAt(index);
        }
        return result;
    }
}
