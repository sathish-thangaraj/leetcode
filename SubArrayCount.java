package leetcode;

import java.util.HashMap;

public class SubArrayCount {

    public static void main(String[] args){
        int[] nums = {1,1,1};
        int k = 2;

        System.out.println(subarraySum(nums,k));
    }

    public static int subarraySum(int[] nums, int k) {
        int sum = 0 ;
        int subarrayCount = 0 ;
        HashMap<Integer,Integer> countSubArrayMap = new HashMap<>();
        countSubArrayMap.put(0,1);
        for(int i=0;i<nums.length;i++){
            sum += nums[i];
            if(countSubArrayMap.containsKey(sum-k)){
                subarrayCount += countSubArrayMap.get(sum-k);
            }
            countSubArrayMap.put(sum , countSubArrayMap.getOrDefault(sum,0)+1);
        }
        return subarrayCount;
    }
}
