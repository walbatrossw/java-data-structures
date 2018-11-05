package doubles.ds.rbt.integer;

public class RedBlackTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        root = insertIntoTree(root, newNode);
    }

    // 삽입 구현
    private Node insertIntoTree(Node root, Node newNode) {

        if (root == null) {
            return newNode;
        }

        if (newNode.getData() < root.getData()) {
            root.setLeftNode(insertIntoTree(root.getLeftNode(), newNode));
            root.getLeftNode().setParentNode(root);
        } else if (newNode.getData() > root.getData()) {
            root.setRightNode(insertIntoTree(root.getRightNode(), newNode));
            root.getRightNode().setParentNode(root);
        }

        return root;
    }

    // 규칙 위반 수정
    private void fixViolations(Node node) {

        Node parentNode = null;
        Node grandParentNode = null;

        // 루트노드 X, 블랙노드가 아니고, 부모노드가 레드노드일 때까지 반복 수행
        while (node != root && node.getColor() != NodeColor.BLACK && node.getParentNode().getColor() == NodeColor.RED) {

            parentNode = node.getParentNode();
            grandParentNode = node.getParentNode().getParentNode();

            if (parentNode == grandParentNode.getLeftNode()) {
                Node uncle = grandParentNode.getRightNode();

                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.RED);
                    uncle.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else {
                    if (node == parentNode.getRightNode()) {

                    }
                }

            } else {

            }

        }
    }

    // 오른쪽  회전
    private void rightRotate(Node node) {

        System.out.println("Rotating right on node " + node);

        Node tempLeftNode = node.getLeftNode();
        node.setLeftNode(tempLeftNode.getRightNode());

        if (node.getRightNode() != null) {
            node.getLeftNode().setParentNode(node);
        }

        tempLeftNode.setParentNode(node.getParentNode());

        if (tempLeftNode.getParentNode() == null) {
            root = tempLeftNode;
        } else if (node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempLeftNode);
        } else {
            node.getParentNode().setRightNode(tempLeftNode);
        }

        tempLeftNode.setRightNode(node);
        node.setParentNode(tempLeftNode);

    }

    // 왼쪽 회전
    private void leftRotate(Node node) {

        System.out.println("Rotating left on node " + node);
        Node tempRightNode = node.getRightNode();
        node.setRightNode(tempRightNode.getLeftNode());

        if (node.getRightNode() != null) {
            node.getRightNode().setParentNode(node);
        }

        tempRightNode.setParentNode(node.getParentNode());

        if (tempRightNode.getRightNode() == null) {
            root = tempRightNode;
        } else if (node == node.getParentNode().getLeftNode()) {
            node.getParentNode().setLeftNode(tempRightNode);
        } else {
            node.getParentNode().setRightNode(tempRightNode);
        }

        tempRightNode.setLeftNode(node);
        node.setParentNode(tempRightNode);

    }

    @Override
    public void remove(int value) {

    }

    // 순회
    @Override
    public void traverse() {

        if (root != null) {
            System.out.print("inorder traversal : ");
            inOrderTraversal(root);
            System.out.println();
            System.out.print("preorder traversal : ");
            preOrderTraversal(root);
            System.out.println();
            System.out.print("postorder traversal : ");
            postOrderTraversal(root);
            System.out.println();
        }

    }

    // 중위 순회
    private void inOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }
        System.out.print(node + " ==> ");
        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }

    // 전위 순회
    private void preOrderTraversal(Node node) {
        System.out.print(node + " ==> ");
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }
        System.out.print(node + " ==> ");
        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }

    // 후위 순회
    private void postOrderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
        System.out.print(node + " ==> ");
    }

    @Override
    public Node getMax() {
        return null;
    }

    @Override
    public Node getMin() {
        return null;
    }
}
