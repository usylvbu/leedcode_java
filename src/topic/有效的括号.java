package topic;

import java.util.Map;
import java.util.Stack;

/* 第二十题有效的括号
给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
有效字符串需满足：
左括号必须用相同类型的右括号闭合。
左括号必须以正确的顺序闭合。
每个右括号都有一个对应的相同类型的左括号。

示例 1：

输入：s = "()"
输出：true
示例 2：

输入：s = "()[]{}"
输出：true
示例 3：
输入：s = "(]"
输出：false

提示：
1 <= s.length <= 104
s 仅由括号 '()[]{}' 组成
 */
public class 有效的括号 {
    public boolean isValid(String s) throws IllegalArgumentException {
        // 判断字符串是否为空或长度为奇数
        if(s == null || s.isEmpty() || s.length() % 2 != 0)
            return false;
        // 创建括号到其对应闭合括号的映射
        Map<Character, Character> bracketPairs = Map.of(
                '(' , ')',
                '[' , ']',
                '{' , '}'
        );


        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (bracketPairs.containsKey(c)) {
                stack.push(c);
            } else if (!stack.isEmpty() && bracketPairs.get(stack.peek()) == c) {
                stack.pop(); // 匹配的括号对，弹出栈顶元素
            } else {
                return false; // 非法的关闭括号或未匹配的括号对
            }
        }

        // 栈为空表示所有括号都有匹配的闭合括号并且嵌套正确
        return stack.isEmpty();
    }
/* 方法二
    public boolean isValid(String s)  {
                // 判断字符串是否为空或长度为奇数
        if(s == null || s.isEmpty() || s.length() % 2 != 0)
            return false;

        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            switch (c) {
                case '(':
                case '[':
                case '{':
                    stack.push(c);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }

        // 栈为空表示所有括号都有匹配的闭合括号并且嵌套正确
        return stack.isEmpty();
    }
 */
/*  最快的算法

 //空、空串、长度不匹配
        if(s == null || s.isEmpty() || s.length() % 2 != 0)
            return false;
        char[] charArray = s.toCharArray();
        // 定义栈
        char[] stack = new char[charArray.length/2];
        int index = 0;
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            switch(c){
                case '(':
                case '{':
                case '[':
                    if(index == stack.length){
                        return false;
                    }
                    stack[index++] = c;
                    break;
                case ')':
                    if(index == 0 || stack[--index] != '('){
                        return false;
                    }
                    break;
                case '}':
                    if(index == 0 || stack[--index] != '{'){
                        return false;
                    }
                    break;
                case ']':
                    if(index == 0 || stack[--index] != '['){
                        return false;
                    }
                    break;
            }
        }
        return index == 0;
    }
 */
}
