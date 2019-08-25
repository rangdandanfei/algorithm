package com.fan.datastructure.stack;

import java.util.Stack;

/**
 * @author : lifanfan
 * @description : TODO
 * @date : 2019/8/25
 */
public class StackDemo {

    /**
     * 利用栈结构将给定的字符串逆序输出
     * @param value
     * @return
     */
    public static String reverse(String value) {
        if (value == null || "".equals(value.trim())) {
            return value;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : value.toCharArray()) {
            stack.push(c);
        }
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(StackDemo.reverse("1,2,3,4,5,6"));
        System.out.println(StackDemo.reverse("a;b;c;d"));
        System.out.println(StackDemo.reverse("22 23 24 25 ;"));
        System.out.println(StackDemo.reverse("HH_oo_20190010$${}ppXX@##&"));
    }
}
