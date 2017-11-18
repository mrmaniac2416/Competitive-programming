/**
 * Created by Chirag on 06-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class numbergame {
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
        String str[]=sc.nextLine().split(" ");
        int n=Integer.parseInt(str[0]);
        int k=Integer.parseInt(str[1]);
        int x=Integer.parseInt(str[2]);
        int mod=1000000007;
        int a[]=sc.nextIntArray(n);
//      System.out.println("Done" + n + " " + k + " " + " " + x);
        int subset=(1<<n)-1;
//        System.out.println(subset);
        int ans=0;
        while(subset>0)
        {
            if(Integer.bitCount(subset)!=k)
            {
                subset--;
                continue;
            }

            int mask=1<<n-1;
            int counter=n-1;
//            System.out.println(Integer.toBinaryString(subset));
            ArrayList<Integer> set = new ArrayList<>();
            while(counter>=0)
            {
                if( (mask&subset)!=0)
                {
                    set.add(a[counter]);
                }
                mask=mask>>1;
                counter--;
//                System.out.println(counter);
            }
       /*     for(int element : set)
                System.out.print(element + " ");
            System.out.println();*/
            if(check(set,k,x))
            {
                ans++;
            }

            subset--;
        }
        System.out.println(ans%mod);
        //The Code ends here
        out.close();
    }

    public static boolean check(ArrayList<Integer> set,int k,int x)
    {
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        for(int element : set)
        {
            if(element>max)
                max=element;
            if(element<min)
                min=element;
        }
//        System.out.println(max + " " + min);
        if((max-min)<=x)
            return true;
        return false;
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

