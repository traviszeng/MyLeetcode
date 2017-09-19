/**
 * Created by Administrator on 2017/1/19.
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length==0){
            return "";
        }
        StringBuilder commonPrefix = new StringBuilder();
        int shortest=100;
        int shortestFlag=0;
        for(int i =0;i<strs.length;i++){
            if(strs[i].length()<shortest){
                shortest=strs[i].length();
                shortestFlag=i;
            }
        }
        if(strs[shortestFlag].equals("")){
            return "";
        }
        commonPrefix.append(strs[shortestFlag].charAt(0));
        boolean flag=true;
        for(int i=0;i<strs.length;i++){
            if(!strs[i].startsWith(commonPrefix.toString())){
                flag=false;
            }
        }

        if(!flag){
            return "";
        }
        else if(shortest==1){
            return strs[shortestFlag];
        }
        else {
            boolean newflag = true;
            for (int i = 1; i < strs[shortestFlag].length(); i++) {
                for (int j = 0; j < strs.length; j++) {
                    if (!strs[j].startsWith(commonPrefix.toString()+strs[shortestFlag].charAt(i))) {
                        newflag = false;
                    }
                }
                if(newflag) {
                    commonPrefix.append(strs[shortestFlag].charAt(i));
                }else return commonPrefix.toString();
            }
        }
        return commonPrefix.toString();
    }
    public static void main(String[] args){
        System.out.print(new LongestCommonPrefix().longestCommonPrefix(new String[]{"aaDFGa","aaDFG","aaD"}));
    }
}
