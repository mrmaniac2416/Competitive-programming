/**
 * Created by Chirag on 07-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class CostOfData {
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
        int n=sc.nextInt();
        TrieImplementation trie=new TrieImplementation();
        while (n-->0)
        {
            String s=sc.nextLine();
            trie.insert(s);
        }
        System.out.println(trie.bfs());



        //The Code ends here
        out.close();
    }


    static class TrieNode{
        HashMap<Character,TrieNode> characters;
        boolean isEndOfWord;

        TrieNode()
        {
            this.characters=new HashMap<>();
            isEndOfWord=false;
        }
    }

    static  class TrieImplementation{
        TrieNode root;

        TrieImplementation()
        {
            root=new TrieNode();
        }

        void insert(String s)
        {
            TrieNode temp=root;
            for(int i=0;i<s.length();i++)
            {
                if(temp.characters.containsKey(s.charAt(i)))
                    temp=temp.characters.get(s.charAt(i));
                else
                {
                    temp.characters.put(s.charAt(i),new TrieNode());
                    temp=temp.characters.get(s.charAt(i));
                }
            }
            temp.isEndOfWord=true;
        }
        int bfs()
        {
            TrieNode temp=root;
            int ans=0;
            Queue<TrieNode> neighbours=new ArrayDeque<>();
            neighbours.add(root);
            while (!neighbours.isEmpty())
            {
                TrieNode toBeVisited=neighbours.poll();
                ans++;
                for(char c: toBeVisited.characters.keySet())
                {
//                    System.out.print(c + " " );
                    neighbours.add(toBeVisited.characters.get(c));

                }
//                System.out.println();
            }
          return ans;
        }

        boolean doesPrefixExist(String s)
        {
            TrieNode temp=root;
            for(int i=0;i<s.length();i++)
            {
                if(temp.characters.containsKey(s.charAt(i)))
                    temp=temp.characters.get(s.charAt(i));
                else
                    return false;
            }
            return true;
        }

        boolean doesWordExist(String s)
        {
            TrieNode temp=root;
            for(int i=0;i<s.length();i++)
            {
                if(temp.characters.containsKey(s.charAt(i)))
                    temp=temp.characters.get(s.charAt(i));
                else
                    return false;
            }
            if(temp.isEndOfWord)
                return true;
            else
                return false;
        }

        void delete(String word)
        {
            deleteHelper(root,word,0);
        }

        private boolean deleteHelper(TrieNode current, String word, int index) {
            if (index == word.length()) {
                //when end of word is reached only delete if currrent.endOfWord is true.
                if (!current.isEndOfWord) {
                    return false;
                }
                current.isEndOfWord = false;
                //if current has no other mapping then return true
                return current.characters.size() == 0;
            }
            char ch = word.charAt(index);
            TrieNode node = current.characters.get(ch);
            if (node == null) {
                return false;
            }
            boolean shouldDeleteCurrentNode = deleteHelper(node, word, index + 1);

            //if true is returned then delete the mapping of character and trienode reference from map.
            if (shouldDeleteCurrentNode) {
                current.characters.remove(ch);
                //return true if no mappings are left in the map.
                return current.characters.size() == 0;
            }
            return false;
        }
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

