/**
 * Created by Chirag on 27-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import javax.swing.text.html.HTMLDocument;
import java.io.*;
import java.util.*;


public class cinema {
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
        int language[]=new int[n+1];
        HashMap<Integer,Integer> languagedensity=new HashMap<>();
        for(int i=1;i<=n;i++)
        {
            language[i]=sc.nextInt();
            if(!languagedensity.containsKey(language[i]))
                languagedensity.put(language[i],1);
            else
                languagedensity.put(language[i],languagedensity.get(language[i])+1);
        }

       /* Set keys=languagedensity.keySet();
        Iterator it=keys.iterator();
        while (it.hasNext())
        {
            int key=(int)it.next();
            out.println(key + " " +languagedensity.get(key));
        }*/

        int m=sc.nextInt();
        int audio[]=new int[m+1];
        for(int i=1;i<=m;i++)
            audio[i]=sc.nextInt();
        int subtitle[]=new int[m+1];
        for(int i=1;i<=m;i++)
            subtitle[i]=sc.nextInt();
        int maxfullysatisfied=Integer.MIN_VALUE;
        int maxpartiallysatisfied=Integer.MIN_VALUE;
        int tobeshown=0;
        for(int i=1;i<=m;i++)
        {
            int fullysatisfied=languagedensity.get(audio[i])==null ? 0 : languagedensity.get(audio[i]) ;
            int partiallysatisfied=languagedensity.get(subtitle[i])==null ? 0 : languagedensity.get(subtitle[i]);
//            out.println(fullysatisfied + " " + partiallysatisfied);
            if(maxfullysatisfied==fullysatisfied && maxpartiallysatisfied<partiallysatisfied)
            {
                tobeshown=i;
                maxpartiallysatisfied=partiallysatisfied;
            }

            if (maxfullysatisfied<fullysatisfied)
            {
                maxpartiallysatisfied=partiallysatisfied;
                maxfullysatisfied=fullysatisfied;
                tobeshown=i;
            }
//            out.println(maxfullysatisfied + " " + maxpartiallysatisfied);

        }
//        out.println(Integer.MAX_VALUE>961884247);
        out.print(tobeshown);
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

