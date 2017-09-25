/**
 * Created by Travis Zeng on 2017/9/25
 * */

/**
 * Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

 You may assume no duplicates in the array.

 Here are few examples.
 [1,3,5,6], 5 → 2
 [1,3,5,6], 2 → 1
 [1,3,5,6], 7 → 4
 [1,3,5,6], 0 → 0
 * */
public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if(nums.length==0) return 0;
        if(target<nums[0]) return 0;
        if(target>nums[nums.length-1]) return  nums.length;
        int position =nums.length-1;
        while(nums[position]>target) {
            position--;
        }
        if(nums[position]<target) return position+1;
        return position;
    }

    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        SearchInsertPosition s = new SearchInsertPosition();
        System.out.println(s.searchInsert(nums,4));
    }
}
