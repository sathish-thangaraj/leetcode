package leetcode;

public class MaximumSubArray {

    public static void main(String[] args){
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maximumSubArrayGreedy(nums));
    }

    /*
    Greedy approach
     */
    public static int maximumSubArrayGreedy(int[] nums){

        int localSum = 0 ;
        int maximumSum = Integer.MIN_VALUE;
        for(int i=0;i<nums.length;i++){
            localSum = Math.max(nums[i],localSum+nums[i]);
            maximumSum = Math.max(localSum,maximumSum);
        }

        return maximumSum;
    }
    
}
