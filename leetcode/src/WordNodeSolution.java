import java.util.LinkedList;
import java.util.Set;

/**
 * Created by jiangph on 16-4-12.
 */
public class WordNodeSolution {

    class WorldNode{
        String word;
        int numSteps;

        public WorldNode(String word,int numSteps)
        {
            this.word=word;
            this.numSteps=numSteps;
        }
    }

    //声明广度优先遍历的容器，这里是数组，已经字典set

    /**
     * 当前单词相邻的单词是：对当前单词改变一个字母且在字典中存在的单词
     找到一个单词的相邻单词，加入bfs队列后，要从字典中删除，因为不删除的话会造成类似于hog->hot->hog的死循环。而删除对求最短路径没有影响，因为我们第一次找到该单词肯定是最短路径，即使后面其他单词也可能转化得到它，路径肯定不会比当前的路径短（如果要输出所有最短路径，则不能立即从字典中删除，具体见下一题）
     bfs队列中用NULL来标识层与层的间隔，每次碰到层的结尾，遍历深度+1
     * @param beiginWord
     * @param endWord
     * @param wordDict
     * @return
     */
    public int ladderLength(String beiginWord,String endWord,Set<String>wordDict)
    {
        LinkedList<WorldNode>quene=new LinkedList<WorldNode>();
        quene.add(new WorldNode(beiginWord,1));
        //将最终的元素存放到字典中
        wordDict.add(endWord);
        while (quene!=null)
        {
            WorldNode top=quene.remove();
            String word=top.word;
            if (word.equals(endWord))
            {
                return top.numSteps;
            }
            char[]arr=word.toCharArray();
            for (int i=0;i<arr.length;i++)
            {
                char tmp=arr[i];
                for (char c='a';c<'z';c++)
                {
                    if (arr[i]!=c){
                        arr[i]=c;
                    }
                    String newWorld=new String(arr);
                    if (wordDict.contains(newWorld))
                    {
                        quene.add(new WorldNode(newWorld,top.numSteps+1));
                        wordDict.remove(newWorld);
                    }
                    arr[i]=tmp;
                }
            }
        }
        return 0;
    }



}
