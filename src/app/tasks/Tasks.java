package app.tasks;

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
}
