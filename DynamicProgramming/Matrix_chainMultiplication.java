package DynamicProgramming;

/**
 * Solving matrix chain multiplication through dynamic programming
 */
public class Matrix_chainMultiplication {
    /**
     * the equation of the optimal sub-structure:
     *  m[i,j]=m[i,k]+m[k+1,j]+p(i-1)*p(k)*p(j)
     *
     * */
    /**
     * Assume the matrix chain is compatible and the rows and cols are stored as [100,5,6] which means
     * there are two matrix : 100*5 5*6
     **/
    /**
     * 输入是一个序列p=[p0,p1,p2....pn]
     * 使用一个辅助表m[n][n]来保存m[i,j]的代价
     * 使用s[n][n]来保存获得m[i,j]时候的k值
     *
     * */
    int[][] m = new int[6][6];
    int[][] s = new int[6][6];
    int[] p={30,35,15,5,10,20,25};
    public void matrixChainOrder(int[] p){
        int n=p.length-1;
        for (int i = 0; i <n ; i++) {
            m[i][i]=0;
        }
        for (int l=2;l<=n;l++){      //l is the chain length
            for (int i = 1; i <=n-l+1 ; i++) { // 计算长度为l的子结构时i所能到的最大值
                int j=i+l-1;
                m[i-1][j-1]=Integer.MAX_VALUE;
                for (int k = i; k <=j-1 ; k++) {
                    int q=m[i-1][k-1]+m[k+1-1][j-1]+p[i-1]*p[k]*p[j];
                    if (q<m[i-1][j-1]){
                        m[i-1][j-1]=q;
                        s[i-1][j-1]=k;
                    }
                }
            }
        }
    }

    public void printOptimalParens(int[][] s,int i,int j){
        if(i==j){
            System.out.print("A"+i);
        }
        else{
            System.out.print("(");
            printOptimalParens(s,i,s[i-1][j-1]);
            printOptimalParens(s,s[i-1][j-1]+1,j);
            System.out.print(")");
        }
    }

    public static void main(String[] args) {
        Matrix_chainMultiplication mm = new Matrix_chainMultiplication();
        mm.matrixChainOrder(mm.p);
        for (int i = 0; i <mm.m.length ; i++) {
            for (int j = 0; j <mm.m[i].length ; j++) {
                System.out.print(mm.m[i][j]+"   ");
            }
            System.out.println();
        }
        for (int i = 0; i <mm.s.length ; i++) {
            for (int j = 0; j <mm.s[i].length ; j++) {
                System.out.print(mm.s[i][j]+"   ");
            }
            System.out.println();
        }
        mm.printOptimalParens(mm.s,1,6);
    }
}


