package Utility;


public class TreeNode implements Cloneable{
	private TreeNode leftChildNode;
	private TreeNode rightChildNode;
	private Object data;

	public TreeNode(TreeNode leftChildNode, TreeNode rightChildNode, Object data) {
		super();
		this.leftChildNode = leftChildNode;
		this.rightChildNode = rightChildNode;
		this.data = data;
	}

	public TreeNode getLeftChildNode() {
		return leftChildNode;
	}

	public void setLeftChildNode(TreeNode leftChildNode) {
		this.leftChildNode = leftChildNode;
	}

	public TreeNode getRightChildNode() {
		return rightChildNode;
	}

	public void setRightChildNode(TreeNode rightChildNode) {
		this.rightChildNode = rightChildNode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
	    return super.clone();
	}
}