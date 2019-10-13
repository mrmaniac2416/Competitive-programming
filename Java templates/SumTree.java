  static class Node{
        Node left;
        Node right;
        int data;

        Node(int data)
        {
            this.data=data;
        }

        public String toString()
        {
            return "" + this.data;
        }
    }

    static Node constructTree(int a[],int n)
    {
        HashMap<Pair,Node> nodeMap=new HashMap<>();

        Node root=new Node(a[1]);
        nodeMap.put(new Pair(a[1],1),root);

        for(int i=1;2*i<=n;i++)
        {
            if(a[i]==-1)
                continue;
            Node tempRoot=nodeMap.get(new Pair(a[i],i));
//            debug(nodeMap);
            int lChild=-1;
            int rChild=-1;
            if(2*i<=n)
              lChild=a[2*i];
            if(2*i+1 <=n)
                rChild=a[2*i+1];

            Node leftChild=null;
            Node rightChild=null;
            if(lChild!=-1)
            {
                leftChild=new Node(a[2*i]);
                nodeMap.put(new Pair(a[2*i],2*i),leftChild);
            }
            if(rChild!=-1)
            {
                rightChild=new Node(a[2*i+1]);
                nodeMap.put(new Pair(a[2*i+1],2*i+1),rightChild);
            }

            tempRoot.left=leftChild;
            tempRoot.right=rightChild;
            }
            return root;
    }

    static boolean isLeaf(Node temp)
    {
        if(temp==null)
            return false;
        return temp.left==null && temp.right==null;
    }

    static boolean isSumTree(Node root)
    {
            if(root==null)
                return true;
            if(isLeaf(root))
                return true;

            if(isSumTree(root.left) && isSumTree(root.right))
            {
                int ls;
                int rs;

                if(root.left==null)
                    ls=0;
                else if(isLeaf(root.left))
                    ls=root.left.data;
                else
                    ls=2*root.left.data;

                if(root.right==null)
                    rs=0;
                else if(isLeaf(root.right))
                    rs=root.right.data;
                else
                    rs=2*root.right.data;

                return root.data==(ls+rs);
            }
            return false;
    }
