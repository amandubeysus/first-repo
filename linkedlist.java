class linkedlist{
       Node head;

      static class Node{
int data;
Node next;
Node (int d)
{data=d;
next=null;
}
}
public int printList()
{
Node n=head;
int count=0;while(n!=null){
n=n.next;
count++;
}
return count;
}

public static void main(String[] args)
{
linkedlist llist=new linkedlist();
llist.head=new Node(1);
Node second=new Node(2);
Node third=new Node(3);

llist.head.next=second;
second.next=third;

System.out.println(llist.printList());
}
}