/**
 * Created by Chirag on 07-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import javafx.util.Pair;

import java.io.*;
import java.util.*;


public class wealthylandlord {
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
        int field[][]=new int[1001][1001];
        int cost[]=new int[n+1];
        long total=0;
        HashMap<Integer,Pair[]> farmerland=new HashMap<>();
        for(int i=0;i<n;i++)
        {
            int x1=sc.nextInt();
            int y1=sc.nextInt();
            farmerland.put(i+1,new Pair[2]);
            farmerland.get(i+1)[0]=new Pair(x1,y1);
            int x2=sc.nextInt();
            int y2=sc.nextInt();
            farmerland.get(i+1)[1]=new Pair(x2,y2);
            cost[i+1]=sc.nextInt();
            for(int j=x1;j<=x2;j++)
            {
                for(int k=y1;k<=y2;k++)
                {
                    field[j][k]++;
                }
            }
        }
        for(int i=1;i<=n;i++)
        {
            int x1=(int)farmerland.get(i)[0].u;
            int y1=(int)farmerland.get(i)[0].v;
            int x2=(int)farmerland.get(i)[1].u;
            int y2=(int)farmerland.get(i)[1].v;
            for(int j=x1;j<=x2;j++)
            {
                for(int k=y1;k<=y2;k++)
                {
                    if(field[j][k]>1)
                        total+=cost[i];
                }
            }


        }
       out.println(total);
    /*    for(int i=1;i<=6;i++)
        {
            for(int j=1;j<=6;j++)
                out.print("field [" + i + " ] " + "[ " + j + " ] "  + "=" + field[i][j] + " ");
            out.println();
        }*/

        //The Code ends here
        out.close();
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

