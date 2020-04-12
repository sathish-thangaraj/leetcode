package leetcode;

import java.util.HashSet;

public class UniqueEmailAddress {

    public static void main(String[] args){
        String[] emails = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
        System.out.println(numUniqueEmails(emails));
    }

    public static int numUniqueEmails(String[] emails) {
        HashSet<String> set = new HashSet<>();

        for (int i = 0; i < emails.length; i++) {
            String[] splitDomain = emails[i].split("@");
            String afterRemovingPlus = removePlus(splitDomain[0]);
            String finalString = removeDot(afterRemovingPlus);
            set.add(finalString + "@" + splitDomain[1]);
        }
        return set.size();
    }

    public static String removePlus(String input) {
        String[] splitPlus = input.split("\\+");
        return splitPlus[0];
    }

    public static String removeDot(String input) {
        String[] splitDot = input.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < splitDot.length; i++) {
            sb.append(splitDot[i]);
        }
        return sb.toString();
    }
}
