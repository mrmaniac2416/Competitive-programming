/**
 * Created by Chirag on 08-07-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class cm31 {
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
        HashMap<Integer,HashSet<Pair>> graph=new HashMap<>();
        for(int i=1;i<=noOfNodes;i++)
            graph.put(i,new HashSet<>());
        for(int i=1;i<=noOfEdges;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            int weight=sc.nextInt();
            graph.get(start).add(new Pair(end,weight));
        }
        int distances[]=new int[noOfNodes+1];
        int parents[]=new int[noOfNodes+1];
        int source=1;
        dijkstra(graph,distances,source,parents);
        for(int i=2;i<=noOfNodes;i++)
            out.print(distances[i] + " ");


        //The Code ends here
        out.close();
    }

    static void dijkstra(HashMap<Integer,HashSet<Pair>> graph,int distances[],int source,int parent[])
    {
        PriorityQueue<Pair> pq=new PriorityQueue<>();
        for(int i=1;i<=graph.size();i++)
        {
            distances[i]=(int)(1e9);
        }
        distances[source]=0;
        pq.add(new Pair(source,0));
        parent[source]=source;
        HashSet<Integer> visited=new HashSet<>();


        while (!pq.isEmpty())
        {
//        debug(pq);
            int vertexToBeVisited=(int)pq.poll().vertex;
            visited.add(vertexToBeVisited);
            for(Pair vertex:graph.get(vertexToBeVisited))
            {
                if(distances[vertexToBeVisited]!=(int)(1e9)&& distances[vertex.vertex]>distances[vertexToBeVisited]+vertex.weight)
                {
                    distances[(int)vertex.vertex]= (int) (distances[vertexToBeVisited]+vertex.weight);
                    parent[(int)vertex.vertex]=vertexToBeVisited;
                    if(!visited.contains(vertex.vertex))
                    pq.add(new Pair(vertex.vertex,distances[vertex.vertex]));

                }
            }
        }
    }



    public static class Pair implements Comparable<Pair> {
        int vertex;
        int weight;

        public Pair(int  vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
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
            return Integer.compare(weight, other.weight) != 0 ? Integer.compare(weight, other.weight) : Integer.compare(vertex, other.vertex);
        }

        public String toString() {
            return "[vertex=" + vertex + ", weight=" + weight + "]";
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


    //--------------------------------------------------------
}

