package Introduction;

public class LinkedList {

    public static class  Node{
        int data;
        Node next;

        public Node(int data){
            this.data=data;
            this.next=null;
        }
    }
    public static Node head;
    public static Node tail;

    //Methods
    /*
    add()
    remove()
    print()
    search()
    */

    //add first
    public void addFirst(int data){
        Node newNode=new Node(data);

        if(head==null){
            head=tail=newNode;
            return;
        }
        newNode.next=head;
        head=newNode;
    }

    //add last
    public void addLast(int data){
        Node newNode=new Node(data);

        if (head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    public static void main(String[] args) {

        LinkedList ll=new LinkedList();


    }
}
