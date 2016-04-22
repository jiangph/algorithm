/**
 * Created by jiangph on 16-4-23.
 */
public class MedianTwoSortArray {
    //两个有序数组取出第小的数
    //关键性质，较小队列k/2一定在前面
    class solution{

        public int  KSortArray(int[]a,int m,int[]b,int n,int k)
        {
            int[]aa;
            if (m<n)
                return KSortArray(b,n,a,m,k);
            else if (m<=0)
                return b[k-1];
            else {
                int pa = Math.min(k / 2, m);
                int pb = k - pa;
                aa = new int[m - pa];
                if (a[pa - 1] > b[pb - 1]) {
                    for (int i = 0; i < m-pa; i++) {
                        aa[i] = a[i + pa];
                    }
                    return KSortArray(aa, m - pa, b, n, k);

                }
                else if (a[pa-1]<b[pb-1]){
                    for (int i=0;i<n-pb;i++){
                        aa[i]=b[i+pa];
                    }
                    return KSortArray(aa,n-pb,b,n,k);
                }
                else
                    return a[pa-1];
            }


        }
    }


}
