package Seminar6;

import java.util.Random;

public class Quiz {
    private int doorCount;
    private int winIndex;
    private int pickedIndex;
    private int leavedIndex;
    private Random random = new Random();

    Quiz(int doorCount) {
        this.doorCount = doorCount;
    }

    public String getResult(boolean changeMind) {
        winIndex = random.nextInt(0, doorCount);
        pickedIndex = random.nextInt(0, doorCount);

        if (pickedIndex == winIndex) {
            do {
                leavedIndex = random.nextInt(0, doorCount);
            } while (leavedIndex == pickedIndex & leavedIndex == winIndex);

            if (changeMind) {
                return "поменял, проиграл";
            } else {
                return "не поменял, выиграл";
            }
        } else {
            if (changeMind) {
                return "Поменял, выиграл";
            } else {
                return "не поменял, проиграл";
            }
        }
    }
}
