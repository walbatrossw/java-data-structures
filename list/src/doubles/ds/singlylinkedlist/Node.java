package doubles.ds.singlylinkedlist;

public class Node<E> {
    private E item;
    private Node<E> nextNode;

    public Node(E item, Node<E> nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public Node<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node<E> nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        if (nextNode == null) {
            return "[item : " + item + " , next node : null]";
        }
        return "[item : " + item + " , next node : " + nextNode.getItem() + "] , ";
    }
}
