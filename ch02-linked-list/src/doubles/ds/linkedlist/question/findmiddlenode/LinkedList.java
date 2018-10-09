package doubles.ds.linkedlist.question.findmiddlenode;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;
    private int sizeOfList;

    @Override
    public Node<T> getMiddleNode() {

        Node<T> fastPointer = this.root;
        Node<T> slowPointer = this.root;

        // 마지막 노드까지 반복수행
        while (fastPointer.getNextNode() != null && fastPointer.getNextNode().getNextNode() != null) {
            fastPointer = fastPointer.getNextNode().getNextNode();
            slowPointer = slowPointer.getNextNode();
        }

        return slowPointer;
    }

    @Override
    public void insert(T data) {
        // 사이즈 1증가
        ++this.sizeOfList;
        // 리스트가 비어있으면 첫노드를 새로운 노드로
        if (root == null) {
            this.root = new Node<>(data);
        // 리스트가 비어있지 않으면
        } else {
            insertDataBeginning(data);
        }
    }

    // 노드 추가 : 처음, O(1) 시간 복잡도
    private void insertDataBeginning(T data) {
        Node<T> newNode = new Node<>(data); // 새로운 노드 생성
        newNode.setNextNode(root);          // 새로운 노드의 다음 노드를 현재 root 노드로 설정
        this.root = newNode;                // root 노드를 새로운 노드로 변경
    }

    // 노드 추가 : 마지막 , O(N) 시간 복잡도
    private void insertDataAtEnd(T data, Node<T> node) {
        // 노드의 다음 노드가 null이 아니면, 즉 마지막 노드가 아니면
        if (node.getNextNode() != null) {
            // 재귀 호출
            insertDataAtEnd(data, node.getNextNode());
        // 마지막 노드이면
        } else {
            Node<T> newNode = new Node<>(data); // 새로운 노드 생성
            node.setNextNode(newNode);          // 마지막 노드의 다음노드(null)을 새로운 노드로 변경
        }
    }

    // 노드 삭제 : 특정 데이터를 가진 노드
    @Override
    public void remove(T data) {
        // 리스트가 비어있으면 메서드 종료
        if (this.root == null) {
            return;
        }
        --this.sizeOfList; // 사이즈 크기 1 감소
        // 데이터 비교 : 삭제할 데이터와 첫 노드의 데이터가 같으면
        if (this.root.getData().compareTo(data) == 0) {
            this.root = this.root.getNextNode(); // 첫노드를 첫노드의 다음 노드로 설정
        // 첫노드의 데이터와 삭제할 데이터가 다르면
        } else {
            // 해당 데이터를 가진 노드까지 탐색 후 삭제
            remove(data, root, root.getNextNode());
        }
    }

    // 특정 데이터를 가진 노드를 탐색 후 삭제처리
    private void remove(T dataToRemove, Node<T> prevNode, Node<T> actualNode) {
        // 리스트 전체 탐색
        while (actualNode != null) {
            // 데이터 비교 : 삭제할 데이터와 현재 노드의 데이터가 같으면 삭제처리
            if (actualNode.getData().compareTo(dataToRemove) == 0) {
                // 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 설정
                prevNode.setNextNode(actualNode.getNextNode());
                // 삭제할 노드를 null로 변경하고 메서드 종료
                actualNode = null;
                return;
            }
            // 다음 노드 탐색을 위해 이전노드, 다음노드 변경
            prevNode = actualNode;
            actualNode = actualNode.getNextNode();
        }
    }

    @Override
    public void traverseList() {
        // 리스트가 비어있으면 메서드 종료
        if (this.root == null) {
            return;
        }
        Node<T> actualNode = this.root;
        // 리스트 전체 탐색
        while (actualNode != null) {
            System.out.print(actualNode + " --> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println("null");
    }

    @Override
    public int size() {
        return this.sizeOfList;
    }
}
