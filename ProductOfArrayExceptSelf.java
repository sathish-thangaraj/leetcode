package leetcode;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args){
        int[] nums = {1,2,3,4};
        nums = productExceptSelfUsingExtraSpace(nums);
        for(int i:nums)
            System.out.println(i);
        nums = productExceptSelf(nums);
        for(int i:nums)
            System.out.println(i);
    }

    public static int[] productExceptSelfUsingExtraSpace(int[] nums) {
        int[] left = new int[nums.length];
        int[] right = new int[nums.length];
        left[0] = 1 ;
        for(int i=0;i<nums.length-1;i++){
            left[i+1] = nums[i]*left[i];
        }
        right[nums.length-1] = 1 ;
        for(int i=nums.length-1;i>0;i--){
            right[i-1] = right[i]* nums[i];
        }
        for(int i=0;i<left.length;i++){
            left[i] = left[i] * right[i];
        }
        return left;

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] left = new int[nums.length];
        left[0] = 1 ;
        for(int i=0;i<nums.length-1;i++){
            left[i+1] = nums[i]*left[i];
        }

        int product = 1 ;
        for(int i=left.length-2;i>=0;i--){
            left[i] = left[i] * product * nums[i+1];
            product *= nums[i+1];
        }
        return left;

    }
}
