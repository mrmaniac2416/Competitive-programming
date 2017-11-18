/**
 * Created by Chirag on 08-03-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class junglerun {
    public static final int S=1;
    public static final int T=2;
    public static final int P=3;
    public static final int E=4;
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
        int a[][]=new int[n+1][n+1];
        Pair start=null,end = null;
        for(int i=1;i<=n;i++)
        {
            String str[]=sc.nextLine().split(" ");
            for(int j=1;j<=n;j++)
            {
                char element=str[j-1].charAt(0);
                if(element=='S')
                {
                    a[i][j]=S;
                    start=new Pair(i,j);
                }
                else if(element=='T')
                {
                    a[i][j]=T;
                }
                else if(element=='P')
                {
                    a[i][j]=P;

                }
                else
                {
                    a[i][j]=E;
                    end=new Pair(i,j);
                }
            }
//            out.print("wq");
        }
//          debug(a);
        out.print(bfs(a,start,end));






        //The Code ends here
        out.close();
    }

    public static int bfs(int a[][],Pair start,Pair end)
    {
        HashMap<Pair,Integer> distance=new HashMap<>();
        Queue<Pair> neighbours=new ArrayDeque<>();
        HashSet<Pair> visited=new HashSet<>();
        distance.put(start,0);
        neighbours.add(start);
        visited.add(start);
        while (!neighbours.isEmpty())
        {
            Pair visiting=neighbours.poll();
            if(a[visiting.u][visiting.v]==P || a[visiting.u][visiting.v]==E || a[visiting.u][visiting.v]==S) {
//                out.print("c1");
                Pair vertex[]=new Pair[4];
                vertex[0]=new Pair(visiting.u,visiting.v-1);
                vertex[1]=new Pair(visiting.u,visiting.v+1);
                vertex[2]=new Pair(visiting.u+1,visiting.v);
                vertex[3]=new Pair(visiting.u-1,visiting.v);


//                        out.print("c2");
                for (Pair p:vertex) {
                    if (!visited.contains(new Pair(p.u,p.v)))

                        {
                            try {
                                if (a[p.u][p.v]==P || a[p.u][p.v]==E) {
                                    neighbours.add(new Pair(p.u,p.v));
                                    distance.put(new Pair(p.u,p.v),distance.get(visiting)+1);
                                }
                            }
                            catch (Exception e)
                            {

                            }
                            visited.add(new Pair(p.u,p.v));
                        }
                }
//                        debug(distance);
                         if(visited.contains(end))
                             return distance.get(end);
                        }
                }



//        return distance.get(end);
        return 1;
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

