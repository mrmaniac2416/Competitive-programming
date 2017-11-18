/**
 * Created by Chirag on 21-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class LongLong {
    public static int prime=31;
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
        String s=sc.nextLine();
        int low=0;
        int high=s.length();
        while (low<high)
        {
            int mid=(low+high+1)/2;
            if(matchedIndexes(mid,s))
                low=mid;
            else
                high=mid-1;
//            System.out.println(low + " " + high);
        }
        System.out.println(low);


        //The Code ends here
        out.close();
    }

    //define mod and prime in code..

    static int calculateHash(String s,int start,int end)
    {
        int ans=0;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            ans=ans+(s.charAt(i)*(int)Math.pow(prime,index));
            index++;
        }
        return ans;
    }

    static int rehash(String s,int start1,int end1,int start2,int end2,int hash1,int patternSize)
    {
        int newHash=hash1-s.charAt(start1);
        newHash=newHash/prime;
        newHash=newHash+(s.charAt(end2)*(int)Math.pow(prime,patternSize-1));
        newHash=newHash;
        return newHash;
    }
    static boolean isEqual(String s1,int start1,int end1,String s2,int start2,int end2,int patternSize)
    {
        for(int i=0;i<patternSize;i++)
        {
            if(s1.charAt(start1+i)!=s2.charAt(start2+i))
                return false;
        }
        return true;
    }

    static  boolean matchedIndexes(int patternLength,String inp) {
        int inpLength = inp.length();
        HashSet<Integer> hashes=new HashSet<>();
        int hashInitial=calculateHash(inp,0,patternLength-1);
        for (int i = 0; i < inpLength - patternLength + 1; i++)
        {
            if(i==0)
            {
                hashes.add(hashInitial);
            }
            else
            {
                hashInitial=rehash(inp,i-1,i+patternLength-2,i,i+patternLength-1,hashInitial,patternLength);
                if(hashes.contains(hashInitial))
                    return true;
                hashes.add(hashInitial);
            }
        }
        return false;
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

