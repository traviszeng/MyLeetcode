
/**
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.

 The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.

 You may assume that each input would have exactly one solution.

 Input: numbers={2, 7, 11, 15}, target=9
 Output: index1=1, index2=2
 */
public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int UpBorder = numbers.length-1;
        for (int i = numbers.length-1; i >=0 ; i--) {
            if(numbers[i]>target) UpBorder--;
            else break;
        }
        if(UpBorder!=numbers.length-1) UpBorder++;
        int DownBorder = 0;
        while(DownBorder<UpBorder){
            if(numbers[DownBorder]+numbers[UpBorder]==target)
                return new int[]{DownBorder+1,UpBorder+1};
            else if(numbers[DownBorder]+numbers[UpBorder]<target){
                DownBorder++;
            }else{
                UpBorder--;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        TwoSumII t= new TwoSumII();
        int[] a = t.twoSum(new int[]{-3,3,9,8},0);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }

}
