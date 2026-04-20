package 链表;

public class ListNode {
    public Integer val;

    public ListNode next;

    public ListNode(Integer val){this.val = val;}

    public static ListNode buildNode(Integer[] values){
        if (values == null || values.length == 0){return null;}
        ListNode head = new ListNode(values[0]);
        ListNode cur = head;
        for (int i=1; i<values.length; i++){
            ListNode node = new ListNode(values[i]);
            cur.next = node;
            cur =cur.next;
        }
        return head;
    }

    public static void printNode(ListNode head){
        while (head != null && head.next != null){
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println(head.val);
    }




}
