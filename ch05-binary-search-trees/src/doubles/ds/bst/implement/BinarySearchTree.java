package doubles.ds.bst.implement;

import doubles.ds.bst.Tree;

public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root;

    public void insert(T data) {
        // 루트노드 삽입
        if (root == null) {
            root = new Node<>(data);
        // 하위노드 삽입
        } else {
            insertNode(data, root);
        }
    }

    @Override
    public void traversal() {

    }

    @Override
    public void insertNode(T newData, Node<T> node) {
        //
        if (newData.compareTo(node.getData()) < 0) {
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }

        } else {
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }

    }

    @Override
    public void delete(T data) {

    }

    @Override
    public T getMax() {
        return null;
    }

    @Override
    public T getMin() {
        return null;
    }
}
