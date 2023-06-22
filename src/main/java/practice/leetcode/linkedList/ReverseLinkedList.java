package practice.leetcode.linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/reverse-linked-list/
public class ReverseLinkedList {
    public static void main(String[] args) {
        test(new Integer[]{1,2,3,4,5}, new Integer[]{5,4,3,2,1});
        test(new Integer[]{1,2}, new Integer[]{2,1});
        test(new Integer[]{}, new Integer[]{});
        test(new Integer[]{1}, new Integer[]{1});
    }

    private static void test(Integer[] head, Integer[] expected) {
        ListNode linkedList = arrToLinkedList(head);
        ListNode reversedLinkedList = reverseList(linkedList);
        List<Integer> result = linkedListToArr(reversedLinkedList);
        String finalAnswer = result.equals(Arrays.asList(expected)) ? "✅" : "❌";
        System.out.printf("Head: %s, Target: %s, Result:%s, Final:%s\n", Arrays.asList(head), Arrays.asList(expected), result, finalAnswer);
    }

    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;

        while(head != null) {
            ListNode nxt = head.next;

            head.next = prev;
            prev = head;
            head = nxt;
        }
        return prev;
    }

    private static ListNode arrToLinkedList(Integer[] arr) {
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

    private static List<Integer> linkedListToArr(ListNode head) {
        ListNode node = head;
        List<Integer> list = new ArrayList<>();

        while (node != null) {
            list.add(node.val);
            node = node.next;
        }
        return list;
    }
}
class ListNode{
    int val;
    ListNode next;
    ListNode(){}
    ListNode(int val) {
        this.val = val;
    }
    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}