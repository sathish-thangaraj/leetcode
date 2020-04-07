package leetcode;

import java.util.HashSet;
import java.util.Set;

public class CountElements {

    public static void main(String[] args){
        int[] arr = {1,1,2,2};
        System.out.println(countElements(arr));
    }

    public static int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr)
            set.add(i);
        int count = 0;
        for (int i : arr) {
            if (set.contains(i + 1))
                count++;
        }
        return count;
    }
}
