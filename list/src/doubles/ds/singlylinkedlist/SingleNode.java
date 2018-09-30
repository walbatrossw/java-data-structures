package doubles.ds.singlylinkedlist;

public class SingleNode<E> {
    private E item;
    private SingleNode<E> nextNode;

    public SingleNode(E item, SingleNode<E> nextNode) {
        this.item = item;
        this.nextNode = nextNode;
    }

    public E getItem() {
        return item;
    }

    public void setItem(E item) {
        this.item = item;
    }

    public SingleNode<E> getNextNode() {
        return nextNode;
    }

    public void setNextNode(SingleNode<E> nextNode) {
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
