
    public static class Node{
        int data;
        Node next;

        Node(int data)
        {
            this.data=data;
            this.next=null;
        }
    }
    public static class LinkedList{
        Node head;

        LinkedList()
        {
            head=null;
        }

        void insert(int data)
        {
            if(head==null)
                head=new Node(data);
            else
            {
                Node temp=head;
                while (temp.next!=null)
                    temp=temp.next;
                temp.next=new Node(data);
            }
        }
        void insert(int data,int pos)
        {
            int traversed=1;
            if(pos==1)
            {
                Node temp=new Node(data);
                temp.next=head;
                head=temp;
            }
            else
            {
                Node temp=head;
                while (traversed<(pos-1))
                {
                    temp=temp.next;
                    traversed++;
                }
                Node newNode=new Node(data);
                Node prevNode=temp.next;
                temp.next=newNode;
                newNode.next=prevNode;
            }
        }

        void printForward()
        {
            Node temp=head;
            while (temp!=null)
            {
                System.out.print(temp.data + " ");
                temp=temp.next;
            }
            System.out.println();
        }
        void reverseIterative()
        {
            Node currPointer=head;
            Node nextPointer=head.next;
            head.next=null;
            while (nextPointer!=null)
            {
                Node next=nextPointer.next;
                nextPointer.next=currPointer;
                currPointer=nextPointer;
                nextPointer=next;
            }
            head=currPointer;
        }

        void reverseRecursive(Node p)
        {
            if(p.next==null)
            {
                head=p;
                return;
            }
            reverseRecursive(p.next);
            p.next.next=p;
            p.next=null;
        }
        void printForwardRecursive(Node head)
        {
            if(head==null)
            {
                System.out.println();
                return;
            }
            System.out.print(head.data + " ");
            printForwardRecursive(head.next);
        }
        void printReverseRecursive(Node head)
        {
            if(head==null)
            {
                System.out.println();
                return;
            }
            printReverseRecursive(head.next);
            System.out.print(head.data + " ");
        }
        void deleteData(int data)
        {
            if(head.data==data)
            {
                head=head.next;
                return;
            }
            Node temp=head;
            while (temp.next!=null && temp.next.data!=data )
            {
                temp=temp.next;
            }
            if(temp.next==null)
                return;
            Node toBeDeleted=temp.next;
            temp.next=toBeDeleted.next;
            toBeDeleted=null;
        }
        void deletePos(int pos) //1 indexed
        {
             if(pos==1)
             {
                  head=head.next;
             }
             else
             {
                 Node temp=head;
                 int traversed=1;
                 while (traversed<(pos-1))
                 {
                     temp=temp.next;
                     traversed++;
                 }
                 Node toBeDeleted=temp.next;
                 temp.next=toBeDeleted.next;
                 toBeDeleted=null;
             }
        }

    }
