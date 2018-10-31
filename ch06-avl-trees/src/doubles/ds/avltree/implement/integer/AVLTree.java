package doubles.ds.avltree.implement.integer;

public class AVLTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {
        root = insert(root, data);
    }

    // 삽입
    private Node insert(Node node, int data) {

        // leaf 노드이면 새로운 노드 생성
        if (node == null) {
            return new Node(data);
        }

        // 새로운 데이터가 상위노드의 데이터보다 작으면
        if (data < node.getData()) {
            node.setLeftNode(insert(node.getLeftNode(), data));
            // 새로운 데이터가 상위노드의 데이터보다 크면
        } else {
            node.setRightNode(insert(node.getRightNode(), data));
        }

        // 높이 갱신
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        //
        node = settleViolation(data, node);

        return node;
    }

    private Node settleViolation(int data, Node node) {
        int balance = getBalance(node);

        // Left - Left
        if (balance > 1 && data < node.getLeftNode().getData()) {
            return rightRotation(node);
        }

        // Right - Right
        if (balance < -1 && data > node.getRightNode().getData()) {
            return leftRotation(node);
        }

        // Left - Right
        if (balance > 1 && data > node.getLeftNode().getData()) {
            node.setLeftNode(leftRotation(node.getLeftNode()));
            return rightRotation(node);
        }

        // Right - Left
        if (balance < -1 && data < node.getRightNode().getData()) {
            node.setRightNode(rightRotation(node.getRightNode()));
            return leftRotation(node);
        }

        return node;
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

        Node tempLeftNode = node.getLeftNode();         // 상위노드의 왼쪽 하위노드 ==> 루트노드가 된다
        Node t = tempLeftNode.getRightNode();           // 상위노드의 왼쪽 하위노드의 오른쪽 하위노드

        tempLeftNode.setRightNode(node);                // 왼쪽 하위노드의 오른쪽 하위노드에 상위노드를 세팅 : 상위노드가 오른쪽 하위노드가 됨
        node.setLeftNode(t);                            // 상위노드의 왼쪽 하위노드에 t

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);  // 상위 노드의 높이 갱신
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);  // 새로운 루트노드 높이 갱신

        return tempLeftNode;    // 새로운 루트노드 반환
    }

    // 왼쪽 회전
    private Node leftRotation(Node node) {
        System.out.println("Rotating to the left...");

        Node tempRightNode = node.getRightNode();       // 상위노드의 오른쪽 하위노드
        Node t = tempRightNode.getLeftNode();           // 상위노드의 오른쪽 하위노드의 오른쪽 하위노드

        tempRightNode.setLeftNode(node);                // 오른쪽 하위노드의 왼쪽 하위노드에 상위노드를 세팅 : 상위노드가 왼쪽 하위노드가 됨
        node.setRightNode(t);                           // 상위노드의 왼쪽 하위노드는 t

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1); // 상위노드 높이 갱신
        tempRightNode.setHeight(Math.max(height(tempRightNode.getLeftNode()), height(tempRightNode.getRightNode())) + 1); // 새로운 루트노드 높이 갱신

        return tempRightNode;   // 새로운 루트노드 반환
    }

    // 특정 노드의 높이 반환
    private int height(Node node) {

        // 노드가 null이면 -1
        if (node == null) {
            return -1;
        }

        // null이 아니면 높이 반환
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
