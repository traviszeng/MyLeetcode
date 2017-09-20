import java.util.HashMap;

/**
 * Created by Administrator on 2017/1/19.
 */
public class RomanToInt {
    public int romanToInt(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);
        //divided string into single letter
        char[] romanElment=s.toCharArray();
        int[] romanValue=new int[romanElment.length];
        for(int i =0;i<romanElment.length;i++){
            //put specific value of each letter into romanValue
            romanValue[i]=map.get(romanElment[i]);
        }
        int sum=romanValue[romanValue.length-1];
        for(int i=romanValue.length-2;i>=0;i--){
            if(romanValue[i]<romanValue[i+1]){
                sum=sum-romanValue[i];
            }
            else{
                sum=sum+romanValue[i];
            }
        }
        return sum;
    }

    public static void main(String[] args){
        System.out.println(new RomanToInt().romanToInt("MCMLXXXIV"));
    }
}
