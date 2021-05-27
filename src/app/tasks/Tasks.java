package app.tasks;

import java.util.Arrays;

public class Tasks {

    /**
     * @param str
     * @return The task is to check if a string contains only unique letters. The solution shall not use any data structures
     */

    public boolean isUnique(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean permutation(String first, String second) {
        char[] tempArrayA = first.toCharArray();
        char[] tempArrayB = second.toCharArray();
        Arrays.sort(tempArrayA);
        Arrays.sort(tempArrayB);

        return new String(tempArrayA).equals(new String(tempArrayB));
    }

    public String urlIfy(String str, int length) {
        StringBuilder sb = new StringBuilder();
        char[] tempArray = str.toCharArray();
        for (int i = 0; i < length; i++) {
            if (tempArray[i] == ' ') {
                sb.append("%20");
            } else {
                sb.append(tempArray[i]);
            }
        }

        return sb.toString();
    }

    public boolean oneEditAway(String first, String second) {
        if (first.length() == second.length()) {
            return oneEditReplace(first, second);
        } else if (first.length() + 1 == second.length()) {
            return oneEditInsert(first, second);
        } else if (first.length() - 1 == second.length()) {
            return oneEditInsert(second, first);
        }
        return false;
    }

    boolean oneEditReplace(String s1, String s2) {
        boolean foundDifference = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (foundDifference) {
                    return false;
                }
                foundDifference = true;
            }
        }
        return true;
    }

    boolean oneEditInsert(String s1, String s2) {
        int index1 = 0;
        int index2 = 0;
        while (index2 < s2.length() && index1 < s1.length()) {
            if (s1.charAt(index1) != s2.charAt(index2)) {
                if (index1 != index2) {
                    return false;
                }
                index2++;
            } else {
                index1++;
                index2++;
            }
        }
        return true;
    }

    public String compression(String str) {
        int counter = 1;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < str.length() - 1; i++) {
            char next = str.charAt(i + 1);
            if (str.charAt(i) == next) {
                counter++;
            } else {
                sb.append(str.charAt(i)).append(counter);
                counter = 1;
            }
            if (i == str.length()-2) {
                sb.append(str.charAt(i)).append(counter);
            }
        }

        return sb.toString().length() < str.length() ? sb.toString() : str;
    }
}
