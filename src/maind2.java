import java.io.*;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;


public class maind2 {

    static double eps=(double)1e-6;
    static long mod=(int)1e9+7;
    public static void main(String args[]){
        InputReader in = new InputReader(System.in);
        OutputStream outputStream = System.out;
        PrintWriter out = new PrintWriter(outputStream);
        //----------My Code----------
        String s=in.nextLine();
        char a[]=new char[s.length()+5];
        int n=s.length();
        for(int i=0;i<n;i++){
            a[5+i]=s.charAt(n-i-1);
        }
        a[0]='*';a[1]='*';a[2]='*';a[3]='*';a[4]='*';
        s=new String(a);
        boolean v2[]=new boolean[n+5];
        boolean v3[]=new boolean[n+5];
        v2[4]=v3[4]=true;
        for(int i=1+5;i<n-5+5;i++){
            if(v3[i-2]){
                v2[i]=true;
            }
            if(v2[i-2]){
                String chk1=s.substring(i-3,i-1);
                String chk2=s.substring(i-1,i+1);
                if(!chk1.equals(chk2)){
                    v2[i]=true;
                }
            }

            if(v2[i-3]){
                v3[i]=true;
            }
            if(v3[i-3]){
                String chk1=s.substring(i-5,i-2);
                String chk2=s.substring(i-2,i+1);
                if(!chk1.equals(chk2)){
                    v3[i]=true;
                }
            }
        }
        TreeSet<String> tree=new TreeSet<String>();
        for(int i=5;i<n;i++){
            if(v2[i]){
                String mystr=""+s.charAt(i)+s.charAt(i-1);
                tree.add(mystr);
            }

            if(v3[i]){
                String mystr=""+s.charAt(i)+s.charAt(i-1)+s.charAt(i-2);
                tree.add(mystr);
            }
        }
        //out.println(s);
        out.println(tree.size());
        for(String x:tree){
            out.println(x);
        }
        out.close();
        //---------------The End------------------

    }
    static public int f(int x,int c[],int k) {
        int ans=0;
        for(int i=0;i<26;i++){
            if(c[i]==0)
                continue;
            if(c[i]<x){
                ans+=(c[i]);
            }
            if(c[i]>x+k){
                ans+=(c[i]-(x+k));
            }
        }
        return ans;
    }

    static long modulo(long a,long b,long c) {
        long x=1;
        long y=a;
        while(b > 0){
            if(b%2 == 1){
                x=(x*y)%c;
            }
            y = (y*y)%c; // squaring the base
            b /= 2;
        }
        return  x%c;
    }
    static long gcd(long x, long y)
    {
        long r=0, a, b;
        a = (x > y) ? x : y; // a is greater number
        b = (x < y) ? x : y; // b is smaller number
        r = b;
        while(a % b != 0)
        {
            r = a % b;
            a = b;
            b = r;
        }
        return r;
    }
    static class Pair implements Comparable<Pair>{
        int x;
        int y;
        int i;
        Pair(int xx,int yy){
            x=xx;
            y=yy;
        }
        @Override
        public int compareTo(Pair o) {
            return Integer.compare(this.x, o.x);

        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream inputstream) {
            reader = new BufferedReader(new InputStreamReader(inputstream));
            tokenizer = null;
        }

        public String nextLine(){
            String fullLine=null;
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    fullLine=reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
                return fullLine;
            }
            return fullLine;
        }
        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }
        public long nextLong() {
            return Long.parseLong(next());
        }
        public int nextInt() {
            return Integer.parseInt(next());
        }
    }
}