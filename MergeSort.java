/**
 * Merge Sort algorithm
 */
public class MergeSort {

        /**
         * params: a is a array
         * p,q,r is index
         * and p<=q<r
         * and a[p--q]is sorted in order
         * a[q--r] is sorted in order as well
         * use this method to merge two sorted small array into one
         **/
        public  void  mergeProcess(int[] A,int p,int q,int r)
        {
            int nl=q-p+1;
            int nr=r-q;
            int [] rArr=new int[nl+1];
            int [] lArr=new int [nr+1];

            for(int i=0;i<nl;i++)
            {
                rArr[i]=A[i+p];
            }

            for(int j=0;j<nr;j++)
            {
                lArr[j]=A[j+q+1];
            }
            rArr[nl] = Integer.MAX_VALUE;
            lArr[nr] = Integer.MAX_VALUE;
            int n=0;
            int m=0;
            //接下来进行比较
            for(int i=p;i<=r;i++)
            {
                    if(lArr[m]<rArr[n])
                    {
                        A[i]=lArr[m];
                        m++;
                    }
                    else
                    {
                        A[i]=rArr[n];
                        n++;
                    }
                }

        }

        /**
         * divide-and-conquer process
         * divide until there is only one element in the subsequence
         * */
    public void mergeSort(int[] A,int p,int r)
    {
        if(p == r){
        return;
    }else
    {
        int q=(r+p)/2;
        mergeSort(A,p,q);
        mergeSort(A,q+1,r);
        mergeProcess(A,p,q,r);
    }
    }
    public static void main(String[] args) {
        MergeSort m = new MergeSort();
        int[] a = new int[]{9,1,2,6,4,8,3,2,11,23,1,5,3,2,9,7,6};
        m.mergeSort(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
