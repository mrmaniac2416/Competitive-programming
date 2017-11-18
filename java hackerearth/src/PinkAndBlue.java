/**
 * Created by Chirag on 06-05-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class PinkAndBlue {
    public static int BLUE=1;
    public static int PINK=2;
    public static boolean isPossible=true;
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
        int noOfStudent=sc.nextInt();
        int noOfFriendships=sc.nextInt();
        HashMap<Integer,HashSet<Integer>> graph=new HashMap<>();
        String []genderArray=sc.nextLine().split(" ");
        for(int i=1;i<=noOfStudent;i++)
            graph.put(i,new HashSet<>());
        for(int i=1;i<=noOfFriendships;i++)
        {
            int start=sc.nextInt();
            int end=sc.nextInt();
            graph.get(start).add(end);
            graph.get(end).add(start);
        }
        HashSet<Integer> visited=new HashSet<>();
        HashMap<Integer,Integer> colorsAssigned=new HashMap<>();
        dfs(graph,1,BLUE,visited,colorsAssigned);
        int noOfInversionsBlue=0;
        int noOfInversionsPink=0;
        if(isPossible)
        {
            for(int i=1;i<=noOfStudent;i++)
            {
                if(genderArray[i-1].equals("B") && colorsAssigned.get(i)==PINK)
                    noOfInversionsBlue++;
                if(genderArray[i-1].equals("G") && colorsAssigned.get(i)==BLUE)
                    noOfInversionsBlue++;
            }
            visited=new HashSet<>();
            colorsAssigned=new HashMap<>();
            dfs(graph,1,PINK,visited,colorsAssigned);

            for(int i=1;i<=noOfStudent;i++)
            {
                if(genderArray[i-1].equals("B") && colorsAssigned.get(i)==PINK)
                    noOfInversionsPink++;
                if(genderArray[i-1].equals("G") && colorsAssigned.get(i)==BLUE)
                    noOfInversionsPink++;
            }
            System.out.println(Math.min(noOfInversionsBlue,noOfInversionsPink));
        }
        else
            System.out.println("-1");





        //The Code ends here
        out.close();
    }

    static void dfs(HashMap<Integer,HashSet<Integer>> graph,int start,int currColor,HashSet<Integer> visited,HashMap<Integer,Integer> colorAssigned)
    {
        visited.add(start);
        colorAssigned.put(start,currColor);

        for(int vertex:graph.get(start))
        {
            if(!visited.contains(vertex))
            {
                if(currColor==BLUE)
                {
                    dfs(graph,vertex,PINK,visited,colorAssigned);
                }
                else
                    dfs(graph,vertex,BLUE,visited,colorAssigned);
            }
            else
            {
                if(currColor==colorAssigned.get(vertex))
                   isPossible=false;
            }
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

