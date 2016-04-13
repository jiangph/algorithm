import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * Created by jiangph on 16-4-12.
 */
public class consistenthashing {

    public class Node{
        private String nodeName;
        Node(String name)
        {
            this.nodeName=name;
        }

        public String getName(){
            return this.nodeName;
        }

        public String toString()
        {
            return this.nodeName;
        }
        //
        public boolean equals(Object object)
        {
            if (object instanceof Node)
            {
                return ((Node)object).nodeName.equals(this.nodeName);
            }
            return false;
        }

        //override hashcode
        public int hashCode(){
            return this.nodeName.hashCode();
        }
    }

    //声明变量
    private TreeMap<Long,Object>nodes=null;
    //真实的服务器节点信息
    private List<Object>shards=new ArrayList<Object>();
    //设置虚拟节点数目
    private int VIRTUAL_NUM=4;

    /**
     * 初始化一致环
     */
    public void init(){
        shards.add("192.168.0.0-服务器0");
        shards.add("192.168.0.1-服务器1");
        shards.add("192.168.0.2-服务器2");
        shards.add("192.168.0.3-服务器3");
        shards.add("192.168.0.4-服务器4");

        nodes=new TreeMap<Long, Object>();
        for(int i=0;i<shards.size();i++){
            Object shardInfo=shards.get(i);
            for (int j=0;j<VIRTUAL_NUM;j++){
                nodes.put(hash(computeMd5("SHARD-" + i + "-NODE-" + j),j), shardInfo);
            }
        }
    }

    /**
     * 根据key的hash值去的服务器节点信息
     * @param hash
     * @return
     */
    public Object getShardInfo(long hash){
        Long key=hash;
        SortedMap<Long,Object>tailMap=nodes.tailMap(key);
        if (tailMap.isEmpty()){
            key=nodes.firstKey();
        }else {
            key=tailMap.firstKey();
        }
        return nodes.get(key);
    }



    /**
     * 打印圆环节点数据
     */
    public void printMap(){
        System.out.println(nodes);
    }

    /**
     * 根据2^32把节点分布到圆环上面
     * @param digest
     * @param nTime
     * @return
     */
    public long hash(byte[]digest,int nTime){
        long rv = ((long) (digest[3+nTime*4] & 0xFF) << 24)
                | ((long) (digest[2+nTime*4] & 0xFF) << 16)
                | ((long) (digest[1+nTime*4] & 0xFF) << 8)
                | (digest[0+nTime*4] & 0xFF);

        return rv & 0xffffffffL; /* Truncate to 32-bits */
    }



    /**
     * 计算MD5的值
     * @param k
     * @return
     */
    public byte[]computeMd5(String k)
    {
        MessageDigest md5;
        try{
            md5=MessageDigest.getInstance("MD5");
        }catch (NoSuchAlgorithmException e){
            throw new RuntimeException("unknow things"+e);
        }
        md5.reset();
        byte[]keyBytes=null;
        try{
            keyBytes=k.getBytes("UTF-8");
        }catch (UnsupportedEncodingException e)
        {
            throw  new RuntimeException("unknow things"+e);
        }
        md5.update(keyBytes);
        return md5.digest();
    }



    public static void main(String[]args){
        Random ran=new Random();
        consistenthashing hash=new consistenthashing();
        hash.init();
        hash.printMap();
        //循环50次，是为了取50个数来测试效果，当然也可以用其他任何的数据来测试
        for(int i=0; i<50; i++) {
            System.out.println(hash.getShardInfo(hash.hash(hash.computeMd5(String.valueOf(i)),ran.nextInt(hash.VIRTUAL_NUM))));
        }
    }


}