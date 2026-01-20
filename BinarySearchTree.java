import java.util.LinkedList;
import java.util.Queue;
public class BinarySearchTree<T extends Comparable<T>> {
    private class Node <T extends Comparable<T>> {
        T item;
        Node<T> left;
        Node<T> right;

        public Node(T item) {
            this.item = item;
            left = right = null;
        }
    }

    private Node<T> root;

    public BinarySearchTree() {
        root = null;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public boolean search(T item) {
        return searchRec(root, item);
    }

    private boolean searchRec(Node <T> root, T item) {
        if (root == null) return false;
        int compare = item.compareTo(root.item);
        if (compare == 0) return true;
        return compare < 0 ? searchRec(root.left, item) : searchRec(root.right, item);
    }

    public void insert(T item) {
        root = insertRec(root, item);
    }

    private Node<T> insertRec(Node <T> root, T item) {
        if (root == null) return new Node<>(item);
        int compare = item.compareTo(root.item);
        if (compare < 0) root.left = insertRec(root.left, item);
        else if (compare > 0) root.right = insertRec(root.right, item);
        return root;
    }

    public void remove(T item) {
        root = deleteRec(root, item);
    }

    private Node<T> deleteRec(Node <T> root, T item) {
        if (root == null) return root;
        int compare = item.compareTo(root.item);
        if (compare < 0) root.left = deleteRec(root.left, item);
        else if (compare > 0) root.right = deleteRec(root.right, item);
        else {
            if (root.left == null) return root.right;
            else if (root.right == null) return root.left;
            root.item = minValue(root.right);
            root.right = deleteRec(root.right, root.item);
        }
        return root;
    }

    private T minValue(Node <T> root) {
        T minVal = root.item;
        while (root.left != null) {
            minVal = root.left.item;
            root = root.left;
        }
        return minVal;
    }

    public void preOrderTraversal() {
        preOrder(root);
        System.out.println();
    }

    private void preOrder(Node <T> root) {
        if (root != null) {
            System.out.print(root.item + " ");
            preOrder(root.left);
            preOrder(root.right);
        }
    }

    public void inOrderTraversal() {
        inOrder(root);
        System.out.println();
    }

    private void inOrder(Node <T> root) {
        if (root != null) {
            inOrder(root.left);
            System.out.print(root.item + " ");
            inOrder(root.right);
        }
    }

    public void postOrderTraversal() {
        postOrder(root);
        System.out.println();
    }

    private void postOrder(Node <T> root) {
        if (root != null) {
            postOrder(root.left);
            postOrder(root.right);
            System.out.print(root.item + " ");
        }
    }

    public void levelOrderTraversal() {
        levelOrder(root);
        System.out.println();
    }

    private void levelOrder(Node <T> root) {
        if (root != null) {
            Queue<Node <T>> Q = new LinkedList<>();
            Q.add(root);
            while (!Q.isEmpty()) {
                Node <T> temp = Q.poll();
                System.out.print(temp.item + " ");
                if (temp.left != null) Q.add(temp.left);
                if (temp.right != null) Q.add(temp.right);
            }
        }
    }

    public int treeHeight() {
        return height(root);
    }

    private int height(Node <T> root) {
        if (root == null) return 0;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    public int treeNodeCount() {
        return nodeCount(root);
    }

    private int nodeCount(Node <T> root) {
        if (root == null) return 0;
        return 1 + nodeCount(root.left) + nodeCount(root.right);
    }

    public int treeLeaves() {
        return leavesCount(root);
    }

    private int leavesCount(Node <T> root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return leavesCount(root.left) + leavesCount(root.right);
    }

    public void clearTree() {
        root = null;
    }

    public int nodesAtLevel(int level) {
        return countLevel(root, level);
    }
    private int countLevel(Node<T> node, int lvl) {
        if (node == null || lvl < 0) return 0;
        if (lvl == 0) return 1;
        return countLevel(node.left, lvl - 1) + countLevel(node.right, lvl - 1);
    }
}