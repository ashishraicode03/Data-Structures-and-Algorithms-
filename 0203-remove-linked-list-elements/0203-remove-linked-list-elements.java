class Solution {
    public ListNode removeElements(ListNode head, int val) {
       //Empty LinkedList
        if (head == null) {
            return head;
        }

        ListNode prev = head;
        ListNode curr = head;

        while (curr != null) {
            //if first node or all nodes are matching->remove head
            if (head.val == val) {
                head = head.next;
                curr = head;
                prev = head;
            } 
            //Not match->only update
            else if (curr.val != val) {
                prev = curr;
                curr = curr.next;
            } 
            //value matches->delete and update
            else {
                prev.next = curr.next;
                curr = curr.next;
            }
        }

        return head;
    }
}
