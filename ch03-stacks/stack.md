# Stack(스택)

## 1. Stack?

### 1.1 Stack의 특징

**Stack은 한 쪽 끝에서만 항목을 삭제하거나 새로운 항목을 저장하는 자료구조이다.
스택에서 새로운 항목을 저장하는 연산을 `push`라고 하고, 항목을 삭제하는 연산을
`pop`이라고 한다.**

- LIFO(Last In First Out) : 선입선출
- 대부분의 고수준의 언어(high level language)에서 스택은 Array나 Linked List로
쉽게 구현할 수 있다.

### 1.2 Stack의 Push 연산

주어진 항목을 스택의 맨 위에 놓는 연산으로 O(1)의 시간복잡도를 가진다.

![stack-push](https://github.com/walbatrossw/java-data-structures/blob/master/ch03-stacks/img/stack-push.gif?raw=true)

```java
stack.push(12);
stack.push(56);
stack.push(88);
```


### 1.3 Stack의 Pop 연산

마지막으로 스택에 삽입한 항목을 제거하는 연산으로 O(1)의 시간복잡도를 가진다.

![stack-pop](https://github.com/walbatrossw/java-data-structures/blob/master/ch03-stacks/img/stack-pop.gif?raw=true)

```java
stack.pop();
stack.pop();
```

### 1.4 Stack의 Peek 연산

Stack의 맨 위의 항목을 제거하지 않고 반환하는 연산으로 O(1) 시간복잡도를 가진다.

![stack-peek](https://github.com/walbatrossw/java-data-structures/blob/master/ch03-stacks/img/stack-peek.gif?raw=true)

```
stack.peek();
```

## 2. Stacks in memory management (Stack, Heap)


## 3. Stacks and recursive method calls

## 4. Stack implementation : Linked List

## 5. Stack implementation : Array

