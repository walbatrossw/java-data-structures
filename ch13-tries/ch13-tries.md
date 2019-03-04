# Tries

## 1. HashMap 장단점

### 1.1 장점
- HashMap은 매우 효율적인 자료구조로 중요한 연산들에 O(1) 시간복잡도를 가진다.

### 1.2 단점
- HashMap은 정렬을 지원하지 않는다.
- Hash함수는 왼벽하지 않기 때문에 충돌이 발생하게 된다.

위의 단점을 보완할 수 있는 자료구조는 Trie로 HashMap에서 발생하는 충돌을 제거하고, 정렬을 지원한다.

## 2. Trie 기본 개념

![trie-pic1](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-pic1.png?raw=true)

- Tire / Radix Tree / Prefix Tree 라고 부른다.
- 배열을 통해 자료구조를 구현할 수 있다.
- key는 일반적으로 문자열(String)이다.
- 노드의 모든 하위 항목에는 해당 노드와 연결된 문자열의 공통 접두사가 있으며 루트 노드는 빈문자열을 저장한다.
- 값이 모든 노드에 저장되지 않고, 보통 마지막 노드(leaf node)에만 존재한다.

![trie-pic2](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-pic2.png?raw=true)

- 노드는 일반적으로 알파벳 수 만큼 하위노드를 가지고 있다. - 모든 노드에서 사용이 가능하도록 알파벳 사이즈 만큼의 상수를 미리 선언하는 것이 좋다.

```java
class Node {
  value;
  children[ALPHABET_SIZE] Node;
}
```

- 모든 노드들이 알파벳 수 만큼 하위노드를 가질 필요가 없을 경우가 존재하기 때문에 메모리 측면에서는 비효율적이다.

## 3. Trie 연산

### 3.1 삽입

Trie의 삽입 연산은 아래와 같이 이루어진다.

#### 3.1.1 "apple" 삽입

![trie-insert-apple](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-insert-apple.gif?raw=true)

#### 3.1.2 "air" 삽입

![trie-insert-air](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-insert-air.gif?raw=true)

#### 3.1.3 "approve" 삽입

![trie-insert-approve](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-insert-approve.gif?raw=true)

#### 3.1.4 "appa" 삽입

![trie-insert-appa](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-insert-appa.gif?raw=true)

#### 3.1.5 "appb" 삽입

![trie-insert-appb](https://github.com/walbatrossw/java-data-structures/blob/master/ch13-tries/img/trie-insert-appb.gif?raw=true)

### 3.2 정렬

Trie의 정렬 연산은 아래와 같이 이루어진다.

![trie-sort]()

### 3.3 자동완성

Trie의 자동완성 연산은 아래와 같이 이루어진다.

![trie-autocomplete]()

### 3.4 Map처럼 삽입

Trie에서 Map처럼 데이터를 저장하는 과정은 아래와 같다.

#### 3.4.1 "apple"을 키로 가진 데이터 1 삽입

![trie-put-apple]()

```java
put("apple", 1);
```

#### 3.4.2 "air"을 키로 가진 데이터 2 삽입

![trie-put-apple]()

```java
put("air", 2);
```

#### 3.4.3 "approve"을 키로 가진 데이터 3 삽입

![trie-put-approve]()

```java
put("approve", 3);
```

#### 3.4.4 "appa"을 키로 가진 데이터 4 삽입

![trie-put-appa]()

```java
put("appa", 4);
```

#### 3.4.5 "appb"을 키로 가진 데이터 5 삽입

![trie-put-appb]()

```java
put("appb", 5);
```

### 3.5 Map처럼 반환

Trie에서 Map처럼 데이터를 반환하는 과정은 다음과 같다.

#### 3.5.1 "apple"을 키로 가진 데이터 1 반환

![trie-get-apple]()

```java
get("apple", 1);
```

#### 3.5.2 "air"을 키로 가진 데이터 2 반환

![trie-get-air]()

```java
get("air", 2);
```

## 4. Hashing과 Trie 비교
