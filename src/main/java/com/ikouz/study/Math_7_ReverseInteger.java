package com.ikouz.study;

/**
 * Created by liujiaming on 2016/07/20 21:28.
 */
public class Math_7_ReverseInteger {

    /**
     * Reverse digits of an integer.
     * <p/>
     * Example1: x = 123, return 321
     * Example2: x = -123, return -321
     * <p/>
     * 描述：翻转integer
     * 总结：注意边界，翻转后溢出的问题。Integer.MAX_VALUE MIN_VALUE
     */
    public static int reverse(int x) {
        long ret = 0;
        int mode;
        int xAbs = Math.abs(x);
        while (xAbs > 0) {
            mode = xAbs % 10;
            ret = ret * 10 + mode;
            xAbs = xAbs / 10;
        }
        ret = ret > Integer.MAX_VALUE ? 0 : ret;
        return x > 0 ? (int) ret : (int) -ret;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(reverse(1534235669));
        System.out.println(reverse(-2147483648));
    }
}
