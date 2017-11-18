/**
 * Created by Chirag on 22-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class GameOfBots {
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
        int t=sc.nextInt();
        while (t-->0)
        {
            String states[]=sc.nextLine().split(" ");
            String initialState=states[0];
            String finalState=states[1];
            ArrayList<Node> intialStates=new ArrayList<>();
            ArrayList<Node> finalStates=new ArrayList<>();
            int noOfLeftAOfInitialState=0;
            int noOfLeftBOfInitialState=0;
            int noOfLeftAOfFinalState=0;
            int noOfLeftBOfFinalState=0;
            int totalNoOfAOfInitalState=0;
            int totalNoOfAOfFinalState=0;
            int totalNoOfBOfInitalState=0;
            int totalNoOfBOfFinalState=0;
            for(int i=0;i<initialState.length();i++)
            {
                if(initialState.charAt(i)=='A')
                    totalNoOfAOfInitalState++;
                if(initialState.charAt(i)=='B')
                    totalNoOfBOfInitalState++;
                if(finalState.charAt(i)=='A')
                    totalNoOfAOfFinalState++;
                if(finalState.charAt(i)=='B')
                    totalNoOfBOfFinalState++;
            }

            for(int i=0;i<initialState.length();i++)
            {
                if(initialState.charAt(i)=='A' || initialState.charAt(i)=='B')
                {
                    if(initialState.charAt(i)=='A')
                    {
                        noOfLeftAOfInitialState++;
                        int Aright=totalNoOfAOfInitalState-noOfLeftAOfInitialState;
                        int Bright=totalNoOfBOfInitalState-noOfLeftBOfInitialState;
                        intialStates.add(new Node('A',noOfLeftAOfInitialState,noOfLeftBOfInitialState,Aright,Bright));
                    }
                    if(initialState.charAt(i)=='B')
                    {
                        noOfLeftBOfInitialState++;
                        int Aright=totalNoOfAOfInitalState-noOfLeftAOfInitialState;
                        int Bright=totalNoOfBOfInitalState-noOfLeftBOfInitialState;
                        intialStates.add(new Node('B',noOfLeftAOfInitialState,noOfLeftBOfInitialState,Aright,Bright));
                    }
                }
                if(finalState.charAt(i)=='A' || finalState.charAt(i)=='B')
                {
                    if(finalState.charAt(i)=='A')
                    {
                        noOfLeftAOfFinalState++;
                        int Aright=totalNoOfAOfFinalState-noOfLeftAOfFinalState;
                        int Bright=totalNoOfBOfFinalState-noOfLeftBOfFinalState;
                        finalStates.add(new Node('A',noOfLeftAOfFinalState,noOfLeftBOfFinalState,Aright,Bright));
                    }
                    if(finalState.charAt(i)=='B')
                    {
                        noOfLeftBOfFinalState++;
                        int Aright=totalNoOfAOfFinalState-noOfLeftAOfFinalState;
                        int Bright=totalNoOfBOfFinalState-noOfLeftBOfFinalState;
                        finalStates.add(new Node('B',noOfLeftAOfFinalState,noOfLeftBOfFinalState,Aright,Bright));

                    }
                }
            }
            boolean allEqual=true;
            for(int i=0;i<intialStates.size();i++)
            {
                if(!intialStates.get(i).equals(finalStates.get(i)))
                {
                    allEqual=false;
                    break;
                }

            }
            out.println(allEqual ? "Yes" : "No");




        }


        //The Code ends here
        out.close();
    }

    static class Node{
        char c;
        int Aleft;
        int Bleft;
        int Aright;
        int Bright;

        Node(char c,int Aleft,int Bleft,int Aright,int Bright)
        {
            this.c=c;
            this.Aleft=Aleft;
            this.Bleft=Bleft;
            this.Aright=Aright;
            this.Bright=Bright;
        }
        public boolean equals(Object o) {
            Node other = (Node) o;
            return c == other.c && Aleft == other.Aleft && Bleft==other.Bleft && Aright==other.Aright && Bright==other.Bright;
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

