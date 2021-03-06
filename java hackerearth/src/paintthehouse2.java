/**
 * Created by Chirag on 14-02-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class paintthehouse2 {
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
        long d=sc.nextLong();
        Worker workers[]=new Worker[n];
        for(int i=0;i<n;i++)
        {
            int t=sc.nextInt();
            int x=sc.nextInt();
            int y=sc.nextInt();
            workers[i]=new Worker(t,x,y);
        }
        Arrays.sort(workers);
        long areapainted=0;
        long bestrate=0;
        int prevtime=workers[0].time;
        long cost=0;
       /* for(int i=0;i<n;i++)
            out.println(workers[i]);*/
        for(int i=0;i<n;i++)
        {
            areapainted+=bestrate*(workers[i].time-prevtime);
//            out.print(areapainted);
            if (areapainted>=d)
                break;
            if(workers[i].rate>bestrate)
            {
                bestrate=workers[i].rate;
                cost+=workers[i].cost;
            }
            prevtime=workers[i].time;
        }
          out.println(cost);

        //The Code ends here
        out.close();
    }
    public static class Worker implements Comparable<Worker>{
        int time;
        int cost;
        int rate;

        Worker(int time,int cost,int rate)
        {
            this.time=time;
            this.cost=cost;
            this.rate=rate;
        }

        @Override
        public int compareTo(Worker o) {
            if(Integer.compare(this.time,o.time)==0)
            {
                if(Integer.compare(this.rate,o.rate)==0)
                {
                    return Integer.compare(this.cost,o.cost);
                }
                return -Integer.compare(this.rate,o.rate);
            }
            return Integer.compare(this.time,o.time);
        }
        public String toString(){
            return ("time " + this.time + " cost " + this.cost + " rate " +this.rate);
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

