/**
 * Created by Travis Zeng on 2017/1/19.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x){
        val=x;
    }


    /**
     *  Given a sorted linked list, delete all duplicates such that each element appear only once.

     For example,
     Given 1->1->2, return 1->2.
     Given 1->1->2->3->3, return 1->2->3.
     * */
    public ListNode deteleDuplicates(ListNode head){
        if(head==null) return null;
        while(head.next!=null && head.val == head.next.val){
            head.next = head.next.next;
        }
        if(head.next!=null&& head.val!=head.next.val) {
            head.next = deteleDuplicates(head.next);
        }

        return head;

    }

    /**
     * traverse function of LinkList
     * print the LinkedList as 1 2 3
     * */
    public void walkThroughLinkedList(ListNode head){
        if(head==null) return;
        while(head!=null){
            System.out.print(head.val+" ");
            head = head.next;
        }
    }


    public static void main(String[] args){
        ListNode s= new ListNode(1);
        s.next = new ListNode(1);
        s.next.next = new ListNode(1);
        s.next.next.next = new ListNode(2);
        s.next.next.next.next = new ListNode(2);
        s.next.next.next.next.next = new ListNode(3);
        ListNode ss = s.deteleDuplicates(s);
        ss.walkThroughLinkedList(ss);

    }
}
