/**
 * Created by Chirag on 03-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class bigpandparty {
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
        int noOfPersons=sc.nextInt();
        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        int noOfPairs=sc.nextInt();
        for(int i=0;i<noOfPairs;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            if(!graph.containsKey(start))
            {
                graph.put(start,new HashSet<>());
                graph.get(start).add(end);
            }
            else
                graph.get(start).add(end);
            if(!graph.containsKey(end))
            {
                graph.put(end,new HashSet<>());
                graph.get(end).add(start);
            }
            else
                graph.get(end).add(start);
        }
//        debug(graph);
        int distance[]=bfs(graph);
        for(int i=1;i<distance.length;i++)
        {
            out.println(distance[i]==0 ? "-1" : distance[i]);
        }


        //The Code ends here
        out.close();
    }
    public static int[] bfs(HashMap<Integer,HashSet<Integer>> graph)
    {
        int distance[]=new int[graph.size()];
        distance[0]=0;
        Queue<Integer> neighbours=new ArrayDeque<>();
        neighbours.add(0);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(0);
        while (!neighbours.isEmpty())
        {
            int visiting=neighbours.poll();
            for(int vertex:graph.get(visiting))
            {
                if(!visited.contains(vertex))
                {
                    visited.add(vertex);
                    neighbours.add(vertex);
                    distance[vertex]=distance[visiting]+1;
                }
            }
        }
        return distance;
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
        long u;
        long v;

        public Pair(long u, long v) {
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
            return Long.compare(u, other.u) != 0 ? Long.compare(u, other.u) : Long.compare(v, other.v);
        }

        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
    //--------------------------------------------------------
}

