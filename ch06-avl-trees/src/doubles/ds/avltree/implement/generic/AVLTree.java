package doubles.ds.avltree.implement.generic;

public class AVLTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    // 삽입
    @Override
    public void insert(T data) {
        root = insert(root, data);
    }

    // 삽입 구현
    private Node<T> insert(Node<T> node, T data) {

        // root가 비어있거나 leaf 노드인 경우 새로운 노드 생성
        if (node == null) {
            return new Node<>(data);
        }

        // 삽입할 데이터가 상위노드(부모노드)의 데이터보다 작으면 왼쪽 하위노드에 새로운 노드 생성
        // 삽입할 데이터가 상위노드(부모노드)의 데이터보다 크면 오른쪽 하위노드에 새로운 노드 생성
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(insert(node.getLeftNode(), data)); // 왼쪽 leaf 노드를 찾을때까지 재귀호출
        } else {
            node.setRightNode(insert(node.getRightNode(), data)); // 오른쪽 leaf 노드를 찾을 때까지 재귀 호출
        }

        // 삽입이 완료되고 노드의 높이를 갱신
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        // 삽입으로 인해 트리가 불균형이면 회전연산(LL, RR, LR, RL) 수행
        node = settleViolation(data, node);

        return node;
    }

    // 회전 수행 : 삽입시
    private Node<T> settleViolation(T data, Node<T> node) {

        // 트리의 불균형 여부 파악
        int balance = getBalance(node);

        // Left-Left : 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
        if (balance > 1 && data.compareTo(node.getData()) < 0) {
            System.out.println("Tree is left-left heavy.");
            return rightRotation(node); // 오른쪽 회전 수행
        }

        // Right-Right : 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
        if (balance < -1 && data.compareTo(node.getData()) > 0) {
            System.out.println("Tree is right-right heavy.");
            return leftRotation(node); // 왼쪽 회전 수행
        }

        // Left-Right : 높이 차이가 1보다 크고, 삽입된 데이터가 상위노드의 데이터보다 큰 경우
        if (balance > 1 && data.compareTo(node.getData()) > 0) {
            System.out.println("Tree is left-right heavy.");
            node.setLeftNode(leftRotation(node.getLeftNode())); // 왼쪽 회전 수행
            return rightRotation(node); // 오른쪽 회전 수행
        }

        // Right-Left : 높이 차이가 -1보다 작고, 삽입된 데이터가 상위노드의 데이터보다 작은 경우
        if (balance < -1 && data.compareTo(node.getData()) < 0) {
            System.out.println("Tree is right-left heavy.");
            node.setRightNode(rightRotation(node.getRightNode())); // 오른쪽 회전 수행
            return leftRotation(node); // 왼쪽 회전 수행
        }

        return node;
    }

    // 순회
    @Override
    public void traverse() {
        if (root == null) {
            return;
        }
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

    // 중위 순회
    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }
        System.out.print(node + " ==> ");
        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
    }

    // 전위 순회
    private void preOrderTraversal(Node<T> node) {
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
    private void postOrderTraversal(Node<T> node) {
        if (node.getLeftNode() != null) {
            inOrderTraversal(node.getLeftNode());
        }
        if (node.getRightNode() != null) {
            inOrderTraversal(node.getRightNode());
        }
        System.out.print(node + " ==> ");
    }

    // 삭제
    @Override
    public void delete(T data) {
        root = delete(root, data);
    }

    // 삭제 구현
    private Node<T> delete(Node<T> node, T data) {

        if (node == null) {
            return node;
        }

        // 삭제할 노드 탐색
        // 삭제할 노드의 데이터가 부모노드의 데이터보다 작은 경우
        if (data.compareTo(node.getData()) < 0) {
            node.setLeftNode(delete(node.getLeftNode(), data)); // 왼쪽 자식노드 방향으로 삭제 재귀호출
        // 삭제할 노드의 데이터가 부모노드의 데이터보다 큰 경우
        } else if (data.compareTo(node.getData()) > 0) {
            node.setRightNode(delete(node.getRightNode(), data)); // 오른쪽 자식노드 방향으로 삭제 재귀호출
        // 삭제할 노드를 찾은 경우
        } else {

            // 1. 삭제할 노드가 leaf 노드인 경우
            if (node.getLeftNode() == null && node.getRightNode() == null) {
                System.out.println("Removing a leaf node...");
                return null;
            }

            // 2. 삭제할 노드가 하나의 자식노드를 가진 경우
            if (node.getLeftNode() == null) {
                System.out.println("Removing the right child node");
                Node<T> tempNode = node.getRightNode();
                node = null;
                return tempNode;
            } else if (node.getRightNode() == null) {
                System.out.println("Removing the left child node");
                Node<T> tempNode = node.getLeftNode();
                node = null;
                return tempNode;
            }

            // 3. 삭제할 노드가 두개의 자식노드를 가진 경우
            System.out.println("Removing item with the children");
            Node<T> tempNode = getPredecessor(node.getLeftNode());  // 왼쪽 자식노드 중에서 가장 큰 노드
            node.setData(tempNode.getData());   // 삭제할 노드의 데이터와 가장 큰 노드의 데이터 교환
            node.setLeftNode(delete(node.getLeftNode(), tempNode.getData())); // 삭제 재귀호출

        }

        // 높이 갱신
        node.setHeight(Math.max(height(node.getLeftNode()), height(node.getRightNode())) + 1);

        // 삭제 완료후 트리 불균형 체크, 회전 수행
        return settleDeletion(node);
    }

    // 회전 수행 : 삭제시
    private Node<T> settleDeletion(Node<T> node) {
        int balance = getBalance(node);

        // Left-Left or Left-Right 인 경우
        if (balance > 1) {
            // Left-Right
            if (getBalance(node.getLeftNode()) < 0) {
                node.setLeftNode(leftRotation(node.getLeftNode())); // 왼쪽 회전
            }
            return rightRotation(node); // 오른쪽 회전
        }

        // Right-Right or Right-Left 인 경우
        if (balance < -1) {
            // Right-Left
            if (getBalance(node.getRightNode()) > 0) {
                node.setRightNode(rightRotation(node.getRightNode())); // 오른쪽 회전
            }
            return leftRotation(node); // 왼쪽 회전
        }
        return node;
    }

    // 왼쪽 하위 트리에서 최대값 반환
    private Node<T> getPredecessor(Node<T> node) {
        Node<T> predecessor = node;
        while (predecessor.getRightNode() != null) {
            predecessor = predecessor.getRightNode();
        }
        return predecessor;
    }

    // 오른쪽 회전
    private Node<T> rightRotation(Node<T> parentNode) {
        System.out.println("Rotating to the right on node : " + parentNode);

        Node<T> newParentNode = parentNode.getLeftNode();   // 왼쪽 자식노드가 새로운 부모노드가 됨
        Node<T> nullNode = newParentNode.getRightNode();    // 왼쪽 자식노드의 오른쪽 자식노드(null 노드)

        newParentNode.setRightNode(parentNode);             // 새로운 부모노드의 오른쪽 자식노드에 기존의 부모노드를 세팅
        parentNode.setLeftNode(nullNode);                   // 기존의 부모노드의 왼쪽 자식노드를 null 노드로 세팅

        // 회전한 노드들의 높이 갱신
        parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode())) + 1);
        newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode())) + 1);

        // 새로운 부모노드 반환
        return newParentNode;
    }

    // 왼쪽 회전
    private Node<T> leftRotation(Node<T> parentNode) {

        System.out.println("Rotating to the left on node : " + parentNode);

        Node<T> newParentNode = parentNode.getRightNode();  // 오른쪽 자식노드가 새로운 부모노드가 됨
        Node<T> nullNode = newParentNode.getLeftNode();     // 오른쪽 자식노드의 왼쪽 자식노드(null 노드)

        newParentNode.setLeftNode(parentNode);              // 새로운 부모노드의 왼쪽 자식노드에 기존의 부모노드를 세팅
        parentNode.setRightNode(nullNode);                  // 기존의 부모노드의 오른쪽 자식노드를 null 노드로 세팅

        // 회전한 노드들의 높이 갱신
        parentNode.setHeight(Math.max(height(parentNode.getLeftNode()), height(parentNode.getRightNode())) + 1);
        newParentNode.setHeight(Math.max(height(newParentNode.getLeftNode()), height(newParentNode.getRightNode())) + 1);

        // 새로운 부모노드 반환
        return newParentNode;
    }

    // 특정 노드의 높이 반환
    private int height(Node<T> node) {
        if (node == null) {
            return -1;
        }
        return node.getHeight();
    }

    // 트리 균형/불균형 여부 판단
    private int getBalance(Node<T> node) {

        // 트리가 비어있는 상태
        if (node == null) {
            return 0;
        }

        // 계산 결과가 1보다 큰 경우 : LL or LR
        // 계산 결과가 -1보다 작은 경우 : RR or RL
        return height(node.getLeftNode()) - height(node.getRightNode());
    }


}
