package ListRecursion;

import java.util.HashMap;

public class LinkedRecur {

	public Node createNewNode(int data) {
		Node temp = new Node();
		temp.data = data;
		temp.next = null;
		return temp;
	}

	public Node insertNode(int data, Node head) {
		if (head == null) {
			return createNewNode(data);
		} else {
			head.next = insertNode(data, head.next);
			return head;
		}
	}

	public void PrintList(Node head) {
		if (head == null) {
			return;
		}
		Node temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	public Node insertStart(int data, Node node) {
		Node newNode = createNewNode(data);
		newNode.next = node;
		node = newNode;
		return node;
	}

	public void printRecur(Node node) {
		if (node == null) {
			return;
		} else {
			System.out.println(node.data + " ");
			printRecur(node.next);
		}
	}

	// inserting the node at a position
	public Node insertAtPos(int pos, Node node, int data) {
		Node a = node;
		for (int i = 1; i < pos - 1; i++) {
			a = a.next;
		}

		// System.out.println(a.data);
		Node newNode = createNewNode(data);
		newNode.next = a.next;
		a.next = newNode;
		return node;
	}

	// inserting at a particular position
	public Node insertAtPosition(int i, int position, Node node) {
		if (position < 0) {
			System.out.println("Position can't be less than 1");
		}

		if (node == null && position > 1) {
			System.out.println("Position is greater than element exists");
			return node;
		}

		if (node == null && position == 1) {
			return createNewNode(i);
		}

		if (position == 1) {
			Node newNode = createNewNode(i);
			newNode.next = node;
			return newNode;
		}

		node.next = insertAtPosition(i, position - 1, node.next);
		return node;
	}

	// deleting the last element from the list
	public Node deleteLastElement(Node head) {
		if (head == null || head.next == null) {
			return null;
		} else {
			Node temp = head;
			while (temp.next.next != null) {
				temp = temp.next;
			}
			// System.out.println(temp.data);
			temp.next = null;
			return head;
		}

	}

	// deleting the front node of the list
	public Node deleteFront(Node head) {
		if (head == null) {
			return null;
		} else {
			Node temp = head;
			head = temp.next;
			return head;
		}
	}

	// delete from a specific position in list
	public Node deleteFromPositin(int pos, Node head) {
		if (head == null) {
			return null;
		} else {
			Node temp = head;
			for (int i = 1; i < pos - 1; i++) {
				temp = temp.next;
			}
			// System.out.println(temp.data);
			temp.next = temp.next.next;
			return head;
		}
	}

	// deleting recursively from a given position
	public Node deleteAtPosition(int position, Node node) {
		if (position < 0) {
			System.out.println("Not a valid position");
			return node;
		}

		if (node == null && position > 0) {
			System.out.println("Position not valid");
			return node;
		}

		if (position == 1) {
			return node.next;
		}

		node.next = deleteAtPosition(position - 1, node.next);
		return node;
	}

	// getting the size of the linkedList by recursion
	public static int getSizeRecursion(Node head) {
		if (head == null) {
			return 0;
		} else {
			return 1 + getSizeRecursion(head.next);
		}
	}

	// searching a node in LikedList recursively
	public boolean searchNode(Node head, int val) {
		if (head == null) {
			return false;
		} else if (head.data == val) {
			return true;
		} else {
			return searchNode(head.next, val);
		}
	}

	// rotating linked list by k nodes
	public Node rotateLinkedList(Node head, int k) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		while (temp.next.next != null) {
			temp = temp.next;
		}
		Node last = temp.next;
		// System.out.println(temp.data);
		// System.out.println(last.data);
		for (int i = 0; i < k; i++) {
			temp.next = null;
			last.next = head;
			head = last;
			temp = head;
			while (temp.next.next != null) {
				// System.out.println(temp.data);
				temp = temp.next;
			}
			last = temp.next;
		}
		return head;
	}

	// one more method fot linkedlist rotations
	public Node rotateClockwise(int k, Node node) {
		if (node == null || k < 0) {
			return node;
		}

		int sizeOfLinkedList = getSizeRecursion(node);
		k = k % sizeOfLinkedList;

		if (k == 0) {
			return node;
		}

		Node tmp = node;
		int i = 1;

		while (i < sizeOfLinkedList - k) {
			tmp = tmp.next;
			i++;
		}

		Node temp = tmp.next;
		Node head = temp;
		tmp.next = null;

		while (temp.next != null) {
			temp = temp.next;
		}

		temp.next = node;

		return head;
	}

	// rotate linked list in anticlockwise by k
	public static Node rotateAntiClock(Node head, int k) {
		if (head == null) {
			return null;
		}
		int rotation = k % getSizeRecursion(head);
		// System.out.println(rotation);
		Node temp = head;
		for (int i = 1; i < rotation; i++) {
			temp = temp.next;
		}
		// head=temp.next;
		Node tmp = temp;
		while (tmp.next != null) {
			tmp = tmp.next;
		}
		System.out.println(temp.data);
		System.out.println(tmp.data);
		tmp.next = head;
		head = temp.next;
		temp.next = null;
		return head;
	}

	// reversing a linked list recursively
	// 12 -> 99 -> 37 ->null
	public Node reverse(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node temp = reverse(node.next);// for node 99 the return will be
		node.next.next = node;
		node.next = null;

		return temp;

	}

	// getting the middle node of linkedlist
	// try on more method using the total size of the linked list
	public Node getMiddleNode(Node head) {
		if (head == null) {
			return null;
		}
		Node a = head;
		Node b = head.next;
		while (b != null && b.next != null) {
			a = a.next;
			b = b.next.next;
		}
		return a;
	}

	// sorting the linkedlist using the mergesort
	public Node mergeSort(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node middle = getMiddleNode(node);
		Node secondHalf = middle.next;
		middle.next = null;

		return merge(mergeSort(node), mergeSort(secondHalf));
	}

	// this is the code for merging
	public Node merge(Node a, Node b) {
		Node temp = new Node();
		Node finalList = temp;

		while (a != null && b != null) {
			if (a.data < b.data) {
				temp.next = a;
				a = a.next;
			} else {
				temp.next = b;
				b = b.next;
			}
			temp = temp.next;
		}
		temp.next = (a == null) ? b : a;
		return finalList.next;// this is importaint point as temp was pointing to the front
		// node so we moved it by one
//		else {
//			temp.next=a;
//			a=a.next;
//			b=b.next;
//		}
	}

	// merging two unsorted list can be done by first sorting the lists individually
	// and then merging
	public Node mergeList(Node head1, Node head2) {
		return merge(mergeSort(head1), mergeSort(head2));
	}

	// **to get the union of two linked list first sort them and then merge them
	// using sort
	// in union we keep the duplicate elements only once.
	// ignore the duplicate elements during the merge.

	// **In intersection we only keep the common elements
	// sor the individual lists ans after sorting only keep the common ones.
	public Node getIntersection(Node a, Node b) {
		a = mergeSort(a);
		b = mergeSort(b);
		return mergeWithIntersection(a, b);
	}

	private Node mergeWithIntersection(Node a, Node b) {
		if (a == null && b == null) {
			return null;
		}

		if (a != null && b == null) {
			return a;
		}

		if (a == null && b != null) {
			return b;
		}

		Node temp = new Node();
		Node finalList = temp;
		while (a != null && b != null) {
			if (a.data < b.data) {
				a = a.next;
			} else if (a.data > b.data) {
				b = b.next;
			} else {
				temp.next = a;
				temp = temp.next;
				a = a.next;
				b = b.next;
			}
		}
		temp.next = null;
		return finalList.next;
	}

	// **getting the lowest element from the intersection of two linked lists.
	// first sort both the lists then run the merging algorithm to get the common
	// element.
	public Node getLowestCommomElementOfTwoLinkedLists(Node a, Node b) {
		a = mergeSort(a);
		b = mergeSort(b);
		Node temp;
		while (a != null && b != null) {
			if (a.data < b.data) {
				a = a.next;
			} else if (a.data > b.data) {
				b = b.next;
			} else {
				temp = a;
				temp.next = null;
				return temp;
			}
		}
		return null;
	}

	// to remove the duplicate elements from the linkedlist
	public Node removeDuplicates(Node head) {
		if (head == null) {
			return null;
		}
		Node temp = head;
		Node datum = head;
		temp = temp.next;
		while (temp.next != null) {
			if (datum.data == temp.data) {
				datum.next = temp.next;

			} else {
				datum = temp;
			}
			temp = temp.next;
		}
		return head;
	}

	// to remove the duplicate elements recursively.
	public Node removeDuplicateSortedList(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		if (node.data == node.next.data) {
			node.next = node.next.next;
			removeDuplicateSortedList(node);
		} else {
			removeDuplicateSortedList(node.next);
		}

		return node;
	}

	// deleting N nodes after M nodes from a linked list.
	// first traverse m nodes then delete the n nodes.
	public Node deleteAfterTrav(int n, int m, Node head) {
		if (head == null) {
			return null;
		} else {
			Node temp = head;
			for (int i = 1; i < n; i++) {
				temp = temp.next;
			}
			// System.out.println(temp.data);
			Node delete = temp;
			for (int i = 1; i <= m; i++) {
				delete = delete.next;
			}
			// System.out.println(delete.data);
			temp.next = delete.next;
			delete.next = null;
			return head;
		}
	}

	// same method but more systematic
	public Node deleteNNodesPostMNodes(int n, int m, Node node) {
		if (node == null) {
			return node;
		}

		Node tmp1 = node;
		Node tmp2 = node;
		int i = 0, j = 0;

		while (i++ < m - 1) {
			tmp1 = tmp1.next;
		}

		tmp2 = (m == 0) ? tmp1 : tmp1.next;

		while (j++ < n) {
			if (tmp2 == null) {
				System.out.println("Not enough elements to delete");
				return node;
			}
			tmp2 = tmp2.next;
		}

		if (m == 0) {
			return tmp2;
		} else {
			tmp1.next = tmp2;
		}

		return node;
	}

	// ** we can also use hashmap to remove duplicate elements from the linked list.
	public Node removeDuplicateUsingHashMap(Node node) {
		if (node == null) {
			return null;
		}

		HashMap<Integer, Integer> s = new HashMap<>();

		Node head = node;
		Node prev = null;
		while (node != null) {
			if (!s.containsKey(node.data)) {
				s.put(node.data, 1);
				prev = node;
				node = node.next;
			} else {
				prev.next = node.next;
				node = node.next;
			}
		}

		return head;
	}

	// getting the last element of the list through two pointers.
	public int returnKthLastNode(Node node, int k) {
		if (node == null) {
			System.out.println("Linked list is empty");
			return -1;
		}

		Node ptr1, ptr2;
		ptr1 = ptr2 = node;
		for (int i = 1; i < k; i++) {
			ptr2 = ptr2.next;
			if (ptr2 == null) {
				System.out.println("k is greater than total node present in list");
				return -1;
			}
		}

		while (ptr2.next != null) {
			ptr1 = ptr1.next;
			ptr2 = ptr2.next;
		}

		return ptr1.data;
	}

	// checkimg for the loop in a linked list.
	// We can use hashmap
	// Or take two pointers one slow and other fast.A point will come when bot will
	// coincide
	public Node checkLoop(Node head) {
		if (head == null) {
			return null;
		} else {
			Node slow = head;
			Node fast = head;
			while (slow.data != fast.data) {
				slow = slow.next;
				fast = fast.next.next;
			}
			System.out.println(slow.data);
			return head;
		}
	}

	public boolean ifLoopPresent(Node node) {
		if (node == null) {
			return false;
		}

		Node slow, fast;

		slow = fast = node;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.data == fast.data) {
				return true;
			}
		}

		return false;
	}

	// this will help in calculating the length of the loop
	public int lengthOfLoop(Node head) {
		if (head == null) {
			return -1;
		}

		Node slow, fast;
		slow = fast = head;
		int length = 0;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.data == fast.data) {
				break;
			}
		}

		if (slow == fast) {
			while (slow.next != fast) {
				slow = slow.next;
				length++;
			}
			length++;
		}

		return length;
	}

	// to remove the loop from the linked list
	public void detectAndRemoveLoopPresent(Node head) {
		if (head == null) {
			return;
		}

		Node slow, fast;

		slow = fast = head;
		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
			if (slow.data == fast.data) {
				break;
			}
		}

		if (slow == fast) {
			// this if condition is extra try after removing it.
			if (fast == head) {
				while (slow.next != fast) {
					slow = slow.next;
				}

				slow.next = null;
			} else {
				slow = head;
				while (slow.next != fast.next) {
					slow = slow.next;
				}

				fast.next = null;
			}
		}

		return;
	}

	// removing the middle node.If odd then remove the middle node.
	// if even then there will be two middle.remove the second middle.
	// we'll take two pointers and in every step save the previous node to slow.
	public Node deleteMiddleNode(Node node) {
		if (node == null || node.next == null) {
			return null;
		}

		Node slow, fast, prev;

		slow = fast = prev = node;

		while (fast != null && fast.next != null) {
			prev = slow;
			slow = slow.next;
			fast = fast.next.next;
		}

		prev.next = slow.next;
		return node;
	}

	// to check if the first and the second half of the linkedlist is matching or
	// not.
	// 12->99->37->12->99
	// 12->99->37->12->99->37
	// reach till the middle node and then we can match the lists.
	public boolean ifFirstSecondHalfMatching(Node node) {
		if (node == null || node.next == null) {
			return true;
		}

		Node slow, fast;
		slow = fast = node;

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		Node secondHalf = slow.next;

		while (secondHalf != null) {
			if (node.data != secondHalf.data) {
				return false;
			}

			node = node.next;
			secondHalf = secondHalf.next;
		}

		return true;
	}

	// checking if the linkedlist is a palindrome
	// 12->99->37->37->99->12
	//Enter the value till one half of the linkedlist and then match with the second half..
	public boolean ifPalindrome(Node node) {
		if (node == null || node.next == null) {
			return true;
		}

		Node slow, fast;
		slow = fast = node;

		Stack<Node> s = new Stack<Node>();
		s.push(slow);

		while (fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;

			s.push(slow);
		}

		if (fast.next == null) {//if null then odd nodes otherwise even nodes.
			s.pop();
		}

		Node secondHalf = slow.next;

		while (secondHalf != null) {
			if (s.pop().data != secondHalf.data) {
				return false;
			}

			secondHalf = secondHalf.next;
		}

		return true;
	}
}
