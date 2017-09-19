import java.util.Stack;

/**
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 The brackets must close in the correct order, "()" and "()[]{}" and "([])" are all valid but "(]" and "([)]" are not.
 */
public class ValidParentheses {
    public boolean isValid(String s){
        Stack<Character> stack = new Stack<>();
        char[] c=s.toCharArray();
        for(int i=0;i<s.length();i++){
            if(c[i]=='['||c[i]=='('||c[i]=='{'){
                stack.push(c[i]);
            }
            else{
                switch (c[i]){
                    case ']':
                        if(stack.isEmpty()||stack.pop()!='['){
                            return false;
                        }
                        else{
                            continue;
                        }
                    case ')':
                        if(stack.isEmpty()||stack.pop()!='('){
                            return false;
                        }else{
                            continue;
                        }
                    default:
                        if(stack.isEmpty()||stack.pop()!='{'){
                            return false;
                        }else{
                            continue;
                        }
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args){
        ValidParentheses v=new ValidParentheses();
        System.out.print(v.isValid("([)]"));

    }
}
