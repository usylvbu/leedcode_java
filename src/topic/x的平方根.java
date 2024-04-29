package topic;

public class x的平方根 {
    /**
     * 69. x 的平方根
     *
     * 给定一个非负整数 x ，计算并返回 x 的平方根，即实现 int sqrt(int x) 函数。
     *
     * 输入：x = 4
     * 输出：2
     *
     * 输入：x = 8
     * 输出：2
     * 解释：8 的平方根是 2.82842...，由于返回类型是整数，小数部分将被舍去。
     *
     * 提示：
     * 0 <= x <= 231 - 1
     *
     /**
     * 计算给定整数的平方根。
     *
     * @param x 待求平方根的整数。
     * @return x 的平方根。如果 x 是 0 或 1，则返回 x 本身。
     */
    public int mySqrt(int x) {
        // 处理特殊情况：当 x 为 0 或 1 时，直接返回 x
        if (x == 0 || x == 1){
            return x;
        }
        double xx = x;
        // 初始猜测值为 x 的一半
        double result = xx/2;
        // 通过牛顿迭代法找到最接近平方根的值
        while(result*result > xx) {
            result = (int)(result + x/result)/2;
        }
        // 返回结果的整数部分
        return (int)result;
    }
    /*最快的方法
        public int mySqrt(int x) {
        if(x == 0) return 0;
        double x0 = x;
        while (true) {
            double xi = 0.5*(x0 + x/x0);
            if(Math.abs(xi - x0) < 1e-7) break;
            x0 = xi;
        }
        return (int)x0;
    }
     */
}
