/**
 * Created by Chirag on 31-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class ColorTheGraph {
    public static final int RED=1;
    public static final int BLUE=2;
    public static final int GREY=0;
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
            int m=sc.nextInt();
            HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
            HashSet<Integer> visited=new HashSet<>();
            int redno=0;
            int blueno=0;
            int ans=0;
            int color[]=new int[n+1];
            for(int i=1;i<=n;i++)
                graph.put(i,new HashSet<>());
            for(int i=1;i<=m;i++)
            {
                int start=sc.nextInt();
                int end=sc.nextInt();
                graph.get(start).add(end);
                graph.get(end).add(start);
            }
            Pair colourCount=new Pair(0,0);
            boolean isPossible=true;
            for(int i=1;i<=n;i++)
            {
                if(!visited.contains(i))
                {
                    colourCount=bfs(graph,0,0,visited,color,i);
                    redno=(int)colourCount.u;
                    blueno=(int)colourCount.v;
                    if(redno==-1 && blueno==-1)
                    {
                        out.println("NO");
                        isPossible=false;
                        break;
                    }

                    ans+=Math.max(redno,blueno);
                }
            }
            if(isPossible)
                out.println(ans);
        }


        //The Code ends here
        out.close();
    }


    public static Pair bfs(HashMap<Integer,HashSet<Integer>> graph,int redno,int blueno,HashSet<Integer> visited,int color[],int start)
    {
        Queue<Integer> neighbours=new ArrayDeque<>();
        visited.add(start);
        color[start]=RED;
        redno++;
        neighbours.add(start);
        while (!neighbours.isEmpty())
        {
            int parent=neighbours.poll();
            for(int vertex:graph.get(parent))
            {
                if(!visited.contains(vertex))
                {
                    if(color[parent]==RED)
                    {
                        color[vertex]=BLUE;
                        blueno++;
                    }
                    else
                    {
                        color[vertex]=RED;
                        redno++;
                    }
                    neighbours.add(vertex);
                    visited.add(vertex);
                }
                else
                {
                    if(color[parent]==color[vertex])
                        return new Pair(-1,-1);
                }
            }
        }
        return new Pair(redno,blueno);
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

