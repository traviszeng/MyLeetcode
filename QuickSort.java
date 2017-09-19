/**
 * Quick sort algorithm.
 */
public class QuickSort {
    /**
     * partition procedure of quick sort
     * */
    public int Partition(int[] a,int p, int r){
        int x=a[r];
        int i=p-1;
        for(int j=p;j<=r-1;j++){
            if(a[j]<=x){
                i++;
                int tmp=a[i];
                a[i]=a[j];
                a[j]=tmp;
            }
        }
        int tmp=a[i+1];
        a[i+1]=a[r];
        a[r]=tmp;
        return i+1;
    }

    public void quickSort(int[] a,int p,int r){
        if(p<r){
            int q=Partition(a,p,r);
            quickSort(a,p,q-1);
            quickSort(a,q+1,r);
        }
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        int[] a ={9,5,3,4,6,2,8,1,0};
        q.quickSort(a,0,a.length-1);
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
