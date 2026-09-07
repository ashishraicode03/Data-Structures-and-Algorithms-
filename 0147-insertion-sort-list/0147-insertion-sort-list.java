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
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode mid = slow.next;
        ;
        slow.next = null;
        ListNode f = insertionSortList(head);
        ListNode s = insertionSortList(mid);
        return merge(f, s);
    }

    ListNode merge(ListNode first, ListNode second) {
        ListNode dummy = new ListNode();
        ListNode cur = dummy;
        while (first != null && second != null) {
            if (first.val > second.val) {
                cur.next = second;
                second = second.next;
            } else {
                cur.next = first;
                first = first.next;
            }
            cur = cur.next;
        }
        cur.next = (first == null) ? second : first;
        return dummy.next;
    }
}