package doubles.ds.rbt.integer;

public class RedBlackTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {
        Node newNode = new Node(data);
        root = insertIntoTree(root, newNode);
        fixViolations(newNode);
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

        Node parentNode = null;         // 부모노드 변수 선언
        Node grandParentNode = null;    // 조부모노드 변수 선언

        // 루트노드 X, 블랙노드 X, 부모노드가 레드노드 X 까지 반복수행
        while (node != root && node.getColor() != NodeColor.BLACK && node.getParentNode().getColor() == NodeColor.RED) {

            parentNode = node.getParentNode();   // 노드의 부모노드
            grandParentNode = node.getParentNode().getParentNode();  // 노드의 조부모노드

            // 왼쪽 자식 노드
            if (parentNode == grandParentNode.getLeftNode()) {

                Node uncle = grandParentNode.getRightNode(); // 삼촌노드

                // CASE 1, 4 - 색상 변경 : 삼촌노드 null X, 레드노드인 경우
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);    // 조부모노드 색상 변경 : 레드
                    parentNode.setColor(NodeColor.BLACK);       // 부모노드 색상 변경 : 블랙
                    uncle.setColor(NodeColor.BLACK);            // 삼촌노드 색상 변경 : 블랙
                    node = grandParentNode;                     // 트리 전체 반복 수행을 위해 노드의 참조를 조부모노드로 변경

                // CASE 2, 3 - 회전 + 색상변경 : 삼촌노드가 블랙인 경우
                } else {

                    // CASE 2 : 부모노드의 오른쪽 자식노드인 경우,  1) 왼쪽 회전수행 --> 2) 부모, 조부모 노드의 참조를 한칸씩 위로 변경
                    if (node == parentNode.getRightNode()) {
                        leftRotate(parentNode);
                        node = parentNode;
                        parentNode = node.getParentNode();
                    }

                    // CASE 3 : 부모노드의 왼쪽 자식노드인 경우,
                    // 2. 색상 변경 : 부모노드 색상 <--> 조부모노드 색상
                    rightRotate(grandParentNode); // 오른쪽 회전 수행
                    System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());    // 부모노드를 조부모노드 색상으로 변경
                    grandParentNode.setColor(tempColor);                // 조부모노드를 부모노드 색상으로 변경
                    node = parentNode;                                  // 트리 전체 반복 수행을 위해 노드의 참조를 부모노드로 변경
                }

            // 오른쪽 자식 노드
            } else {

                Node uncle = grandParentNode.getLeftNode(); // 삼촌노드

                // CASE 1, 4 - 색상 변경 : 삼촌노드 null X, 레드노드인 경우
                if (uncle != null && uncle.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);        // 조부모노드 색상 변경 : 블랙 --> 레드
                    parentNode.setColor(NodeColor.BLACK);           // 부모노드 색상 변경 : 레드 --> 블랙
                    uncle.setColor(NodeColor.BLACK);                // 삼촌노드 색상 변경 : 레드 --> 블랙
                    node = grandParentNode;                         // 트리 전체 반복 수행을 위해 노드의 참조를 조부모노드로 변경

                // CASE 2, 3 : 삼촌노드가 블랙노드인 경우 : 회전수행
                } else {

                    // CASE 2 : 부모노드의 왼쪽 자식노드인 경우
                    // 1. 오른쪽 회전 수행
                    // 2. 부모, 조부모 노드의 참조를 한칸씩 위로 변경
                    if (node == parentNode.getLeftNode()) {
                        rightRotate(parentNode);
                        node = parentNode;                 // 자식노드 참조를 부모노드로 변경
                        parentNode = node.getParentNode(); // 부모노드 참조를 조부모노드로 변경
                    }

                    // CASE 3 : 부모노드의 오른쪽 자식노드인 경우
                    // 1. 왼쪽 회전 수행
                    // 2. 색상 변경 : 부모노드의 색 <--> 조부모의 색
                    leftRotate(grandParentNode);    // 왼쪽 회전 수행
                    System.out.println("Recoloring " + parentNode + " + " + grandParentNode);
                    NodeColor tempColor = parentNode.getColor();
                    parentNode.setColor(grandParentNode.getColor());    // 부모노드를 조부모노드 색상으로 변경
                    grandParentNode.setColor(tempColor);                // 조부모노드를 부모노드 색상으로 변경
                    node = parentNode;                                  // 트리 전체 반복 수행을 위해 노드의 참조를 부모노드로 변경
                }
            }
        }

        // 루트노드가 레드인 경우
        if (root.getColor() == NodeColor.RED) {
            System.out.println("Recoloring the root to the black");
            root.setColor(NodeColor.BLACK); // 블랙노드로 색상 변경
        }
    }

    // 오른쪽  회전
    private void rightRotate(Node oldParentNode) {

        System.out.println("Rotating right on node " + oldParentNode);

        Node newParentNode = oldParentNode.getLeftNode();
        oldParentNode.setLeftNode(newParentNode.getRightNode());

        if (oldParentNode.getLeftNode() != null) {
            oldParentNode.getLeftNode().setParentNode(oldParentNode);
        }

        newParentNode.setParentNode(oldParentNode.getParentNode());

        if (newParentNode.getParentNode() == null) {
            root = newParentNode;
        } else if (oldParentNode == oldParentNode.getParentNode().getLeftNode()) {
            oldParentNode.getParentNode().setLeftNode(newParentNode);
        } else {
            oldParentNode.getParentNode().setRightNode(newParentNode);
        }

        // 위치 변경
        newParentNode.setRightNode(oldParentNode);
        oldParentNode.setParentNode(newParentNode);

    }

    // 왼쪽 회전
    private void leftRotate(Node oldParentNode) {

        System.out.println("Rotating left on node " + oldParentNode);

        Node newParentNode = oldParentNode.getRightNode();
        oldParentNode.setRightNode(newParentNode.getLeftNode());

        if (oldParentNode.getRightNode() != null) {
            oldParentNode.getRightNode().setParentNode(oldParentNode);
        }

        newParentNode.setParentNode(oldParentNode.getParentNode());

        if (newParentNode.getParentNode() == null) {
            root = newParentNode;
        } else if (oldParentNode == oldParentNode.getParentNode().getLeftNode()) {
            oldParentNode.getParentNode().setLeftNode(newParentNode);
        } else {
            oldParentNode.getParentNode().setRightNode(newParentNode);
        }

        newParentNode.setLeftNode(oldParentNode);
        oldParentNode.setParentNode(newParentNode);

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
