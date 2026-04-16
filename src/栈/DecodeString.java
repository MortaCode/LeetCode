package 栈;

import java.util.*;

public class DecodeString {


    public static void main(String[] args) {
        DecodeString_394 decodeString = new DecodeString_394();
        String s = "3[a]2[bc]"; //"aaabcbc"
        System.out.println(decodeString.decodeString(s));
    }

    int idx;
    Stack<String> stk = new Stack<>();

    public String decodeString(String s) {
        int len = s.length();
        while (idx < len){
            char c = s.charAt(idx);
            if (Character.isDigit(c)){
                String digit = getDigit(s);
                stk.push(digit);
            } else if (Character.isLetter(c) || "[".equals(c)){
                stk.push(String.valueOf(c));
            } else {
                List<String> list = new ArrayList<>();
                while (!"[".equals(stk.peek())){
                    list.add(stk.pop());
                }
                Collections.reverse(list);
                stk.pop();//移除"["
                int num = Integer.parseInt(stk.pop());
                String origin = getString(list);
                StringBuilder sb = new StringBuilder();
                for (int i=0; i<num; i++){
                    sb.append(origin);
                }
                stk.push(sb.toString());
            }
        }
        return getString(stk);
    }

    public String getDigit(String s){
        StringBuilder sb = new StringBuilder();
        while (Character.isDigit(s.charAt(idx))){
            sb.append(s.charAt(idx++));
        }
        return sb.toString();
    }

    public String getString(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String str : list){
            sb.append(str);
        }
        return sb.toString();
    }

    public String getString(Stack<String> stk){
        StringBuilder sb = new StringBuilder();
        for (String str : stk){
            sb.append(stk.pop());
        }
        return sb.toString();
    }
}
