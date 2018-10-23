package doubles.ds.bst.implement;

import doubles.ds.bst.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    // 삽입
    @Override
    public void insert(T data) {

        // 루트노드가 null 이면 루트 노드 삽입
        if (root == null) {
            root = new Node<>(data);
        // 아니면 하위노드에 삽입
        } else {
            insertNode(data, root);
        }

    }

    @Override
    public T getMinValue() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    @Override
    public T getMaxValue() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    // 삽입
    private void insertNode(T newData, Node<T> node) {
        // 새로운 데이터가 기존의 데이터보다 작으면 : 왼쪽 하위노드
        if (newData.compareTo(node.getData()) < 0) {
            // 왼쪽 하위노드가 존재하면 하위노드에 삽입하기 위해 재귀호출
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            // 왼쪽 하위노드가 없다면 노드를 생성, 상위노드의 왼쪽 하위노드에 설정
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
        // 새로운 데이터가 기존의 데이터보다 크거나 같으면 : 오른쪽 하위노드
        } else {
            // 오른쪽 하위 노드가 존재하면 하위 노드에 삽입하기 위해 재귀호출
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            // 오른쪽 하위 노드가 없다면 노드를 생성, 상위노드의 오른쪽 하위 노드에 설정
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }

    }

    // 순회
    @Override
    public void traversal() {
        if (root != null) {
            inOrderTraversal(root);
        }
    }

    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + " --> ");
        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    private void preOrderTraveral(Node<T> node) {

    }

    private void postOrderTraversal(Node<T> node) {

    }

    // 삭제
    @Override
    public void delete(T data) {

    }

    // 최대값 : 가장 오른쪽에 위치한 노드가 최대값을 가지고 있다.
    private T getMax(Node<T> node) {
        // 가장 오른쪽에 위치한 노드를 찾을 때까지 재취호출
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }

    // 최소값 : 가장 왼쪽에 위치한 노드가 최소값을 가지고 있다.
    private T getMin(Node<T> node) {
        // 가장 왼쪽에 위치한 노드를 찾을 때까지 재귀호출
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }
}
