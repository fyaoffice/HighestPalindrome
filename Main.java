package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner in = new Scanner(new File("input03.txt"));
        int k = Integer.parseInt(in.nextLine().split(" ")[1]);
        String s = in.nextLine();
        String out = highestValuePalindrome(s, 0, k);
        System.out.println(out);
    }

    public static String highestValuePalindrome(String s, int n, int k) {
        StringBuilder out = new StringBuilder(s);
        int i, differences = 0;
        for (i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                differences++;
            }
        }


        for (i = 0; i < s.length() / 2; i++) {
            if (s.charAt(i) != s.charAt(s.length() - 1 - i)) {
                if (k == 0) {
                    return "-1";
                } else {
                    if (s.charAt(i) == '9') {
                        out.setCharAt(s.length() - 1 - i, '9');
                    } else if (s.charAt(s.length() - 1 - i) == '9') {
                        out.setCharAt(i, '9');
                    } else if (k > 1 && k > differences) {
                        out.setCharAt(i, '9');
                        out.setCharAt(s.length() - 1 - i, '9');
                        k--;
                    } else {
                        if (s.charAt(i) > s.charAt(s.length() - 1 - i)) {
                            out.setCharAt(s.length() - 1 - i, s.charAt(i));
                        } else {
                            out.setCharAt(i, s.charAt(s.length() - 1 - i));
                        }

                    }
                    differences--;
                    k--;
                }
            } else {
                if (k > 1 && k > differences && s.charAt(i)!='9' && s.charAt(s.length() - 1 - i)!='9') {
                    out.setCharAt(i, '9');
                    out.setCharAt(s.length() - 1 - i, '9');
                    k = k - 2;
                }
            }
        }
        if (s.length() % 2 != 0 && k > 0) {
            out.setCharAt(s.length()/2, '9');
        }
        return out.toString();

    }
}
