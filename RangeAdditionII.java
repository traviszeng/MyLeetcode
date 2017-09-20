/**
 * Created by TravisZeng on 2017/7/25.
 */

/**
 * Given an m * n matrix M initialized with all 0's and several update operations.

 Operations are represented by a 2D array, and each operation is represented by an array with two positive integers a and b, which means M[i][j] should be added by one for all 0 <= i < a and 0 <= j < b.

 You need to count and return the number of maximum integers in the matrix after performing all the operations.

 Example 1:

 Input:
 m = 3, n = 3
 operations = [[2,2],[3,3]]
 Output: 4
 Explanation:
 Initially, M =
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]

 After performing [2,2], M =
 [[1, 1, 0],
 [1, 1, 0],
 [0, 0, 0]]

 After performing [3,3], M =
 [[2, 2, 1],
 [2, 2, 1],
 [1, 1, 1]]

 So the maximum integer in M is 2, and there are four of it in M. So return 4.

 Note:

 The range of m and n is [1,40000].
 The range of a is [1,m], and the range of b is [1,n].
 The range of operations size won't exceed 10,000.

 *
 * */
public class RangeAdditionII {

    //brutal solution
    public int maxCount(int m, int n, int[][] ops) {
        int[][] number = new int[m][n];
        for (int i = 0; i <ops.length ; i++) {
            arrayAdd(ops[i][0],ops[i][1],number);
        }
        return findMax(number[0][0],number);
    }

    public void arrayAdd(int a,int b, int[][] array){
        for (int i = 0; i <a; i++) {
            for(int j = 0; j<b;j++){
                array[i][j]+=1;
            }
        }
    }

    public int findMax(int max,int[][] array){
        int amountOfMaxNumber= 0;
        for (int i = 0; i <array.length ; i++) {
            for (int j = 0; j <array[i].length ; j++) {
                if(array[i][j]==max){
                    amountOfMaxNumber+=1;
                }
                else{
                    break;
                }
            }
        }
        return amountOfMaxNumber;
    }

    public int maxCountII(int m, int n, int[][] ops) {
        if(m==0||n==0) return 0;
        if(ops==null||ops.length==0) return m*n;
        int minOfA = ops[0][0];
        int minOfB = ops[0][1];
            for (int j = 1; j <ops.length ; j++) {
                if(ops[j][0]<minOfA) minOfA = ops[j][0];
                if(ops[j][1]<minOfB) minOfB = ops[j][1];
            }
        return minOfA*minOfB;
    }

    public static void main(String[] args){
        int[][] ops = {};
        RangeAdditionII r = new RangeAdditionII();
        //System.out.println(r.maxCount(3,3,ops));

        System.out.println(r.maxCountII(3,3,ops));
    }
}
