package leetcode;

import java.util.HashSet;
import java.util.Set;

public class HappyNumber {
    public static void main(String[] args) {
        int input = 19;
        System.out.println(isHappyNumberUsingHashSet(input));
        System.out.println(isHappyNumberUsingFloyds(input));
    }

    // Use hash set to store the number which is already seen by us
    // If we already saw the number it is going in loop
    //time complexity o(log(n))
    public static boolean isHappyNumberUsingHashSet(int num) {

        if (num == 1)
            return true;

        Set<Integer> seen = new HashSet();

        while (num != 1 && !seen.contains(num)) {
            seen.add(num);
            num = getNextNumber(num);
        }

        return num == 1;
    }


    // Floyds algorithm
    // time complexity o(logn)

    public static boolean isHappyNumberUsingFloyds(int num) {

        int slowRunner = getNextNumber(num);
        int fastRunner = getNextNumber(getNextNumber(num));

        while (fastRunner != 1 && fastRunner != slowRunner) {
            slowRunner = getNextNumber(slowRunner);
            fastRunner = getNextNumber(getNextNumber(fastRunner));
        }

        return fastRunner == 1;
    }


    public static int getNextNumber(int num) {
        int sum = 0;
        while (num > 0) {
            int remainder = num % 10;
            num = num / 10;
            sum = sum + remainder * remainder;
        }
        return sum;
    }
}
