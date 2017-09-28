/**
 * Created by Travis Zeng on 2017/9/21.
 */
/**
 * Given an integer and check if it is the power of two
 * */
public class PowerOfTwo {

    public boolean isPowerOfTwo(int n) {
        if(n<=0 ) return false;
        else if(n==1) return true;
        else{
            while(n>=2){
                if(n%2!=0) return false;
                n=n/2;
            }
            return true;
        }
    }

}
