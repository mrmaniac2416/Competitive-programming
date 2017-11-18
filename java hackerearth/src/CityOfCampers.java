/**
 * Created by Chirag on 15-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class CityOfCampers {
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
        int noOfCampers=sc.nextInt();
        int noOfQueries=sc.nextInt();
        DisjointSet ds=new DisjointSet();
        TreeSet<Pair> sizes=new TreeSet<>();
        for(int i=1;i<=noOfCampers;i++)
        {
            ds.makeSet(i);
            sizes.add(new Pair(1,i));
        }

        while (noOfQueries-->0)
        {
            int c1=sc.nextInt();
            int c2=sc.nextInt();
            if(ds.findSet(c1).data==ds.findSet(c2).data)
                continue;
            int size1=ds.map.get(ds.findSet(c1).data).size;
            int size2=ds.map.get(ds.findSet(c2).data).size;
//            debug(sizes);
            sizes.remove(new Pair(size1,ds.findSet(c1).data));
//            debug(sizes);
            sizes.remove(new Pair(size2,ds.findSet(c2).data));
//            debug(sizes);

            ds.union(c1,c2);
            int newSize=ds.findSet(c1).size;
//            System.out.println(newSize);
            sizes.add(new Pair(newSize,ds.findSet(c1).data));
            debug(sizes);
            System.out.println(sizes.last().size-sizes.first().size);
        }






        //The Code ends here
        out.close();
    }

   public static class Node {
        int data;
        int rank;
        Node parent;
        int size;

        Node(int data) {
            this.data = data;
            this.rank = 0;
            this.parent = this;
            this.size=1;
        }
    }

    public static class DisjointSet {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();



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

        void union(int data1,int data2)
        {
            Node d1=map.get(data1);
            Node d2=map.get(data2);

            Node p1=findSet(d1);
            Node p2=findSet(d2);

            if(p1.data==p2.data)
                return;

            if(p1.rank>=p2.rank)
            {
                p1.rank=(p1.rank==p2.rank) ? p1.rank+1 : p1.rank;
                p2.parent=p1;
                p1.size=p1.size+p2.size;
                p2.size=0;
            }
            else
            {
                p1.parent=p2;
                p2.size=p1.size+p2.size;
                p1.size=0;
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
        int size;
        int element;

        public Pair(int size, int element) {
            this.size = size;
            this.element = element;
        }


        public int hashCode() {
            int hu = (int) (size ^ (size >>> 32));
            int hv = (int) (element ^ (element >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return size == other.size && element == other.element;
        }

        public int compareTo(Pair other) {
            return Integer.compare(size, other.size) != 0 ? Integer.compare(size, other.size) : Integer.compare(element, other.element);
        }

        public String toString() {
            return "[size=" + size + ", element=" + element + "]";
        }
    }
    //--------------------------------------------------------
}

