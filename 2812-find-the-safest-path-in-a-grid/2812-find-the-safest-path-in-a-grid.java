import java.util.*;

class Solution {

    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a);
            int pb = find(b);

            if (pa == pb) {
                return;
            }

            if (size[pa] < size[pb]) {
                int temp = pa;
                pa = pb;
                pb = temp;
            }

            parent[pb] = pa;
            size[pa] += size[pb];
        }
    }

    public int maximumSafenessFactor(List<List<Integer>> grid) {
        int n = grid.size();

        int[][] dist = new int[n][n];
        for (int[] row : dist) {
            Arrays.fill(row, -1);
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid.get(i).get(j) == 1) {
                    dist[i][j] = 0;
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            int r = curr[0];
            int c = curr[1];

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (dist[nr][nc] != -1) {
                    continue;
                }

                dist[nr][nc] = dist[r][c] + 1;
                queue.offer(new int[]{nr, nc});
            }
        }

        List<int[]> cells = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cells.add(new int[]{dist[i][j], i, j});
            }
        }

        cells.sort((a, b) -> Integer.compare(b[0], a[0]));

        DSU dsu = new DSU(n * n);
        boolean[][] active = new boolean[n][n];

        for (int[] cell : cells) {
            int d = cell[0];
            int r = cell[1];
            int c = cell[2];

            active[r][c] = true;

            int id = r * n + c;

            for (int k = 0; k < 4; k++) {
                int nr = r + dr[k];
                int nc = c + dc[k];

                if (nr < 0 || nr >= n || nc < 0 || nc >= n) {
                    continue;
                }

                if (!active[nr][nc]) {
                    continue;
                }

                dsu.union(id, nr * n + nc);
            }

            if (active[0][0] && active[n - 1][n - 1]
                    && dsu.find(0) == dsu.find(n * n - 1)) {
                return d;
            }
        }

        return 0;
    }
}