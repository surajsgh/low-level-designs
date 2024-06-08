import java.util.concurrent.ThreadLocalRandom;

public class Dice {
    int diceCount;
    int start = 1;
    int end = 6;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        int totalSum = 0;
        int currentCount = 0;

        while (currentCount<diceCount) {
            totalSum += ThreadLocalRandom.current().nextInt(start, end+1);
            currentCount++;
        }

        return totalSum;
    }
}
