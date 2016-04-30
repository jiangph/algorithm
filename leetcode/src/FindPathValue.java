import java.util.Stack;

/**
 * Created by jiangph on 16-4-30.
 */
public class FindPathValue {

    /**
     *输入一个整数和一棵二元树。从树的根结点开始往下访问一直到叶结点所经过的所有结点形成一条
     路径。打印出和与输入整数相等的所有路径
     */

    class Node{
        Node left;
        Node right;
        int val;
        public Node(Node left,Node right, int val)
        {
            this.left=left;
            this.right=right;
            this.val=val;
        }
    }

    public class Solution{
        //define a class to restore the stack result
        int top=0;
        Stack<Node> stack=new Stack<Node>();
        public void FindPath(Node node,int sum,int currSum){
            stack.push(node);
            if (node==null) return;
            currSum+=node.val;
            if (node.left==null&&node.right==null&&currSum==sum)
            {
                for (int i=0;i<stack.size();i++)
                {
                    System.out.println(stack.pop());
                }
            }
            else {
                FindPath(node.left,sum,currSum);
                FindPath(node.right,sum,currSum);
            }
            currSum+=node.val;

        }


    }

}
