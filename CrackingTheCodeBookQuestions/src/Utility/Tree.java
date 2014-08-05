package Utility;

import trees_graphs.Problem3_createBST_minimalHeight;

public class Tree {
    private static TreeNode root;

    public Tree() {

        root = new TreeNode(null, null, "a");
        root.setLeftChildNode(new TreeNode(new TreeNode(null, null, "j"), new TreeNode(null, null, "k"), "b"));
        root.setRightChildNode(new TreeNode(new TreeNode(new TreeNode(null, null, "e"), null, "d"),
                new TreeNode(new TreeNode(new TreeNode(null, null, "m"), null, "i"), null, "h"), "c"));
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        Tree.root = root;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        inOrderTraversal(root.getLeftChildNode());
        System.out.print(root.getData() + " ");
        inOrderTraversal(root.getRightChildNode());
    }

    public void preOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        System.out.print(root.getData() + " ");
        preOrderTraversal(root.getLeftChildNode());
        preOrderTraversal(root.getRightChildNode());
    }

    public void postOrderTraversal(TreeNode root) {
        if (root == null)
            return;
        postOrderTraversal(root.getLeftChildNode());
        postOrderTraversal(root.getRightChildNode());
        System.out.print(root.getData() + " ");
    }

    /**
     * The following function takes in a sorted array of unique values/keys and creates the BST of minimal height
     * 
     * @param int[] (sorted array)
     * @return TreeNode (root node of the tree)
     */
    public void createBst(int array[]) {
        setRoot(new Problem3_createBST_minimalHeight(array).createBst(array));
    }

    /**
     * This function removes a node from a BST by taking the value to be removed. BST has the constraint that all the keys are unique
     * 
     * @param int /key to be deleted
     * @throws CloneNotSupportedException
     */
    public void removeNode(int data) throws CloneNotSupportedException {
        TreeNode node = removeNodeHelper(root, data);
        String str = (String) (node == null ? "no such key found" : node.getData().toString());
        System.out.println("\n" + str);

    }

    private TreeNode removeNodeHelper(TreeNode node, int data) throws CloneNotSupportedException {
        if (node == null)
            return null;
        else {
            TreeNode left = node.getLeftChildNode();
            TreeNode right = node.getRightChildNode();
            if ((Integer) node.getData() == data) {
                return findReplacementNode(node);
            } else if ((Integer) node.getData() > data) {
                return removeNodeHelper(left, data);
            } else {
                return removeNodeHelper(right, data);
            }

        }
    }

    private TreeNode findReplacementNode(TreeNode node) throws CloneNotSupportedException {
        if (node.getLeftChildNode() != null) {
            return findMaxInLeftSubTree(node.getLeftChildNode());

        } else if (node.getRightChildNode() != null) {
            return findMinInRightSubTree(node.getRightChildNode());
        } else {
            return null;
        }
    }

    private TreeNode findMaxInLeftSubTree(TreeNode node) throws CloneNotSupportedException {
        TreeNode parent = (TreeNode) node.clone();
        TreeNode left = node.getLeftChildNode();
        TreeNode right = node.getRightChildNode();
        if (left == null && right == null) {
            node.setData(null);
            return parent;
        } else if (right != null) {
            TreeNode returnedNode = findMaxInLeftSubTree(right);
            if (right.getData() == null) {
                parent.setRightChildNode(right.getLeftChildNode());
            }
            return returnedNode;
        } else {
            parent.setData(null);
            return node;
        }
    }

    private TreeNode findMinInRightSubTree(TreeNode node) {
        TreeNode parent = node;
        TreeNode left = node.getLeftChildNode();
        TreeNode right = node.getRightChildNode();
        if (left == null && right == null) {
            node.setData(null);
            return parent;
        } else if (left != null) {
            TreeNode returnedNode = findMinInRightSubTree(left);
            if (left.getData() == null) {
                parent.setRightChildNode(left.getLeftChildNode());
            }
            return returnedNode;
        } else {
            parent.setData(null);
            return node;
        }
    }

    /**
     * This function imitates the find functionality given the key to be searched and returns null if not found
     * 
     * @param int /key to be searched
     * @return null if not found else TreeNode if found
     */
    public TreeNode findNode(int data) {
        return findNodeHelper(this.getRoot(), data);
    }

    private TreeNode findNodeHelper(TreeNode root, int data) {
        if (root == null)
            return null;
        if ((Integer) root.getData() == data) {
            return root;
        } else if ((Integer) root.getData() > data) {
            return findNodeHelper(root.getLeftChildNode(), data);
        } else {
            return findNodeHelper(root.getRightChildNode(), data);
        }
    }

}
