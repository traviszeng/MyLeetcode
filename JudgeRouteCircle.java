import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.*;

/**
 * Created by Administrator on 2017/8/13.
 */
public class JudgeRouteCircle {
    public boolean judgeCircle(String moves) {
        if(moves==null) return true;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0;i<moves.length();i++){
            if(map.get(moves.charAt(i))==null){
                map.put(moves.charAt(i),1);
            }
            else{
                map.put(moves.charAt(i),map.get(moves.charAt(i))+1);
            }
        }
        if(map.containsKey('U')&&map.containsKey('D')&&map.containsKey('R')&&map.containsKey('L')){
            if((map.get('L').intValue()==map.get('R').intValue())&&(map.get('U').intValue()==map.get('D').intValue())){
                return true;
            }
            else{
                return false;
            }
        }
        else if(map.containsKey('R')&&map.containsKey('L')&&!map.containsKey('U')&&!map.containsKey('D')){
            if(map.get('R').intValue()==map.get('L').intValue()){
                return true;
            }
            else{
                return false;
            }
        }
        else if(map.containsKey('D')&&map.containsKey('U')&&!map.containsKey('L')&&!map.containsKey('R')){
            if(map.get('U').intValue()==map.get('D').intValue()){
                return true;
            }
            else{
                return false;
            }
        }
        else{
            return false;
        }
    }

    /**
     *  Given a sorted array, two integers k and x, find the k closest elements to x in the array. The result should also be sorted in ascending order. If there is a tie, the smaller elements are always preferred.

     Example 1:

     Input: [1,2,3,4,5], k=4, x=3
     Output: [1,2,3,4]

     Example 2:

     Input: [1,2,3,4,5], k=4, x=-1
     Output: [1,2,3,4]

     Note:

     The value k is positive and will always be smaller than the length of the sorted array.
     Length of the given array is positive and will not exceed 104
     Absolute value of elements in the array and x will not exceed 104

     *
     * */
   /* public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        arr.add(new Integer(x));
        List<Integer> result = new ArrayList<Integer>();
        //int[] num = (int[]) arr.toArray();
        Arrays.sort(num);
        int xFlag=0;
        for (int i = 0; i <num.length ; i++) {
            if(num[i]==x) xFlag=i;
        }

        int left;


        if(xFlag-x/2-1>=0) left= xFlag-x/2-1;
        else {
            left=0;
        }

        for (int i = left; i <left+k ; i++) {
            result.add(num[i]);
        }
        return result;

    }*/

    /**
     * You are given an integer array sorted in ascending order (may contain duplicates), you need to split them into several subsequences, where each subsequences consist of at least 3 consecutive integers. Return whether you can make such a split.

     Example 1:

     Input: [1,2,3,3,4,5]
     Output: True
     Explanation:
     You can split them into two consecutive subsequences :
     1, 2, 3
     3, 4, 5

     Example 2:

     Input: [1,2,3,3,4,4,5,5]
     Output: True
     Explanation:
     You can split them into two consecutive subsequences :
     1, 2, 3, 4, 5
     3, 4, 5

     Example 3:

     Input: [1,2,3,4,4,5]
     Output: False

     Note:

     The length of the input is in range of [1, 10000]

     *
     * */

    public boolean isPossible(int[] nums) {
        return true;
    }


    /**
     * Start from integer 1, remove any integer that contains 9 such as 9, 19, 29...

     So now, you will have a new integer sequence: 1, 2, 3, 4, 5, 6, 7, 8, 10, 11, ...

     Given a positive integer n, you need to return the n-th integer after removing. Note that 1 will be the first integer.

     Example 1:

     Input: 9
     Output: 10

     Hint: n will not exceed 9 x 10^8.
     * */
    public int newInteger(int n) {
        return 0;
    }

    public static void main(String[] args) {
        JudgeRouteCircle j = new JudgeRouteCircle();
        System.out.println(j.judgeCircle("UD"));
        //System.out.println(j.judgeCircle("RULDDLLDLRDUUUURULRURRRRLRULRLULLLRRULULDDRDLRULDRRULLUDDURDLRRUDRUDDURLLLUUDULRUDRLURRDRLLDDLLLDLRLLRUUDUURDRLDUDRUDRLUDULRLUDRLDDUULDDLDURULUDUUDDRRDUURRLRDLDLRLLDRRUUURDLULLURRRRDRRURDUURDLRRUULRURRUULULUUDURUDLRDDDDDURRRLRUDRUULUUUULDURDRULLRRRUDDDUUULUURRDRDDRLLDRLDULDLUUDRDLULLDLDDRUUUUDDRRRDLLLLURUURLRUUULRDDULUULUURDURDDDRRURLURDLLLRLULRDLDDLRDRRRRLUURRRRLDUDLLRUDLDRDLDRUULDRDULRULRRDLDLLLUDLDLULLDURUURRLLULUURLRLRDUDULLDURRUDDLDDLLUDURLLRLDLDUDLURLLDRRURRDUDLDUULDUDRRUDULLUUDURRRURLULDDLRRURULUURURRDULUULDDDUUDRLDDRLULDUDDLLLDLDURDLRLUURDDRLUDRLUDLRRLUUULLDUUDUDURRUULLDDUDLURRDDLURLDRDRUDRLDDLDULDRULUDRRDRLLUURULURRRUDRLLUURULURRLUULRDDDRDDLDRLDRLDUDRLDRLDDLDUDDURUDUDDDLRRDLUUUDUDURLRDRURUDUDDRDRRLUDURULDULDDRLDLUURUULUDRLRLRLLLLRLDRURRRUULRDURDRRDDURULLRDUDRLULRRLLLDRLRLRRDULDDUDUURLRULUUUULURULDLDRDRLDDLRLURRUULRRLDULLUULUDUDRLDUDRDLLDULURLUDDUURULDURRUURLRDRRRLDDULLLLDDRRLRRDRDLRUDUUDLRLDRDRURULDLULRRDLLURDLLDLRDRURLRUDURDRRRULURDRURLDRRRDUDUDUDURUUUUULURDUDDRRDULRDDLULRDRULDRUURRURLUDDDDLDRLDLLLLRLDRLRDRRRLLDRDRUULURLDRULLDRRDUUDLURLLDULDUUDLRRRDDUDRLDULRDLLULRRUURRRURLRRLDDUDDLULRUDULDULRDUDRLRDULRUUDDRUURUDLDRDUDDUULLUDDLLRLURURLRRULLDDDLURDRRDLLLLULLDLUDDLURLLDDRLDLLDDRDRDDUDLDURLUUUUUDLLLRLDULDDRDDDDRUDLULDRRLLLDUUUDDDRDDLLULUULRRULRUDRURDDULURDRRURUULDDDDUULLLURRRRDLDDLRLDDDRLUUDRDDRDDLUDLUUULLDLRDLURRRLRDRLURUURLULLLLRDDLLLLRUDURRLDURULURULDDRULUDRLDRLLURURRRDURURDRRUDLDDLLRRDRDDLRLRLUDUDRRUDLLDUURUURRDUDLRRLRURUDURDLRRULLDLLUDURUDDRUDULLDUDRRDDUDLLLDLRDRUURLLDLDRDDLDLLUDRDDRUUUDDULRUULRDRUDUURRRURUDLURLRDDLUULRDULRDURLLRDDDRRUDDUDUDLLDDRRUUDURDLLUURDLRULULDULRUURUDRULDRDULLULRRDDLDRDLLLDULRRDDLDRDLLRDDRLUUULUURULRULRUDULRULRUURUDUUDLDUDUUURLLURDDDUDUDLRLULDLDUDUULULLRDUDLDRUDRUULRURDDLDDRDULRLRLRRRRLRULDLLLDDRLUDLULLUUDLDRRLUDULRDRLLRRRULRLRLLUDRUUDUDDLRLDRDDDDRDLDRURULULRUURLRDLLDDRLLRUDRRDDRDUDULRUDULURRUDRDLRDUUDDLDRUDLLDDLRLULLLRUUDRRRRUULLRLLULURLDUDDURLRULULDLDRURDRLLURRDLURRURLULDLRLDUDLULLLDRDLULDLRULLLUDUDUDUDLDDDDDRDLUDUULLUDRLUURDRLULD"));
    }
}
