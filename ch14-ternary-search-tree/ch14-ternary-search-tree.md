# Ternary Search Tree

## 1. Trie와 TST(Ternary Search Tree) 비교 및 특징

![tst-pic]()

- Trie는 탐색, 정렬에 매우 효율적이지만 메모리를 많이 사용하는 문제가 있다.
- TST는 Trie에 비해 적은 reference와 null object를 가진다.
- Trie와 마찬가지로 TST도 노드에 문자열을 저장한다.
- TST는 각 노드마다 3개의 하위노드를 가진다.
    - less : lower child
    - equal : middle child
    - greater : higher child
- 해시맵 만큼 효율적이다.
- 해싱은 전체 문자열의 키를 탐색해야하지만 TST는 그렇지 않다.
- TST도 정렬 연산을 수행할 수 있다.
- TST는 해시맵보다 빠르며 BST보다 유연하다.

## 2. TST 연산

### 2.1 삽입

### 2.2 탐색
