/**
 * DA-IICT
 * Author : Savaliya Sagar.
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class ABC {
    public static int mod = 1000000007;
    static FasterScanner in = new FasterScanner();
    static PrintWriter o = new PrintWriter(System.out);

    public static void Solve() {
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int grid[][] = new int[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                grid[i][j] = in.nextInt();
            }
        }
        int max = Integer.MIN_VALUE;
        int l = (int) Math.pow(2,n)-1;
        for(int i=0;i<=l;i++){
            int rows = 0;
            int count[] = new int[m];
            for(int j=0;j<n;j++){
                int f = i>>j;
                // o.println(i + " "  +  j + "  "  + Integer.toBinaryString(f));
                if(f%2==1){
                    rows++;
                    for(int s=0;s<m;s++){
                        if(grid[j][s]==1){
                            count[s]++;
                        }
                    }
                }
            }
            // o.println(rows + "++ ");
            if(k-rows>m){
                continue;
            }
            ArrayList<Pair> p = new ArrayList<>();
            for(int j=0;j<m;j++){
                p.add(new Pair(count[j],j));
            }
            Collections.sort(p,Collections.reverseOrder());
            // o.println(Arrays.toString(count));
            int answer = 0;
            for(int j=0;j<k-rows;j++){
                answer += p.get(j).u;
            }
            if(answer>max){
                max = answer;
            }
            //  o.println(max + "++++++++++ ");
        }
        o.print(max);
    }

    static class Pair implements Comparable<Pair> {
        long u;
        long v;
        BigInteger bi;
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

    public static void main(String[] args) {
        Solve();
        o.close();
    }

    static class FasterScanner {
        private byte[] buf = new byte[1024];
        private int curChar;
        private int snumChars;

        public int read() {
            if (snumChars == -1)
                throw new InputMismatchException();
            if (curChar >= snumChars) {
                curChar = 0;
                try {
                    snumChars = System.in.read(buf);
                } catch (IOException e) {
                    throw new InputMismatchException();
                }
                if (snumChars <= 0)
                    return -1;
            }
            return buf[curChar++];
        }

        public String nextLine() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isEndOfLine(c));
            return res.toString();
        }

        public String nextString() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            StringBuilder res = new StringBuilder();
            do {
                res.appendCodePoint(c);
                c = read();
            } while (!isSpaceChar(c));
            return res.toString();
        }

        public long nextLong() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            long res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int nextInt() {
            int c = read();
            while (isSpaceChar(c))
                c = read();
            int sgn = 1;
            if (c == '-') {
                sgn = -1;
                c = read();
            }
            int res = 0;
            do {
                if (c < '0' || c > '9')
                    throw new InputMismatchException();
                res *= 10;
                res += c - '0';
                c = read();
            } while (!isSpaceChar(c));
            return res * sgn;
        }

        public int[] nextIntArray(int n, int f) {
            if (f == 0) {
                int[] arr = new int[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextInt();
                }
                return arr;
            } else {
                int[] arr = new int[n + 1];
                for (int i = 1; i < n + 1; i++) {
                    arr[i] = nextInt();
                }
                return arr;
            }
        }

        public long[] nextLongArray(int n, int f) {
            if (f == 0) {
                long[] arr = new long[n];
                for (int i = 0; i < n; i++) {
                    arr[i] = nextLong();
                }
                return arr;
            } else {
                long[] arr = new long[n + 1];
                for (int i = 1; i < n + 1; i++) {
                    arr[i] = nextLong();
                }
                return arr;
            }
        }

        private boolean isSpaceChar(int c) {
            return c == ' ' || c == '\n' || c == '\r' || c == '\t' || c == -1;
        }

        private boolean isEndOfLine(int c) {
            return c == '\n' || c == '\r' || c == -1;
        }
    }
}
