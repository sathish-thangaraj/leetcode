class MiddleNode {
    public ListNode middleNode(ListNode head) {
        ListNode temp = head ;
        int numberOfNodes = 0 ;
        while(temp!=null){
            numberOfNodes++;
            temp = temp.next;
        }
        
        int mid = numberOfNodes / 2 ;
        
        while(mid>0){
            mid--;
            head = head.next;
        }
        return head;
    }
}
