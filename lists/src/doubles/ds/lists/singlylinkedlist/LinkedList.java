package doubles.ds.lists.singlylinkedlist;

public class LinkedList<T extends Comparable<T>> implements List<T> {

    private Node<T> root;   // 연결리스트의 첫노드
    private int sizeOfList; // 연결리스트의 사이즈

    // 삽입
    @Override
    public void insert(T data) {

        // 사이즈 증가
        ++this.sizeOfList;

        // 첫노드가 null이면 새로운 노드 생성
        if (root == null) {
            this.root = new Node<>(data);
            return;
        }

        // 첫노드에 삽입
        insertDataAtBeginning(data);

    }

    // 첫노드에 삽입
    private void insertDataAtBeginning(T data) {

        // 새로운 노드 객체 생성
        Node<T> newNode = new Node<>(data);

        // 기존의 첫노드를 새로운 노드의 다음노드로 변경
        newNode.setNextNode(root);

        // 첫노드를 새로운 노드로 변경
        this.root = newNode;

    }

    // 마지막 노드에 삽입
    private void insertDataAtEnd(T data, Node<T> node) {

        // 해당 노드가 마지막 노드가 아니면
        if (node.getNextNode() != null) {
            insertDataAtEnd(data, node.getNextNode());
            return;
        }

        // 새로운 노드 객체 생성
        Node<T> newNode = new Node<>(data);

        // 해당 노드의 다음 노드를 새로운 노드로 변경
        node.setNextNode(newNode);
    }

    // 삭제 : 특정 데이터를 가진 노드
    @Override
    public void remove(T data) {

        // 첫노드가 null 이면
        if (this.root == null)
            return;

        // 연결리스트 사이즈 감소
        --this.sizeOfList;

        // 첫번째 노드의 데이터가 입력받은 데이터가 같으면
        if (this.root.getData().compareTo(data) == 0) {
            // 첫번째 노드를 첫번째 노드의 다음 노드로 변경
            this.root = this.root.getNextNode();
            return;
        }

        // 특정 데이터를 가진 노드 제거
        remove(data, root, root.getNextNode());

    }

    // 삭제 : 특정 데이터를 가진 노드
    private void remove(T dataToRemove, Node<T> prevNode, Node<T> node) {

        // 마지막 노드까지 탐색 반복 수행
        while (node != null) {

            // 노드의 데이터와 입력받은 데이터가 같으면
            if (node.getData().compareTo(dataToRemove) == 0) {

                // 이전 노드의 다음 노드를 삭제할 노드의 다음 노드로 변경
                prevNode.setNextNode(node.getNextNode());

                // 삭제할 노드 null로 변경
                node = null;
                return;

            }

            // 데이터 비교를 위해 노드 변경
            prevNode = node;
            node = node.getNextNode();

        }

    }

    // 연결리스트 전체 탐색
    @Override
    public void traverseList() {

        // 첫노드가 null 이면
        if (this.root == null)
            return;

        Node<T> node = this.root;

        // 마지막 노드까지 탐색 반복 수행
        while (node != null) {
            System.out.print(node + " -> ");
            node = node.getNextNode();
        }
        System.out.println();

    }

    // 연결리스트의 사이즈
    @Override
    public int size() {
        return this.sizeOfList;
    }

}
