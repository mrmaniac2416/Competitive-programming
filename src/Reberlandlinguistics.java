/**
 * Created by Chirag on 29-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class Reberlandlinguistics {
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
         StringBuilder str=new StringBuilder(sc.nextLine());
        TreeSet<String> suffix=new TreeSet<>();
        for(int rootsize=5;rootsize<=str.length();rootsize++)
        {
            StringBuilder suffixstring=new StringBuilder(str.substring(rootsize,str.length()));
            for(int twosused=0;twosused<=suffixstring.length()/2;twosused++)
            {
                int threesused=(suffixstring.length()-2*twosused)/3;
                if((2*twosused+3*threesused)==suffixstring.length())
                {
                    for(int start2=0;start2+2*twosused<=suffixstring.length();start2+=3)
                    {
                        boolean hasdupli=false;
                        HashSet<String> toadded=new HashSet<>();
                        for(int i=start2;i<start2+2*twosused;i+=2) {
                            String str2;
                            if (!toadded.contains(str2=suffixstring.substring(i,i+2)))
                            toadded.add(str2=suffixstring.substring(i, i + 2));
                            else
                                hasdupli=true;

//                            out.println("Adding "  + str2 + " in 1 when start2= " + start2 + " when i = " + i );
                        }
                        for(int i=0;i<start2;i+=3)
                        {
                            String str2;
                            if(hasdupli)
                                break;
                            if (!toadded.contains(str2=suffixstring.substring(i,i+3)))
                                toadded.add(suffixstring.substring(i, i + 3));
                            else
                                hasdupli=true;
//                            out.println("Adding "  + str2 + " in 2 when start2= " + start2 + " when i = " + i );
                        }
                        for(int i=start2+2*twosused;i<suffixstring.length();i+=3)
                        {
                            String str2;
                            if(hasdupli)
                                break;
                            if (!toadded.contains(str2=suffixstring.substring(i,i+3)))
                                toadded.add(suffixstring.substring(i, i + 3));
                            else
                                hasdupli=true;
//                            out.println("Adding "  + str2 + " in 3 when start2= " + start2 + " when i = " + i );
                        }
                        if(!hasdupli)
                        {
                            for(String element : toadded)
                                suffix.add(element);
                        }
                    }
                }
            }
        }
        out.println(suffix.size());
        Iterator it=suffix.iterator();
        while (it.hasNext())
        {
            out.print(it.next() + " ");
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

