import java.util.HashMap;
import java.util.Map;



/**
 * Given a 2D integer matrix M representing the gray scale of an image,
 * you need to design a smoother to make the gray scale of each cell
 * becomes the average gray scale (rounding down) of all the 8 surrounding cells and itself.
 * If a cell has less than 8 surrounding cells, then use as many as you can.

 Example 1:

 Input:
 [[1,1,1],
 [1,0,1],
 [1,1,1]]
 Output:
 [[0, 0, 0],
 [0, 0, 0],
 [0, 0, 0]]
 Explanation:
 For the point (0,0), (0,2), (2,0), (2,2): floor(3/4) = floor(0.75) = 0
 For the point (0,1), (1,0), (1,2), (2,1): floor(5/6) = floor(0.83333333) = 0
 For the point (1,1): floor(8/9) = floor(0.88888889) = 0

 Note:

 The value in the given matrix is in the range of [0, 255].
 The length and width of the given matrix are in the range of [1, 150].

 * */

/**
 * Created by Travis Zeng on 2017/9/16
 * */

public class ImageSmoother {

    public static int[][] imageSmoother(int[][] M) {
        if (M.length == 1 && M[0].length == 1) return M;
        Map<Integer, Integer> map = new HashMap<>();

        int flag = 0;
        for (int i = 0; i < M.length; i++) {
            for (int j = 0; j < M[i].length; j++) {
                map.put(flag, M[i][j]);
                flag++;
            }
        }

        for (int i = 0; i < M.length * M[0].length; i++) {
            int sum = map.get(i);
            int num = 1;
            //左上角元素是否存在
            if (map.containsKey(i - M[0].length - 1)&&i%M[0].length!=0&&i>=M[0].length) {
                num++;
                sum += map.get(i - M[0].length - 1);
            }
            //右上角元素是否存在
            if (map.containsKey(i - M[0].length + 1)&&i>=M[0].length&&(i+1)%M[0].length!=0) {
                num++;
                sum += map.get(i - M[0].length + 1);
            }

            //左边元素是否存在
            if (map.containsKey(i - 1)&&i%M[0].length!=0) {
                num++;
                sum += map.get(i - 1);
            }

            //右边元素是否存在
            if (map.containsKey(i + 1)&&(i+1)%M[0].length!=0) {
                num++;
                sum += map.get(i + 1);
            }

            //左下角元素是否存在
            if (map.containsKey(i + M[0].length - 1)&&i%M[0].length!=0&&i<(M.length-1)*M[0].length) {
                num++;
                sum += map.get(i + M[0].length - 1);
            }

            //右下角元素是否存在
            if (map.containsKey(i + M[0].length + 1)&&(i+1)%M[0].length!=0&&i<(M.length-1)*M[0].length) {
                num++;
                sum += map.get(i + M[0].length + 1);
            }

            //正下方元素是否存在
            if(map.containsKey(i+M[0].length)&&i<(M.length-1)*M[0].length){
                num++;
                sum+=map.get(i+M[0].length);
            }

            if(map.containsKey(i-M[0].length)&&i>=M[0].length){
                num++;
                sum+=map.get(i-M[0].length);
            }


            M[i/M[0].length][i%M[0].length] = sum/num;
        }
        return M;
    }

    public static void main(String[] args) {

        int[][] M = {{2,3,4},{5,6,7},{8,9,10},{11,12,13},{14,15,16}};
        int[][] newM = imageSmoother(M);
        for (int i = 0; i <newM.length ; i++) {
            for (int j = 0; j <newM[i].length ; j++) {
                System.out.print(newM[i][j]+" ");
            }
            System.out.println();
        }

    }


    public  int[][] imageSmoother2(int[][] M){
            int rows = M.length;
            int cols = M[0].length;

            int[][] MM = new int[rows][cols];

            for(int row=0; row<rows; row++) {
                for(int col=0; col<cols; col++) {
                    MM[row][col] = compute(M, row, col, rows, cols);
                }
            }
            return MM;
        }

        private int compute(int[][] M, int row, int col, int rows, int cols) {
            int sum = 0;
            int cnt = 0;
            for(int y=-1; y<=1; y++) {
                for(int x=-1; x<=1; x++) {
                    int xx = x+col;
                    int yy = y+row;
                    if(yy >=0 && yy<rows && xx >= 0 && xx < cols) {
                        sum += M[yy][xx];
                        cnt++;
                    }
                }
            }


            return sum / cnt;

    }
}


