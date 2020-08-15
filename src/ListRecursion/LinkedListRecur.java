package ListRecursion;

public class LinkedListRecur {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Node head = null;
		LinkedRecur link = new LinkedRecur();
		head = link.insertNode(12, head);
		head = link.insertNode(99, head);
		head = link.insertNode(37, head);
		head = link.insertNode(8, head);
		head = link.insertNode(18, head);
        
		//head.next.next.next.next.next=head.next;
		//head = link.insertStart(5, head);

//        System.out.println("printing the list");
//        link.PrintList(head);
//        System.out.println();

		//head = link.insertAtPos(3, head, 55);
		// System.out.println(head.data);

		System.out.println("printing the list");
		link.PrintList(head);
		System.out.println();

//        link.deleteLastElement(head);
//        
//        head=link.deleteFront(head);

		//head = link.deleteFromPositin(3, head);

//		System.out.println("printing the list");
//		link.PrintList(head);
//		System.out.println();
//		
//		System.out.println("Size of the list");
//		System.out.println(link.getSizeRecursion(head));
//		System.out.println();
//		
//		System.out.println("searching an element in the list");
//		System.out.println(link.searchNode(head,12));
//		System.out.println();
		
		//head=link.rotateLinkedList(head,2);
		//head=link.rotateAntiClock(head, 2);
		
//		Node head1=null;
//		head1=link.insertNode(12, head1);
//		head1=link.insertNode(9, head1);
//		head1=link.insertNode(37, head1);
//		
//		Node head2=null;
//		head2=link.insertNode(45, head2);
//		head2=link.insertNode(8, head2);
//		
//		Node mergeList=link.mergeList(head1, head2);
		
		//head=link.deleteAfterTrav(1,3,head);
		
//		System.out.println("check if the loop exists");
//		System.out.println(link.ifLoopPresent(head));
//		System.out.println();

		
//		System.out.println("The middle element of the node is");
//		System.out.println(link.getMiddleNode(head).data);
//		System.out.println();
		
//		Node head1 = null;
	    LinkedRecur a = new LinkedRecur();
//
//	    head1 = a.insertNode(7, head1);
//	    head1 = a.insertNode(24, head1);
//	    head1 = a.insertNode(34, head1);
//	    head1 = a.insertNode(9, head1);
//	    head1 = a.insertNode(18, head1);
//	    head1 = a.insertNode(37, head1);
//	    head1 = a.insertNode(5, head1);
//	    
//	    a.PrintList(head1);
//	    System.out.println();
	    
	    Node head2 = null;
	    
	    head2 = a.insertNode(9, head2);
	    head2 = a.insertNode(9, head2);
	    head2 = a.insertNode(9, head2);
	    head2 = a.insertNode(9, head2);
	    head2 = a.insertNode(9, head2);
	    
	    head2=a.addOne(head2,1);
	    a.PrintList(head2);
	    System.out.println();
	    
	    //System.out.println(a.getIntersectionOfLists(head1, head2));
	}

}
