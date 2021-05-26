package app.tasks;

import java.util.Arrays;

public class Tasks {

    /**
     *
     * @param str
     * @return
     * The task is to check if a string contains only unique letters. The solution shall not use any data structures
     */

    public boolean isUnique(String str)
    {
        for (int i = 0; i<str.length(); i++) {
            for (int j = 0; j<str.length(); j++) {
                if (str.charAt(i) == str.charAt(j) && i != j) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean permutation(String first, String second)
    {
        char[] tempArrayA = first.toCharArray();
        char[] tempArrayB = second.toCharArray();
        Arrays.sort(tempArrayA);
        Arrays.sort(tempArrayB);

        return new String(tempArrayA).equals(new String(tempArrayB));
    }
}
