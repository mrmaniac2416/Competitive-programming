/**
 * Created by Chirag on 05-07-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class ScoringInExam {
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
        int noOfQuestions=sc.nextInt();
        int noOfQueries=sc.nextInt();
        int times[]=sc.nextIntArray(noOfQuestions);
        int scores[]=sc.nextIntArray(noOfQuestions);
        Pair questionInfo[]=new Pair[noOfQuestions];
        for(int i=0;i<noOfQuestions;i++)
        {
            questionInfo[i]=new Pair(scores[i],times[i]);
        }
        long timeSum[]=new long[noOfQuestions];
        Arrays.sort(questionInfo);
        timeSum[0]=questionInfo[0].time;
        for(int i=1;i<noOfQuestions;i++)
        {
            timeSum[i]=timeSum[i-1]+questionInfo[i].time;
        }
        while (noOfQueries-->0)
        {
            int k=sc.nextInt();
            out.println(timeSum[k-1]);
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
        int score;
        int time;

        public Pair(int s,int t) {
            this.score = s;
            this.time = t;
        }


        public int hashCode() {
            int hu = (int) (score ^ (score >>> 32));
            int hv = (int) (time ^ (time >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return score == other.score && time == other.time;
        }

        public int compareTo(Pair other) {
            return -Integer.compare(score, other.score);
        }

        public String toString() {
            return "[u=" + score + ", v=" + time + "]";
        }
    }
    //--------------------------------------------------------
}

