/**
 * Created by Chirag on 02-06-2017.
 * DA-IICT (B.tech 2nd year)
 */

import java.io.*;
import java.util.*;


public class MonkAndSomeQueries {
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
        int noOfQueries=sc.nextInt();
        bst array=new bst();
        while (noOfQueries-->0)
        {
            int queryType=sc.nextInt();
            if(queryType==1)
            {
                int data=sc.nextInt();
                array.root=array.insert(array.root,data);
            }
            else if(queryType==2)
            {
                int data=sc.nextInt();
                if(array.search(array.root,data)!=null)
                   array.root= array.delete(data);
//                else
//                    System.out.println("-1");
            }
            else if(queryType==3)
            {
//                if(array.root!=null)
//                    System.out.println(array.minMax().v);
//                else
//                    System.out.println("-1");
            }
            else
            {
//                if(array.root!=null)
//                    System.out.println(array.minMax().u);
//                else
//                    System.out.println("-1");
            }
//             if(array.root!=null)
//            array.levelOrder();

        }



        //The Code ends here
        out.close();
    }

    public static class bstNode{
        int data;
        bstNode left;
        bstNode right;
        bstNode(int data)
        {
            this.data=data;
            left=null;
            right=null;
        }
    }

    public static class bst{
        bstNode root;
        bst(){
            this.root=null;
        }
        bstNode insert(bstNode root,int data)
        {
            if(root==null)
                root=new bstNode(data);

            else if(data==root.data)
                root.left=insert(root.left,data);
            else if(root.data<data)
            {
                if(data==19691)
                    System.out.println("Inserted right of " + root.data);
                root.right=insert(root.right,data);
            }
            else
            {
                if(data==19691)
                    System.out.println("Inserted left of " + root.data);
                root.left=insert(root.left,data);
            }

            return root;
        }

        bstNode search(bstNode root,int data)
        {
            if(root==null)
                return null;
            if(root.data==data)
                return root;
            else if(root.data<data)
                return search(root.right,data);
            else
                return search(root.left,data);
        }

        int height(bstNode root)
        {
            if(root==null)
                return 0;
            int lheight=height(root.left);
            int rheight=height(root.right);

            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }

        void inorder(bstNode root) {
            if (root != null) {
                inorder(root.left);
                System.out.println(root.data);
                inorder(root.right);
            }
        }

        Pair minMax()
        {
            Pair ans=new Pair(0,0);
            bstNode temp=root;
            while (temp.left!=null)
                temp=temp.left;
            ans.u=temp.data;
            temp=root;
            while (temp.right!=null)
                temp=temp.right;
            ans.v=temp.data;
            return ans;
        }

        int maxdepth(bstNode root)
        {
            if(root==null)
                return -1;
            int ldepth=maxdepth(root.left);
            int rdepth=maxdepth(root.right);

            if(ldepth>rdepth)
                return ldepth+1;
            else
                return rdepth+1;
        }

        void levelOrder(bstNode root)
        {
            Queue<bstNode> neighbours=new ArrayDeque<>();
            neighbours.add(root);
            while (!neighbours.isEmpty())
            {
                bstNode popped=neighbours.poll();
                System.out.print(popped.data + " ");
                if(popped.left!=null)
                    neighbours.add(popped.left);
                if(popped.right!=null)
                    neighbours.add(popped.right);
            }
        }
        void preorder(bstNode root)
        {
            if(root==null)
                return;
            System.out.print(root.data + " ");
            preorder(root.left);
            preorder(root.right);
        }

        boolean isBST(bstNode root,int min,int max)
        {
            if(root==null)
                return true;
            if(!(root.data>=min && root.data<max))
                return false;
            return isBST(root.left,min,root.data) && isBST(root.right,root.data,max);
        }


        bstNode delete(int data)
        {
            bstNode toBeDeleted=root;
            bstNode tobeDeletedParent=root;
            boolean isLeftChild=true;
            while (toBeDeleted.data!=data)
            {
                tobeDeletedParent=toBeDeleted;
                if(toBeDeleted.data<data)
                {
                    toBeDeleted=toBeDeleted.right;
                    isLeftChild=false;

                }
                else
                {
                    toBeDeleted=toBeDeleted.left;
                    isLeftChild=true;
                }
            }
            if(toBeDeleted.left==null && toBeDeleted.right==null)
            {
                if(toBeDeleted==root)
                    root=null;
                if(isLeftChild)
                    tobeDeletedParent.left=null;
                else
                    tobeDeletedParent.right=null;
            }
            else if(toBeDeleted.left==null)
            {
                if(isLeftChild)
                    tobeDeletedParent.left=toBeDeleted.right;
                else
                    tobeDeletedParent.right=toBeDeleted.right;

            }
            else if(toBeDeleted.right==null)
            {
                if(isLeftChild)
                    tobeDeletedParent.left=toBeDeleted.left;
                else
                    tobeDeletedParent.right=toBeDeleted.left;
                toBeDeleted=null;
            }
            else
            {
                bstNode rightSubTree=toBeDeleted.right;
                bstNode minimumRightSubTree;
                while (rightSubTree.left!=null)
                {
                    rightSubTree=rightSubTree.left;
                }
                minimumRightSubTree=rightSubTree;
//                System.out.println("to be deleted" + toBeDeleted.data + " minimum right sub tree" + minimumRightSubTree.data);
//                System.out.println(toBeDeleted.left.data + " " + toBeDeleted.right.data);
                if(toBeDeleted.data==19691 && minimumRightSubTree.data==19691)
                    this.levelOrder(search(this.root,19691));
                this.root=delete(minimumRightSubTree.data);
                toBeDeleted.data=minimumRightSubTree.data;

            }
            return this.root;
        }

        int getSuccessor(bstNode root,int data)
        {
            bstNode toFind=root;
            while (toFind.data!=data)
            {
                if(toFind.data<data)
                {
                    toFind=toFind.right;
                }
                else
                    toFind=toFind.left;
            }
            if(toFind.right!=null)
            {
                toFind=toFind.right;
                while (toFind.left!=null)
                {
                    toFind=toFind.left;
                }
                return toFind.data;
            }
            else
            {
                bstNode successor=null;
                bstNode ancestor=root;
                while (ancestor.data!=data)
                {
                    if(ancestor.data>data)
                    {
                        successor=ancestor;
                        ancestor=ancestor.left;
                    }
                    else
                        ancestor=ancestor.right;
                }
                return successor.data;
            }

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

