package doubles.ds.lru;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int actualSize;
    private Map<Integer, Node> map;
    private DoublyLinkedList linkedList;

    // 생성자
    public LRUCache() {
        this.map = new HashMap<>();
        this.linkedList = new DoublyLinkedList();
    }

    // 삽입
    public void put(int id, String data) {

        // 기존의 노드는 업데이트
        if (map.containsKey(id)) {
            Node node = this.map.get(id);
            node.setData(data);
            update(node);
            return;
        }

        // 새 노드 생성
        Node newNode = new Node(id, data);

        // 지정된 저장공간보다 실제 사이즈가 작으면 그대로 삽입 수행
        if (this.actualSize < Constants.CAPACITY) {
            this.actualSize++;
            add(newNode);
        } else { // 지정된 저장공간보다 실제 사이즈가 크거나 같으면 마지막 노드를 제거하고 삽입 수행
            System.out.println("cache is full... remove tail");
            removeTail();
            add(newNode);
        }
    }

    // 노드 삽입 처리
    private void add(Node newNode) {

        // 새 노드의 다음노드를 기존의 head 노드로 세팅
        newNode.setNextNode(this.linkedList.getHeadNode());
        newNode.setPrevNode(null);

        // 기존의 head 노드의 이전노드를 새 노드로 세팅
        if (linkedList.getHeadNode() != null) {
            linkedList.getHeadNode().setPrevNode(newNode);
        }

        // 새 노드를 head 노드로 세팅
        linkedList.setHeadNode(newNode);

        // tail 노드가 없으면(즉, 첫번째로 삽입되는 노드) tail 노드를 새 노드로 세팅
        if (linkedList.getTailNode() == null) {
            linkedList.setTailNode(newNode);
        }

        // map에 저장
        this.map.put(newNode.getId(), newNode);

    }

    // tail 노드 삭제
    private void removeTail() {

        // tail 노드 추출
        Node lastNode = this.map.get(this.linkedList.getTailNode().getId());

        // tail 노드의 이전노드를 tail 노드로 변경
        // 이전 노드 -> tail 노드
        // 이전 노드(tail)
        this.linkedList.setTailNode(linkedList.getTailNode().getPrevNode());

        // 기존의 tail 노드를 null로 변경
        if (this.linkedList.getTailNode() != null) {
            this.linkedList.getTailNode().setNextNode(null);
        }

        lastNode = null; // 추출한 기존의 tail 노드를 null로 초기화
    }

    // 특정 노드 반환 + 반환된 노드를 head 노드로 변경
    public Node get(int id) {

        // id에 대응되는 키값이 map에 존재하지 않으면 null 반환
        if (!this.map.containsKey(id)) {
            return null;
        }

        // id값에 해당하는 노드 추출
        Node node = this.map.get(id);

        // 추출한 노드를 head 노드로 변경
        update(node);
        return node;
    }

    private void update(Node node) {

        // 이전, 다음 노드 추출
        Node prevNode = node.getPrevNode();
        Node nextNode = node.getNextNode();

        // head 노드가 아니면(middle 노드인 경우)
        if (prevNode != null) {
            // 이전노드 -> 노드 -> 다음노드
            // 이전노드 ---------> 다음노드
            prevNode.setNextNode(nextNode);
        } else { // head 노드인 경우
            // 노드(head) -> 다음노드
            // 다음노드(head) ->
            this.linkedList.setHeadNode(nextNode); // 다음노드를 head 노드로 세팅
        }

        // tail 노드가 아니면(middle 노드인 경우)
        if (nextNode != null) {
            // 이전노드 <- 노드 <- 다음노드
            // 이전노드 <-------- 다음노드
            nextNode.setPrevNode(prevNode);
        } else { // tail 노드인 경우
            // 이전노드 -> 노드(tail)
            // -> 이전노드(tail)
            this.linkedList.setTailNode(prevNode);  // tail 노드를 이전노드로 변경
        }

        // 노드를 새로 삽입하여 head노드로 변경
        add(node);
    }

    // 캐시 출력
    public void show() {
        Node actualNode = this.linkedList.getHeadNode();
        while (actualNode != null) {
            System.out.print(actualNode + " <--> ");
            actualNode = actualNode.getNextNode();
        }
        System.out.println();
    }

}
