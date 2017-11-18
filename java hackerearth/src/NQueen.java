/**
 * Created by Chirag on 28-12-2016.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class NQueen {
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
        int board[][]=new int[n][n];
        nQueen(board,n,n);
        boolean flag=false;
        for(int row[]: board)
        {
            for(int element : row)
            {
                if(element!=0)
                {
                    flag=true;
                    break;
                }
            }
        }
        if (flag) {
            out.println("YES");
            for(int row[]: board)
            {
                for(int element : row)
                    out.print(element + " ");
                out.println();
            }
        }
        else
            out.println("NO");
        //The Code ends here
        out.close();
    }

    public static boolean isAttacked(int x,int y,int board[][],int n)
    {
//        Checking col
        for(int i=0;i<n;i++)
        {
            if(board[i][y]==1)
                return true;
        }
//        Checking row
        for(int j=0;j<n;j++)
        {
            if(board[x][j]==1)
                return true;
        }
//        Checking diagonal
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(board[i][j]==1) {
                    if ((i + j) == (x + y) || (i - j) == (x - y))
                        return true;
                }
            }
        }
        return false;
    }
    public static boolean nQueen(int board[][],int n,int n2)
    {
        if(n==0)
            return true;
        for(int i=0;i<n2;i++)
        {
            for(int j=0;j<n2;j++)
            {
                if(isAttacked(i,j,board,n2))
                {
                    continue;
                }
//                out.println("Changed" + i  + " " + j);
                board[i][j]=1;
//                out.println(isAttacked(2,1,board,n2));
                if(nQueen(board,n-1,n2))
                    return true;
                board[i][j]=0;
            }
        }
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

