/**
 * Created by Chirag on 03-07-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class BennyAndSegments {
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
            int noOfRoads=sc.nextInt();
            int favouriteNumber=sc.nextInt();
            Pair roads[]=new Pair[noOfRoads];
            for(int i=0;i<noOfRoads;i++)
            {
                int start=sc.nextInt();
                int end=sc.nextInt();
                roads[i]=new Pair(start,end);
            }
            Arrays.sort(roads);
            boolean isPossible=false;
            for(int start=0;start<noOfRoads;start++) {
                int maxEnd = roads[start].start + favouriteNumber;
                int currEnd = roads[start].end;
                for (int j = start; j < noOfRoads; j++) {
                    if (roads[j].start <= currEnd && roads[j].end <= maxEnd) {
                        currEnd = Integer.max(currEnd, roads[j].end);
                    }
                }
                if (currEnd == maxEnd) {
                    isPossible = true;
                    break;
                }
            }
            System.out.println(isPossible ? "Yes" : "No");

        }


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
        int  end;

        public Pair(int start, int end) {
            this.start = start;
            this.end = end;
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
            return "[u=" + start + ", v=" + end + "]";
        }
    }
    //--------------------------------------------------------
}

