/**
 * Created by Chirag on 15-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class CityAndSoldiers {
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
        int noOfSoldiers=sc.nextInt();
        int noOfQueries=sc.nextInt();
        DisjointSet ds=new DisjointSet();
        for(int i=1;i<=noOfSoldiers;i++)
            ds.makeSet(i);
        while (noOfQueries-->0)
        {
            int type=sc.nextInt();
            if(type==1)
            {
                int n1=sc.nextInt();
                int n2=sc.nextInt();
                ds.union(n1,n2);
              /*  if(n1==12645 && n2==29664)
                {
                    System.out.println(type + " " + ds.map.get(12645).parent.data + " " + ds.map.get(29664).parent.data);
                }*/
            }
            if(type==2)
            {
                int n=sc.nextInt();
                ds.makeLeader(n);
              /*  if(n==29664 || n==12645)
                    System.out.println(type + " " + ds.map.get(n).parent.data);*/
            }
            if(type==3)
            {
                int n=sc.nextInt();
                System.out.println(ds.findSet(n).data);
               /* if(n==12645)
                {
                    System.out.println(type+ " " +ds.map.get(12645).parent.data);
                    break;
                }*/
            }

        }


        //The Code ends here
        out.close();
    }

    public static class DisjointSet {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        class Node {
            int data;
            Node parent;

            Node(int data) {
                this.data = data;
                this.parent = this;
            }
        }

        void makeSet(int data) {
            map.put(data, new Node(data));
        }

        Node findSet(int data) {
            return findSet(map.get(data));
        }

        boolean isConnected(int d1,int d2)
        {
            return findSet(d1)==findSet(d2);
        }

        Node findSet(Node node)
        {
            Node parent=node.parent;
            if(parent==node)
                return parent;
            node.parent=findSet(node.parent);
            return node.parent;
        }

        void makeLeader(int data)
        {
            Node n=map.get(data);
            Node prevLeader=findSet(data);
            prevLeader.parent=n;
            n.parent=n;
        }

        void union(int data1,int data2)
        {
            Node d1=map.get(data1);
            Node d2=map.get(data2);


            Node p1=findSet(d1);
            Node p2=findSet(d2);

            if(p1.data==p2.data)
                return;

/*
            if(data1==12645 && data2==29664)
            {

                while (d1.parent.data!= d1.data)
                {
                    System.out.print(d1.data + " ");
                    d1=d1.parent;
                }
                System.out.println();
                System.out.println("union");
                System.out.println(d1.data + " " + d2.data);
                System.out.println(d1.parent.data + " " + d2.parent.data);
                System.out.println(p1.data + " " + p2.data);
                System.out.println(p1.parent.data + " " + p2.parent.data);
            }
*/
//            if(data1==12645 && data2==29664) {
                p1.parent=p2;
//                System.out.println(p1.parent.data + " " + p2.parent.data);
//            }
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

