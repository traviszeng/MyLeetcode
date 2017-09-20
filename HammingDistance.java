/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.
 */
/**
 * return Integer.bitCount(x ^ y); //that do all jobs below
 * */
public class HammingDistance {
    public int hammingDistance(int x,int y){
        char[] c=Integer.toBinaryString(x^y).toCharArray();
        int sum=0;
        for (int i = 0; i <c.length ; i++) {
            if(c[i]=='1') sum++;
        }
        return sum;
    }

    public static void main(String[] args){
        HammingDistance h = new HammingDistance();
        System.out.print(h.hammingDistance(8,19));
    }
}
