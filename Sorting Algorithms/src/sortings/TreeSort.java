package sortings;

import main.Sort;

public class TreeSort extends Sort {
	Node root;
	int index;

	public TreeSort(int[] list) {
		super(list);
		this.root = null;
		this.index = 0;
		// TODO Auto-generated constructor stub
	}

	class Node {
		int value;
		Node left, right;

		public Node(int value) {
			this.value = value;
			left = right = null;
		}
	}

	@Override
	public void sort() {
		int[] list = super.getList();
		int size = this.getSize();

		for (int i = 0; i < size; i++) {
			insertNode(list[i]);
		}
		popNode(list, root);
	}

	private void popNode(int[] list, Node node) {
		if (node != null) {
			popNode(list, node.left);
			list[index++] = node.value;
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

}
