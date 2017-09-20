/**
 * Created by Administrator on 2017/1/18.
 */
public class ReverseInteger {
    public int  reverse(int x){
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }
        return result;


    }


    public static void main(String[] args){
        //System.out.print(new ReverseInteger().reverse(1));
        System.out.print(new ReverseInteger().reverse(1534122369));
        String st = new String();
    }
}
