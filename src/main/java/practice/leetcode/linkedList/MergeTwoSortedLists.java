package practice.leetcode.linkedList;

import java.util.Arrays;
import java.util.List;

//https://leetcode.com/problems/merge-two-sorted-lists/
public class MergeTwoSortedLists {
    public static void main(String[] args) {
        test(new Integer[]{1,2,4}, new Integer[]{1,3,4}, new Integer[]{1,1,2,3,4,4});
        test(new Integer[]{1,4}, new Integer[]{1,2,3,4}, new Integer[]{1,1,2,3,4,4});
        test(new Integer[]{}, new Integer[]{}, new Integer[]{});
        test(new Integer[]{}, new Integer[]{0}, new Integer[]{0});
        test(new Integer[]{1}, new Integer[]{}, new Integer[]{1});
        test(new Integer[]{-9,3}, new Integer[]{5,7}, new Integer[]{-9,3,5,7});
    }

    private static void test(Integer[] arr1, Integer[] arr2, Integer[] expected) {
        ListNode list1 = LinkedListUtils.arrToLinkedList(arr1);
        ListNode list2 = LinkedListUtils.arrToLinkedList(arr2);
        ListNode result = mergeTwoLists(list1, list2);
        List<Integer> resultArr = LinkedListUtils.linkedListToArr(result);
        String finalAnswer = Arrays.asList(expected).equals(resultArr) ? "✅" : "❌";
        System.out.printf("List1: %s, List2: %s, Result: %s, Expected: %s, Final: %s.\n", Arrays.asList(arr1), Arrays.asList(arr2), resultArr, Arrays.asList(expected), finalAnswer);
    }

    private static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode head = null;
        ListNode node = head;

        while (list1 != null && list2 != null) {
            if (head == null) {
                if (list1.val <= list2.val) {
                    head = new ListNode(list1.val);
                    node = head;
                    list1 = list1.next;
                }
                else {
                    head = new ListNode(list2.val);
                    node = head;
                    list2 = list2.next;
                }
                continue;
            }
            if (list1.val <= list2.val) {
                node.next = list1;
                list1 = list1.next;
            }
            else {
                node.next = list2;
                list2 = list2.next;
            }
            node = node.next;
        }

        if (list1 == null) {
            while (list2 != null) {
                if (head == null) {
                    head = new ListNode(list2.val);
                    node = head;
                    list2 = list2.next;
                    continue;
                }
                node.next = list2;
                list2 = list2.next;
                node = node.next;
            }
        }
        else {
            while (list1 != null) {
                if (head == null) {
                    head = new ListNode(list1.val);
                    node = head;
                    list1 = list1.next;
                    continue;
                }
                node.next = list1;
                list1 = list1.next;
                node = node.next;
            }
        }
        return head;
    }
}
