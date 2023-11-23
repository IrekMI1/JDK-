package Seminar6;

import java.util.HashMap;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int doorCount = 3;
        int experimentCount = 100000;
        Quiz quiz = new Quiz(doorCount);
        HashMap<Integer, String> results = new HashMap<>();
        String result;

        for (int i = 1; i <= experimentCount; i++) {
            result = quiz.getResult( true);
            results.put(i, result);
            System.out.println(result);
        }

        int wins = Analyser.winCount(results);
        int loses = experimentCount - wins;
        System.out.println("Число выигрышей: " + wins);
        System.out.println("Число проигрышей: " + loses);
        System.out.println("Процент выигрышей: " + (double) wins / experimentCount * 100.0);
    }
}
