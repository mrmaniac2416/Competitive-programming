        static class BstNode{
        int data;
        BstNode left;
        BstNode right;

        BstNode(int data)
        {
            this.data=data;
            this.left=null;
            this.right=null;
        }
    }





    static class Bst{
        BstNode root;

        Bst()
        {
            this.root=null;
        }

        BstNode insert(BstNode root,int data)
        {

            if(root==null)
            {
               root=new BstNode(data);
            }
            else if(root.data<=data)
            {
                root.right=insert(root.right,data);
            }
            else
            {
                root.left=insert(root.left,data);
            }
            return root;
        }

        BstNode doesElementExist(BstNode root,int data)
        {
            if(root==null)
                return null;
            if(root.data==data)
                return root;
            if(root.data<data)
            {
                return doesElementExist(root.right,data);
            }
            else
                return doesElementExist(root.left,data);
        }

        int getMax(BstNode root)
        {
            if(root==null)
                System.out.println("Empty tree");
            while (root.right!=null)
                      root=root.right;
            return root.data;
        }
        BstNode getMin(BstNode root)
        {
            if(root==null)
                System.out.println("Empty tree");
            while (root.left!=null)
                root=root.left;
            return root;
        }

        int getHeight(BstNode tree)
        {
            if(root==null)
                return 0;

            int lheight=getHeight(root.left);
            int rheight=getHeight(root.right);

            if(lheight>rheight)
                return lheight+1;
            else
                return rheight+1;
        }

        void levelOrder(BstNode root)
        {
            Queue<BstNode> neighbours=new ArrayDeque<>();
            neighbours.add(root);
            System.out.println(root.data);

            while (!neighbours.isEmpty())
            {
                BstNode visiting=neighbours.poll();
                System.out.println(visiting.data);
                if(visiting.left!=null)
                    neighbours.add(root.left);
                if(visiting.right!=null)
                    neighbours.add(root.right);
            }
        }
        boolean checkBST(BstNode root) {


            return checkBSTUtil(root,Integer.MIN_VALUE,Integer.MAX_VALUE);

        }

        boolean checkBSTUtil(BstNode root,int min,int max)
        {
            if(root==null)
                return true;
            if(!(root.data>min && root.data<max))
                return false;
            return checkBSTUtil(root.left,min,root.data) && checkBSTUtil(root.right,root.data,max);
        }

        BstNode delete(BstNode root,int data)
        {
            if(root==null)
                return null;
            if(root.data<data)
                root.right=delete(root.right,data);
            else if(root.data>data)
                root.left=delete(root.left,data);
            else
            {
                if(root.left==null && root.right==null)
                    root=null;
                else if(root.left==null)
                {
                    BstNode temp=root;
                    root=root.right;
                    temp=null;
                }
                else if(root.right==null)
                {
                    BstNode temp=root;
                    root=root.left;
                    temp=null;
                }
                else
                {
                    BstNode temp=getMin(root.right);
                    root.data=temp.data;
                    root.right=delete(root.right,temp.data);
                }
            }
            return root;
        }

        BstNode inorderSuccessor(BstNode root,int data)
        {
            BstNode toFind=doesElementExist(root,data);

            if(toFind.right!=null)
                return getMin(toFind.right);
            else
            {
                BstNode successor=null;
                BstNode ancestor=root;
                while (ancestor!=toFind)
                {
                    if(toFind.data<ancestor.data)
                    {
                        successor=ancestor;
                        ancestor=ancestor.left;
                    }
                    else
                        ancestor=ancestor.right;
                }
                return successor;
            }
        }





    }
