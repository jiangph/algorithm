import java.util.LinkedList;

/**
 * Created by jiangph on 16-4-10.
 */
public class Trie {
    //字典树
    //构建节点
    class Node{
       char content; //装node中的内容
       boolean isEnd; //是否是单词的结尾
       int count; //这个单词的这个字母下面的分支的个数
       LinkedList<Node>childList;//子list

    public Node(char c)
    {
        childList=new LinkedList<Node>();
        isEnd=false;
        content=c;
        count=0;
    }

       /**
        * 遍历一下这个node中的linkedlist中是否有这个字母
        * 有就意味着可以继续找下去，没有就没有
        * @param c
        * @return  如果有的话就返回下一个node，没有就是null
        */
       public  Node subNode(char c)
       {
           if (childList!=null)
           {
               for(Node eachChild:childList){
                   if (eachChild.content==c)
                   {
                       return eachChild;
                   }
               }
           }
               return null;
       }

   }

    //具体实现
    private Node root; //根

    /**
     * 构造函数生成根
     */
    public Trie()
    {
        root=new Node(' ');
    }


    /**
     * 插入函数，先判断是否有这个单词了（通过每个单词字母来判断）如果有就按着顺序来判断
     * 如果有这个字母，姬玄判断下一个，的没有这个字母的时候，对这个字母new一个node，放入到上一字母的后面
     * @param word
     */
    public void insert(String word){
        //如果找到就返回
        if (search(word)==true) return;
        Node current=root;
        for (int i=0;i<word.length();i++)
        {
            Node child=current.subNode(word.charAt(i));
            if (child!=null)
            {
                current=child;
            }
            else {
                current.childList.add(new Node(word.charAt(i)));
                current=current.subNode(word.charAt(i));
            }
            //单词下面的分支数++
            current.count++;
        }
        //在单词最后字母那里结束了
        current.isEnd=true;
    }

    /**
     * 查找函数，判断是狗已经有隔着单词了
     * @param word 要判断的单词
     * @return 有这个单词就返回true 没有返回false
     */
    public boolean search(String word)
    {
        Node current=root;
        for (int i=0;i<word.length();i++)
        {
            if (current.subNode(word.charAt(i))==null)
            {
                return false;
            }
            else
                current=current.subNode(word.charAt(i));
        }
        //判断这个单词的这个字母是狗在字典里面结束了
        if (current.isEnd==true) return true;
        else return false;
    }

    /**
     * 删除函数，先判断是否存在这个单词，不存在就跳出，存在就删除
     * @param word
     */
    public void deleteWord(String word)
    {
        if (search(word)==false)return;
        Node current=root;
        for (char c:word.toCharArray()){
            Node child=current.subNode(c);
            if (child.count==1)
            {
                current.childList.remove(child);
                return;
            }
            else {
                child.count--;
                current=child;
            }
        }
        current.isEnd=false;
    }

    //for test
    public static void main(String[]args)
    {
        Trie trie=new Trie();
        trie.insert("ball");
        trie.insert("balls");
        trie.insert("sense");
        System.out.println(trie.search("ball"));
        trie.deleteWord("balls");
        System.out.println(trie.search("ball"));
    }








}
