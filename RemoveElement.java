package leetcode;

public class RemoveElement {
    public static void main(String[] args) {
        int[] numbers = {3, 2, 2, 3};
        removeElement(numbers, 3);
        for (int i : numbers)
            System.out.println(i);
    }

    public static int removeElement(int[] nums, int val) {

        int k = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i];
                k++;
            }
        }
        return k;
    }

}
