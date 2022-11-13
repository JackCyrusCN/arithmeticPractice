package org.southwill.day02;

import java.util.Arrays;
import java.util.LinkedList;

/**
 * 解题思路两种：
 * 1. 递归法： 先走至链表末端，回溯时依次将节点值加入列表 ，这样就可以实现链表值的倒序输出。
 * 2. 辅助栈法： 从前至后访问每个节点。
 */
public class Solution {

    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        while(head != null) {
            stack.addLast(head.val);
            head = head.next;
        }
        int[] res = new int[stack.size()];
        for(int i = 0; i < res.length; i++)
            res[i] = stack.removeLast();
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(5, null);
        ListNode node2 = new ListNode(1, node1);
        ListNode head = new ListNode(3, node2);
        int[] result = solution.reversePrint(head);
        String strArray[] = Arrays.stream(result)
                .mapToObj(String::valueOf)
                .toArray(String[]::new);
        System.out.println(String.join(",", strArray)); // Arrays.toString(strArray)
    }
}
