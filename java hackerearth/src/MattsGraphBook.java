/**
 * Created by Chirag on 25-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class MattsGraphBook {
    public static int noOfVisited=0;
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
        int noOfNodes=sc.nextInt();
        int noOfEdges=sc.nextInt();
        HashSet<Integer> vertexList=new HashSet<>();
        HashSet<Pair> edgeList=new HashSet<>();
        for(int i=0;i<noOfNodes;i++)
            vertexList.add(i);
        for(int i=1;i<=noOfEdges;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            edgeList.add(new Pair(start,end));
        }
//        debug(vertexList);
//        debug(edgeList);
        int toBeRemoved=sc.nextInt();
        vertexList.remove(toBeRemoved);
        HashSet<Pair> newEdgeList=new HashSet<>();
        for(Pair edge:edgeList)
        {
            if(!(edge.u==toBeRemoved || edge.v==toBeRemoved))
                newEdgeList.add(edge);
        }
        edgeList=newEdgeList;
//        debug(vertexList);
//        debug(edgeList);

        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        for(int vertex:vertexList)
            graph.put(vertex,new HashSet<>());
        for(Pair edge:edgeList)
        {
            graph.get(edge.u).add(edge.v);
            graph.get(edge.v).add(edge.u);
        }
        HashSet<Integer> visited=new HashSet<>();
        int start=vertexList.iterator().next();
        dfs(graph,start,visited);
        if(noOfVisited==vertexList.size())
        {
            System.out.println("Connected");
        }
        else
            System.out.println("Not Connected");


        //The Code ends here
        out.close();
    }


    static void dfs(HashMap<Integer,HashSet<Integer>> graph,int start,HashSet<Integer> visited)
    {
        visited.add(start);
        noOfVisited++;

        for(int vertex:graph.get(start))
        {
            if(!visited.contains(vertex))
                dfs(graph,vertex,visited);
        }
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

