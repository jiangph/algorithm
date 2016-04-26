import java.util.Scanner;

/**
 * Created by jiangph on 16-4-26.
 */
public class KnapsackProblem {

    /**
     *  求解背包问题：
     * 给定 n 个背包，其重量分别为 w1,w2,……,wn, 价值分别为 v1,v2,……,vn
     * 要放入总承重为 totalWeight 的箱子中，
     * 求可放入箱子的背包价值总和的最大值。
     *
     * NOTE: 使用动态规划法求解 背包问题
     * 设 前 n 个背包，总承重为 j 的最优值为 v[n,j], 最优解背包组成为 b[n];
     * 求解最优值：
     * 1. 若 j < wn, 则 ： v[n,j] = v[n-1,j];
     * 2. 若  j >= wn, 则：v[n,j] = max{v[n-1,j], vn + v[n-1,j-wn]}。
     *
     * 求解最优背包组成：
     * 1. 若 v[n,j] > v[n-1,j] 则 背包 n 被选择放入 b[n],
     * 2. 接着求解前 n-1 个背包放入 j-wn 的总承重中，
     *    于是应当判断 v[n-1, j-wn] VS v[n-2,j-wn], 决定 背包 n-1 是否被选择。
     * 3. 依次逆推，直至总承重为零。
     *
     *    重点： 掌握使用动态规划法求解问题的分析方法和实现思想。
     *    分析方法： 问题实例 P(n) 的最优解S(n) 蕴含 问题实例 P(n-1) 的最优解S(n-1);
     *              在S(n-1)的基础上构造 S(n)
     *    实现思想： 自底向上的迭代求解 和 基于记忆功能的自顶向下递归
     * @param args
     */
    public static void main(String[]args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("input the thing number");
        int item=sc.nextInt();
        int[]weight=new int[item];
        int[]value=new int[item];
        for (int i=0;i<item;i++)
        {
            System.out.print("input each item's weight");
            weight[i]=sc.nextInt();
            System.out.print("input each item's value");
            value[i]=sc.nextInt();
        }
        System.out.print("input the total weight");
        int weigh=sc.nextInt();
        //construct the max
        int[][]Knapsack=new int[item][weigh];
        //init the matrix
        for (int i=0;i<weigh;i++)
        {
            Knapsack[0][i]=0;
        }
        for (int j=1;j<item;j++)
        {
            Knapsack[j][0]=0;
        }
        //the state exchange function
        for (int i=1;i<item;i++)
        {
            for (int j=1;j<weigh;j++)
            {
                if (weight[i-1]>j)
                    Knapsack[i][j]=Knapsack[i-1][j];
                else
                {
                    Knapsack[i][j]=Math.max(Knapsack[i-1][j],Knapsack[i-1][j-weight[i-1]]+value[i-1]);
                }
            }
        }

    }
}
