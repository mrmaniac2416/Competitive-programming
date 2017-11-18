/**
 * Created by Chirag on 27-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class monkandchamber {
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
        int x=sc.nextInt();
        ArrayList<Pair> spiders=new ArrayList<>(n);
        for(int i=0;i<n;i++)
        {
            int u=sc.nextInt();
            Pair p=new Pair(u,i);
            spiders.add(p);
        }
        Queue<Pair> spidersq=new LinkedList<>(spiders);
        int noofiterations=x;

        while(noofiterations-->0)
        {
            ArrayList<Pair> removedelements=new ArrayList<>();
            long max=Integer.MIN_VALUE;
            int tobeiterated=(x>spidersq.size() ? spidersq.size() : x);
            for(int i=0;i<tobeiterated;i++)
            {
                max=spidersq.peek().u>max ? spidersq.peek().u : max;
                removedelements.add(spidersq.poll());

            }
            long removedindex=0;
            for(int i=0;i<tobeiterated;i++)
            {
                if(removedelements.get(i).u==max)
                {
                    removedindex=removedelements.get(i).v;
                    removedelements.remove(i);
                    break;
                }
            }
            for(int i=0;i<removedelements.size();i++)
                spidersq.add(removedelements.get(i).u==0 ? new Pair(0,removedelements.get(i).v) : new Pair(removedelements.get(i).u-1,removedelements.get(i).v));

//            for(Pair element : spidersq)
//                out.print(element + " ");
//            out.println();
            out.print(removedindex+1 + " ");
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

