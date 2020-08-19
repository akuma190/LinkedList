package ListRecursion;

import java.util.HashMap;
import java.util.Stack;

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
	//12->99->37->8->18
	//18->12->99->37->8
	//8->18->12->99->37
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

	// one more method for linkedlist rotations
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

		Node temp = reverse(node.next);// for node 99 the return will be 37.after 37 its null.
		//node is 99 and node.next.next is 37.next
		//second iteration 12.next is 99.next=12
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

	// **getting the lowest common element from the intersection of two linked lists.
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

	// to remove the duplicate elements from the sorted linked linkedlist
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
	//to remove the dulicates from unsorted linked list we can first sort the list

	// deleting N nodes after M nodes from a linked list.
	// first traverse n nodes then delete the m nodes.
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

	// getting the kth last element of the list through two pointers.
	//8->18->17->28->6->null
	//2nd from the last means 28.
	//we can get size then size -k but this will need two traversals.
	//
	public int returnKthLastNode(Node node, int k) {
		if (node == null) {
			System.out.println("Linked list is empty");
			return -1;
		}

		Node ptr1, ptr2;
		ptr1 = ptr2 = node;
		//take two pointers and then traverse one of the pointer till k-1
		for (int i = 1; i < k; i++) {
			ptr2 = ptr2.next;
			if (ptr2 == null) {
				System.out.println("k is greater than total node present in list");
				return -1;
			}
		}
        
		//traverse both and when one of the pointers becomes null then both are done.
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
	//this two pointer strategy can be used to find the middle.
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
	// Enter the value till one half of the linkedlist and then match with the
	// second half..
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

		if (fast.next == null) {// if null then odd nodes otherwise even nodes.
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
	// delete the nodes which have greater values on the right.
	// taking two loops will not be an efficient solution O(n2).
	// we'll revrese the linked list and then carry on
    //12->99->8->39->5
	//99->39->5
	public Node deleteGreaterValuesOnRight(Node node) {
		if (node == null || node.next == null) {
			return node;
		}
//revrerse and check if next elment is greater then keep otherise delete.
		Node reverse = this.reverse(node);
		Node tmp = reverse;
		int max = tmp.data;

		while (tmp.next != null) {
			if (tmp.next.data > max) {// if the element is greater than the max element.
				max = tmp.next.data;
				tmp = tmp.next;
			} else {
				tmp.next = tmp.next.next;// otherwise we will delete the node
			}
		}

		node = this.reverse(reverse);

		return node;
	}

	// Checking if two lists are identical or not
	public boolean ifIdenticalLists(Node node1, Node node2) {
		while (node1 != null && node2 != null) {
			if (node1.data != node2.data) {
				return false;
			}

			node1 = node1.next;
			node2 = node2.next;
		}

		return (node1 == null && node2 == null);
	}

	// pairwise swapping the elements of the linked list.
	// 12->99->8->39->5
	// 99->12->39->8->5
	public Node pairwiseSwapElements(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node head = node;

		while (node != null && node.next != null) {
			int t = node.data;
			node.data = node.next.data;
			node.next.data = t;

			node = node.next.next;
		}

		return head;
	}

	// deleting alternate nodes from the linkdlist
	// 12->99->8->39->5
	// 12->8->5
	public Node deleteAlternateNode(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node head = node;

		while (node != null && node.next != null) {
			node.next = node.next.next;
			node = node.next;
		}

		return head;
	}

	// moving the last element of the list to the front
	public Node moveLastNodeToFront(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node head = node;

		while (node.next.next != null) {// rather than using previous used this concept.
			node = node.next;
		}

		node.next.next = head;
		head = node.next;

		node.next = null;
		return head;
	}

	// swapping the nodes of given values of the linkedlist without swapping the data.
	//here we will be taking four pointers.
	public Node swapNodes(Node node, int a, int b) {
		if (node == null || node.next == null) {
			return node;
		}

		Node t1, t2, head, prev1, prev2;
		prev1 = prev2 = t1 = t2 = null;

		head = node;

		while (node != null) {
			if (node.data == a) {
				t1 = node;
				break;
			}
			prev1 = node;
			node = node.next;
		}

		node = head;

		while (node != null) {
			if (node.data == b) {
				t2 = node;
				break;
			}
			prev2 = node;
			node = node.next;
		}

		if (t1 == null || t2 == null) {
			return head;
		}

		if (prev1 != null) {
			prev1.next = t2;
		} else {
			head = t2;
		}

		if (prev2 != null) {
			prev2.next = t1;
		} else {
			head = t1;
		}

		Node tmp = t1.next;
		t1.next = t2.next;
		t2.next = tmp;

		return head;
	}

	// finding out the intersection point of the two unsorted list
	// if the node lies in teh first half then issue.
	//1->24->34->9->8->37->5
	//12->99->8->37->5 
	public int getIntersectionOfLists(Node node1, Node node2) {
		if (node1 == null || node2 == null) {
			return -1;
		}

		Node head1 = node1, head2 = node2;

		int count1 = 0, count2 = 0;
		while (node1 != null) {
			count1++;
			node1 = node1.next;
		}

		while (node2 != null) {
			count2++;
			node2 = node2.next;
		}

		int v = count1 - count2;
		while (v > 0) {
			head1 = head1.next;
			v--;
		}

		while (v < 0) {
			head2 = head2.next;
			v++;
		}

		while (head1 != null && head2 != null) {
			if (head1.data == head2.data) {
				return head1.data;
			}

			head1 = head1.next;
			head2 = head2.next;
		}

		return -1;
	}

	// reversing a linked list iteratively
	public Node reverseIteratively(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node prev, next;
		prev = next = null;

		while (node != null) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
		}

		return prev;
	}

	// reversing the linkedlist in group of K
	// 12->99->8->39->5
	// 8->99->12->5->39
	public Node reverseInGroup(Node head, int k) {
		Node prev, next;
		prev = next = null;

		Node node = head;

		int i = 0;

		while (node != null && i < k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}

		if (next != null) {
			head.next = reverseInGroup(next, k);
		}

		return prev;
	}

	// reverse alternatively in the group of K.
	// 12->99->8->->39->5->70->25
	// 99->12->8->39->70->5->25
	// Add two loop within the loop.In one loop reverse two times in other increase
	// two times.
	public Node reverseAlternativelyInGroup(Node head, int k) {
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		Node prev, next;
		prev = next = null;

		Node node = head;

		int i = 0;

		while (node != null && i < k) {
			next = node.next;
			node.next = prev;
			prev = node;
			node = next;
			i++;
		}

		i = 0;
		if (next != null) {
			head.next = next;
			node = next;
			while (node != null && i < k - 1) {
				node = node.next;
				i++;
			}
			if (node != null) {
				node.next = reverseAlternativelyInGroup(node.next, k);
			}
		}

		return prev;
	}

	// separating the even and odd nodes from the linked list.
	// 12->99->8->->39->5->70->25
	// 12->8->70->99->39->5->25
	// tis can be solved efficiently using four pointers.
	public Node seperateOddEven(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node evenStartingNode, evenEndNode, oddStartingNode, oddEndNode;

		evenStartingNode = evenEndNode = oddStartingNode = oddEndNode = null;

		while (node != null) {
			if (node.data % 2 == 0) {
				if (evenStartingNode == null) {
					evenStartingNode = node;
					evenEndNode = evenStartingNode;
				} else {
					evenEndNode.next = node;
					evenEndNode = evenEndNode.next;
				}
			} else {
				if (oddStartingNode == null) {
					oddStartingNode = node;
					oddEndNode = oddStartingNode;
				} else {
					oddEndNode.next = node;
					oddEndNode = oddEndNode.next;
				}
			}

			node = node.next;
		}

		evenEndNode.next = oddStartingNode;
		oddEndNode.next = null;
		return evenStartingNode;
	}
	

	// splitting a single linkedlist alternatively.
	//12->99->8->39->5->70->25
	//12->8->5->25
	//99->39->70
	Node firstHead, secondHead;

	public void alternateSplit(Node node) {
		if (node == null || node.next == null) {
			return;
		}

		Node firstTemp;
		Node secondTemp;

		firstHead = firstTemp = node;
		secondHead = secondTemp = node.next;
		node = node.next.next;

		while (node != null && node.next != null) {
			firstTemp.next = node;
			secondTemp.next = node.next;

			firstTemp = firstTemp.next;
			secondTemp = secondTemp.next;

			node = node.next.next;
		}

		if (node != null) {
			firstTemp.next = node;
			firstTemp = firstTemp.next;
		}

		firstTemp.next = null;
		secondTemp.next = null;

		return;
	}

	// swapping the node links pairwise.
	//12->99->8->39->5->70
	//99->12->39->8->70->5
	//this is like reversing the elements in the group of two elements.
	public Node pairwiseSwapNodeLinks(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node head = node.next;

		Node prev = node;
		node = node.next;
		Node next;

		while (node != null) {
			next = node.next;
			node.next = prev;

			if (next == null || next.next == null) {
				prev.next = next;
				break;
			}

			prev.next = next.next;

			prev = next;
			node = prev.next;
		}

		return head;
	}

	// merging two lists alternatively.
	// 12->99->8->39
	// 5->70
	//12->5->99->70-.8->39
	Node first, second;

	public void mergeTwoListAlternatively(Node node1, Node node2) {

		Node node1next, node2next;
		first = node1;
		second = node2;

		while (node1 != null && node2 != null) {
			node1next = node1.next;
			node1.next = node2;
			node1 = node1next;

			node2next = node2.next;
			node2.next = node1next;
			node2 = node2next;
		}

		second = node2;
	}

	// sort list of items with only 0,1 and 2
	// 2->1->0->1->2->1
	// 0->1->1->1->2->2
	public Node sortListOfZeroOneTwos(Node node) {
		if (node == null || node.next == null) {
			return node;
		}

		Node head = node;

		int count_0, count_1, count_2;

		count_0 = count_1 = count_2 = 0;

		while (node != null) {
			if (node.data == 0) {
				count_0++;
			} else if (node.data == 1) {
				count_1++;
			} else {
				count_2++;
			}

			node = node.next;
		}

		node = head;

		while (count_0 > 0) {
			node.data = 0;
			node = node.next;
			count_0--;
		}

		while (count_1 > 0) {
			node.data = 1;
			node = node.next;
			count_1--;
		}

		while (count_2 > 0) {
			node.data = 2;
			node = node.next;
			count_2--;
		}

		return head;
	}
	
	//add 1 to the linked list
	//1->9->9->9->9
	//2->0->0->->0
	//9->9->9->9->->9
	//1->0->0-0->0->0
	public int addNumber(Node node,int i) {
		if(node==null) {
			return i;
		}else {
			int j=node.data+addNumber(node.next,i);
			node.data=j%10;
			return j/10;
		}
	}
	
	public Node addOne(Node node,int i) {
		int c=addNumber(node,i);
		
		System.out.println(c);
		if(c==1) {
			Node newNode=createNewNode(c);
			System.out.println(newNode.data);
			newNode.next=node;
			return newNode;
		}
		return node;
	}
}
