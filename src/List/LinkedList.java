package List;

public class LinkedList {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node head=null;
		Linked link=new Linked();
		head=link.insertNode(2,head);
        head=link.insertNode(12,head);
        head=link.insertNode(10,head);
        head=link.insertNode(13,head);
        
        System.out.println("printing the list");
        link.PrintList(head);
        System.out.println();
        
	}

}
