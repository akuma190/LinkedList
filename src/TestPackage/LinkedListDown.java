package TestPackage;

class NodeDown {
	int data;
	NodeDown right;
	NodeDown next;
}

class LinkedDown {

	public NodeDown getNewNode(int key) {
		NodeDown a = new NodeDown();
		a.next = null;
		a.right = null;
		a.data = key;
		return a;
	}

	public NodeDown insert(NodeDown node, int key) {
		if (node == null)
			return getNewNode(key);
		node.next = insert(node.next, key);
		return node;
	}

	public void printMultiLevels(NodeDown head) {
		if (head == null) {
			return;
		} else {
			NodeDown temp = head;
			while (temp != null) {
				System.out.println(temp.data + "->");
				if (temp.right != null) {
					NodeDown down = temp;
					while (down != null) {
						System.out.print(down.data + "->");
						down = down.next;
					}
				}
				System.out.println();
				temp = temp.right;
			}
		}
	}

	public NodeDown flattenList(NodeDown head) {
		if (head == null) {
			return null;
		} else {
			NodeDown temp = head;
			while (temp != null) {
				NodeDown tempNdext = temp.right;
				if (temp.next != null) {
					NodeDown down = temp;
					while (down.next != null) {
						// System.out.print(down.data + "->");
						down = down.next;
					}
					System.out.println("temp:" + temp.data);
					System.out.println("down:" + down.data);
					temp.right = null;
					down.next = tempNdext;
				}
				temp = tempNdext;
				// System.out.println("temp="+temp.data);
			}
			return head;
		}
	}

	public void PrintList(NodeDown head) {
		if (head == null) {
			return;
		}
		NodeDown temp = head;
		while (temp != null) {
			System.out.print(temp.data + " ");
			temp = temp.next;
		}
	}

	// the other method is where we can recursively flatten it using merging.
	public NodeDown flatten(NodeDown node) {
		if (node == null || node.right == null)
			return node;
		return merge(node, flatten(node.right));
	}

	public NodeDown merge(NodeDown first, NodeDown second) {
		// flag new node
		NodeDown temp = new NodeDown();
		NodeDown finalList = temp;
		// Based on node's value, nodes would be arranged
		while (first != null && second != null) {
			if (first.data < second.data) {
				temp.next = first;
				first = first.next;
			} else {
				temp.next = second;
				second = second.next;
			}
			temp = temp.next;
		}
		temp.next = (first != null) ? first : second;
		finalList.next.right = null;
		return finalList.next;
	}
}

public class LinkedListDown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		NodeDown root = null;
		LinkedDown a = new LinkedDown();
		root = a.insert(root, 20);
		root = a.insert(root, 22);
		root = a.insert(root, 25);
		root = a.insert(root, 65);
		root = a.insert(root, 70);

		root.right = a.insert(root.right, 7);
		root.right = a.insert(root.right, 12);
		root.right = a.insert(root.right, 23);
		root.right = a.insert(root.right, 34);

		root.right.right = a.insert(root.right.right, 10);
		root.right.right = a.insert(root.right.right, 15);
		root.right.right = a.insert(root.right.right, 17);
		root.right.right = a.insert(root.right.right, 18);
		root.right.right = a.insert(root.right.right, 21);
		root.right.right = a.insert(root.right.right, 33);

		root.right.right.right = a.insert(root.right.right.right, 32);
		root.right.right.right = a.insert(root.right.right.right, 39);
		root.right.right.right = a.insert(root.right.right.right, 40);

		// a.printMultiLevels(root);
		root = a.flattenList(root);
		a.PrintList(root);

	}

}
