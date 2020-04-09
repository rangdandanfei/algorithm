package com.fan.subject.num;

/**
 * @author: rangdandanfei
 * @date: 2020/4/9 18:28
 * @description:
 */

public class NumberSolution {

    /**
     * 如何计算一个非负整数的各个位数之和？
     * 例如：
     * 100，各位数和 = 1 + 0 + 0 = 1
     * 35，各位数和 = 3 + 5 = 8
     * 216，各位数和 = 2 + 1 + 6 = 9
     *
     * 思路：
     * 对非负整数 x 每次对 10 取余（即可获得x的个位数），
     * 然后再将x除以10
     * 不断重复上面操作，直到x为0，最终将每次取余的结果加起来
     *
     * 举例：
     * x = 216,        x % 10 = 216 % 10 = 6
     * x = x/10 = 21,  x % 10 = 21 % 10 = 1
     * x = x/10 = 2,   x % 10 = 2 % 10 = 2
     * x = x/10 = 0,   结束
     * 则 result = 6 + 1 + 2 = 9
     *
     * @param num
     * @return
     */
    public static int getDigitSum(int num) {
        int sum = 0;
        while (num != 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }



    public static void main(String[] args) {
        System.out.println(getDigitSum(100));
        System.out.println(getDigitSum(35));
        System.out.println(getDigitSum(216));
        System.out.println(getDigitSum(1243490));
    }

}
