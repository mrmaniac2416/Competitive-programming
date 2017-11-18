/**
 * Created by Chirag on 04-07-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class MissingSoldiers {
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
        Pair segments[]=new Pair[n];
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            int y=sc.nextInt();
            int d=sc.nextInt();
            segments[i]=new Pair(x,d+x);
        }
        Arrays.sort(segments);
//        debug(segments);
        int ans=segments[0].end-segments[0].start+1;
        int startBoundry=segments[0].start;
        int endBoundry=segments[0].end;
        for(int i=1;i<n;i++)
        {
            if(segments[i].start<=endBoundry && segments[i].end<=endBoundry)
            {
                continue;
            }
            if(segments[i].start <= endBoundry && segments[i].end>endBoundry)
            {
                ans+=segments[i].end-endBoundry;
                endBoundry=segments[i].end;
            }
            if(segments[i].start>endBoundry)
            {
                ans+=segments[i].end-segments[i].start+1;
                startBoundry=segments[i].start;
                endBoundry=segments[i].end;
            }
        }
        System.out.println(ans);


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

    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static class Pair implements Comparable<Pair> {
        int start;
        int end;

        public Pair(int u, int v) {
            this.start = u;
            this.end = v;
        }


        public int hashCode() {
            int hu = (int) (start ^ (start >>> 32));
            int hv = (int) (end ^ (end >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return start == other.start && end == other.end;
        }

        public int compareTo(Pair other) {
            return Integer.compare(start, other.start) != 0 ? Integer.compare(start, other.start) : Integer.compare(end, other.end);
        }

        public String toString() {
            return "[start=" + start + ", end=" + end + "]";
        }
    }
    //--------------------------------------------------------
}

