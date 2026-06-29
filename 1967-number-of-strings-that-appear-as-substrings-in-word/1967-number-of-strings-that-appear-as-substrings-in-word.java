class Solution {
    public int numOfStrings(String[] patterns, String word) {
        int sol = 0;

        for (String x : patterns) {
            if (word.contains(x)) {
                sol++;
            }
        }

        return sol;
    }
}