package modified_binary_search;

import java.util.Random;

/**
 * Random Pick with Weight
 *
 * Statement
 * You’re given an array of positive integers, w, where w[i] describes the weight of the ith index.
 *
 * You need to perform weighted random selection to return an index from the w array. The larger the value of w[i],
 * the heavier the weight is. Hence, the higher the chances of its index being picked.
 *
 * Suppose the weights array contains the values [12,84,35]
 * In this case, the probabilities of picking the indexes will be the following:
 *
 * Index 0: 12/(12+84+35)=9.2%
 * Index 1: 84/(12+84+35)=64.1%
 * Index 2: 35/(12+84+35)=26.7%
 */
public class WeightedRandomPick {
    int[] prefixSum;
    Random random;

    public static void main(String[] args) {
        int[] w = {12, 84, 35};
        WeightedRandomPick obj = new WeightedRandomPick(w);
        int[] results = new int[100000];
        for (int i = 0; i < 100000; i++) {
            results[i] = obj.pickIndex();
        }
        System.out.println("Index 0 count: " + getCount(0, results) + ", probability: " + getCount(0, results) / 1000.0 + "%");
        System.out.println("Index 1 count: " + getCount(1, results) + ", probability: " + getCount(1, results) / 1000.0 + "%");
        System.out.println("Index 2 count: " + getCount(2, results) + ", probability: " + getCount(2, results) / 1000.0 + "%");
    }

    private static int getCount(int index, int[] results) {
        int count = 0;
        for (int i : results) {
            if (i == index) {
                count++;
            }
        }
        return count;
    }


    public WeightedRandomPick(int[] w) {
        prefixSum = new int[w.length];
        prefixSum[0] = w[0];
        for (int i = 1; i < w.length; i++) {
            prefixSum[i] = prefixSum[i - 1] + w[i];
        }
        random = new Random();
    }

    /**
     * The WeightedRandomPick constructor takes an array of weights w and initializes a prefixSum array where prefixSum[i]
     * is the sum of weights from index 0 to index i.
     *
     * The pickIndex method first generates a random integer between 1 and the total weight (inclusive).
     * Then, it performs a binary search on the prefixSum array to find the index where the random integer falls
     * between two consecutive prefix sums. This index is returned as the randomly selected index.
     *
     * Note that we add 1 to the random integer generated to avoid 0 as a possible random number,
     * as this would cause the binarySearch method to return -1, which is not a valid index.
     * @return
     */
    public int pickIndex() {
        int total = prefixSum[prefixSum.length - 1];
        int rand = random.nextInt(total) + 1; // add 1 to avoid 0 as a possible random number
        int idx = binarySearch(rand, prefixSum);
        return idx;
    }

    private int binarySearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
