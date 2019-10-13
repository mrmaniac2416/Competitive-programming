/**
 * DA-IICT
 * Author : Savaliya Sagar.
 */

import java.io.*;
import java.math.*;
import java.util.*;

public class lookserryparry2{
    public static int mod = 1000000007;
    static FasterScanner in = new FasterScanner();
    static PrintWriter o = new PrintWriter(System.out);
    public static TreeSet<Integer> t = new TreeSet<>();
    public static void main(String[] args) {

        int n = in.nextInt();
        char a[][] = new char[n][n];
        for(int i=0;i<n;i++){
            String s = in.nextLine();
            a[i] = s.toCharArray();
        }
        int count[] = new int[n];
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                count[i]+=Character.getNumericValue(a[j][i]);
            }
        }
        int input[] = in.nextIntArray(n,0);
        for(int i=0;i<n;i++)
            t.add(i+1);
        int l = 1000000;
        for(int i=0;i<n && l>0;i++){
            System.out.println(i);
            if(count[i]==input[i]){
                dfs(a,i,count,n);
                System.out.println(i);
                i=-1;
                System.out.println("i decreased" + i);

            }
            l--;
        }

        if(l!=0){
            o.println(t.size());
            for(int k:t)
                o.print(k+" ");
        }else
            o.print(-1);
        o.close();
    }


    public static void dfs(char[][] c,int k,int[] count,int n){
        t.remove(k+1);
//        System.out.println(k+1 + "removed");
        for (int i=0;i<n;i++){
            count[i]-=Character.getNumericValue(c[k][i]);
        }
    }
    public static long gcd(long n1, long n2) {
        long r;
        while (n2 != 0) {
            r = n1 % n2;
            n1 = n2;
            n2 = r;
        }
        return n1;
    }

    public static long pow(long x, long n, long mod) {
        long res = 1;
        x %= mod;
        while (n > 0) {
            if (n % 2 == 1) {
                res = (res * x) % mod;
            }
            x = (x * x) % mod;
            n /= 2;
        }
        return res;
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