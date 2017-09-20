package DynamicProgramming;

/**
 * Find the fastest assembly line solved by dynamic programming
 */
public class TheFastestAssemblyLine {
    /**
     * 两条拥有相同作用但不同工作时间的装配线，在同一装配线上移动时间可忽略但移到另一条工作线上就需要t[i][j] i=1  or 2
     * 进入和退出两条工作线的时间也不一样记为:进入时间：e[1],e[2] 退出时间：x[1],x[2]
     * 在两条工作线上第j个工作站需用时间为a[i][j] i=1 or 2
     * 需要用动态规划的方法找到用时最短的装配方案
     **/

    //amount of station
    public int  numOfStation=6;
    //moving time cost
    public int[][] t = {{2,3,1,3,4},{2,1,2,2,1}};
    //assemble time cost
    public int[][] a ={{7,9,3,4,8,4},{8,5,6,4,5,7}};
    //time cost of the fastest way to get to station(i,j)
    public int[][] f =new int [2][numOfStation];
    //get in time cost
    public int e1=2;
    public int e2=4;
    //get out time cost
    public int x1=3;
    public int x2=2;
    //the line record: record the current fastest way solution is from which line
    public int[][] l = new int[2][numOfStation];
    //optimal solution
    public int ff;
    public int ll;

    public void fastestWay(int[][] a,int[][] t,int e1, int e2, int x1,int x2,int numOfStation){
        f[0][0]=a[0][0]+e1;
        f[1][0]=a[1][0]+e2;
        for(int j=1;j<numOfStation;j++){
            if(f[0][j-1]+a[0][j]<=f[1][j-1]+t[1][j-1]+a[0][j]){
                f[0][j]=f[0][j-1]+a[0][j];
                l[0][j]=1;
            }
            else{
                f[0][j]=f[1][j-1]+t[1][j-1]+a[0][j];
                l[0][j]=2;
            }
            if(f[1][j-1]+a[1][j]<=f[0][j-1]+t[0][j-1]+a[1][j]){
                f[1][j]=f[1][j-1]+a[1][j];
                l[1][j]=2;
            }
            else{
                f[1][j]=f[0][j-1]+t[0][j-1]+a[1][j];
                l[1][j]=1;
            }
        }
        if(f[0][numOfStation-1]+x1<=f[1][numOfStation-1]+x2){
            ff=f[0][numOfStation-1]+x1;
            ll=1;
        }else{
            ff=f[1][numOfStation-1]+x2;
            ll=2;
        }
    }

    public void printStation(int[][] l,int ll,int numOfStation){
        int i=ll;
        System.out.println("line "+i+",station "+numOfStation);
        for (int j=numOfStation;j>1;j--){
            i=l[i-1][j-1];
            System.out.println("line "+i+",station "+(j-1));
        }
        System.out.println("time is :"+ff);
    }


    public static void main(String[] args) {
        TheFastestAssemblyLine tt = new TheFastestAssemblyLine();
        tt.fastestWay(tt.a,tt.t,tt.e1,tt.e2,tt.x1,tt.x2,tt.numOfStation);
        for (int i = 0; i <tt.f.length ; i++) {
            for (int j = 0; j <tt.f[i].length ; j++) {
                System.out.print(tt.f[i][j]+" ");
            }
            System.out.println();
        }
        for (int i = 0; i <tt.f.length ; i++) {
            for (int j = 0; j <tt.f[i].length ; j++) {
                System.out.print(tt.l[i][j]+" ");
            }
            System.out.println();
        }

        tt.printStation(tt.l,tt.ll,tt.numOfStation);
    }
}
