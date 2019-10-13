/**
 * Created by Chirag on 20-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class GoodSubstrings {
    public static final int prime=101;
    public static final int mod=1000000007;
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
        String badInfo=sc.nextLine();
        int prefixArrayBad[]=new int[s.length()];
        for(int i=0;i<s.length();i++)
        {
            int toBeAdded=badInfo.charAt(s.charAt(i)-'a')=='1' ? 0 : 1;
            if(i!=0)
            prefixArrayBad[i]= toBeAdded +prefixArrayBad[i-1];
            else
                prefixArrayBad[i]=toBeAdded;
        }
        int maximumBadAllowed=sc.nextInt();
//        debug(prefixArrayBad);
        HashSet<Integer> qualifiedStrings=new HashSet<>();
        for(int length=1;length<=s.length();length++)
        {
            int hashInitial=0;
            for(int i=0;i<s.length()-length+1;i++)
            {
                if(i==0)
                    hashInitial=calculateHash(s,0,length-1);
                else
                    hashInitial=rehash(s,i-1,i+length-2,i,i+length-1,hashInitial,length);

                if(noOfBad(prefixArrayBad,i,i+length-1)<=maximumBadAllowed)
                            {

                                if(!qualifiedStrings.contains(hashInitial))
                                {
                                    qualifiedStrings.add(hashInitial);
//                                    System.out.println(s.substring(i,i+length) + hashInitial);
                                }
                            }
            }
        }
//        out.println(calculateHash("ababab",0,2));
//        out.println(calculateHash("ababab",2,4));
//        debug(qualifiedStrings);
        out.print(qualifiedStrings.size());


        //The Code ends here
        out.close();
    }

    public static int noOfBad(int prefix[],int start,int end)
    {
        if(start!=0)
            return prefix[end]-prefix[start-1];
        else
           return prefix[end];
    }
    //define mod and prime in code..

    static int calculateHash(String s,int start,int end)
    {
        int ans=0;
        int index=0;
        for(int i=start;i<=end;i++)
        {
            ans=ans+(s.charAt(i)*(int)Math.pow(prime,index))%mod;
            ans=ans%mod;
            index++;
        }
        return ans;
    }

    static int rehash(String s,int start1,int end1,int start2,int end2,int hash1,int patternSize)
    {
        int newHash=hash1-s.charAt(start1);
        newHash=newHash/prime;
        newHash=newHash+(s.charAt(end2)*(int)Math.pow(prime,patternSize-1))%mod;
        newHash=newHash%mod;
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

    static  ArrayList<Integer> matchedIndexes(String pattern,String inp) {
        int patternLength = pattern.length();
        int inpLength = inp.length();
        ArrayList<Integer> ans = new ArrayList<>();
        int hashPattern=calculateHash(pattern,0,patternLength-1);
        int hashInitial=calculateHash(inp,0,patternLength-1);
        for (int i = 0; i < inpLength - patternLength + 1; i++)
        {
            if(i==0)
            {
                if(hashInitial==hashPattern)
                {
                    if(isEqual(pattern,0,patternLength-1,inp,0,patternLength-1,patternLength))
                        ans.add(i);
                }
            }
            else
            {
                hashInitial=rehash(inp,i-1,i+patternLength-2,i,i+patternLength-1,hashInitial,patternLength);
                if(hashInitial==hashPattern)
                {
                    if(isEqual(pattern,0,patternLength-1,inp,i,i+patternLength-1,patternLength))
                        ans.add(i);
                }
            }
        }
        return ans;
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

