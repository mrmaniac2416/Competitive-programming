/**
 * Created by Chirag on 31-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class littlemonkandedgecount {
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
        int n=sc.nextInt();
        int q=sc.nextInt();
        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            graph.put(i,new HashSet<>());
        }
        Pair[] edges=new Pair[q+1];
        for(int i=1;i<=(n-1);i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            edges[i]=new Pair(a,b);
            graph.get(a).add(b);
            graph.get(b).add(a);
        }
//        debug(edges);
        for(int i=1;i<=q;i++)
        {
            int query=sc.nextInt();
            out.println(dfs(edges[query].u,edges[query].v,graph));
//            System.out.println("query done");
        }




        //The Code ends here
        out.close();
    }

    public static int dfs(int start,int end,HashMap<Integer,HashSet<Integer>> graph)
    {

        Stack<Integer> neighbours=new Stack<>();
        int c1=1;
        neighbours.add(start);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(start);
        while (!neighbours.isEmpty())
        {
            int visiting=neighbours.pop();
//            System.out.println("visiting " + visiting);
            for(int vertex:graph.get(visiting))
            {
//                debug(visited);
                if(!visited.contains(vertex) && vertex!=end)
                {
//                    System.out.println("adding vertex to stack" + vertex);
                    neighbours.add(vertex);
                    visited.add(vertex);
                    c1++;
                }
            }
        }
        neighbours=new Stack<>();
        int c2=1;
        neighbours.add(end);
        visited=new HashSet<>();
        visited.add(end);
        while (!neighbours.isEmpty())
        {
            int visiting=neighbours.pop();
            for(int vertex:graph.get(visiting))
            {
                if(!visited.contains(vertex) && vertex!=start)
                {
                    neighbours.add(vertex);
                    visited.add(vertex);
                    c2++;
                }
            }
        }
//        debug(c1,c2);
        return c1*c2;
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

