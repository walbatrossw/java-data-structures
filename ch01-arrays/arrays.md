# Arrays(배열)

## 1. Arrays란?

- 배열의 인덱스 또는 키로 식별되는 요소 / 값의 컬렉션
    - 인덱스는 0부터 시작
    - 인덱스 때문에 랜덤 엑세스가 가능

- 배열은 동일한 유형의 타입을 저장하기 위한 자료구조
- 배열은 인덱스를 키로 사용
- 배열은 원하는 만큼의 차원을 가질 수 있음, 1차원/2차원/3차원 배열 등
- 동적배열 : 배열의 크기가 동적으로 변경되는 경우
- 응용 프로그램에는 table, hashtable, heap이 있음

## 2. Array의 장점

- 인덱스, 즉 키 때문에 랜덤 엑세스가 가능하다.
- 구현 및 사용이 쉽다.
- 매우 빠른 자료구조로 항목을 반복해서 추가하거나, 삭제하려고할 때 주어진 인덱스를
통해 빠르게 처리가 가능하다.

## 3. Array의 단점

- 컴파일 시점에 배열의 크기를 알아야하기 때문에 동적 자료구조가 아니다.
- 배열이 다 찾을 경우, 더 큰 배열을 만들어야하고 다 찬 배열의 데이터를 다시 복사해
옮겨야만 한다.
- 다른 유형의 데이터를 저장할 수 없다.

## 4. Array의 연산

### 4.1 삽입 엽산

배열에 34, 12, 120, -5를 차례로 추가한다면 아래와 같이 연산을 한다.

![array-operation-add](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-add.gif?raw=true)

- 배열이 가득 차지 않는 한 배열에 값을 계속 추가할 수 있다.
- 새로운 값을 리스트에 추가할 때, 다음 인덱스에 삽입하면 되기 때문에 매우 빠르다.
- 데이터의 양과 상관없이 빠르게 처리할 수 있기 때문에 O(1)의 시간 복잡도를 가진다.

### 4.2 특정 인덱스의 삽입 연산

배열의 인덱스 1에 23을 추가하려고 한다면, 아래와 같이 연산을 수행한다.

![array-operation-add-index](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-add-index.gif?raw=true)

- 주어진 인덱스에 값을 위와 같이 추가할 수 있다.
- 문제점은 새로운 값을 주어진 인덱스 위치에 삽입하기 위해서는 기존에 저장된 값들을
이동해야 된다.
- 저장된 데이터가 많으면 많을수록 처리시간이 증가하기 때문에 O(N)의 시간 복잡도를
가진다.

### 4.3 삭제 연산

배열에 저장된 값들을 뒤에서부터 차례로 삭제하는 연산은 아래와 같은데 배열의 마지막
요소부터 삭제하는 연산은 매우 간단하다.

![array-operation-remove](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-remove.gif?raw=true)

- 저장된 데이터의 양과 상관 없이 빠르게 처리할 수 있기 때문에 O(1)의 시간복잡도를
가진다.

### 4.4 특정 인덱스의 삭제 연산

배열의 특정 인덱스의 값을 삭제하는 연산은 아래와 같은데 배열의 마지막 값을 삭제하는
것처럼 간단하지 않다. 해당 인덱스의 값을 삭제하고, 배열에 공백을 채우기 위해 값들을
앞으로 한칸씩 이동시켜야 한다.

![array-operation-remove-index](https://github.com/walbatrossw/java-data-structures/blob/master/ch01-arrays/img/array-operation-remove-index.gif?raw=true)

- 저장된 데이터가 많으면 많을수록 이동시켜야할 데이터가 증가하기 때문에 O(1)의 시간복잡도를
갖는다.

## 5. Array 사용

## 6. ArrayList 구현해보기

## 6. Questions
