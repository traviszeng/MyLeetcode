
/**
 *  Assume you are an awesome parent and want to give your children some cookies.
 *  But, you should give each child at most one cookie.
 *  Each child i has a greed factor gi, which is the minimum size of a cookie that the child will be content with;
 *  and each cookie j has a size sj. If sj >= gi, we can assign the cookie j to the child i, and the child i will be content.
 *  Your goal is to maximize the number of your content children and output the maximum number.

 Note:
 You may assume the greed factor is always positive.
 You cannot assign more than one cookie to one child.
 */
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        int contentKid = 0;
        java.util.Arrays.sort(g);
        java.util.Arrays.sort(s);
        int currentCookiePosition=0;
        for(int i=0;i<g.length;i++){
            if(currentCookiePosition>s.length-1) break;
            while(g[i]>s[currentCookiePosition] && currentCookiePosition<s.length-1){
                currentCookiePosition++;
            }
            if(s[currentCookiePosition]>=g[i]){
                s[currentCookiePosition]=0;
                contentKid++;
                continue;
            }
        }
        return contentKid;
    }

    public static void main(String[] args) {
        AssignCookies a = new AssignCookies();
        System.out.println(a.findContentChildren(new int[]{1,2,3,12,88,8},new int[]{1,1,9,7,2}));
    }
}
