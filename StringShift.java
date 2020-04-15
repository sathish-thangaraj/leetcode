package leetcode;

public class StringShift {

    public static void main(String[] args) {
        String s = "abcdefg" ;
        int[][] shift = {{1,1},{1,1},{0,2},{1,3}};
        System.out.println(stringShift(s,shift));
    }

    public static String stringShift(String s, int[][] shift) {
        int count = 0;

        for (int i = 0; i < shift.length; i++) {
            if (shift[i][0] == 0)
                count -= shift[i][1];
            else if (shift[i][0] == 1)
                count += shift[i][1];
        }

        count = count % s.length();
        if (count > 0)
            return s.substring(s.length() - count, s.length()) + s.substring(0, s.length() - count);
        if (count < 0)
            return s.substring(-(count), s.length()) + s.substring(0, -(count));

        return s;

    }
}
