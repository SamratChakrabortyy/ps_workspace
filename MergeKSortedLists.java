package p5_workspace; 

import java.util.;
import java.util.stream.;
import java.util.function.;



 //Definition for singly-linked list.

 class ListNode {
     int val;
     ListNode next;
     ListNode() {}
     ListNode(int val) { this.val = val; }
     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
 


class MergeKSortedLists {
	public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0) 
        	return null;

        int k = lists.length;

        Queue<ListNode> minHeap = new PriorityQueue<>(Comparator
        	.comparingInt(n -> n.val));
        
        for (ListNode node : lists) {

        	if(Objects.nonNull(node)) {
        		minHeap.add(node);
        		node = node.next;
        	}

        }
        ListNode head = new ListNode(), tail = head;

        while(minHeap.size() > 0) {

        	ListNode currMin = minHeap.remove();
        	tail.next = currMin;
        	tail = currMin;

        	if(Objects.nonNull(currMin.next)){
        		minHeap.add(currMin.next);
        	}

        }
        return head.next;
    }
}