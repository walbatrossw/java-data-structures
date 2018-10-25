package doubles.ds.bst.question.comparetrees;

public class TreeCompareHelper<T extends Comparable<T>> {

    public boolean compareTrees(Node<T> node1, Node<T> node2) {

        // 두 노드가 leaf 노드인지 체크
        if (node1 == null || node2 == null) {
            return node1 == node2;
        }

        // 노드간의 데이터 비교
        if (node1.getData().compareTo(node2.getData()) != 0) {
            return false;
        }

        // 왼쪽 하위트리의 값과 오른쪽 하위트리의 값이 일치하는지 확인하기 위해 재귀호출
        return compareTrees(node1.getLeftChild(), node2.getLeftChild()) && compareTrees(node1.getRightChild(), node2.getRightChild());
    }
}
