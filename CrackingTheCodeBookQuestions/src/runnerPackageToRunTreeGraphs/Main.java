package runnerPackageToRunTreeGraphs;

import Utility.Tree;
import Utility.TreeNode;

public class Main {

	public static void main(String[] args) throws CloneNotSupportedException {
		int array[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11 };
		Tree tree = new Tree();
		tree.createBst(array);
		tree.inOrderTraversal(tree.getRoot());
		tree.removeNode(6);
		tree.inOrderTraversal(tree.getRoot());
		
	}

}
