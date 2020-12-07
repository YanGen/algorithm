package com.muhuan.algorithm.leetcode.dialog;

/**
 * @author yg
 * @date 2020/11/30 11:17
 * TODO
 * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 */

import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class AddTwoNumbers {

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int jinwei = 0;
        ListNode shaobin = new ListNode(-1); //哨兵占链表头部
        ListNode cursor = shaobin; //游标串联链表

        while (l1 != null || l2 != null || jinwei != 0){
            int a = l1 != null ? l1.val : 0;
            int b = l2 != null ? l2.val : 0;
            int cur = a+b+jinwei;
            jinwei = cur/10;
            cursor.next = new ListNode(cur % 10);
            cursor = cursor.next;

            l1 = l1!=null?l1.next:null;
            l2 = l2 != null?l2.next:null;
        }
        return shaobin.next;//返回实际上的第一位
    }

}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
