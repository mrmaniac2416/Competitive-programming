import java.io.*;
import java.util.*;
public final class monsters_cell
{
    static BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    static FastScanner sc=new FastScanner(br);
    static PrintWriter out=new PrintWriter(System.out);

    public static void main(String args[]) throws Exception
    {
        int n=sc.nextInt(),m=sc.nextInt(),k=sc.nextInt();int[][] a=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                a[i][j]=sc.nextInt();
            }
        }
        int max=0;
        for(int i=1;i<(1<<n);i++)
        {
            System.out.println( " i: "+ i + " no of set bits: " + Integer.bitCount(i));
            if(Integer.bitCount(i)>=k)
            {
                continue;
            }
            int[] cnt=new int[m];
            for(int j=0;j<n;j++)
            {
                System.out.println(" j:" + j);
                if((i&(1<<j))!=0)
                {
                    System.out.println(" i & 1<<j " + (i&(1<<j)));
                    for(int l=0;l<m;l++)
                    {
                        System.out.println("l : " + l);
                        System.out.println(" cnt[l]: " + cnt[l]   + "  a[j][l] :"  + a[j][l]);
                        cnt[l]+=a[j][l];
                        System.out.println(" cnt[l]: " + cnt[l]);
                    }
                }
                System.out.println();
            }
            Arrays.sort(cnt);int curr=0;
            for(int element=0;element<m;element++)
            {
                System.out.print(" cnt[ " + element + " ]: "  + cnt[element] + " " );
            }
            System.out.println();

            for(int l=1,j=m-1;l<=k-Integer.bitCount(i) && j>=0;l++,j--)
            {
                System.out.println("l: " + l + "j: " + j + " l<= " + (k-Integer.bitCount(i)) +  " cnt[ " + j + " ] : "  + cnt[j]);
                curr+=cnt[j];
                System.out.println("curr : " + curr);

            }
            System.out.println("Max : " + max);
            max=Math.max(max,curr);
            System.out.println("Max : " + max);
            System.out.println();
        }
//        out.println(max);out.close();
    }
}
class FastScanner
{
    BufferedReader in;
    StringTokenizer st;

    public FastScanner(BufferedReader in) {
        this.in = in;
    }

    public String nextToken() throws Exception {
        while (st == null || !st.hasMoreTokens()) {
            st = new StringTokenizer(in.readLine());
        }
        return st.nextToken();
    }

    public String next() throws Exception {
        return nextToken().toString();
    }

    public int nextInt() throws Exception {
        return Integer.parseInt(nextToken());
    }

    public long nextLong() throws Exception {
        return Long.parseLong(nextToken());
    }

    public double nextDouble() throws Exception {
        return Double.parseDouble(nextToken());
    }
}
