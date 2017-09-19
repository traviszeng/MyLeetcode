/**
 * Created by Travis Zeng on 2017/8/12.
 */

/**
 *
 * Given a string and an integer k, you need to reverse the first k characters
 * for every 2k characters counting from the start of the string.
 * If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters,
 * then reverse the first k characters and left the other as original.

 Example:

 Input: s = "abcdefg", k = 2
 Output: "bacdfeg"

 Restrictions:

 The string consists of lower English letters only.
 Length of the given string and k will in the range [1, 10000]
 */
public class ReverseII {
    public String reverseStr(String s, int k) {
        if(s == null) return null;
        int run = s.length()/k;
        //如果只有<k的字母，直接reverse
        if(run == 0) return new StringBuilder(s).reverse().toString();

        StringBuilder result = new StringBuilder();
        for(int i = 1;i<=run;i+=2){
            StringBuilder pieces = new StringBuilder();
            for (int j = (i-1)*k; j <i*k ; j++) {
                pieces.append(s.charAt(j));
            }
            pieces.reverse();
            result.append(pieces);
            //run为奇数是最后一轮i==run
            if(i!=run){
                for (int j = i*k; j <(i+1)*k ; j++) {
                     result.append(s.charAt(j));
                }
            }
        }
        //如果为偶数，剩下的都要reverse
        if(run %2==0){
            StringBuilder pieces = new StringBuilder();
            for (int i = run*k; i <s.length() ; i++) {
                pieces.append(s.charAt(i));
            }
            result.append(pieces.reverse());
        }
        //如果为奇数，剩下的直接append
        else{
            for (int i = run*k; i <s.length() ; i++) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }


    public static void main(String[] args){
        ReverseII re = new ReverseII();
        System.out.println(re.reverseStr("abcdefghijk",3));
    }
}
