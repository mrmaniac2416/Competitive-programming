/**
 * Created by Chirag on 20-05-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class TheSillySnail {
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
            HashMap<Integer, btNode> nodes=new HashMap<>();
            int noOfRelations=sc.nextInt();
            btNode root=new btNode(1);
            nodes.put(1,root);
            while (noOfRelations-->0)
            {
                int parent=sc.nextInt();
                btNode parentNode=nodes.get(parent);
                int leftChild=sc.nextInt();
                int rightChild=sc.nextInt();
//                out.println(parent + " " + leftChild + " " + rightChild);
                btNode leftNode=null,rightNode=null ;
//                out.print(parentNode.data + " ");
                if(leftChild!=0) {
                    leftNode=new btNode(leftChild);
                    parentNode.left = leftNode;
                    nodes.put(leftChild,leftNode);
//                    out.print(parentNode.left.data + " ");
                }
                if(rightChild!=0) {
                    rightNode = new btNode(rightChild);
                    parentNode.right = rightNode;
                    nodes.put(rightChild,rightNode);
//                    out.print(parentNode.right.data + " ");
                }


            }
//            debug(nodes);
//            out.println(root.left + " " + root.right);
            preOrder(root);
            out.println();
        }


        //The Code ends here
        out.close();
    }

    public static class btNode{
        int data;
        btNode left;
        btNode right;

        btNode(int data)
        {
            this.data=data;
        }

    }
    public static void preOrder(btNode root)
    {
        if(root!=null) {
            out.print(root.data + " ");
            preOrder(root.left);
            preOrder(root.right);
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

