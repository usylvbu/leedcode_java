package topic;

public class 二进制求和 {
        /*67.二进制求和
    给你两个二进制字符串 a 和 b ，以二进制字符串的形式返回它们的和。
示例 1：
输入:a = "11", b = "1"
输出："100"
示例 2：
输入：a = "1010", b = "1011"
输出："10101"

提示：
1 <= a.length, b.length <= 104
a 和 b 仅由字符 '0' 或 '1' 组成
字符串如果不是 "0" ，就不含前导零
     */
    /**没做出来，用的官方题解
     * 将两个字符串表示的二进制数相加，并以字符串形式返回结果。
     * 注意：两个输入字符串的长度可以不相等。
     *
     * @param a 表示第一个二进制数的字符串
     * @param b 表示第二个二进制数的字符串
     * @return 两个二进制数相加后的结果，以字符串形式表示
     */
    public String addBinary(String a, String b) {
        StringBuffer ans = new StringBuffer();

        // 确定较短的字符串的长度，同时处理进位
        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            // 为每一位添加进位并求和，转换为字符并追加到结果中
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        // 处理最后的进位
        if (carry > 0) {
            ans.append('1');
        }

        // 反转结果字符串，以便正确读取二进制数
        ans.reverse();

        return ans.toString();
    }
}
