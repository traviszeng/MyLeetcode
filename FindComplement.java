/**
 * Given a positive integer, output its complement number. The complement strategy is to flip the bits of its binary representation.
 */
public class FindComplement {
    public int findComplement(int num) {
        int binaryNumLength=Integer.toBinaryString(num).length();
        return num^(int)(Math.pow(2,binaryNumLength)-1);
    }

    public static void main(String[] args){
        FindComplement f=new FindComplement();
        System.out.print(f.findComplement(5));
    }
}
