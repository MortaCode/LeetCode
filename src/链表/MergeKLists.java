package 链表;


//合并k个有序链表-23
public class MergeKLists {
    //方案一： 分治法（归并排序）
    public ListNode mergeKListsWithDivideAndConquer(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        return merge(lists, 0, lists.length - 1);
    }

    private ListNode merge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode l1 = merge(lists, left, mid);
        ListNode l2 = merge(lists, mid + 1, right);
        return mergeTwoLists(l1, l2);
    }

    //方案二：  逐一合并
    public ListNode mergeKListsOneByOne(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        ListNode result = null;
        for (ListNode list : lists) {
            result = mergeTwoLists(result, list);
        }
        return result;
    }

    // 合并两个有序链表
    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;

        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }

        current.next = (l1 != null) ? l1 : l2;
        return dummy.next;
    }

    public static void main(String[] args) {
//        输入：lists = [[1,4,5],[1,3,4],[2,6]]
//        输出：[1,1,2,3,4,4,5,6]
        ListNode[] lists = null;
        MergeKLists mergeKLists = new MergeKLists();
        mergeKLists.mergeKListsWithDivideAndConquer(lists);
    }
}
