/**
 * Created by jiangph on 16-4-23.
 */
public class CycleList {
    //define a list node
    public class Node{
        int val;
        Node next;
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }

    //定义一些节点方便使用
    public class NodePost{
        int join;
        int position;
        Node pos;
    }


    //判断是否环
    public boolean IsCycle(Node head)
    {
        Node slow=head;
        Node fast=head;
        NodePost nodePost=new NodePost();
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            if (fast==slow)
                return true;
            nodePost.pos=slow;
        }
        return false;
    }

    //判断环长；这里从相遇处在跑一次，再次相遇即是环长
    public int CycleLength()
    {
        int cycleLength=0;
        NodePost nodePost=new NodePost();
        Node fast=nodePost.pos;
        Node slow=nodePost.pos;
        while (fast!=null&&fast.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
            cycleLength++;
            if (fast==slow)
                return cycleLength;
        }
        return cycleLength;
    }

    //判断从头节点到交点的距离
    public int HeadToJoin(Node node)
    {
        /**
         * 这里有一个重要的定理，头节点到join的距离，跟相遇点到join的距离是一样的
         * 相遇后我们从head节点，还有相遇点pos同时+1遍历就可以得到结果
         */
        //define the param
        NodePost nodePost=new NodePost();
        Node pos=nodePost.pos;
        Node head=node;
        int result=0;
        while (pos==head)
        {
            pos=pos.next;
            head=head.next;
            result++;
        }
        return result;
    }



}
