package doubles.ds.bst.question.kthsmallestelementfind;


public class BinarySearchTree<T extends Comparable<T>> implements Tree<T> {

    private Node<T> root; // 루트 노드

    @Override
    public Node<T> getKthSmallest(Node<T> node, int k) {

        // 왼쪽 하위 트리의 갯수 + 루트 노드
        int n = treeSize(node.getLeftChild()) + 1;

        // 가장 작은 요소를 찾을 경우
        if (n == k) {
            return node;
        }

        // 찾는 요소가 왼쪽 하위 트리에 존재할 경우
        if (n > k) {
            return getKthSmallest(node.getLeftChild(), k);
        }

        // 찾는 요소가 오른쪽 하위 트리에 존재할 경우
        return getKthSmallest(node.getRightChild(), k - n);

    }

    // 루트 노드 반환
    @Override
    public Node<T> getRoot() {
        return this.root;
    }

    // 삽입
    @Override
    public void insert(T data) {
        // 루트노드가 null 이면 루트 노드 삽입
        if (root == null) {
            root = new Node<>(data);
            // 아니면 하위노드에 삽입
        } else {
            insertNode(data, root);
        }
    }

    // 최소값 반환
    @Override
    public T getMinValue() {
        if (root == null) {
            return null;
        }
        return getMin(root);
    }

    // 최대값 반환
    @Override
    public T getMaxValue() {
        if (root == null) {
            return null;
        }
        return getMax(root);
    }

    // 순회 : 중위, 전위, 후위
    @Override
    public void traversal() {
        if (root != null) {
            inOrderTraversal(root);
            System.out.println();
            preOrderTraversal(root);
            System.out.println();
            postOrderTraversal(root);
            System.out.println();
        }
    }

    // 삭제
    @Override
    public void delete(T data) {
        if (root != null) {
            root = delete(root, data);
        }
    }

    // 트리 사이즈 반환
    private int treeSize(Node<T> node) {

        if (node == null) {
            return 0;
        }

        // 왼쪽 하위 트리 + 오른쪽 하위 트리의 사이즈를 구하기 위해 재귀호출
        // 트리의 사이즈 = 왼쪽 하위 트리 사이즈 + 오른쪽 하위 트리 사이즈 + 1
        return (treeSize(node.getLeftChild()) + treeSize(node.getRightChild()) + 1);
    }

    // 삽입
    private void insertNode(T newData, Node<T> node) {
        // 새로운 데이터가 기존의 데이터보다 작으면 : 왼쪽 하위노드
        if (newData.compareTo(node.getData()) < 0) {
            // 왼쪽 하위노드가 존재하면 하위노드에 삽입하기 위해 재귀호출
            if (node.getLeftChild() != null) {
                insertNode(newData, node.getLeftChild());
                // 왼쪽 하위노드가 없다면 노드를 생성, 상위노드의 왼쪽 하위노드에 설정
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setLeftChild(newNode);
            }
            // 새로운 데이터가 기존의 데이터보다 크거나 같으면 : 오른쪽 하위노드
        } else {
            // 오른쪽 하위 노드가 존재하면 하위 노드에 삽입하기 위해 재귀호출
            if (node.getRightChild() != null) {
                insertNode(newData, node.getRightChild());
                // 오른쪽 하위 노드가 없다면 노드를 생성, 상위노드의 오른쪽 하위 노드에 설정
            } else {
                Node<T> newNode = new Node<>(newData);
                node.setRightChild(newNode);
            }
        }

    }

    // 최소값 : 가장 왼쪽에 위치한 노드가 최소값을 가지고 있다.
    private T getMin(Node<T> node) {
        // 가장 왼쪽에 위치한 노드를 찾을 때까지 재귀호출
        if (node.getLeftChild() != null) {
            return getMin(node.getLeftChild());
        }
        return node.getData();
    }

    // 최대값 : 가장 오른쪽에 위치한 노드가 최대값을 가지고 있다.
    private T getMax(Node<T> node) {
        // 가장 오른쪽에 위치한 노드를 찾을 때까지 재취호출
        if (node.getRightChild() != null) {
            return getMax(node.getRightChild());
        }
        return node.getData();
    }


    // 중위 순회
    private void inOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            inOrderTraversal(node.getLeftChild());
        }
        System.out.print(node + " --> ");
        if (node.getRightChild() != null) {
            inOrderTraversal(node.getRightChild());
        }
    }

    // 전위 순회
    private void preOrderTraversal(Node<T> node) {
        System.out.print(node + " --> ");
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
    }

    // 후위 순회
    private void postOrderTraversal(Node<T> node) {
        if (node.getLeftChild() != null) {
            preOrderTraversal(node.getLeftChild());
        }
        if (node.getRightChild() != null) {
            preOrderTraversal(node.getRightChild());
        }
        System.out.print(node + " --> ");
    }


    // 삭제
    private Node<T> delete(Node<T> node, T data) {

        if (node == null) {
            return node;
        }

        // 삭제할 데이터가 현재 노드의 데이터보다 작으면 왼쪽 하위노드 탐색
        if (data.compareTo(node.getData()) < 0) {
            // 삭제 재귀 호출
            node.setLeftChild(delete(node.getLeftChild(), data));
            // 삭제할 데이터가 현재 노드의 데이터보다 크면 오른쪽 하위노드 탐색
        } else if (data.compareTo(node.getData()) > 0) {
            // 삭제 재귀 호출
            node.setRightChild(delete(node.getRightChild(), data));
            // 삭제할 데이터가 현재 노드의 데이터와 같으면 삭제
        } else {
            // 하위 노드가 없는 leaf 노드이면
            if (node.getLeftChild() == null && node.getRightChild() == null) {
                System.out.println("removing a leaf node...");
                return null;
            }
            // 왼쪽 하위노드가 null 이면 : 오른쪽 하위 노드만 있다면
            if (node.getLeftChild() == null) {
                System.out.println("removing the right child...");
                Node<T> tempNode = node.getRightChild();
                node = null;
                return tempNode;
                // 오른쪽 하위노드가 null 이면 : 왼쪽 하위 노드만 있다면
            } else if (node.getRightChild() == null) {
                System.out.println("removing the left child...");
                Node<T> tempNode = node.getLeftChild();
                node = null;
                return tempNode;
            }
            // 하위노드가 2개인 경우
            System.out.println("removing item with two children...");
            // 왼쪽의 하위 노드중에서 가장 큰 노드 탐색
            Node<T> tempNode = getPredecessor(node.getLeftChild());
            // 삭제하려는 노드와 왼쪽 하위노드에서 가장 큰 노드와 swap
            node.setData(tempNode.getData());
            // 삭제 재귀 호출
            node.setLeftChild(delete(node.getLeftChild(), tempNode.getData()));
        }

        return node;
    }

    // 왼쪽 하위노드에서 가장 큰 노드 탐색
    private Node<T> getPredecessor(Node<T> node) {
        if (node.getRightChild() != null) {
            return getPredecessor(node.getRightChild());
        }
        System.out.println("Predecessor : " + node);
        return node;
    }

}
