/**
 * Created by Chirag on 19-02-2017.
 * DA-IICT (B.tech 2nd year)
 */

import javafx.scene.layout.Priority;

import java.io.*;
import java.util.*;


public class arjitandapex {
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
        int t=sc.nextInt();
        while (t-->0)
        {
            int m=sc.nextInt();
            int n=sc.nextInt();
            Pair newstudents[]=new Pair[m];
            for(int i=0;i<m;i++)
            {
                int skill=sc.nextInt();
                int proficiency=sc.nextInt();
                newstudents[i]=new Pair(skill,proficiency);
            }
            HashMap<Integer,HashMap<Integer,Integer>> oldstudents=new HashMap<>();
            for(int i=0;i<n;i++)
            {
                int skill=sc.nextInt();
                int proficiency=sc.nextInt();
                if(!oldstudents.containsKey(skill))
                {
                    oldstudents.put(skill,new HashMap<>());
                    oldstudents.get(skill).put(proficiency,1);
                }
                else
                {
                    if(!oldstudents.get(skill).containsKey(proficiency))
                    {
                        oldstudents.get(skill).put(proficiency,1);
                    }
                    else
                    {
                        oldstudents.get(skill).put(proficiency,oldstudents.get(skill).get(proficiency)+1);
                    }
                }
            }
//            debug(oldstudents);
//            debug(newstudents);
            int minimumgoodpairs=sc.nextInt();
            int minimumgreatpairs=sc.nextInt();
            PriorityQueue<Pair> validpairs=new PriorityQueue<>();
//            out.println((oldstudents.containsKey(newstudents[0].u)));
            for(int i=0;i<m;i++)
            {
                if(oldstudents.containsKey(newstudents[i].u))
                {
                    if(oldstudents.get(newstudents[i].u).containsKey(newstudents[i].v))
                    {
                        validpairs.add(new Pair(1,i));
                    }
                    else
                        validpairs.add(new Pair(0,i));
                }
            }
//            debug(validpairs);
            int goodpairs=0;
            int greatpairs=0;
            while (!validpairs.isEmpty())
            {
                Pair newstudent=validpairs.poll();
                int index=(int)newstudent.v;
                boolean isgreat= newstudent.u==1 ? true : false;
                    if(oldstudents.containsKey(newstudents[index].u))
                    {
                        if(oldstudents.get(newstudents[index].u).containsKey(newstudents[index].v))
                        {
                            oldstudents.get(newstudents[index].u).put((int) newstudents[index].v,oldstudents.get(newstudents[index].u).get(newstudents[index].v)-1);
                            greatpairs++;
                            goodpairs++;
                            if(oldstudents.get(newstudents[index].u).get(newstudents[index].v)==0)
                                oldstudents.get(newstudents[index].u).remove(newstudents[index].v);
                            if(oldstudents.get(newstudents[index].u).size()==0)
                                oldstudents.remove(newstudents[index].u);
                        }
                        else
                        {
                            if(isgreat)
                            {
                                validpairs.add(new Pair(0,newstudent.v));
                            }
                            else
                            {
                                Iterator it=oldstudents.get(newstudents[index].u).keySet().iterator();
                                int proficiency=(int)it.next();
                                oldstudents.get(newstudents[index].u).put(proficiency,oldstudents.get(newstudents[index].u).get(proficiency)-1);
                                if(oldstudents.get(newstudents[index].u).get(proficiency)==0)
                                    oldstudents.get(newstudents[index].u).remove(proficiency);
                                if(oldstudents.get(newstudents[index].u).size()==0)
                                    oldstudents.remove(newstudents[index].u);
                                goodpairs++;

                            }
                        }
                    }
            }
            if(greatpairs>=minimumgreatpairs)
                out.println("Great");
            else if(goodpairs>=minimumgoodpairs)
                out.println("Good");
            else
                out.println(":(");
        }


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

    public static void debug(Object... o) {
        System.out.println(Arrays.deepToString(o));
    }

    public static class Pair implements Comparable<Pair> {
        int u;
        int v;

        public Pair(int u, int v) {
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
            return -Integer.compare(u, other.u) != 0 ? -Integer.compare(u, other.u) : Integer.compare(v, other.v);
        }

        public String toString() {
            return "[u=" + u + ", v=" + v + "]";
        }
    }
    //--------------------------------------------------------
}

