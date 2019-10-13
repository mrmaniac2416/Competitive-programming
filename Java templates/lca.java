bstNode lca(bstNode root,bstNode n1,bstNode n2 )
{
	if(root==null)
		return null;
	if(root==n1 || root==n2)
		return root;
	bstNode left=lca(root.left,n1,n2);
	bstNode right=lca(root.right,n1,n2);
	if(left!=null && right!=null)
		return root;
	if(left==null && right==null)
		return null;
	return left!=null ? left : right;
}