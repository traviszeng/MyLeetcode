/**
 *  Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

 For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 */
public class MoveZeros {
    public void moveZeroes(int[] nums) {
        for (int i = 1; i <nums.length ; i++) {
           int flag = 1;
           while(nums[i-flag]==0&&nums[i-flag+1]!=0){
               int temp=nums[i-flag+1];
               nums[i-flag+1]=nums[i-flag];
               nums[i-flag]=temp;
               if(i-(flag+1)>=0){
                   flag++;
               }
           }
        }
    }

    public void moveZeroesOthers(int[] nums){
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
            for (int k = 0; k <nums.length ; k++) {
                System.out.print(nums[k]+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        MoveZeros m = new MoveZeros();
        int[] a=new int[]{0, 0,1,3,5,0,6,8,0,0,12};
        m.moveZeroesOthers(a);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
