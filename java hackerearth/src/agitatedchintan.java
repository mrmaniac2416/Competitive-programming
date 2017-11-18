/**
 * Created by Chirag on 03-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class agitatedchintan {
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
        int t=sc.nextInt();
        while (t-->0)
        {
            int n=sc.nextInt();
            HashMap<Integer,HashSet<Pair>> graph=new HashMap<>();
            for(int i=0;i<n-1;i++)
            {
                int start=sc.nextInt();
                int end=sc.nextInt();
                int weight=sc.nextInt();
                if(!graph.containsKey(start))
                {
                    graph.put(start,new HashSet<Pair>());
                    graph.get(start).add(new Pair(end,weight));
                }
                else
                {
                    graph.get(start).add(new Pair(end,weight));
                }
                if(!graph.containsKey(end))
                {
                    graph.put(end,new HashSet<>());
                    graph.get(end).add(new Pair(start,weight));
                }
                else
                {
                    graph.get(end).add(new Pair(start,weight));
                }
            }
//            debug(graph);
            Pair maxvertex=bfs(1,graph);
//            debug(maxvertex);
            Pair maxdistance=bfs(maxvertex.vertex,graph);
//            debug(maxdistance);
            if(maxdistance.weight<=100)
                out.print("0 ");
            else if(maxdistance.weight<=1000)
                out.print("100 ");
            else if(maxdistance.weight<=10000)
                out.print("1000 ");
            else
                out.print("10000 ");
            out.println(maxdistance.weight);

        }



        //The Code ends here
        out.close();
    }

    public static Pair bfs(int start,HashMap<Integer,HashSet<Pair>> graph)
    {
        Queue<Integer> neighbours=new ArrayDeque<>();
        neighbours.add(start);
        HashSet<Integer> visited=new HashSet<>();
        visited.add(start);
        HashMap<Integer,Integer> distances=new HashMap<>();
        distances.put(start,0);
        Pair max=new Pair(0,0);
        while (!neighbours.isEmpty())
        {
            int visting=neighbours.poll();
            for(Pair vertex:graph.get(visting))
            {
                if (!visited.contains(vertex.vertex)) {
                    if(!distances.containsKey(vertex.vertex))
                    {
                        distances.put(vertex.vertex,vertex.weight+distances.get(visting));
                        if(distances.get(vertex.vertex)>max.weight)
                        {
                            max.vertex=vertex.vertex;
                            max.weight=distances.get(vertex.vertex);
                        }
                    }
                    visited.add(vertex.vertex);
                    neighbours.add(vertex.vertex);
                }

            }
        }
//        debug(distances);
        return max;
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
        int vertex;
        int weight;

        public Pair(int u, int v) {
            this.vertex = u;
            this.weight = v;
        }


        public int hashCode() {
            int hu = (int) (vertex ^ (vertex >>> 32));
            int hv = (int) (weight ^ (weight >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return vertex == other.vertex && weight == other.weight;
        }

        public int compareTo(Pair other) {
            return Integer.compare(vertex, other.vertex) != 0 ? Integer.compare(vertex, other.vertex) : Integer.compare(weight, other.weight);
        }

        public String toString() {
            return "[vertex=" + vertex + ", weight=" + weight + "]";
        }
    }
    //--------------------------------------------------------
}

