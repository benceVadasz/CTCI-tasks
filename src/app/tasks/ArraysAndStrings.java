package app.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class ArraysAndStrings {

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
            if (i == str.length() - 2) {
                sb.append(str.charAt(i)).append(counter);
            }
        }

        return sb.toString().length() < str.length() ? sb.toString() : str;
    }

    public int[][] rotateMatrix(int[][] matrix) {

        int[][] fin = new int[3][3];
        int[][] finFin = new int[3][3];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                fin[j][i] = matrix[i][j];
            }
        }
        for (int i = 0; i < fin.length; i++) {
            finFin[fin.length - i - 1] = fin[i];
        }
        return finFin;
    }

    public int[][] zeroMatrix(int[][] matrix) {

        int[][] fin = new int[matrix.length][matrix[0].length];
        ArrayList<Integer> colIndexes = new ArrayList<>();

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (!colIndexes.contains(j) && matrix[i][j] != 0) {
                    fin[i][j] = matrix[i][j];
                } else if (colIndexes.contains(j) && matrix[i][j] != 0) {
                    fin[i][j] = 0;
                } else if (matrix[i][j] == 0) {

                    int index = 0;
                    colIndexes.add(j);
                    for (int k = 0; k < matrix[i].length; k++) {
                        fin[i][index] = 0;
                        index++;
                    }
                    if (i != matrix.length - 1) {
                        j = -1;
                        i++;
                    }
                }
            }
        }

        return fin;
    }
}
