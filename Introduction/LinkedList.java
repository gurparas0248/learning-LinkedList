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
    public static int size;

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
        size++;

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
        size++;

        if (head==null){
            head=tail=newNode;
            return;
        }

        tail.next=newNode;
        tail=newNode;
    }

    //printing LL

    public void print(){
        if(head==null){
            System.out.println("empty ll");
            return;
        }
        Node temp=head;
        while(temp!=null){
            System.out.print(temp.data+"->");
            temp=temp.next;
        }
        System.out.println("null");
    }

    //add index
    public void addIndex(int index,int data){
        if(index==0){
            addFirst(data);
            return;
        }
        Node newNode=new Node(data);
        size++;
        Node temp=head;
        int i=0;
        while(i<index-1){
            temp=temp.next;
            i++;
        }
        newNode.next=temp.next;
        temp.next=newNode;

    }

    //remove first
    public int removefirst(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        int val= head.data;
        head=head.next;
        size--;
        return val;
    }

    //remove last
    public int removeLast(){
        if(size==0){
            System.out.println("LL is empty");
            return Integer.MIN_VALUE;
        } else if (size==1) {
            int val=head.data;
            head=tail=null;
            size=0;
            return val;

        }
        Node prev=head;
        for(int i=0;i<size-2;i++){
            prev=prev.next;
        }
        int val=tail.data;
        prev.next=null;
        tail=prev;
        size--;
        return val;
    }

    //Iterative search
    public int search(int key){
        Node temp=head;
        int i=0;
        while(temp!=null){
            if(temp.data==key){
                return i;
            }
            temp=temp.next;
            i++;
        }
        return -1;
    }

    //recursive search

    public int helper(Node head,int key){
        if(head==null){
            return -1;
        }
        if(head.data==key){
            return 0;
        }
        int index=helper(head.next,key);
        if(index==-1){
            return -1;
        }
        return index+1;
    }
    public int recSearch(int key){
        return helper(head,key);
    }

    //reverse a Linked List
    public void reverse(){
        Node prev=null;
        Node curr=tail=head;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        head=prev;
    }

    //deleteNthfromEnd
    public void deleteNthfromEnd(int n){
        //calculate size
        int sz=0;
        Node temp=head;
        while (temp!=null){
            temp=temp.next;
            sz++;
        }
        if(n==sz){
            head=head.next;
            return;
        }
        //sz-n
        int i=1;
        int iToFind=sz-n;
        Node prev=head;
        while(i<iToFind){
            prev=prev.next;
            i++;
        }
        prev.next=prev.next.next;
        return;
    }
    //finding middle node (Slow fast Approach)
    public Node findMid(Node haad){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next; //+1
            fast=fast.next.next; //+2
        }
        return slow; //slow is mid
    }

    public boolean checkPalindrome(){
        if(head==null || head.next==null){
            return true;
        }
        //step1- find mid

        Node midNode=findMid(head);

        //step2- reverse 2nd half
        Node prev=null;
        Node curr=midNode;
        Node next;
        while(curr!=null){
            next=curr.next;
            curr.next=midNode;
            prev=curr;
            curr=next;
        }

        Node right =prev; //right half head
        Node left=head; // left half head

        //step3 - check left half and right half
        while(right!=null){
            if(left.data!= right.data){
                return false;
            }
            left=left.next;
            right=right.next;
        }

        return true;
    }

    //Detecting Cycle in ll
    public static boolean isCycle(){
        Node slow=head;
        Node fast=head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
            if(slow==fast){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

        head=new Node(1);
        head.next=new Node(2);
        head.next.next=new Node(3);
        //head.next.next.next=new Node(4);
        System.out.println(isCycle());





    }
}
