/**
 * Created by Chirag on 26-12-2016.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class cm1 {
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

        //Storing primes
        int n=127;
        int primes[]=new int[n+1];

        for(int i=2;i<=Math.sqrt(n);i++)
        {
            for(int j=2;i*j<=n;j++)
            {
                primes[i*j]=-1;
            }
        }
//        System.out.println(primes[121]);
        for(int i=0;i<65;i++)
            primes[i]=-1;
        for(int i=91;i<97;i++)
            primes[i]=-1;

        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int length=sc.nextInt();
            String s=sc.nextLine();
            StringBuilder str=new StringBuilder(s);
            for(int j=0;j<length;j++)
            {
                int ascii=(int)str.charAt(j);
                int replacement=ascii;
                for(int k=0;;k++)
                {

                    if(ascii-k>=65) {
                        if (primes[ascii - k] == 0) {
                            replacement = ascii - k;
                            break;
                        }
                    }
                    if(ascii+k<=122) {
                        if (primes[ascii + k] == 0) {
                            replacement = ascii + k;
                            break;
                        }
                    }
                }
                str.setCharAt(j,(char)replacement);
            }
           out.println(str);
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

