class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] counts = new int[26];
        for (char c : s.toCharArray()) counts[c - 'a']++;
        int bestPos = -1, bestChar = -1;
        int[] bestSnapshot = null;
        for (int i = 0; i < n; i++) {
            int tChar = target.charAt(i) - 'a';
            int found = -1;
            for (int c = tChar + 1; c < 26; c++) {
                if (counts[c] > 0) { found = c; break; }
            }
            if (found != -1) {
                bestPos = i;
                bestChar = found;
                bestSnapshot = counts.clone();
                bestSnapshot[found]--;
            }
            if (counts[tChar] > 0) {
                counts[tChar]--;
            } else {
                break;
            }
        }
        if (bestPos == -1) return "";
        StringBuilder sb = new StringBuilder();
        sb.append(target, 0, bestPos);           
        sb.append((char) ('a' + bestChar));      
        for (int c = 0; c < 26; c++) {
            for (int k = 0; k < bestSnapshot[c]; k++) {
                sb.append((char) ('a' + c));
            }
        }
        return sb.toString();
    }
}