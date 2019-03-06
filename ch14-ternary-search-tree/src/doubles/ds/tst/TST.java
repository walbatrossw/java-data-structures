package doubles.ds.tst;

public class TST {

    private Node rootNode;

    // 삽입
    public void put(String key, int value) {

        rootNode = put(rootNode, key, value, 0);

    }

    // 삽입 처리
    private Node put(Node node, String key, int value, int index) {

        char c = key.charAt(index); // 문자 추출

        // 현재 노드가 null 이면
        if (node == null) {
            node = new Node(c); // 새로운 노드 생성
        }

        // LESS : 추출한 문자 < 현재 노드의 문자
        if (c < node.getCharacter()) {
            // 왼쪽 하위노드로 세팅, 삽입 재귀호출
            node.setLeftNode(put(node.getLeftNode(), key, value, index));

        // GREATER : 추출한 문자열 > 현재 노드의 문자열
        } else if (c > node.getCharacter()) {
            // 오른쪽 하위노드로 세팅, 삽입 재귀 호출
            node.setRightNode(put(node.getRightNode(), key, value, index));

        // EQUAL : 현재 인덱스 < 전체 키의 길이
        } else if (index < key.length() - 1) {
            // 가운데 하위노드로 세팅, 삽입 재귀 호출(인덱스 1 증가)
            node.setMiddleNode(put(node.getMiddleNode(), key, value, index + 1));

        // 값 저장
        } else {
            node.setValue(value);
        }

        return node;
    }

    // 탐색
    public Integer get(String key) {

        Node node = get(rootNode, key, 0);

        if (node == null) {
            return null;
        }

        return node.getValue();
    }

    // 탐색 처리
    private Node get(Node node, String key, int index) {

        if (node == null) {
            return null;
        }

        char c = key.charAt(index); // 문자 추출

        // LESS : 추출한 문자 < 현재 노드의 문자
        if (c < node.getCharacter()) {
            // 왼쪽 하위노드 탐색 재귀 호출
            return get(node.getLeftNode(), key, index);

        // GREATER : 추출한 문자 > 현재 노드의 문자
        } else if (c > node.getCharacter()) {
            // 오른쪽 하위노드 탐색 재귀 호출
            return get(node.getRightNode(), key, index);

        // EQUAL : 현재 인덱스 < 전체 문자열의 길이
        } else if (index < key.length() - 1) {
            // 가운데 하위노드 탐색 재귀호출(인덱스 1증가)
            return get(node.getMiddleNode(), key, index + 1);

        // 값이 저장된 노드 반환
        } else {
            return node;
        }

    }
}
