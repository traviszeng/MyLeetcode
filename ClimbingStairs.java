/**
 * Created by Travis Zeng on 2017/9/22
 * */


/**
 *You are climbing a stair case. It takes n steps to reach to the top.

 Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

 Note: Given n will be a positive integer.
 * */

public class ClimbingStairs {
    public int climbStairs(int n) {
        int[] count=new int[n+1];
        count[0]=1;
        count[1]=1;
        for(int i=2;i<=n;i++){
            count[i]=count[i-2]+count[i-1];
        }
        return count[n];

    }

}
