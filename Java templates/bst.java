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
            else if(root.data<data)
                root.right=insert(root.right,data);
            else
                root.left=insert(root.left,data);
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

        public int minDepth(bstNode a) {
           
        if(a.left==null && a.right==null)
        {
            return 1;
        }
        if(a.left==null && a.right!=null)
        {
            return minDepth(a.right)+1;
        }
        if(a.left!=null && a.right==null)
        {
            return minDepth(a.left)+1;
        }
        int left=minDepth(a.left);
        int right=minDepth(a.right);
        
        if(left>=right)
          return right+1;
         else
          return left+1;
        
    }

        void levelOrder()
        {
            Queue<bstNode> neighbours=new ArrayDeque<>();
            neighbours.add(this.root);
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
