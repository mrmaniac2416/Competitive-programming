/**
 * Created by Chirag on 25-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class PrisonBreak {
    public static int noOfPaths=0;
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
            int sizeOfPrison=sc.nextInt();
            int prison[][]=sc.nextInt2DArray(sizeOfPrison,sizeOfPrison);
            boolean visited[][]=new boolean[sizeOfPrison+1][sizeOfPrison+1];
            dfs(prison,sizeOfPrison,0,0,visited);
            out.println(noOfPaths);
            noOfPaths=0;

        }


        //The Code ends here
        out.close();
    }

    static void dfs(int prison[][],int sizeOfPrison,int x,int y,boolean visited[][])
    {
        if(x==(sizeOfPrison-1) && y==(sizeOfPrison-1))
        {
            noOfPaths++;
            return;
        }
        visited[x][y]=true;
//        debug(visited);
        for(int i=-1;i<=1;i++)
        {
            for(int j=-1;j<=1;j++)
            {
                if(!(i==0 && j==0) && (Math.abs(i)!=Math.abs(j)))
                {
                    try {
                        if(prison[x+i][y+j]==0 && !(visited[x+i][y+j]))
                        {
                            dfs(prison,sizeOfPrison,x+i,y+j,visited);
                            visited[x+i][y+j]=false;
                        }
                    }
                    catch (Exception e)
                    {

                    }
                }
            }
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

