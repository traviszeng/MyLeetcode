/**
 * Created by Travis Zeng on 2017/3/7.
 */
public class weiyunsuanTest {
    public static void main(String[] args) {
        String s = "hellowifsdasdasd65465464656";
        int h=0;
        for (int i = 0; i <s.length() ; i++) {
            h=(h<<2)|(h>>>27);
            h+=s.charAt(i);
        }
        System.out.println(h);
    }
}
