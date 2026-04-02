package 栈;

import java.util.Map;
import java.util.Stack;

//有效括号-20
public class IsValid_20 {

//    给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
//    有效字符串需满足：
//    左括号必须用相同类型的右括号闭合。
//    左括号必须以正确的顺序闭合。
//    每个右括号都有一个对应的相同类型的左括号。

    Map<Character, Character> map = Map.ofEntries(
            Map.entry(')','('),
            Map.entry('}','{'),
            Map.entry(']','[')
    );
    public boolean isValid(String s) {
        if (s == null || s.length() == 0)
            return true;
        Stack<Character> stk = new Stack<>();
        for (char c : s.toCharArray()){
            if (map.containsKey(c)){
                if (stk.isEmpty() || !map.get(c).equals(stk.peek())){//这里被搞成pop，一次跳出两个
                    return false;
                }
                stk.pop();
            } else {
                stk.push(c);
            }
        }
        return stk.isEmpty();
    }

    public static void main(String[] args) {
        IsValid_20 instance = new IsValid_20();
        String s = "[{(()}]";
        System.out.println(instance.isValid(s));
    }
}
