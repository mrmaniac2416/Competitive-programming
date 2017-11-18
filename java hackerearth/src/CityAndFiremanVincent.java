/**
 * Created by Chirag on 15-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class CityAndFiremanVincent {
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
        int mod=1000000007;
        int noOfCities=sc.nextInt();
        int[] riskFactorArray=new int[noOfCities+1];
        DisjointSet ds=new DisjointSet();
        for(int i=1;i<=noOfCities;i++) {
            riskFactorArray[i] = sc.nextInt();
            ds.makeSet(i,riskFactorArray[i]);
        }
        int noOfPaths=sc.nextInt();
        while (noOfPaths-->0)
        {
            int c1=sc.nextInt();
            int c2=sc.nextInt();
          /*  int riskFactor=ds.map.get(c1).riskFactorPair.riskFactor;
            int count=ds.map.get(c1).riskFactorPair.count;
            System.out.println(c1 + " " +  riskFactor + " " + count);
            riskFactor=ds.map.get(c2).riskFactorPair.riskFactor;
            count=ds.map.get(c2).riskFactorPair.count;
            System.out.println(c2 + " " +  riskFactor + " " + count);*/
            ds.union(c1,c2);
         /*   riskFactor=ds.map.get(c1).riskFactorPair.riskFactor;
            count=ds.map.get(c1).riskFactorPair.count;
            System.out.println(c1 + " " +  riskFactor + " " + count);
            riskFactor=ds.map.get(c2).riskFactorPair.riskFactor;
            count=ds.map.get(c2).riskFactorPair.count;
            System.out.println(c2 + " " +  riskFactor + " " + count);*/

//            System.out.println();
        }
        long ans=1;
        for(int i=1;i<=noOfCities;i++)
        {
            int riskFactor=ds.map.get(i).riskFactorPair.riskFactor;
            int count=ds.map.get(i).riskFactorPair.count;
//            System.out.println(i + " " +  riskFactor + " " + count);
            if(riskFactor==0 && count==0)
              continue;
            ans=ans*count;
            ans=ans%mod;
        }
        System.out.println(ans);




        //The Code ends here
        out.close();
    }


    public static class DisjointSet {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        class Node {
            int data;
            int rank;
            Node parent;
            Pair riskFactorPair;
;
            Node(int data,int riskFactor) {
                this.data = data;
                this.rank = 0;
                this.parent = this;
                riskFactorPair=new Pair(riskFactor,1);
            }
        }

        void makeSet(int data,int riskFactor) {
            map.put(data, new Node(data,riskFactor));
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

                if(p1.riskFactorPair.riskFactor>p2.riskFactorPair.riskFactor)
                {
                    p1.riskFactorPair.riskFactor=p2.riskFactorPair.riskFactor;
                    p1.riskFactorPair.count=p2.riskFactorPair.count;
                }
                else if(p1.riskFactorPair.riskFactor==p2.riskFactorPair.riskFactor)
                    p1.riskFactorPair.count=p1.riskFactorPair.count+p2.riskFactorPair.count;
                p2.riskFactorPair.riskFactor=0;
                p2.riskFactorPair.count=0;
            }
            else
            {
                p1.parent=p2;
                if(p2.riskFactorPair.riskFactor>p1.riskFactorPair.riskFactor)
                {
                    p2.riskFactorPair.riskFactor=p1.riskFactorPair.riskFactor;
                    p2.riskFactorPair.count=p1.riskFactorPair.count;
                }
                else if(p1.riskFactorPair.riskFactor==p2.riskFactorPair.riskFactor)
                    p2.riskFactorPair.count=p1.riskFactorPair.count+p2.riskFactorPair.count;
                p1.riskFactorPair.riskFactor=0;
                p1.riskFactorPair.count=0;
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
        int riskFactor;
        int count;

        public Pair(int u, int v) {
            this.riskFactor = u;
            this.count = v;
        }


        public int hashCode() {
            int hu = (int) (riskFactor ^ (riskFactor >>> 32));
            int hv = (int) (count ^ (count >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return riskFactor == other.riskFactor && count == other.count;
        }

        public int compareTo(Pair other) {
            return Integer.compare(riskFactor, other.riskFactor) != 0 ? Integer.compare(riskFactor, other.riskFactor) : Integer.compare(count, other.count);
        }

        public String toString() {
            return "[riskfactor=" + riskFactor + ", count=" + count + "]";
        }
    }
    //--------------------------------------------------------
}

