package com.fan.datastructure.stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * @author : lifanfan
 * @description : 用两个栈(一个保存运算符，一个保存操作数)实现简单的算术表达式求值
 * @date : 2019/8/25
 */
public class CalculateDemo {
    public static void main(String[] args) {
        Stack<String> ops = new Stack<>();
        Stack<Double> vals = new Stack<>();
        Scanner scanner = new Scanner(System.in);
        String s;
        while ((s = scanner.nextLine()) != null && !"".equals(s = s.trim())) {
            if (s.equals("(")) {
                // 如果字符为"("，则忽略
            } else if (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("sqrt")) {
                // 压入运算符
                ops.push(s);
            } else if (s.equals(")")) {
                // 如果字符为")"，弹出运算符和所需操作数，进行计算，计算结果压入栈中
                String op = ops.pop();
                double v = vals.pop();
                if (op.equals("+")) {
                    v = vals.pop() + v;
                } else if (op.equals("-")) {
                    v = vals.pop() - v;
                } else if (op.equals("*")) {
                    v = vals.pop() * v;
                } else if (op.equals("/")) {
                    v = vals.pop() / v;
                } else if (op.equals("sqrt")) {
                    v = Math.sqrt(v);
                }
                vals.push(v);
            } else {
                // 压入操作数
                vals.push(Double.parseDouble(s));
            }
        }
        System.out.println(vals.pop());
    }
}
