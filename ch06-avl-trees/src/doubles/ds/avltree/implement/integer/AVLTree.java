package doubles.ds.avltree.implement.integer;

public class AVLTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {

    }

    // 순회
    @Override
    public void traverse() {

        if (root == null) {
            return;
        }
        inorderTraversal(root);
        preOrderTraversal(root);
        postOrderTraversal(root);
    }

    // 오른쪽 회전
    private Node rightRotation(Node node) {
        System.out.println("Rotating to the right...");
        Node tempLeftNode = node.getLeftNode();
        Node t = tempLeftNode.getRightNode();

        tempLeftNode.setRightNode(node);
        node.setLeftNode(t);
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);
        return tempLeftNode;
    }

    // 왼쪽 회전
    private Node leftRotation(Node node) {

    }


    // 특정 노드의 높이 반환
    private int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    // 트리 균형, 불균형 여부 판단
    private int getBalance(Node node) {
        if (node == null) {
            return 0;
        }
        return height(node.getLeftNode()) - height(node.getRightNode());
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

    // 전위 순회
    private void preOrderTraversal(Node node) {
        System.out.println(node);
        if (node.getLeftNode() != null) {
            inorderTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            inorderTraversal(node.getRightNode());
        }
    }

    private void postOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            inorderTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            inorderTraversal(node.getRightNode());
        }
        System.out.println(node);
    }
}
