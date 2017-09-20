/**
 * Insertion sort algorithm
 */
public class InsertionSort {
    public int[] insertionSort(int[] a){
        for (int j = 1; j <a.length ; j++) {
            int key=a[j];
            //insert a[j] into the sorted sequence a[1...j-1]
            int i=j-1;
            while(i>=0 && a[i]>key){
                a[i+1]=a[i];
                i=i-1;
            }
            a[i+1]=key;
        }
        return a;
    }

    public static void main(String[] args) {
        InsertionSort in = new InsertionSort();
        int[] a=in.insertionSort(new int[]{9,5,3,2,1,5,6});
        for (int i = 0; i <a.length ; i++) {
            System.out.println(a[i]);
        }
    }
}
