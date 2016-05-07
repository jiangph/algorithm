/**
 * Created by jiangph on 16-5-7.
 */
public class RotateList {

    class Node{
        Node next;
        int val;
        Node(Node next,int val)
        {
            this.next=next;
            this.val=val;
        }
    }

    public class Solution{

        public Node rotate(Node head,int k)
        {
            if (head==null) return null;
            Node p=head;
            int len=1;
            while (p!=null&&p.next!=null)
            {
                p=p.next;
                len++;
            }
            k=k%len;
            int countTail=len-k;
            Node newHead=head;
            while (countTail>1)
            {
                newHead=newHead.next;
            }
            Node tmp=newHead.next;
            newHead.next=null;
            p.next=head;
            head=tmp;
            return head;
        }

    }

}
