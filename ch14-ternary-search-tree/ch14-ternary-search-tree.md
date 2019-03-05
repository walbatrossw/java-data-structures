# Ternary Search Tree

## 1. Trie와 TST(Ternary Search Tree) 비교 및 특징

![tst-pic](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-pic.png?raw=true)

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

TST의 삽입 연산은 아래와 같이 이루어진다.

#### 2.1.1 "cat"문자열의 키를 가진 데이터 삽입

![tst-insert-cat](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-insert-cat.gif?raw=true)

```java
put("cat", 23);
```

TST에 데이터가 존재하지 않을 경우 Trie와 같은 방식으로 차례로 문자열에서 문자 하나씩 가운데 노드에 차례로
삽입이 된다. 하지만 루트노드에 빈 문자열을 저장하지 않고 바로 첫번째 문자를 루트노드부터 삽입하는 것이
Trie와 차이점이다.

#### 2.1.2 "apple"문자열의 키를 가진 데이터 삽입

![tst-insert-apple](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-insert-apple.gif?raw=true)

```java
put("apple", 46);
```

apple의 문자열 첫번째 a가 c보다 작기 때문에 c의 왼쪽 하위트리로 삽입되고, 나머지 문자열들은 하나씩 차례로
가운데 노드에 삽입된다.

#### 2.1.3 "car"문자열의 키를 가진 데이터 삽입

![tst-insert-car](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-insert-car.gif?raw=true)

```java
put("car", 6);
```

car는 기존에 삽입된 cat과 첫번째, 두번째 문자열이 동일하기 때문에 그대로 가운데 하위 트리를 따라 이동한다.
세번째 문자열 r은 기존에 삽입된 t보다 작기 때문에 오른쪽 하위노드로 삽입된다.

#### 2.1.4 "carrot"문자열의 키를 가진 데이터 삽입

![tst-insert-carrot](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-insert-carrot.gif?raw=true)

```java
put("carrot", 68);
```

carrot은 기존에 삽입된 cat과 첫번째, 두번째 문자열이 동일하기 때문에 그대로 가운데 하위 트리를 따라 이동한다.
세번째 문자열은 기존에 삽입된 car의 세번째 문자열과 동일하기 때문에 그대로 가운데 노드로 이동하고 나머지
문자열은 rot는 차례로 하나씩 가운데 하위노드에 삽입된다.

#### 2.1.5 "cow"문자열의 키를 가진 데이터 삽입

![tst-insert-cow](https://github.com/walbatrossw/java-data-structures/blob/master/ch14-ternary-search-tree/img/tst-insert-cow.gif?raw=true)

```java
put("cow", 112);
```

cow는 기존에 삽입된 cat과 첫번째 문자열만 동일하기 때문에 cat의 두번째 문자열 a와 cow의 두번째 문자열 o와
비교를 하고 a보다 큰 o를 오른쪽 하위노드에 삽입한다. 나머지 문자열 w는 가운데 하위노드에 삽입된다.

### 2.2 탐색
