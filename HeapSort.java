/**
 * Heap Sort and related function
 */

/**
 * Heap data structure can be seen as a complete binary tree or a array
 *       16
 *      /  \
 *     9    13
 *    / \   /
 *   7   5 6
 *   can be demostrate as an array like [16,9,13,7,5,6]
 **/
public class HeapSort {
    /**
     * params:index of the current node
     * get the parent node of current node
     * */
    public int getParentIndex(int i){
        if(i==0) return 0;
        return (i-1)/2;
    }

    /**
     * params:index of the current node
     * get the left node of current node
     * */
    public int getLeftChildIndex(int i){
        return i*2+1;
    }

    /**
     * params:index of the current node
     * get the right node of current node
     * */
    public int getRightChildIndex(int i){
        return (i+1)*2;
    }

    /**
     * the Max_heapify procedure
     * in order to keep the property of max heap: the value of root node is bigger than the value of leftchild node and rightchild node
     * justify the position of node i and makes the heap satisfies the property of max heap
     * */

    /**
     * T(n) =0(lg n)
     * */
    public void MaxHeapify(int[] a,int i,int heapSize){
        int leftChild =getLeftChildIndex(i);
        int rightChild=getRightChildIndex(i);
        if(leftChild>=heapSize && rightChild>=heapSize) return ;
        int largest=i;
        if(leftChild<heapSize && a[leftChild]>a[i]){
            largest=leftChild;
        }
        if(rightChild<heapSize && a[rightChild]>a[largest]){
            largest=rightChild;
        }
        if(largest!=i){
            int tmp=a[largest];
            a[largest]=a[i];
            a[i]=tmp;
            MaxHeapify(a,largest,heapSize);
        }
    }


    /**
     * build up max heap procedure
     * we use the procedure maxheapify in a bottom-up manner to convert an array a[1...n] into a max heap
     * we can build a max heap from an unorder array in linear time
     **/
    public void BuildUpMaxHeap(int[] a){

        for (int i = (a.length-1)/2; i >=0 ; i--) {
            MaxHeapify(a,i,a.length);
        }
    }

    /**
     * Heap sort procedure
     * */
    public void heapSort(int[] a){
        /**
         * Build up the primitive max heap
         * and make sure the max number in the very first position of the array
         * */
        BuildUpMaxHeap(a);
        int heapSize=a.length;
        for(int i=a.length-1;i>=1;i--){
            int tmp =a[0];
            a[0]=a[i];
            a[i]=tmp;
            heapSize--;
            MaxHeapify(a,0,heapSize);
        }
    }

    public static void main(String[] args) {
        int[] a = {6, 5, 4, 1, 8, 3, 7, 2, 15, 0};
        HeapSort h = new HeapSort();
        h.heapSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
