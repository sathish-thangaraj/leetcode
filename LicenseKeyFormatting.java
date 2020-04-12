package leetcode;

public class LicenseKeyFormatting {

    public static void main(String[] args) {
        String S = "5F3Z-2e-9-w";
        int K = 4;
        System.out.println(licenseKeyFormattingOptimized(S, K));
    }

    public static String licenseKeyFormatting(String S, int K) {
        S = S.replaceAll("-", "").toUpperCase();
        StringBuilder output = new StringBuilder(S);
        for (int i = output.length() - K; i > 0; i = i - K) {
            output.insert(i, "-");
        }
        return output.toString();
    }

    public static String licenseKeyFormattingOptimized(String S, int K) {
        StringBuilder sb = new StringBuilder();
        char[] chars = S.toCharArray();
        int counter = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            if (chars[i] == '-') {
                continue;
            }
            if (K == counter) {
                counter = 0;
                sb.append("-");
            }
            sb.append(Character.toUpperCase(chars[i]));
            counter++;
        }
        return sb.reverse().toString();
    }
}
