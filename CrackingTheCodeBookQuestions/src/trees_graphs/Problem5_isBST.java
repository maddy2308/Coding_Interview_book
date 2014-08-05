package trees_graphs;

import Utility.TreeNode;

public class Problem5_isBST {
	public Object isBst(TreeNode root) {

		Integer leftValue = 0, rightValue = 0;
		if (root == null)
			return null;
		else {
			Object obj = isBst(root.getLeftChildNode());
			if (!(obj instanceof Boolean)) {
				TreeNode left = (TreeNode) obj;
				if (left == null)
					leftValue = null;
				else
					leftValue = (Integer) left.getData();
			} else if ((Boolean) (obj)) {
				return false;
			}

			obj = isBst(root.getRightChildNode());
			if (!(obj instanceof Boolean)) {
				TreeNode right = (TreeNode) obj;
				if (right == null)
					rightValue = null;
				else
					rightValue = (Integer) right.getData();
			} else if ((Boolean) (obj)) {
				return false;
			}

			if (check(leftValue, (Integer) root.getData(), rightValue)) {
				return true;
			} else {
				return false;
			}
		}
	}

	private boolean check(Integer leftValue, Integer rootValue,
			Integer rightValue) {
		if (leftValue == null) {
			if (rightValue == null)
				return true;
			else if (rootValue < rightValue)
				return true;
			else
				return false;
		} else {
			if ((leftValue <= rootValue) && (rootValue < rightValue)) {
				return true;
			} else {
				return false;
			}
		}
	}
}
