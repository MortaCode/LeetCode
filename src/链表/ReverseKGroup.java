package 链表;

//K 个一组翻转链表-25
public class ReverseKGroup {

    public static void main(String[] args) {
        ReverseKGroup reverseKGroup = new ReverseKGroup();
        Integer[] values = new Integer[]{1,2,3,4,5,6,7,8};
        ListNode head = ListNode.buildNode(values);
        ListNode.printNode(head);
        ListNode result = reverseKGroup.reverseKGroup(head, 3);
        ListNode.printNode(result);
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev = dummy; //当前组的上一节点
        while (head != null){
            //ListNode tail = head;  //head是当前组的头节点、tail是当前组的尾节点
            ListNode tail = prev;  //head是当前组的头节点、tail是当前组的尾节点
            for (int i=0; i<k; i++){
                tail = tail.next;
                if (tail == null){//最后一组
                    return dummy.next;
                }
            }
            ListNode next = tail.next;  //当前组的下一节点
            ListNode[] list = reverse(head, tail);
            head = list[0];
            tail = list[1];
            //连接上当前组
            prev.next = head;
            tail.next = next;
            //下一组
            prev = tail;
            head = tail.next;//next呢
        }
        return dummy.next;
    }

    public ListNode[] reverse(ListNode head, ListNode tail){
        ListNode prev = tail.next;
        ListNode cur = head;
        while (prev != tail){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return new ListNode[]{tail,head};
    }
}
