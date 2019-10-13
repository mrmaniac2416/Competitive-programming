/**
 * Created by Chirag on 07-12-2016.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class lookserryparry {
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
        int contacts[][]=new int[n][n];
        for(int i=0;i<n;i++)
        {
            String str=sc.nextLine();
            for(int j=0;j<n;j++)
                contacts[i][j]=Character.digit(str.charAt(j),10);
        }
        int prediction[]=sc.nextIntArray(n);
        int indegree[]=new int[n];
        int flag=0;

//        System.out.println("Input taken");
        HashSet<Integer> people=new HashSet<Integer>();
        for(int i=0;i<n;i++)
            people.add(i+1);
        long loopcount=0;
                for(int i=0;i<n && loopcount<10e6;i++,loopcount++)
                {
                    if(prediction[i]!=indegree(i,contacts,n))
                    {
                        continue;
                    }
                    else
                    {
                        for(int col=0;col<n;col++)
                        {
                                contacts[i][col]=0;

                        }
                        people.remove(i+1);
                        i=-1;

                    }

                }




        if(loopcount>=10e6)
            out.println("-1");
        else
        {
            out.println(people.size());
            Iterator<Integer> it =people.iterator();
            while(it.hasNext())
            {
                out.print(it.next() + " ");
            }

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

        public int[][] nextInt2DArray(int m,int n) {
            int[][] arr = new int[m][n];
            for (int i = 0; i < m; i++) {
                for(int j=0;j<n;j++)
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

    public static int indegree(int index,int contacts[][],int n)
    {
        int indegree=0;
        for(int row=0;row<n;row++) {
            indegree+= contacts[row][index];
        }
    return indegree;
    }


    //--------------------------------------------------------
}

