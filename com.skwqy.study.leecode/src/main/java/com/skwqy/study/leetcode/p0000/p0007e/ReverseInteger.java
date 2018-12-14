package com.skwqy.study.leetcode.p0000.p0007e;

/**
 * @author skwqy
 * @Created on 2018 12 2018/12/12 11:48 PM
 */
public class ReverseInteger {
    public int reverse(int x) {

        int result = 0;
        while(x != 0){
            int pop = x%10;
            x = x/10;
            // 溢出判断
            // 如果是正数
            if(result > Integer.MAX_VALUE/10){
                return 0;
            }
            // Integer.MAX_VALU = 2147483647
            else if (result == Integer.MAX_VALUE/10 && pop > 7){
                return 0;
            }

            // 如果是负数
            if (result < Integer.MIN_VALUE/10){
                return 0;
            }
            // Integer.MIN_VALUE = -2147483648
            else if(result == Integer.MIN_VALUE/10 && pop < -8){
                return 0;
            }
            result = result*10+pop;
        }
        return result;
    }
}
