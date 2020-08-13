package TestPackage;

class Node {
	Node next;
	int data;
}

class Linked {

	public Node getNewNode(int key) {
		Node a = new Node();
		a.next = null;
		a.data = key;
		return a;
	}

	public Node insert(int key, Node node) {

		if (node == null)
			return getNewNode(key);
		else
			node.next = insert(key, node.next);

		return node;
	}

	public void printList(Node node) {
		if (node == null) {
			return;
		}

		System.out.print(node.data + " ");
		printList(node.next);
	}
	
	public Node removeDuplicates(Node head) {
		if(head==null) {
			return null;
		}
		Node temp=head;
		Node datum=head;
		temp=temp.next;
		while(temp.next!=null) {
			if(datum.data==temp.data) {
				datum.next=temp.next;
				
			}else {
				datum=temp;
			}
			temp=temp.next;
		}
		return head;
	}
}

public class LinkedListApp {

	public static void main(String[] args) {

		Node head1 = null;
		Linked a = new Linked();

		head1 = a.insert(1, head1);
		head1 = a.insert(1, head1);
		head1 = a.insert(7, head1);
		head1 = a.insert(7, head1);
		head1 = a.insert(7, head1);
		head1 = a.insert(10, head1);
		head1 = a.insert(10, head1);
		head1 = a.insert(10, head1);
		head1 = a.insert(11, head1);
        
		head1=a.removeDuplicates(head1);
		a.printList(head1);
	}
}
