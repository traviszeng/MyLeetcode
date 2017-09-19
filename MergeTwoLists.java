/**
 * Created by Administrator on 2017/1/19.
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1,ListNode l2){
        if(l1==null) return l2;
        if(l2==null) return l1;
        if(l1.val<l2.val){
            l1=mergeTwoLists(l1.next,l2);
            return l1;
        }
        else{
            l2=mergeTwoLists(l1,l2.next);
            return l2;
        }
    }
}
