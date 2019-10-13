/**
 * Created by Chirag on 15-12-2017.
 * DA-IICT (B.tech 3rd year)
 */

import java.io.*;
import java.util.*;


public class NephranRiddle {
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
        String f0="What are you doing at the end of the world? Are you busy? Will you save us?";
        String s1="What are you doing while sending \"";
        String s2="\"? Are you busy? Will you send \"";
        String s3="\"?";
        long length[]=new long[56];
        length[0]=f0.length();
       /* debug(f0,s1,s2,s3);
        debug(s1,s1.charAt(0),s1.charAt(1));*/
        for(int i=1;i<length.length;i++)
        {
            length[i]=s1.length()+2*length[i-1]+s2.length()+s3.length();
        }
//        debug(s1+f0+s2+f0+s3);
//      debug(length);
        String f1=s1+f0+s2+f0+s3;
      /*  debug(length);
        debug(f0.charAt(68),f1.charAt(193),f1.charAt(138),f0.charAt(46),f1.charAt(65));
        debug(s1.length(),s2.length(),s2.length());*/
        int q=sc.nextInt();
        while (q-->0)
        {
            int n=sc.nextInt();
            long k=sc.nextLong();
            if(n>=length.length)
            {
               System.out.print(ans(length,s1.length(),s2.length(),s3.length(),n,k,s1,s2,s3,f0));
            }

          else if(k>length[n])
                System.out.print(".");
            else
                System.out.print(ans(length,s1.length(),s2.length(),s3.length(),n,k,s1,s2,s3,f0));
        }


        //The Code ends here
        out.close();
    }

  public static  char ans(long length[],int s1Len,int s2Len,int s3Len,int n,long k,String s1,String s2,String s3,String f0)
    {
//        debug(s1Len,s2Len,s3Len,n,k);
        if(n==0)
        {
//            System.out.println("1");
            return f0.charAt((int)(k-1));
        }
        else if(k<=s1Len)
        {
//            System.out.println("2");
            return s1.charAt((int)(k-1));
        }
        else if(n>length.length)
        {
//            System.out.println("3");
            return ans(length,s1Len,s2Len,s3Len,n-1,k-s1Len,s1,s2,s3,f0);
        }
//        debug(k,s1Len,s1Len+length[n-1],s1Len+length[n-1]+s2Len,s1Len+2*length[n-1]+s2Len,s1Len+2*length[n-1]+s2Len+s3Len);
        if(k>s1Len && k<=(s1Len+length[n-1]))
        {
//            System.out.println("4");
            return ans(length,s1Len,s2Len,s3Len,n-1,k-s1Len,s1,s2,s3,f0);
        }
        else if(k>(s1Len+length[n-1]) && k<=(s1Len+length[n-1]+s2Len))
        {
//            System.out.println("5");
            return s2.charAt((int)(k-s1Len-length[n-1]-1));
        }
        else if(k>(s1Len+length[n-1]+s2Len) && k<=(s1Len+2*length[n-1]+s2Len))
        {
//            System.out.println("6");
            return ans(length,s1Len,s2Len,s3Len,n-1,k-s1Len-length[n-1]-s2Len,s1,s2,s3,f0);
        }
        else
        {
//            System.out.println("7");
            return s3.charAt((int)(k-s1Len-2*length[n-1]-s2Len-1));
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

        char nextCharacter() {
            return next().charAt(0);
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


    // Different other methods

    public static long pow(long n, long p, long mod) {
        if (p == 0)
            return 1;
        if (p == 1)
            return n % mod;
        if (p % 2 == 0) {
            long temp = pow(n, p / 2, mod);
            return (temp * temp) % mod;
        } else {
            long temp = pow(n, p / 2, mod);
            temp = (temp * temp) % mod;
            return (temp * n) % mod;

        }
    }

    public static long pow(long n, long p) {
        if (p == 0)
            return 1;
        if (p == 1)
            return n;
        if (p % 2 == 0) {
            long temp = pow(n, p / 2);
            return (temp * temp);
        } else {
            long temp = pow(n, p / 2);
            temp = (temp * temp);
            return (temp * n);

        }
    }

    public static long gcd(long x, long y) {
        if (x == 0)
            return y;
        else
            return gcd(y % x, x);
    }

    static long modInverse(long a, long m) {
        long m0 = m, t, q;
        long x0 = 0, x1 = 1;

        if (m == 1)
            return 0;

        while (a > 1) {
            // q is quotient
            q = a / m;

            t = m;

            // m is remainder now, process
            // same as Euclid's algo
            m = a % m;
            a = t;

            t = x0;

            x0 = x1 - q * x0;

            x1 = t;
        }

        // Make x1 positive
        if (x1 < 0)
            x1 += m0;

        return x1;
    }

    public static boolean isPrime(int n) {
        if (n <= 1)
            return false;
        if (n <= 3)
            return true;

        if (n % 2 == 0 || n % 3 == 0)
            return false;

        for (int i = 5; i * i <= n; i = i + 6)
            if (n % i == 0 || n % (i + 2) == 0)
                return false;

        return true;
    }

    public static class DisjointSet {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();

        class Node {
            int data;
            int rank;
            Node parent;

            Node(int data) {
                this.data = data;
                this.rank = 0;
                this.parent = this;
            }
        }

        void makeSet(int data) {
            map.put(data, new Node(data));
        }

        Node findSet(int data) {
            return findSet(map.get(data));
        }

        boolean isConnected(int d1, int d2) {
            return findSet(d1) == findSet(d2);
        }

        Node findSet(Node node) {
            Node parent = node.parent;
            if (parent == node)
                return parent;
            node.parent = findSet(node.parent);
            return node.parent;
        }

        void union(int data1, int data2) {
            Node d1 = map.get(data1);
            Node d2 = map.get(data2);

            Node p1 = findSet(d1);
            Node p2 = findSet(d2);

            if (p1.data == p2.data)
                return;

            if (p1.rank >= p2.rank) {
                p1.rank = (p1.rank == p2.rank) ? p1.rank + 1 : p1.rank;
                p2.parent = p1;
            } else {
                p1.parent = p2;
            }
        }

    }


}

