package sortings;

import java.util.ArrayList;

public class _8_TreeSort extends Sort {
	Node root;
	int index;

	public _8_TreeSort(ArrayList<Integer> list) {
		super(list);
		this.root = null;
		this.index = 0;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void sort() {
		ArrayList<Integer> list = super.getList();
		int size = this.getSize();

		for (int i = 0; i < size; i++) {
			insertNode(list.get(i));
		}
		popNode(list, root);
	}

	private void popNode(ArrayList<Integer> list, Node node) {
		if (node != null) {
			popNode(list, node.left);
			list.set(index++, node.value);
			popNode(list, node.right);
		}
	}

	private void insertNode(Integer value) {
		Node node = new Node(value);

		if (root == null) {
			this.root = node;
		} else {
			Node temp = root;
			while (true) {
				if (temp.value > value) {
					if (temp.left == null) {
						temp.left = node;
						return;
					} else {
						temp = temp.left;
					}
				} else {
					if (temp.right == null) {
						temp.right = node;
						return;
					} else {
						temp = temp.right;
					}
				}
			}

		}
	}

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

}
