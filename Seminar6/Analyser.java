package Seminar6;

import java.util.HashMap;

public class Analyser {
    static int winCount(HashMap<Integer, String> results) {
        int count = 0;
        for (String result : results.values()) {
            if (result.contains("выиграл")) {
                count++;
            }
        }
        return count;
    }
}
