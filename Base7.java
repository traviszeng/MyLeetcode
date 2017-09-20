/**
 * Created by Travis Zeng on 2017/8/12.
 */



/**
 * Given an integer, return its base 7 string representation.

 Example 1:

 Input: 100
 Output: "202"

 Example 2:

 Input: -7
 Output: "-10"

 Note: The input will be in range of [-1e7, 1e7].
 * */
public class Base7 {
    public String convertToBase7(int num) {
        boolean isNegative ;
        StringBuilder builder = new StringBuilder();
        if(num==0) return "0";
        if(num<0) {
            isNegative = true;
        }
        else {
            isNegative = false;
        }
        num = Math.abs(num);
        while(num!=0){
            builder.append(num%7);
            num = num/7;
        }
        if(isNegative==true){
            return "-"+builder.reverse().toString();
        }
        else return builder.reverse().toString();

    }

    public static void main(String[] args){
        Base7 b = new Base7();
        System.out.println(b.convertToBase7(-7));
    }

}
