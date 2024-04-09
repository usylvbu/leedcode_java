package topic;
/*
第二十一题合并两个有序列表
将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
示例 1：
输入：l1 = [1,2,4], l2 = [1,3,4]
输出：[1,1,2,3,4,4]
示例 2：

输入：l1 = [], l2 = []
输出：[]
示例 3：

输入：l1 = [], l2 = [0]
输出：[0]

提示：
两个链表的节点数目范围是 [0, 50]
-100 <= Node.val <= 100
l1 和 l2 均按 非递减顺序 排列
 */
public class 合并两个有序列表 {

    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result =  new ListNode();
        ListNode next = result;
        if (list1 == null && list2 != null){
            return list2;
        } else if (list1 !=null && list2 == null) {
            return list1;
        }
        if (list1 == null && list2 == null){
            return null;
        }
        while (list1 != null || list2 != null){

            if (list1.val < list2.val){
                next.val = list1.val;
                list1 = list1.next;
            }else{
                next.val = list2.val;
                list2 = list2.next;
            }
            if (list1 == null){
                next.next = list2;
                break;
            }else if (list2 == null){
                next.next = list1;
                break;
            }
            next.next = new ListNode();
            next = next.next;
        }

        return result;
    }
}
