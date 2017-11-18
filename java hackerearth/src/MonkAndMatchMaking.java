/**
 * Created by Chirag on 21-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class MonkAndMatchMaking {
    public static int prime=1;
//    public static int mod=(int)(1e9+7);
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
        String s=sc.nextLine();
        int preHash[]=new int[s.length()];
//        int suffHash[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            if(i==0)
                preHash[i]=s.charAt(i);
            else
            {
                preHash[i]=s.charAt(i)*(int)Math.pow(prime,i) + preHash[i-1];
            }
        }
     /*   for(int i=(s.length()-1);i>=0;i--)
        {
            if(i==(s.length()-1))
                suffHash[i]=s.charAt(i);
            else
                suffHash[i]=s.charAt(i)*(int)Math.pow(prime,s.length()-1-i)+suffHash[i+1];
        }*/
        int noOfQueries=sc.nextInt();
//        debug(preHash);
//        debug(suffHash);
        while (noOfQueries-->0)
        {
            int l1=sc.nextInt();
            int r1=sc.nextInt();
            int l2=sc.nextInt();
            int r2=sc.nextInt();
            l1--;
            r1--;
            l2--;
            r2--;
            int hashLR1=0;
            int hashLR2=0;
            if(l1==0)
                hashLR1=preHash[r1];
            else
                hashLR1=(preHash[r1]-preHash[l1-1])/(int)Math.pow(prime,l1);
            if(l2==0)
                hashLR2=preHash[r2];
            else
                hashLR2=(preHash[r2]-preHash[l2-1])/(int)Math.pow(prime,l2);
//            System.out.println(hashLR1 + " " + hashLR2);
            if(hashLR1==hashLR2)
                System.out.println("Yes");
            else
                System.out.println("No");
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

