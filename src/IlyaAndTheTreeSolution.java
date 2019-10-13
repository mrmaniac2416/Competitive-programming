import java.awt.Point;

import java.io.*;
import java.math.BigInteger;
import java.util.*;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.function.Supplier;

public class IlyaAndTheTreeSolution {
    static Scanner in = new Scanner();
    static PrintWriter out = new PrintWriter(System.out);
    static ArrayList<Integer> tree[];
    static int values[], ans[];

    public static void main(String[] test) throws NumberFormatException, IOException {
        int n = in.nextInt();
        int m = n - 1;
        tree = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            tree[i] = new ArrayList<>();
        }
        values = new int[n];
        ans = new int[n];
        for (int i = 0; i < n; i++) {
            values[i] = in.nextInt();
        }
        for (int i = 0; i < m; i++) {
            int u = in.nextInt() - 1;
            int v = in.nextInt() - 1;
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(0, 0, 0, new TreeSet<Integer>());

        for (Integer i : ans) {
            out.append(i + " ");
        }
        out.flush();
        out.close();
    }

    static void dfs(int node, int parent, int gcd_path, TreeSet<Integer> gcds_path) {
        TreeSet<Integer> now = new TreeSet<>();
        for (Integer i : gcds_path) {
            now.add(GCD(i, values[node]));
        }
        now.add(gcd_path);
        int now_gcd = GCD(values[node], gcd_path);
        ans[node] = Math.max(now_gcd, now.last());
//        debug(node,gcd_path,gcds_path,now,now_gcd,ans[node]);
        for (Integer u : tree[node]) {
            if (u != parent) {
                dfs(u, node, now_gcd, now);
            }
        }

    }

    static int GCD(int a, int b) {
        return a == 0 ? b : GCD(b % a, a);
    }

    static class Scanner {
        BufferedReader br;
        StringTokenizer st;

        Scanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }

        String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }

        int nextInt() throws NumberFormatException, IOException {
            return Integer.parseInt(next());
        }

        String nextLine() throws IOException {
            return br.readLine();
        }

        long nextLong() throws NumberFormatException, IOException {
            return Long.parseLong(next());
        }

    }
    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }
}