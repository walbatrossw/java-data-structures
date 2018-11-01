package doubles.ds.avltree.implement.integer;

public class AVLTree implements Tree {

    private Node root;  // 루트 노드

    // 삽입
    @Override
    public void insert(int data) {
        root = insert(root, data);
    }

    // 삽입 구현
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

        // 불균형 발생시 경우의 수(LL, RR, LR, RL)에 따라 회전 연산 수행
        node = settleViolation(data, node);

        return node;
    }

    // 회전 수행 : 삽입시
    private Node settleViolation(int data, Node node) {

        int balance = getBalance(node);

        // Left - Left : 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
        if (balance > 1 && data < node.getLeftNode().getData()) {
            return rightRotation(node); // 오른쪽 회전 수행
        }

        // Right - Right : 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
        if (balance < -1 && data > node.getRightNode().getData()) {
            return leftRotation(node); // 왼쪽 회전 수행
        }

        // Left - Right : 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
        if (balance > 1 && data > node.getLeftNode().getData()) {
            node.setLeftNode(leftRotation(node.getLeftNode())); // 왼쪽 회전 수행
            return rightRotation(node); // 오른쪽 회전 수행
        }

        // Right - Left : 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
        if (balance < -1 && data < node.getRightNode().getData()) {
            node.setRightNode(rightRotation(node.getRightNode()));  // 오른쪽 회전 수행
            return leftRotation(node);  // 왼쪽 회전 수행
        }

        return node;
    }

    // 삭제
    @Override
    public void delete(int data) {
        root = delete(root, data);
    }

    // 삭제 구현
    private Node delete(Node node, int data) {
        if (node == null) {
            return node;
        }

        // 삭제할 노드의 데이터가 상위노드의 데이터보다 작은 경우
        if (data < node.getData()) {
            node.setLeftNode(delete(node.getLeftNode(), data)); // 왼쪽 노드 방향으로 재귀 호출
        } else if (data > node.getData()) { // 삭제할 노드의 데이터가 상위노드의 데이터보다 작은 경우
            node.setRightNode(delete(node.getRightNode(), data)); // 오른쪽 노드 방향으로 재귀 호출
        } else {    // 삭제할 노드를 찾았을 경우

            // 삭제할 노드가 leaf 노드이면
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            // 삭제할 노드가 하나의 자식 노드를 가진 경우
            // 삭제할 노드가 오른쪽노드이면
            if (node.getLeftNode() == null) {
                System.out.println("Removing the right child node ...");
                Node tempNode = node.getRightNode();
                node = null;
                return tempNode;
            } else if (node.getRightNode() == null) { // 삭제할 노드가 왼쪽노드이면
                System.out.println("Removing the left child node ...");
                Node tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            // 삭제할 노드가 두개의 자식 노드를 가진 경우
            System.out.println("Removing item with two children...");
            Node tempNode = getPredecessor(node.getLeftNode()); // 오른쪽 자식노드 중에서 가장 큰 데이터를 가진 노드
            node.setData(tempNode.getData());   //  삭제할 노드의 데이터와 바꿈
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData())); // 삭제 재귀호출
        }

        // 높이 갱신
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        // 삭제된 이후 트리 불균형 체크, 회전 수행
        return settleDeletion(node);

    }

    // 회전 수행 : 삭제시
    private Node settleDeletion(Node node) {

        int balance = getBalance(node);

        // Left - Left 또는 Left - Right인 경우,
        if (balance > 1) {
            // Left - Right인 경우
            if (getBalance(node.getLeftNode()) < 0) {
                node.setLeftNode(leftRotation(node.getLeftNode())); // 왼쪽으로 회전 수행
            }
            return rightRotation(node); // 오른쪽으로 회전 수행
        }

        // Right - Right 또는 Right - Left인 경우
        if (balance < -1) {
            // Right - Left 인 경우
            if (getBalance(node.getRightNode()) > 0) {
                node.setRightNode(rightRotation(node.getRightNode())); // 오른쪽으로 회전 수행
            }
            return leftRotation(node); // 왼쪽으로 회전 수행
        }

        return node;
    }

    // 왼쪽 하위 트리에서 최대값 반환
    private Node getPredecessor(Node node) {

        Node predecessor = node;

        while (predecessor.getRightNode() != null) {
            predecessor = predecessor.getRightNode();
        }
        return predecessor;
    }

    // 순회
    @Override
    public void traverse() {

        if (root == null) {
            return;
        }
        System.out.print("inorder : ");
        inorderTraversal(root);
        System.out.println();
        System.out.print("preorder : ");
        preOrderTraversal(root);
        System.out.println();
        System.out.print("postorder : ");
        postOrderTraversal(root);
        System.out.println();
    }

    // 오른쪽 회전
    private Node rightRotation(Node node) {

        System.out.println("Rotating to the right on node : " + node);

        Node tempLeftNode = node.getLeftNode();         // 상위노드의 왼쪽 하위노드
        Node t = tempLeftNode.getRightNode();           // 상위노드의 왼쪽 하위노드의 오른쪽 하위노드

        tempLeftNode.setRightNode(node);                // 왼쪽 하위노드의 오른쪽 하위노드에 상위노드를 세팅 : 상위노드가 오른쪽 하위노드가 됨
        node.setLeftNode(t);                            // 상위노드의 왼쪽 하위노드에 t

        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);  // 상위 노드의 높이 갱신
        tempLeftNode.setHeight(Math.max(height(tempLeftNode.getLeftNode()), height(tempLeftNode.getRightNode())) + 1);  // 새로운 루트노드 높이 갱신

        return tempLeftNode;    // 새로운 루트노드 반환
    }

    // 왼쪽 회전
    private Node leftRotation(Node node) {
        System.out.println("Rotating to the left on node : "  + node);

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

        // 노드가 null이면 -1 : leaf노드의 자식노드
       if (node == null) {
            return -1;
        }

        // null이 아니면 높이 반환
        return node.getHeight();
    }

    // 트리 균형, 불균형 여부 판단
    private int getBalance(Node node) {

        // 트리가 비어있는 상태
        if (node == null) {
            return 0;
        }

        // 1을 반환할 경우 LL 또는 LR, -1을 반환할 경우 RR 또는 RL
        return height(node.getLeftNode()) - height(node.getRightNode());
    }


    // 중위 순회
    private void inorderTraversal(Node node) {
        if (node.getLeftNode() != null) {
            inorderTraversal(node.getLeftNode());
        }
        System.out.print(node + " ==> ");
        if (node.getRightNode() != null) {
            inorderTraversal(node.getRightNode());
        }
    }

    // 전위 순회
    private void preOrderTraversal(Node node) {
        System.out.print(node + " ==> ");
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
        System.out.print(node + " ==> ");
    }
}
