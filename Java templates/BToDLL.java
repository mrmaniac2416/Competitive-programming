class GfG
{
Node head;
static Node prev = null;
void convert(Node root, Node headref) {
if (root == null)
return;
convert(root.left, headref);
if (head == null) {
head = root;
} else {
prev.right = root;
root.left = prev;
}
prev = root;
convert(root.right, headref); 
}
Node BToDLL(Node root)
{
convert(root, null);
return head;
}
}