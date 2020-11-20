class Solution {

//1、对于链表，应该理解元素之间其实本来就是嵌套的，一个元素里嵌套下一个元素，元素的next一旦修改，
//整个链表可能就变了，而数组结构，修改操作改的只是当前元素本身
//2、本题来说，每次都是比较头部节点大小，然后把较小的拿出来，把next指向剩余元素合并后的链表
//3、每次循环其实都是确定表头，通过递归把每次找到的表头依次连接起来就是新的链表。

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null){
            return l2;
        }else if(l2==null){
            return l1;
        }else {
            if(l1.val>l2.val){
                l2.next=mergeTwoLists(l1,l2.next);
                return l2;
            }else{
                l1.next=mergeTwoLists(l1.next,l2);
                return l1;
            }
        }
    }
}