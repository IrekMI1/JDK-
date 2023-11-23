package Seminar6;

import java.util.HashMap;
import java.util.Random;

public class Main {
//    public static String game(int doorCount, boolean changeMind) {
//        Random random = new Random();
//        int winIndex = random.nextInt(0, doorCount);
//        int pickedIndex = random.nextInt(0, doorCount);
//        int leavedIndex;
//
//        if (pickedIndex == winIndex) {
//            do {
//                leavedIndex = random.nextInt(0, doorCount);
//            } while (leavedIndex == pickedIndex & leavedIndex == winIndex);
//
//            if (changeMind) {
//                return "поменял, проиграл";
//            } else {
//                return "не поменял, выиграл";
//            }
//        } else {
//            if (changeMind) {
//                return "Поменял, выиграл";
//            } else {
//                return "не поменял, проиграл";
//            }
//        }
//    }

    public static void main(String[] args) {
        int doorCount = 3;
        int experimentCount = 100000;
        Quiz quiz = new Quiz(doorCount);
        HashMap<Integer, String> results = new HashMap<>();
        String result;

        for (int i = 1; i <= experimentCount; i++) {
            result = quiz.getResult( false);
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
