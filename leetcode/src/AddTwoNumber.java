/**
 * Created by jiangph on 16-4-23.
 */
public class AddTwoNumber {

    class ListNode{
        int val;
        ListNode next;
        ListNode(int x){
            val=x;
            next=null;
        }
    }

    public class Solution{
        public ListNode addTwoNumber(ListNode l1,ListNode l2)
        {
            if (l1==null) return l2;
            if (l2==null) return l1;
            //把相加后的结果存放于链表l1
            ListNode ret=l1;
            ListNode pre1=new ListNode(0);
            pre1.next=l1;
            //表进位
            int flag=0;
            while (l1!=null&&l2!=null)
            {
                l1.val=l1.val+l2.val+flag;
                flag=l1.val/10;
                l1.val=l1.val%10;
                pre1=l1;
                l1.next=l1.next;
                l2.next=l2.next;
            }

            //如果链表2有剩余，接到链表1的后面
            if (l2!=null){
                pre1.next=l2;
                l1=l2;
            }

            while (l1!=null)
            {
                l1.val+=flag;
                flag=l1.val/10;
                l1.val=l1.val%10;
                pre1=l1;
                l1=l1.next;
            }
            return ret;

        }
    }


}
