import java.io.*;
import java.util.*;
import java.lang.*;

class TestClass
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw=new PrintWriter(System.out);

        String s=br.readLine();
        int t=Integer.valueOf(s);
        int n, k, x;
        String[] c;

        for(int j=0; j<t; j++)
        {
            s=br.readLine();
            n=Integer.valueOf(s);

            HashSet<Integer> hs=new HashSet<>();
            s=br.readLine();
            c=s.split(" ");

            for(int i=0; i<n; i++)
                hs.add(Integer.valueOf(c[i]));

            s=br.readLine();
            k=Integer.valueOf(s);

            for(int i=0; i<k; i++)
            {
                s=br.readLine();
                x=Integer.valueOf(s);

                if(hs.contains(x))
                    pw.println("Yes");

                else
                    pw.println("No");
            }
        }

        br.close();
        pw.close();
    }
}