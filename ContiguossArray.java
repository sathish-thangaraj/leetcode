package leetcode;

import java.util.HashMap;

public class ContiguossArray {

    public static void main(String[] args){
        int[] nums = {0,1,1,1,0,0};
        System.out.println(findMaxLength(nums));
    }

    public static int findMaxLength(int[] nums) {
        int maxLength = 0 ;
        HashMap<Integer,Integer> counts = new HashMap<>();
        int count = 0 ;
        counts.put(0,-1);
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)
                count -= 1;
            if(nums[i]==1)
                count += 1;

            if(counts.containsKey(count)){
                maxLength = Math.max(maxLength,i-counts.get(count));
            }
            else{
                counts.put(count,i);
            }
        }

        return maxLength;
    }
}
