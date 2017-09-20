import java.util.stream.Stream;

/**
 * Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString {
    public String reverseString(String s) {
        if(s==null) return null;
        StringBuilder string = new StringBuilder();
        for(int i=s.length()-1;i>=0;i--){
            string.append(s.charAt(i));
        }
        return string.toString();

        /**
         * return new StringBuilder(s).reverse().toString();
         * */
    }

    /**Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.

     Example 1:

     Input: "Let's take LeetCode contest"
     Output: "s'teL ekat edoCteeL tsetnoc"

     Note: In the string, each word is separated by single space and there will not be any extra space in the string. */

    public String reverseWords(String s) {
        String[] ss = s.split(" ");
        StringBuilder builder = new StringBuilder();
        for (String a: ss) {
            builder.append(new StringBuilder(a).reverse()).append(" ");
        }
        builder.deleteCharAt(builder.length()-1);
        return builder.toString();
    }

    /**
     * 使用Stream流来解决 找出一个句子中长度大于六个字母的所有单词
     *
     * */
    public String[] reverseWordsStream(String s){
        return Stream.of(s.split(" ")).filter(ss -> ss.length()>6 ).toArray(String[]::new);
    }

    public static void main(String[] args){
        ReverseString r = new ReverseString();
        System.out.println(r.reverseWords("abcdskjhk skdjhaksjdh oioiuo"));
        String[] n = r.reverseWordsStream("abcdskjhk skdjhaksjdh oioiuo");
        for (String s:n
             ) {
            System.out.println(s);
        }
    }
}
