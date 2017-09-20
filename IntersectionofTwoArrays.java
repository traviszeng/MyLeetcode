import java.util.*;

/**
 *  Given two arrays, write a function to compute their intersection.

 Example:
 Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

 Note:

 Each element in the result must be unique.
 The result can be in any order.

 */
public class IntersectionofTwoArrays {
    public int[] intersection(int[] nums1, int[] nums2) {
        Map<Integer,Integer>  map1 = new HashMap<>();
        for (int i = 0; i <nums1.length ; i++) {
            if(!map1.containsKey(nums1[i])){
                map1.put(nums1[i],0);
            }else{
             continue;
            }
        }
        for (int i = 0; i <nums2.length ; i++) {
            if(map1.containsKey(nums2[i])&&map1.get(nums2[i])==0){
               map1.remove(nums2[i]);
               map1.put(nums2[i],1);
            }
        }
        List<Integer> list = new ArrayList<Integer>();
        for (Map.Entry<Integer, Integer> entry : map1.entrySet()) {
            if(entry.getValue()==1){
                list.add(entry.getKey());
            }
        }
        int[] a = new int[list.size()];
        for (int i = 0; i <a.length ; i++) {
            a[i]=list.get(i);
        }
        return a;
    }

    public int[] intersectionUsingSet(int[] nums1, int[] nums2){
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    }


    public static void main(String[] args) {
        IntersectionofTwoArrays i = new IntersectionofTwoArrays();
        i.intersection(new int[]{11,1,2,2,3},new int[]{2,2,3});
    }
}
