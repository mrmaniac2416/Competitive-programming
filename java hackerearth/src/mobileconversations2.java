import java.util.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Collections;
import java.util.StringTokenizer;

class mobileconservations2 {

    public static void main(String[] args){
        FastReader f=new FastReader(System.in);
        OutputStream o = System.out;
        PrintWriter out=new PrintWriter(o);
        //int t=f.nextInt();
        //while(--t>=0){
        int n=f.nextInt();
        long x =0;long y=0;
        long m=10000000;
        long ma = 10000000;
        for(int i=0;i<n;i++){
            long a = f.nextLong();
            long b = f.nextLong();
            x=x+a;y=y+b;
            out.println(" x " + x);
            out.println(" y " + y);
            if(b<m){
                m=b;
            }
            if(b>a){
                if(a<ma){
                    ma=a;
                }
            }
            out.println(" m" + m);
            out.println(" ma " + ma);
        }
        out.println(" y - m + ma" + (y-m+ma));
        out.println(x);
        out.println(ma);

        if((y-m+ma)>x && ma!=10000000){
            out.println(ma);

        }

        else
            out.println(x-(y-m));
        out.println("x-(y-m)" + (x-(y-m)));

        //}
        out.close();
    }


    static long strength(long[] a){
        int ans=0;
        for(int i=0;i<a.length-1;i++){
            //System.out.println(a[i]);
            ans+= Math.abs(a[i+1]-a[i]);
        }
        ans+= Math.abs(a[a.length-1]-a[0]);
        return ans;
    }




    static void swap(int[] a,int i,int j){
        int t = a[i];
        a[i]=a[j];
        a[j]=t;
    }






    static class FastReader {
        BufferedReader reader;
        StringTokenizer st;
        FastReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream));
            st = null;
        }
        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if (line == null) {
                        return null;
                    }
                    st = new StringTokenizer(line);
                } catch (Exception e) {
                    throw new RuntimeException();
                }
            }
            return st.nextToken();
        }
        String nextLine() {
            String s = null;
            try {
                s = reader.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return s;
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
        char nextChar() {
            return next().charAt(0);
        }
        int[] nextIntArray(int n) {
            int[] arr = new int[n];
            int i = 0;
            while (i < n) {
                arr[i++] = nextInt();
            }
            return arr;
        }
        long[] nextLongArray(int n) {
            long[] arr = new long[n];
            int i = 0;
            while (i < n) {
                arr[i++] = nextLong();
            }
            return arr;
        }
        int[] nextIntArrayOneBased(int n) {
            int[] arr = new int[n + 1];
            int i = 1;
            while (i <= n) {
                arr[i++] = nextInt();
            }
            return arr;
        }
        long[] nextLongArrayOneBased(int n) {
            long[] arr = new long[n + 1];
            int i = 1;
            while (i <= n) {
                arr[i++] = nextLong();
            }
            return arr;
        }
        void close() {
            try {
                reader.close();
            } catch (IOException e) {
                System.err.println("There's been an error trying closing the reader ");
                e.printStackTrace();
            }
        }
    }

    public static class Pair<FIRST, SECOND> implements Comparable<Pair<FIRST, SECOND>> {

        public final FIRST s;
        public final SECOND j;
        //public final THIRD i;

        private Pair(FIRST first, SECOND second) {
            this.s = first;
            this.j = second;
            //this.i = third;
        }



        @Override
        public int compareTo(Pair<FIRST, SECOND> o) {

            return compare(o.j,j);
        }

        // todo move this to a helper class.
        public int compare(Object o1, Object o2) {
            return o1 == null ? o2 == null ? 0 : -1 : o2 == null ? +1
                    : ((Comparable) o1).compareTo(o2);
        }



        @Override
        public boolean equals(Object obj) {
            if (!(obj instanceof Pair))
                return false;
            if (this == obj)
                return true;
            return equal(s, ((Pair) obj).s) && equal(j, ((Pair) obj).j);
        }

        // todo move this to a helper class.
        private boolean equal(Object o1, Object o2) {
            return o1 == null ? o2 == null : (o1 == o2 || o1.equals(o2));
        }

        @Override
        public String toString() {
            return "(" + s + ", " + j + ')';
        }
    }
}