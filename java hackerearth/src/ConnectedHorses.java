/**
 * Created by Chirag on 23-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class ConnectedHorses {
    public static int mod=(int)(1e9+7);
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
            int n=sc.nextInt();
            int m=sc.nextInt();
            int q=sc.nextInt();
            DisjointSet ds=new DisjointSet();
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                    ds.makeSet(i,j);
            }
//            debug(ds.map);

          /*  for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    System.out.println(ds.findSet(new Pair(i,j)));
                }
            }*/
            HashSet<Pair> horsePositions=new HashSet<>();
            long factorial[]=pre_calculate();
            for(int i=0;i<q;i++)
            {
                int x=sc.nextInt();
                int y=sc.nextInt();
                horsePositions.add(new Pair(x,y));
            }
            for(Pair postion:horsePositions)
            {
                int x=postion.x;
                int y=postion.y;
                for(int j=-2;j<=2;j++)
                {
                    for(int k=-2;k<=2;k++)
                    {
                        if (horsePositions.contains(new Pair(x+j,y+k)))
                        {
                            if(j!=0 && k!=0 && Math.abs(j)!= Math.abs(k))
                            {
                                if(x+j>0 && x+j<=n && y+k>0 && y+k<=m)

                                {
//                                    System.out.println("unioned" + new Pair(x,y) + " " + new Pair(x+j,y+k));
                                    ds.union(new Pair(x,y),new Pair(x+j,y+k));
                                }
                              /*  if(x+j>0 && x+j<=n && y+k>0 && y+k<=m)
                                    System.out.println((x+j) + " " + (y+k));*/
                            }
                        }
                    }
                }
            }
//            System.out.println("heloo");
            long ans=1;
         /*   for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {*//*
                    if(ds.map.get(new Pair(i,j)).size!=0)
                        ans=ans*modFact(ds.map.get(new Pair(i,j)).size,mod)%mod;*//*
                    System.out.print(ds.map.get(new Pair(i,j)).size + " ");
                }
                System.out.println();
            }*/
            for(int i=1;i<=n;i++)
            {
                for(int j=1;j<=m;j++)
                {
                    if(ds.map.get(new Pair(i,j)).size!=0)
                        ans=ans*factorial[ds.map.get(new Pair(i,j)).size]%mod;
//                    System.out.print(ds.findSet(ds.map.get(new Pair(i,j))) + " ");
                }
//                System.out.println();
            }
            out.println(ans);
        }



        //The Code ends here
        out.close();
    }

    public static class DisjointSet {
        HashMap<Pair, Node> map = new HashMap<>();

        class Node {
            Pair coordinate;
            int rank;
            Node parent;
            int size=0;

            Node(int x,int y) {
                this.coordinate = new Pair(x,y);
                this.rank = 0;
                this.parent = this;
                this.size=1;
            }

            public String toString() {
                return "  coordinate " + coordinate.toString() + " parent " + parent.coordinate.toString() + " ";
            }
        }

        void makeSet(int x,int y) {
            map.put(new Pair(x,y), new Node(x,y));
        }

        Node findSet(Pair data) {
            return findSet(map.get(data));
        }

        boolean isConnected(Pair d1,Pair d2)
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

        void union(Pair data1,Pair data2)
        {
            Node d1=map.get(data1);
            Node d2=map.get(data2);

            Node p1=findSet(d1);
            Node p2=findSet(d2);


            if(p1.coordinate.equals(p2.coordinate))
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

   public  static  long[] pre_calculate(){       // calculating factorial
        long []factorial=new long[(int)1e6+1];
        factorial[0] = 1;
        for(int i = 1; i <= 1e6; i++){
            factorial[i] = (factorial[i - 1] * i) % mod;
        }
        return factorial;
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
        int x;
        int y;

        public Pair(int x, int  y) {
            this.x = x;
            this.y = y;
        }


        public int hashCode() {
            int hu = (int) (x ^ (x >>> 32));
            int hv = (int) (y ^ (y >>> 32));
            return 31 * hu + hv;
        }

        public boolean equals(Object o) {
            Pair other = (Pair) o;
            return x == other.x && y == other.y;
        }

        public int compareTo(Pair other) {
            return Integer.compare(x, other.x) != 0 ? Integer.compare(x, other.x) : Integer.compare(y, other.y);
        }

        public String toString() {
            return "[x=" + x + ", y=" + y + "]";
        }
    }
    //--------------------------------------------------------
}

