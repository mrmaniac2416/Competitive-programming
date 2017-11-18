/**
 * Created by Chirag on 01-04-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class longestpathintree {
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
        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        for(int i=1;i<=n;i++)
            graph.put(i,new HashSet<>());
        for(int i=1;i<=n-1;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);

        }
        for(int i=1;i<=n;i++)
        {
            Pair p=bfs(graph,i);
            out.println(p.u + " "+ p.v);
        }


        //The Code ends here
        out.close();
    }


    public static Pair bfs(HashMap<Integer,HashSet<Integer>> graph,int start)
    {
        Queue<Integer> neighbours=new ArrayDeque<>();
        neighbours.add(start);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(start);
        TreeMap<Integer,Integer> count=new TreeMap<>();
        int distances[]=new int[graph.size()+1];
        distances[start]=0;

        while (!neighbours.isEmpty())
        {
            int visting=neighbours.poll();

            for(int vertex:graph.get(visting))
            {
                if(!visited.contains(vertex))
                {
                    neighbours.add(vertex);
                    visited.add(vertex);
                    distances[vertex]=distances[visting]+1;
                    if(!count.containsKey(distances[vertex]))
                    {
                        count.put(distances[vertex],1);
                    }
                    else
                        count.replace(distances[vertex],count.get(distances[vertex])+1);
                }
            }
        }
        debug(distances);
        debug(count);
        return new Pair(count.lastKey()+1,count.get(count.lastKey()));
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

