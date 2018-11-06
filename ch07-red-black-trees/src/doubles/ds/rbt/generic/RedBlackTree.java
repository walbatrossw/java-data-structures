package doubles.ds.rbt.generic;

public class RedBlackTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    // 삽입
    @Override
    public void insert(T data) {
        Node<T> newNode = new Node<>(data); // 새로운 노드 생성
        root = insertIntoTree(root, newNode);
        fixViolation(newNode);
    }

    // 삽입 구현
    private Node<T> insertIntoTree(Node<T> parentNode, Node<T> newNode) {

        // 부모노드가 null이면
        if (parentNode == null) {
            return newNode; // 바로 노드 반환
        }

        // 새로운 노드의 데이터가 부모노드의 데이터보다 작으면
        if (newNode.getData().compareTo(parentNode.getData()) < 0) {
            // leaf 노드까지 재귀 탐색후 삽입
            parentNode.setLeftChildNode(insertIntoTree(parentNode.getLeftChildNode(), newNode));
            // 삽입한 노드의 부모노드 세팅
            parentNode.getLeftChildNode().setParentNode(parentNode);
        } else {    // 새로운 노드의 데이터가 부모노드의 데이터보다 크면
            // leaf 노드까지 재귀 탐색 후 삽입
            parentNode.setRightChildNode(insertIntoTree(parentNode.getRightChildNode(), newNode));
            // 삽입한 노드의 부모노드 세팅
            parentNode.getRightChildNode().setParentNode(parentNode);
        }

        return parentNode; // 부모노드 삽입
    }

    // 레드블랙트리 속성 위반 수정
    private void fixViolation(Node<T> node) {

        // 부모, 조부모노드 변수 선언, null 초기화
        // while 반복문안에서 반복하면서 계속 부모, 조부모노드는 바뀌게된다.
        Node<T> parentNode = null;
        Node<T> grandParentNode = null;

        // 노드가 루트노드가 되고, 노드의 색상이 블랙이고, 부모노드가 블랙일 때까지 반복수행
        while (node != root && node.getColor() != NodeColor.BLACK && node.getParentNode().getColor() == NodeColor.RED) {

            parentNode = node.getParentNode();                      // 부모노드
            grandParentNode = node.getParentNode().getParentNode(); // 조부모노드

            // 왼쪽 자식노드에 삽입된 경우
            if (parentNode == grandParentNode.getLeftChildNode()) {

                Node<T> uncleNode = grandParentNode.getRightChildNode();    // 삼촌 노드

                // CASE 1, 2 (색상변경만 수행) : 삼촌노드가 null X, 레드노드인 경우
                if (uncleNode != null && uncleNode.getColor() == NodeColor.RED) {
                    grandParentNode.setColor(NodeColor.RED);
                    parentNode.setColor(NodeColor.BLACK);
                    uncleNode.setColor(NodeColor.BLACK);
                    node = grandParentNode;
                } else { // CASE 3, 4 (회전 + 색상변경 수행) : 삼촌노드가 블랙노드인 경우

                    // CASE 3 : 부모노드의 오른쪽 자식노드인 경우

                    // CASE 4 : 부모노드의 왼쪽 자식노드인 경우
                    
                }


            } else { // 오른쪽 자식노드에 삽입된 경우

                Node<T> uncleNode = grandParentNode.getLeftChildNode();     // 삼촌 노드

                // CASE 1, 2 (색상변경만 수행) : 삼촌노드가 null X, 레드노드인 경우
                if (uncleNode != null && uncleNode.getColor() == NodeColor.RED) {

                } else { // CASE 3, 4 (회전 + 색상변경 수행) : 삼촌노드가 블랙노드인 경우

                }

            }

        }

        // 루트노드가 레드노드인 경우
        if (root.getColor() == NodeColor.RED) {
            System.out.println("Recoloring the root to the black");
            root.setColor(NodeColor.BLACK); // 블랙노드로 변경
        }
    }

    // 오른쪽 회전
    private void rightRotate(Node<T> node) {

        System.out.println("Rotating right on node " + node);

        Node<T> newParentNode = node.getLeftChildNode();
        node.setLeftChildNode(newParentNode.getRightChildNode());

        if (node.getLeftChildNode() != null) {
            node.getLeftChildNode().setParentNode(node);
        }

        newParentNode.setParentNode(node.getParentNode());

        if (newParentNode.getParentNode() == null) {
            root = newParentNode;
        } else if (node == node.getParentNode().getLeftChildNode()) {
            node.getParentNode().setLeftChildNode(newParentNode);
        } else {
            node.getParentNode().setRightChildNode(newParentNode);
        }

        newParentNode.setRightChildNode(node);
        node.setParentNode(newParentNode);

    }

    // 왼쪽 회전
    private void leftRotate(Node<T> node) {

        System.out.println("Rotating left on node " + node);

        Node<T> newParentNode = node.getRightChildNode();
        node.setRightChildNode(newParentNode);

        if (node.getRightChildNode() != null) {
            node.getRightChildNode().setParentNode(node);
        }

        newParentNode.setParentNode(node.getParentNode());

        if (node.getRightChildNode() != null) {
            root = newParentNode;
        } else if (node == node.getParentNode().getLeftChildNode()) {
            node.getParentNode().setLeftChildNode(newParentNode);
        } else {
            node.getParentNode().setRightChildNode(newParentNode);
        }

        newParentNode.setLeftChildNode(node);
        node.setParentNode(newParentNode);

    }

    // 삭제
    @Override
    public void remove(T value) {

    }

    // 순회
    @Override
    public void traverse() {

    }

    // 최대값 반환
    @Override
    public Node<T> getMax() {
        return null;
    }

    // 최소값 반환
    @Override
    public Node<T> getMin() {
        return null;
    }
}
