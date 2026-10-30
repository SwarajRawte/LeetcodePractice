class Solution {

    private static class State {
        int u;
        int cnt;
        long dist;

        State(int u, int cnt, long dist) {
            this.u = u;
            this.cnt = cnt;
            this.dist = dist;
        }
    }

    public int shortestPath(int n, int[][] edges, String labels, int k) {

        List<int[]>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            int u = e[0];
            int v = e[1];
            int w = e[2];

            graph[u].add(new int[]{v, w});
        }

        long inf = Long.MAX_VALUE / 4;

        long[][] dist = new long[n][k + 1];

        for (long[] row : dist) {
            Arrays.fill(row, inf);
        }

        PriorityQueue<State> pq =
                new PriorityQueue<>(
                        Comparator.comparingLong(s -> s.dist)
                );

        dist[0][1] = 0;
        pq.offer(new State(0, 1, 0));

        while (!pq.isEmpty()) {
            State cur = pq.poll();

            int u = cur.u;
            int cnt = cur.cnt;
            long d = cur.dist;

            if (d != dist[u][cnt]) {
                continue;
            }

            if (u == n - 1) {
                return (int) d;
            }

            for (int[] e : graph[u]) {
                int v = e[0];
                int w = e[1];

                int nextCnt;

                if (labels.charAt(u) == labels.charAt(v)) {
                    nextCnt = cnt + 1;
                } else {
                    nextCnt = 1;
                }

                if (nextCnt > k) {
                    continue;
                }

                long newDist = d + w;

                if (newDist < dist[v][nextCnt]) {
                    dist[v][nextCnt] = newDist;
                    pq.offer(new State(v, nextCnt, newDist));
                }
            }
        }

        return -1;
    }
}