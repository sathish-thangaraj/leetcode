package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumSubSequence {

    public static void main(String[] args) {
        int[] nums = {4, 3, 10, 9, 8};
        List<Integer> output = minSubsequence(nums);
        for(int i:output)
            System.out.println(i);
    }

    // Find the total Sum
    // Sort the array
    // Add the elements from array (higher numbers) till the subsequence sum is greater than half of the total sum
    public static List<Integer> minSubsequence(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        List<Integer> output = new ArrayList();
        int subSequenceSum = 0;
        Arrays.sort(nums);
        int k = nums.length - 1;
        while (subSequenceSum <= sum / 2) {
            subSequenceSum += nums[k];
            output.add(nums[k]);
            k--;
        }
        return output;
    }
}
