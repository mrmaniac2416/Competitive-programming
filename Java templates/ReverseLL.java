 Node reverseDLL(Node head)
    {
        // Your code here  
        if(head==null || head.next==null)
           return head;
        
        Node newHead=reverse(head.next);
        head.next.next=head;
        head.prev=head.next;
        head.next=null;
        
        return newHead;
        
    }

  Node reverse(Node head)
    {
        // Your code here  
        if(head==null || head.next==null)
           return head;
        
        Node newHead=reverse(head.next);
        head.next.next=head;
        head.next=null;
        
        return newHead;
        
    }
