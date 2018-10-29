package doubles.ds.avltree.implement.integer;

public class AVLTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {

    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    public int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeftNode()) - height(node.getRightNode());
    }

    // 순회
    @Override
    public void traverse() {

        if (root == null) {
            return;
        }

        inorderTraversal(root);

    }

    // 중위 순회
    private void inorderTraversal(Node node) {

        if (node.getLeftNode() != null) {
            inorderTraversal(node.getLeftNode());
        }

        System.out.println(node);

        if (node.getRightNode() != null) {
            inorderTraversal(node.getRightNode());
        }

    }

}
