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

TST와 Trie의 삽입 연산과정이 어떻게 다른지 살펴보자.

#### 2.1.1 "cat"문자열의 키를 가진 데이터 삽입

![tst-insert-cat]()

```java
put("cat", 23);
```

TST에 데이터가 존재하지 않을 경우 Trie와 같은 방식으로 삽입이 된다. 하지만 루트노드에 빈문자열을 저장하는 것이 아니라 처음부터 문자를 저장하는 방식이 차이점이다.

#### 2.1.2 "apple"문자열의 키를 가진 데이터 삽입

![tst-insert-apple]()

```java
put("apple", 46);
```

apple의 첫번째 알파벳 a가 c보다 작기 때문에 왼쪽 하위트리로 이동하게 되고, 차례로 나머지 문자열들을 삽입하게 된다.

#### 2.1.3 "car"문자열의 키를 가진 데이터 삽입

![tst-insert-cat]()

```java
put("car", 6);
```

car는 cat과 첫번째, 두번째 알파벳 c, a가 동일하기 때문에 그대로 하위 트리를 따라 이동하고, 세번째 알파벳이 r과 t가 다르고 r이 t보다 작기 때문에 기존 t노드의 왼쪽 하위노드로 삽입된다.

#### 2.1.4 "carrot"문자열의 키를 가진 데이터 삽입

![tst-insert-cat]()

```java
put("carrot", 68);
```

carrot은 cat과 첫번째, 두번째 알파벳 c, a가 동일하기 때문에 그대로 하위 트리를 따라 이동하고, 세번째 알파벳 r과 t가 다르고, r이 t보다 작기 때문에 왼쪽의 하위노드 r로 이동한다. 그 이후에는 차례로 나머지 문자열을 삽입한다.

#### 2.1.5 "cow"문자열의 키를 가진 데이터 삽입

![tst-insert-cat]()

```java
put("cow", 112);
```

cow는 cat과 첫번째 알파벳만 동일하기 때문에 cat의 두번째 알파벳에서 a와 o를 비교한다. a보다 o가 크기 때문에 a의 오른쪽 하위노드에 o가 놓이게 되고, o의 하위노드로 나머지 문자열이 삽입된다.


### 2.2 탐색
