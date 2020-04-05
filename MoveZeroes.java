package leetcode;

public class MoveZeroes {

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int i : nums)
            System.out.println(i);
    }

    public static void moveZeroes(int[] nums) {

        int nonZeroPointer = 0;
        for (int i = 0; i < nums.length; i++) {

            if (nums[i] != 0) {
                nums[nonZeroPointer] = nums[i];
                nonZeroPointer++;
            }
        }

        for (int i = nonZeroPointer; i < nums.length; i++) {
            nums[nonZeroPointer] = 0;
            nonZeroPointer++;
        }

    }
}
