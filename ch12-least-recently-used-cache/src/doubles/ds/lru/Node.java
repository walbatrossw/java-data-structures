package doubles.ds.lru;

public class Node {

    private int id;         // 해시테이블 키
    private String data;    // 해시테이블 데이터
    private Node prevNode;  // 이전 노드
    private Node nextNode;  // 다음 노드

    public Node() {
    }

    public Node(int id, String data) {
        this.id = id;
        this.data = data;
    }

    // getter, setter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Node getPrevNode() {
        return prevNode;
    }

    public void setPrevNode(Node prevNode) {
        this.prevNode = prevNode;
    }

    public Node getNextNode() {
        return nextNode;
    }

    public void setNextNode(Node nextNode) {
        this.nextNode = nextNode;
    }

    @Override
    public String toString() {
        return this.id + " - " + this.data;
    }
}
