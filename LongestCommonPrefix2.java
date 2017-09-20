/**
 * Created by Administrator on 2017/1/19.
 */
public class LongestCommonPrefix2 {
    public String longestCommonPrefix(String[] strs){
        if(strs == null || strs.length == 0)    return "";
        String pre = strs[0];
        int i = 1;
        while(i < strs.length){
            while(strs[i].indexOf(pre) != 0) {
                pre = pre.substring(0, pre.length() - 1);
                System.out.println(pre);
            }
            i++;
        }
        return pre;
    }

    public static void main(String[] args){
        LongestCommonPrefix2 l = new LongestCommonPrefix2();
        l.longestCommonPrefix(new String[]{"asdasdasd","asdaa","asdffhhjh"});
    }
}
