/**
 * Created by Chirag on 10-12-2016.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class pfastinc {
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
        int k=sc.nextInt();
        ArrayList<String> volunteers = new ArrayList<>();
        volunteers.add("0");
        for(int i=0;i<n;i++)
        {
            volunteers.add(sc.nextLine());
        }
        String pairs[][]=new String[k][2];
        for(int i=0;i<k;i++)
        {
            pairs[i][0]=sc.next();
            pairs[i][1]=sc.next();
        }
        ArrayList<ArrayList<Integer>> pair=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            pair.add(new ArrayList<Integer>());
        }
        for(int i=0;i<k;i++)
        {
            pair.get(i).add(volunteers.indexOf(pairs[i][0]));
            pair.get(i).add(volunteers.indexOf(pairs[i][1]));
        }
        ArrayList<Integer> teams=new ArrayList<>();
       /* for(ArrayList<Integer> p : pair)
        {
            for(int element : p)
            {
                out.print(element + " ");
           }
            out.println();
        }*/

//        out.print(1<<(pair.get(0).get(1)-1));
        for(int i=1;i< 1<<n;i++)
        {
            int flag=0;
             for(int j=0;j<k;j++)
             {
                 if((i & 1<<(pair.get(j).get(0)-1))!=0 && (i & 1<<(pair.get(j).get(1)-1))!=0 )
                 {
//                     out.print(i + " ");
                     flag=1;
                     break;
                 }
             }
             if(flag==0)
                 teams.add(i);

        }
//      for(int teamz : teams)
//           out.print(teamz + " ");
        int maxones=0;
        int maxno=0;
        for(int i : teams)
        {
            int ones=Integer.bitCount(i);
            if(ones > maxones)
            {
                maxones=ones;
                maxno=i;
            }
        }
        out.println(maxones);
        String str=Integer.toBinaryString(maxno);
//       out.print(str);
        ArrayList<String> team=new ArrayList<>();
        for(int i=str.length()-1;i>=0;i--)
        {
            if(str.charAt(i)=='1')
                team.add(volunteers.get(str.length()-1-i+1));
        }
        Collections.sort(team);
        for(String member : team)
            out.println(member);



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

