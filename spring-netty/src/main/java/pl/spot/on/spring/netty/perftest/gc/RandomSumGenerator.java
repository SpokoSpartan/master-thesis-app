package pl.spot.on.spring.netty.perftest.gc;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class RandomSumGenerator {

    private int[] values;

    public RandomSumGenerator(int size) {
        assignRandomInt(size);
    }

    private void assignRandomInt(int size) {
        Random random = ThreadLocalRandom.current();
        values = new int[size];
        for (int i = 0; i < size; i++) {
            values[i] = random.nextInt();
        }
    }

    public int sum() {
        int sum = 0;
        for (int val : this.values) {
            sum += val;
        }
        return sum;
    }

}
