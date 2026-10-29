
import java.util.*;

class Solution {
    private int n, LOG, timer;
    private List<Integer>[] adj;
    private int[][] up;
    private int[] depth, tin, tout, parent, prefix;
    private char[] chars;
    private Fenwick bit;

    private int mask(char c) {
        return 1 << (c - 'a');
    }

    class Fenwick {
        int[] tree;
        int size;

        Fenwick(int n) {
            size = n + 1;
            tree = new int[n + 2];
        }

        void add(int i, int val) {
            for (; i < tree.length; i += i & -i) {
                tree[i] ^= val;
            }
        }

        void rangeXor(int l, int r, int val) {
            add(l + 1, val);
            add(r + 2, val);
        }

        int query(int i) {
            int res = 0;
            for (i++; i > 0; i -= i & -i) {
                res ^= tree[i];
            }
            return res;
        }
    }

    private void dfs() {
        int[] stack = new int[2 * n + 5];
        int top = 0;
        stack[top++] = 0;
        parent[0] = 0;

        while (top > 0) {
            int u = stack[--top];

            if (u < 0) {
                tout[~u] = timer - 1;
                continue;
            }

            tin[u] = timer++;
            prefix[u] = (u == 0 ? 0 : prefix[parent[u]])
                        ^ mask(chars[u]);

            stack[top++] = ~u;

            for (int v : adj[u]) {
                if (v == parent[u]) {
                    continue;
                }

                parent[v] = u;
                depth[v] = depth[u] + 1;
                stack[top++] = v;
            }
        }
    }

    private void buildLCA() {
        for (int u = 0; u < n; u++) {
            up[0][u] = parent[u];
        }

        for (int k = 1; k < LOG; k++) {
            for (int u = 0; u < n; u++) {
                up[k][u] = up[k - 1][up[k - 1][u]];
            }
        }
    }

    private int lca(int u, int v) {
        if (depth[u] < depth[v]) {
            int temp = u;
            u = v;
            v = temp;
        }

        int diff = depth[u] - depth[v];

        for (int k = 0; k < LOG; k++) {
            if ((diff & (1 << k)) != 0) {
                u = up[k][u];
            }
        }

        if (u == v) {
            return u;
        }

        for (int k = LOG - 1; k >= 0; k--) {
            if (up[k][u] != up[k][v]) {
                u = up[k][u];
                v = up[k][v];
            }
        }

        return parent[u];
    }

    private int getPrefix(int u) {
        return prefix[u] ^ bit.query(tin[u]);
    }

    public List<Boolean> palindromePath(
            int n, int[][] edges, String s, String[] queries) {

        this.n = n;
        chars = s.toCharArray();

        adj = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] e : edges) {
            adj[e[0]].add(e[1]);
            adj[e[1]].add(e[0]);
        }

        LOG = 1;
        while ((1 << LOG) <= n) {
            LOG++;
        }

        up = new int[LOG][n];
        depth = new int[n];
        tin = new int[n];
        tout = new int[n];
        parent = new int[n];
        prefix = new int[n];

        timer = 0;
        dfs();
        buildLCA();

        bit = new Fenwick(n);

        List<Boolean> ans = new ArrayList<>();

        for (String q : queries) {
            String[] p = q.split("\\s+");

            if (p[0].equals("update")) {
                int u = Integer.parseInt(p[1]);
                char c = p[2].charAt(0);

                int delta = mask(chars[u]) ^ mask(c);

                if (delta != 0) {
                    bit.rangeXor(tin[u], tout[u], delta);
                    chars[u] = c;
                }
            } else {
                int u = Integer.parseInt(p[1]);
                int v = Integer.parseInt(p[2]);

                int w = lca(u, v);

                int pathMask = getPrefix(u)
                             ^ getPrefix(v)
                             ^ mask(chars[w]);

                ans.add((pathMask & (pathMask - 1)) == 0);
            }
        }

        return ans;
    }
}
