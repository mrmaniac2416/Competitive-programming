/**
 * Created by Chirag on 02-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class MonkAndIQ {
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
        int noOfCourses=sc.nextInt();
        int noOfApplicants=sc.nextInt();
        int noOfAlreadyApplied=sc.nextInt();
        int []IQOfAlreadyApplied=new int[noOfAlreadyApplied+1];
        int []IQOfApplicants=new int[noOfApplicants+1];
        for(int i=1;i<=noOfAlreadyApplied;i++)
            IQOfAlreadyApplied[i]=sc.nextInt();
        for(int i=1;i<=noOfApplicants;i++)
            IQOfApplicants[i]=sc.nextInt();
        HashMap<Integer,NewPair> courseDetails=new HashMap<>();
        PriorityQueue<Pair> courseZfactor=new PriorityQueue<>();
        for(int i=1;i<=noOfCourses;i++)
            courseDetails.put(i,new NewPair(0,0,0));
        for(int i=1;i<=noOfAlreadyApplied;i++)
        {
            courseDetails.get(i).noOfStudents=1;
            courseDetails.get(i).IQ.u=IQOfAlreadyApplied[i];
        }
        for(int i=1;i<=noOfCourses;i++)
        {
            int z=courseDetails.get(i).noOfStudents*(courseDetails.get(i).IQ.u + courseDetails.get(i).IQ.v);
            courseZfactor.add(new Pair(z,i));
        }
        /*debug(courseZfactor);
        debug(courseDetails);*/
        for(int i=1;i<=noOfApplicants;i++)
        {
            int courseAppliedTo=courseZfactor.peek().v;


            int secondLastIq=courseDetails.get(courseAppliedTo).IQ.u;
            courseDetails.get(courseAppliedTo).IQ.u=IQOfApplicants[i];
            courseDetails.get(courseAppliedTo).IQ.v=secondLastIq;
            courseDetails.get(courseAppliedTo).noOfStudents++;
            int newZ=courseDetails.get(courseAppliedTo).noOfStudents*(courseDetails.get(courseAppliedTo).IQ.u + courseDetails.get(courseAppliedTo).IQ.v);
            courseZfactor.poll();
            courseZfactor.add(new Pair(newZ,courseAppliedTo));
       /*     debug(courseZfactor);
            debug(courseDetails);
            System.out.println(newZ);*/
            System.out.print(courseAppliedTo + " ");
        }





        //The Code ends here
        out.close();
    }

    public static class NewPair{
        int noOfStudents;
        Pair IQ;
        NewPair(int noOfStudents,int iq1,int iq2)
        {
            this.noOfStudents=noOfStudents;
            IQ=new Pair(iq1,iq2);
        }
        public String toString() {
            return "[noOfStudents=" + noOfStudents +   ", IQ1= " + IQ.u + " IQ2= " + IQ.v  + "]";
        }
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
        int u;
        int v;

        public Pair(int u, int v) {
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
            return Integer.compare(u, other.u) != 0 ? Integer.compare(u, other.u) : Integer.compare(v, other.v);
        }

        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
    //--------------------------------------------------------
}

