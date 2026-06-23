class Solution {
    private static final int MOD = 1_000_000_007;

    public int zigZagArrays(int n, int l, int r) {
        int m = r - l + 1;

        if (n == 1) {
            return m;
        }

        long[] up = new long[m];
        long[] down = new long[m];

        for (int i = 0; i < m; i++) {
            up[i] = i;
            down[i] = m - i - 1;
        }

        for (int len = 3; len <= n; len++) {
            long[] prefixUp = new long[m + 1];
            long[] prefixDown = new long[m + 1];

            for (int i = 0; i < m; i++) {
                prefixUp[i + 1] = (prefixUp[i] + up[i]) % MOD;
                prefixDown[i + 1] = (prefixDown[i] + down[i]) % MOD;
            }

            long totalUp = prefixUp[m];

            long[] newUp = new long[m];
            long[] newDown = new long[m];

            for (int i = 0; i < m; i++) {
                newUp[i] = prefixDown[i];
                newDown[i] = (totalUp - prefixUp[i + 1] + MOD) % MOD;
            }

            up = newUp;
            down = newDown;
        }

        long answer = 0;

        for (int i = 0; i < m; i++) {
            answer = (answer + up[i] + down[i]) % MOD;
        }

        return (int) answer;
    }
}