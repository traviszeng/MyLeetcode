/**
 * Created by TravisZeng on 2017/8/27.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *  If the depth of a tree is smaller than 5, then this tree can be represented by a list of three-digits integers.

 For each integer in this list:

 The hundreds digit represents the depth D of this node, 1 <= D <= 4.
 The tens digit represents the position P of this node in the level it belongs to, 1 <= P <= 8. The position is the same as that in a full binary tree.
 The units digit represents the value V of this node, 0 <= V <= 9.

 Given a list of ascending three-digits integers representing a binary with the depth smaller than 5. You need to return the sum of all paths from the root towards the leaves.

 Example 1:

 Input: [113, 215, 221]
 Output: 12
 Explanation:
 The tree that the list represents is:
 3
 / \
 5   1

 The path sum is (3 + 5) + (3 + 1) = 12.

 Example 2:

 Input: [113, 221]
 Output: 4
 Explanation:
 The tree that the list represents is:
 3
 \
 1

 The path sum is (3 + 1) = 4.

 * */
public class PathSum {
    public int pathSum(int[] nums) {
        int sum = 0;
        List<Integer> list = new ArrayList();
        Map<Integer,Integer> map= new HashMap<>();
        for(int i=nums.length-1;i>=0;i--)
        {
            list.add(nums[i]/10);
            map.put(nums[i]/10,nums[i]%10);
        }

        int root = map.get(11);
        list.remove(list.size()-1);

        if(list.size()==0) return root;
        else{
            while(list.size()>0){
                int leaves =list.get(0);
                list.remove(0);

                //位置
                int position = leaves%10;
                int aleaves = leaves/10;
                //对应的层数
                int level = aleaves%10;

                if(map.containsKey((level+1)*10+position*2)||map.containsKey((level+1)*10+position*2-1)) continue;
                sum = sum+map.get(leaves);

                while(level >2){
                    sum =sum +map.get((level-1)*10+(position+1)/2);
                    //list.remove(list.indexOf((level-1)*10+(position+1)/2));
                    level = level-1;
                    position = (position+1)/2;

                }
                sum = sum+root;

            }
        }
        return sum;
    }


    public static void main(String[] args){
        PathSum path =new PathSum();
        System.out.println(path.pathSum(new int[]{111,217,221,315,415}));
    }
}
