package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class SingleNumber {

    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 3};
        System.out.println(singleNumberUsingBitOperator(nums));
        System.out.println(singleNumberUsingHashMap(nums));
        System.out.println(singleNumberUsingMath(nums));
    }

    /*
    Using XOR Operator we can find the single number
     */
    public static int singleNumberUsingBitOperator(int[] nums) {
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            result = result ^ nums[i];
        }
        return result;
    }

    //Using hashmap we can find the single number
    public static int singleNumberUsingHashMap(int[] nums) {
        Map<Integer, Integer> counter = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counter.put(nums[i], counter.getOrDefault(nums[i], 0) + 1);
        }

        for (int i : counter.keySet()) {
            if (counter.get(i) == 1)
                return i;
        }
        return -1;
    }

    //Using Math we can find the single number
    // 2 *(a+b+c) = a + a + b + b + c + c . If c is there only once we can find using below formula
    // 2∗(a+b+c)−(a+a+b+b+c) = c

    public static int singleNumberUsingMath(int[] nums) {

        int actualSum = 0;
        int desiredSum = 0;

        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            actualSum += nums[i];
            if (!set.contains(nums[i])) {
                desiredSum += nums[i];
                set.add(nums[i]);
            }

        }

        desiredSum = 2 * desiredSum;
        return desiredSum - actualSum;
    }
}
