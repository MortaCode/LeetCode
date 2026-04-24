package 回溯;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class LetterCombinations {
    Map<Character, String> phoneMap = Map.ofEntries(
            Map.entry('2', "abc"),
            Map.entry('3', "def"),
            Map.entry('4', "ghi"),
            Map.entry('5', "jkl"),
            Map.entry('6', "mno"),
            Map.entry('7', "pqrs"),
            Map.entry('8', "tuv"),
            Map.entry('9', "wxyz")
        );


//    给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
//    给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
//    示例
//    输入：digits = "23"
//    输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]

    public static void main(String[] args) {
        String digits = "23";
        LetterCombinations solution = new LetterCombinations();
        List<String> list = solution.letterCombinations(digits);
        System.out.println(list);
    }
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0){
            return null;
        }
        List<String> combinations = new ArrayList<>();
        StringBuffer combination = new StringBuffer();
        backtrack(combinations, phoneMap, digits, 0, combination);
        return combinations;
    }

    public void backtrack(List<String> combinations, Map<Character, String> phoneMap, String digits, int index, StringBuffer combination) {
        if (index == digits.length()) {
            combinations.add(combination.toString());
            return;
        }
        char digit = digits.charAt(index);
        String letters = phoneMap.get(digit);
        int lettersCount = letters.length();
        for (int i = 0; i < lettersCount; i++) {
            combination.append(letters.charAt(i));
            backtrack(combinations, phoneMap, digits, index + 1, combination);
            combination.deleteCharAt(index);
        }
    }

}
