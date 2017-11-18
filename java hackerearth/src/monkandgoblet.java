/**
 * Created by Chirag on 27-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class monkandgoblet {
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
        int q=sc.nextInt();
        Deque<Pair> students=new ArrayDeque<>();

        while(q-->0)
        {
            String operation[]=sc.nextLine().split(" ");
            if(operation[0].equals("E"))
            {
                long school=Long.parseLong(operation[1]);
                long rollno=Long.parseLong(operation[2]);
                if(students.isEmpty())
                    students.add(new Pair(school,rollno));
                else
                  {
                      Deque<Pair> removedelements=new ArrayDeque<>();
                      boolean schoolexists=false;
                      while (!students.isEmpty())
                      {
                          Pair element=students.peekLast();
                          if(element.u==school)
                          {
                              schoolexists=true;
                              break;
                          }
                          removedelements.add(students.removeLast());
                      }
                      if(schoolexists)
                      {
                          students.addLast(new Pair(school,rollno));
                          while (!removedelements.isEmpty())
                              students.addLast(removedelements.removeLast());
                      }
                      else
                      {
                          for(Pair student:removedelements)
                          {
                              students.addFirst(student);
                          }
                          students.addLast(new Pair(school,rollno));
                      }



                  }
                }
                else
            {
                Pair removedstudent=students.removeFirst();
                out.println(removedstudent.u + " " + removedstudent.v);
            }
           /* for(Iterator descItr = students.descendingIterator();descItr.hasNext();) {
                System.out.println(descItr.next());
            }
            System.out.println();*/
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

