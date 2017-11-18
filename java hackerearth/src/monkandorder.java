/**
 * Created by Chirag on 25-01-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class monkandorder {
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
        int n = sc.nextInt();
        ArrayList<Stack<Integer>> fighters = new ArrayList<>();
        Stack<Integer> auxstack=new Stack<>();
        int size = sc.nextInt();
        Stack<Integer> fighterheight = new Stack<>();
        for (int i = 0; i < size; i++) {
            int element;
            fighterheight.push(element = sc.nextInt());
            if(i==0)
                auxstack.push(element);
            else
            {
                if(auxstack.peek() < element)
                    auxstack.push(auxstack.peek());
                else
                    auxstack.push(element);
            }
        }
        fighters.add(fighterheight);
        n--;
        while (n-- > 0) {
            size = sc.nextInt();
            fighterheight = new Stack<>();
            for (int i = 0; i < size; i++)
                fighterheight.push(sc.nextInt());
            fighters.add(fighterheight);
        }
        int q = sc.nextInt();

        while (q-- > 0) {
            int v = sc.nextInt();

            if (v == 0) {
                int k = sc.nextInt();
                fighters.get(k-1).pop();
                if(k==1)
                    auxstack.pop();
            }
            if (v == 1) {
                int k = sc.nextInt();
                int h = sc.nextInt();
                fighters.get(k - 1).push(h);
                if(k==1)
                {
                    if(auxstack.peek() < h)
                        auxstack.push(auxstack.peek());
                    else
                        auxstack.push(h);
                }
            }
            if (v == 2) {
                boolean canuse = true;
//                System.out.println(min);
/*
                for (Stack<Integer> row : fighters) {
                    for (int fighter : row)
                        System.out.print(fighter + " ");
                    System.out.println();
                }
*/
             int min=auxstack.peek();

                for(int i=1;i<fighters.size();i++)
                {
                        min=binsearch(fighters.get(i),min,0,fighters.get(i).size());
//                    out.println(min);
                    if(min==-1)
                    {
                        canuse=false;
                        break;
                    }

                }
                if(canuse)
                    out.println("YES");
                else
                    out.println("NO");
            }

            }


            //The Code ends here
            out.close();
        }

    public static int binsearch(Stack<Integer> a,int search,int l,int r)
    {
        int mid=0;
        boolean flag=false;
        while(l<r)
        {
            mid=(l+r)/2;
            if(a.get(mid)==search)
            {
                flag=true;
                break;
            }
            if(a.get(mid)<search)
                l=mid+1;
            if(a.get(mid)>search)
                r=mid;
        }
        if(flag)
        {
            if(mid==0)
                return -1;
            else
                return a.get(mid-1);

        }
        if(l>=a.size())
            return -1;
        else
            return a.get(l);
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

