package com.fan.subject.str;

import java.util.*;

/**
 * @author: rangdandanfei
 * @date: 2020/4/9 17:00
 * @description:
 *
 * 给定一个字符串，找出其中不含有重复字符的 最长子串 的长度
 *
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"或 "kew"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */

public class LongestSubStrSolution {

    /**
     * 思路一：
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring1(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        List<Character> list = new ArrayList<>();
        int n = s.length();
        int maxLength = 0;
        for (int i = 0; i < n; i++) {
            int index = list.indexOf(s.charAt(i));
            if (index == -1) {
                list.add(s.charAt(i));
                maxLength = Math.max(list.size(), maxLength);
            } else {
                for (int j = index; j >= 0; j--) {
                    list.remove(j);
                }
                list.add(s.charAt(i));
            }
        }
        return maxLength;
    }

    /**
     * 思路二：滑动窗口
     * 窗口通常是在数组/字符串中由开始和结束索引定义的一系列元素的集合，即 [i,j)（左闭，右开）
     * 而滑动窗口是可以将两个边界向某一方向“滑动”的窗口。
     * 例如：我们将 [i,j) 向右滑动1个元素，则它将变为 [i+1,j+1)（左闭，右开），
     * 用 HashSet 将字符存储在当前窗口 [i,j)（最初j=i）中，然后我们向右滑动索引j，如果它不在 HashSet中，我们会继续滑动j，
     * 直到 s[j] 已经存在于 HashSet中，此时没有重复的最长子字符串将会以索引i开头。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring2(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                maxLength = Math.max(j - i, maxLength);
            } else {
                set.remove(s.charAt(i++));
            }
        }
        return maxLength;
    }

    /**
     * 优化的滑动窗口1：
     * 可以定义字符到索引的映射map，而不是使用集合来判断一个字符是否存在。
     * 当我们找到重复字符时，我们可以立即跳过该窗口。
     * 如果 s[i] 在 [i,j)范围内有与 j'重复的字符，我们不需要逐渐增加i,我们可以直接跳过[i,j']范围内的所有元素，并将i变为j'+1
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring3(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>(16);
        int maxLength = 0;
        for (int i = 0,j = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                i = Math.max(map.get(s.charAt(j)), i);
            }
            maxLength = Math.max(maxLength, j - i + 1);
            map.put(s.charAt(j), j + 1);
        }
        return maxLength;
    }

    /**
     * 优化的滑动窗口2：（只针对字符集比较小的情况）
     * 当我们知道该字符集比较小的时候，我们可以用一个整数数组作为直接访问表来替换Map
     * 常用的表如下所示：
     * int [26] -- 用于字母'a'-'z'或'A'-'Z'
     * int [128] -- 用于ASCII码
     * int [256] -- 用于扩展ASCII码
     *
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring4(String s) {
        if (s == null || "".equals(s)) {
            return 0;
        }
        int n = s.length();
        int[] index = new int[128];
        int maxLength = 0;
        for (int j = 0,i = 0; j < n; j++) {
            i = Math.max(index[s.charAt(j)], i);
            maxLength = Math.max(maxLength, j - i + 1);
            index[s.charAt(j)] = j + 1;
        }
        return maxLength;
    }



    public static void main(String[] args) {

    }

}
