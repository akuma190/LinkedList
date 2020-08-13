package List;

public class Linked {

	public Node createNewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		return temp;
	}

	public Node insertNode(int data, Node head) {
		if (head == null) {
			return createNewNode(data);
		}
		Node temp=head;
		while(temp.next!=null) {
			temp=temp.next;
		}
		Node newNode=new Node();
		newNode.data=data;
		newNode.next=null;
		temp.next=newNode;
		return head;
	}
	
	public void PrintList(Node head) {
		if(head==null) {
			return;
		}
		Node temp=head;
		while(temp!=null) {
			System.out.print(temp.data+" ");
			temp=temp.next;
		}
	}

}
