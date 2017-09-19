/**
 * Minimum Moves to Equal Array Elements
 * Given a non-empty integer array of size n,
 * find the minimum number of moves required to make all array elements equal,
 * where a move is incrementing n - 1 elements by 1.
 */

import java.util.Arrays;

/**
 * Example:
 * Input:
 [1,2,3]

 Output:
 3

 Explanation:
 Only three moves are needed (remember each move increments two elements):

 [1,2,3]  =>  [2,3,3]  =>  [3,4,3]  =>  [4,4,4]
 * */
public class MinimumMoves {
    public int minMoves(int[] nums) {
        //When it comes to a very big integer it will reach time limit
        int moves=0;
        Arrays.sort(nums);
        if(nums.length==2){
            return nums[1]-nums[0];
        }
        while(nums[0]!=nums[nums.length-1]){
            for (int i = 0; i <nums.length-2 ; i++) {
                nums[i]++;
            }
            Arrays.sort(nums);
            moves++;
        }
        return moves;
    }

    public int minimunMoves(int[] nums){
        //improved algorithm
            if (nums.length == 0) return 0;
            int min = nums[0];
            for (int n : nums) min = Math.min(min, n);
            int res = 0;
            for (int n : nums) res += n - min;
            return res;
    }

    public static void main(String[] args) {
        MinimumMoves m = new MinimumMoves();
        System.out.println(m.minMoves(new int[]{1,1,1,1}));
    }
}
