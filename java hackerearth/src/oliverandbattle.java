/**
 * Created by Chirag on 04-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class oliverandbattle {
    public static void main(String[] args) {
        MyScanner sc = new MyScanner();
        out = new PrintWriter(new BufferedOutputStream(System.out));


      /*
      int n      = sc.nextInt();        // read input as integer
      long k     = sc.nextLong();       // read input as long
      double d   = sc.nextDouble();     // read input as double
      String str = sc.next();           // read input as String
      String s   = sc.nextLine();       // read whole line as String

      int result = 3*n;
      out.println(result);                    // print via PrintWriter
      */
        //The Code Starts here
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            boolean visited[][]=new boolean[n+1][m+1];
            int a[][] = new int[n + 1][m + 1];
            int maxdestroyed = 0;
            int troops=0;
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= m; j++) {
                    a[i][j] = sc.nextInt();
                }
            }
            for (int i=1;i<=n;i++) {
                for (int j=1;j<=m;j++) {
                    int destroyed=0;
                    if (a[i][j] == 1 && !visited[i][j])
                    {
                        destroyed = bfs(a, i, j,visited);
                        troops++;
                    }
                    if(destroyed>maxdestroyed)
                        maxdestroyed=destroyed;
                }
            }
            out.println(troops + " " + maxdestroyed);
        }



        //The Code ends here
        out.close();
    }
    public static int bfs(int a[][],int x,int y,boolean visited[][])
    {
        Queue<Pair> neighbours=new ArrayDeque<>();
        neighbours.add(new Pair(x,y));
        int destroyed=1;
        visited[x][y]=true;
        while (!neighbours.isEmpty())
        {
            Pair visiting=neighbours.poll();
            for (int i=-1;i<=1;i++) {
                for (int j=-1;j<=1;j++) {
                    try {
                        if(!visited[visiting.u-i][visiting.v-j] && a[visiting.u-i][visiting.v-j]==1)
                        {
                            neighbours.add(new Pair(visiting.u-i,visiting.v-j));
                             destroyed++;
                            visited[visiting.u-i][visiting.v-j]=true;
                        }
                    } catch (Exception e) {
                    }
                }
            }
        }
        return destroyed;
    }

    //-----------PrintWriter for faster output---------------------------------
    public static PrintWriter out;

    //-----------MyScanner class for faster input----------
    public static class MyScanner {
        BufferedReader br;
        StringTokenizer st;

        public MyScanner() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }

        public int[] nextIntArray(int n) {
            int[] arr = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextInt();
            }
            return arr;
        }

        public long[] nextLongArray(int n) {
            long[] arr = new long[n];
            for (int i = 0; i < n; i++) {
                arr[i] = nextLong();
            }
            return arr;
        }

        public int[][] nextInt2DArray(int m, int n) {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++)
                    arr[i][j] = nextInt();
            }
            return arr;
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }

    }

    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;

        public Pair(int u, int v) {
            this.u = u;
            this.v = v;
        }


        public int hashCode() {
            int hu = (int) (u ^ (u >>> 32));
            int hv = (int) (v ^ (v >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return u == other.u && v == other.v;
        }

        public int compareTo(Pair other) {
            return Integer.compare(u, other.u) != 0 ? Integer.compare(u, other.u) : Integer.compare(v, other.v);
        }

        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
    //--------------------------------------------------------
}

