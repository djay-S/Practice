package practice.leetcode.linkedList;

import java.util.ArrayList;
import java.util.List;

public class LinkedListUtils {
    public static ListNode arrToLinkedList(Integer[] arr) {
        if (arr.length == 0) {
            return null;
        }
        int index = 0;
        ListNode linkedList = new ListNode(arr[index++]);
        ListNode head = linkedList;

        while (index < arr.length) {
            ListNode node = new ListNode(arr[index]);
            head.next = node;
            head = head.next;
            index++;
        }
        return linkedList;
    }

    public static List<Integer> linkedListToArr(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
