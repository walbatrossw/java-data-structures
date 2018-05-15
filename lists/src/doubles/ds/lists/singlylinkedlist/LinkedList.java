package doubles.ds.lists.singlylinkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public void insert(T data) {
        ++this.sizeOfList;

        if (root == null) {
            this.root = new Node<>(data);
        } else {
            insertDataAtBeginning(data);
        }
    }

    // O(1)
    private void insertDataAtBeginning(T data) {
        Node<T> newNode = new Node<>(data);
        newNode.setNextNode(root);
        this.root = newNode;
    }

    // O(N)
    private void insertDataAtEnd(T data, Node<T> node) {

        if (node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode());
        } else {
            Node<T> newNode = new Node<>(data);
            node.setNextNode(newNode);
        }

    }

    @Override
    public void remove(T data) {

        if (this.root == null)
            return;

        --this.sizeOfList;

        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode();
        } else {
            remove(data, root, root.getNextNode());
        }

    }

    private void remove(T dataToRemove, Node<T> prevNode, Node<T> actualNode) {

        while (actualNode != null) {
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                prevNode.setNextNode(actualNode.getNextNode());
                actualNode = null;
                return;
            }

            prevNode = actualNode;
            actualNode = actualNode.getNextNode();
        }

    }

    @Override
    public void traverseList() {

        if (this.root == null)
            return;

        Node<T> actualNode = this.root;
        while (actualNode != null) {
            System.out.print(actualNode + " -> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println();

    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
