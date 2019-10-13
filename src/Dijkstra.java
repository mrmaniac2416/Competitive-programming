/**
 * Created by Chirag on 08-12-2016.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;
import javafx.util.Pair;


public class Dijkstra
{
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
        ArrayList<Integer> vertices = new ArrayList<>();
        int n=sc.nextInt();
        int m=sc.nextInt();
        vertices.add(0);
        for(int i=1;i<=n;i++)
               vertices.add(i);
        HashMap<Integer,LinkedHashSet<Pair<Integer,Integer>>> graph=new HashMap<>();
        for(int i=0;i<n;i++)
            graph.put(i+1,new LinkedHashSet<Pair<Integer, Integer>>());
        for(int i=0;i<m;i++)
        {
            int v1=sc.nextInt();
            int v2=sc.nextInt();
            int w=sc.nextInt();
            int flag=0;
            Pair<Integer,Integer> p1=new Pair<>(v2,w);
            Pair<Integer,Integer> p2=new Pair<>(v1,w);
            for(Pair<Integer,Integer> edge : graph.get(v1))
            {
                if(edge.getKey()==p1.getKey() && edge.getValue() < p1.getValue()) {
                    edge = p1;
                    flag = 1;
                }

            }
            if(flag==0)
                graph.get(v1).add(p1);
            flag=0;
            for(Pair<Integer,Integer> edge : graph.get(v2))
            {
                if(edge.getKey()==p2.getKey() && edge.getValue() < p2.getValue()) {
                    edge = p2;
                    flag = 1;
                }

            }
            if(flag==0)
                graph.get(v2).add(p2);

        }
        ArrayList<Integer> s=new ArrayList<>();
        s.add(vertices.get(1));
        ArrayList<Integer> nots=new ArrayList<>(vertices);
        nots.remove(1);
        int cost[]=new int[n+1];

        for(int i=1;i<=n;i++)
        {
            cost[i]=Integer.MAX_VALUE;
        }
        cost[1]=0;
        for(Pair<Integer,Integer> edge : graph.get(vertices.get(1)))
        {
            cost[edge.getKey()]=edge.getValue();
        }
      /* for(int i=1;i<=n;i++) {


               System.out.print(i);
           for (Pair<Integer, Integer> p : graph.get(vertices.get(i))) {
                   System.out.print("vertex " + p.getKey() + "Weight " + p.getValue());
               }
           System.out.println();
       }*/
//        for(int i=0;i<cost.length;i++)
//            System.out.print("cost[ " +i + "]" + cost[i] + " ");
//        System.out.println();
//        for(int vertex : nots)
//            System.out.print(vertex + " ");
//        System.out.println();
        for(int j=2;j<=n;j++)
        {
            int min=Integer.MAX_VALUE;
            int minvertex=0;
            int minindex=0;
            for(int i=1;i<nots.size();i++) {
//                out.print(nots.get(i));
                if (min > cost[nots.get(i)]) {
                    min = cost[nots.get(i)];
                    minvertex = nots.get(i);
                    minindex=i;
                  //  System.out.println(min + " " + minindex);
                }
            }
//            System.out.println("added" + minvertex);
                s.add(minvertex);
                nots.remove(minindex);
//            for(int vertex : nots)
//                System.out.print(vertex + " ");

//            System.out.println();

                for(int i=1;i<nots.size();i++)
                {
                    if(cost[nots.get(i)] > cost[minvertex] + weight(minvertex,nots.get(i),vertices,graph))
                    {
//                        System.out.println(cost[nots.get(i)] + " " + cost[minvertex] + " " + weight(minvertex,nots.get(i),vertices,graph));
                        if(weight(minvertex,nots.get(i),vertices,graph)==Integer.MAX_VALUE)
                            cost[nots.get(i)]=cost[nots.get(i)]==Integer.MAX_VALUE ? Integer.MAX_VALUE : cost[nots.get(i)];
                        else
                        cost[nots.get(i)]=cost[minvertex] + weight(minvertex,nots.get(i),vertices,graph);
                    }
                }
            }
        for(int i=0;i<cost.length;i++)
            System.out.print("cost[" +i + "]-" + cost[i] + " ");
        System.out.println();

//        for(int vertex : s)
//            out.print(vertex + " ");

            //The Code ends here
        out.close();
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

    public static int weight(int v1,int v2,ArrayList<Integer> vertices, HashMap<Integer,LinkedHashSet<Pair<Integer,Integer>>> graph)
    {
              if(v1==v2)
                  return 0;
               for(Pair<Integer,Integer> p : graph.get(v1))
              {
                  if(p.getKey()==v2)
                      return p.getValue();

              }
              return Integer.MAX_VALUE;
    }
    //--------------------------------------------------------
}

