/**
 * Created by jiangph on 16-5-11.
 */
public class IntegerBreak {

    public class Solution{

        /**
         *

         Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.

         For example, given n = 2, return 1 (2 = 1 + 1); given n = 10, return 36 (10 = 3 + 3 + 4).

         Note: you may assume that n is not less than 2.

         作为一道编程题，这道题还是很简单的。简单的观察就能知道拆出足够多的 3 就能使得乘积最大。
         * @param n
         * @return
         */

        public int integerBreak(int n)
        {
            if (n==2) return 1;
            if (n==3) return 2;
            int ret=1;
            while (n>4)
            {
                ret*=3;
                n-=3;
            }
            return ret*n;
        }
    }

}
