package University.Java_Using_Project.Experiment8;

import java.util.Scanner;

public class Main {
    public static String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }

        int maxLen = 1;
        String maxStr = s.substring(0, 1);

        for (int i = 0; i < s.length(); i++) {
            for (int j = i + maxLen; j <= s.length(); j++) {
                if (j - i > maxLen && isPalindrome(s.substring(i, j))) {
                    maxLen = j - i;
                    maxStr = s.substring(i, j);
                }
            }
        }

        return maxStr;
    }

    private static boolean isPalindrome(String str) {
        int left = 0;
        int right = str.length() - 1;

        while (left < right) {
            if (str.charAt(left) != str.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Name: Nisha\nUID:21BCS9166");
        System.out.println("Enter the string");
        String s =  in.nextLine();
        System.out.println(longestPalindrome(s));
    }
}
