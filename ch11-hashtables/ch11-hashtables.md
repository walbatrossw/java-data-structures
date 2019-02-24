## 1. Hashtable이란?

### 1.1 Hashtable 기본개념

O(logN)보다 빠른 연산을 위해 키와 1차원 배열의 인덱스의 관계를 이용하여 키(항목)을 저장하는 자료구조를 해시테이블이라고 한다. **해시테이블은 키를 간단한 해시함수로 계산한 값을 배열의 인덱스로 이용하여 항목을 저장하고 탐색/삭제하는 연산을 평균 O(1) 시간복잡도로 지원하는 자료구조이다.**

![hashtable-pic1](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-pic1.png?raw=true)

![hashtable-pic2](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-pic2.png?raw=true)

위의 그림과 같이 소설의 저자를 키로 제목을 값으로 또는 회원의 이메일을 키, 회원정보를 값으로 저장할 수도 있다. 이렇게 저장된 값을 탐색,수정,삭제 할 때에는 소설의 저자, 회원의 이메일을 통해 접근할 수 있다.

![hashtable-array](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-array.gif?raw=true)

일반적으로 배열에 회원을 저장하거나 특정 회원을 탐색하는 상황을 생각해보자. 배열의 인덱스를 통한 삽입이나 탐색 연산은 O(1) 시간복잡도를 가지게 된다.

하지만 해시테이블의 경우 배열의 인덱스를 키값으로 가지고 있는 것이 아니라 위에서 봤듯이 회원의 이메일을 키값으로 가지고 있기 때문에 키값을 해시함수를 통해 배열의 인덱스로 변환하는 과정을 거치야 한다.

```java
index = h(key) // h()는 해시함수를 의미하고, 배열의 인덱스에 키를 맵핑한다.
```

![hashtable-hashfunction](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-hashfunction.png?raw=true)

해시함수는 키들을 균등하게 해시테이블의 인덱스로 변환하기 위해 의미가 부여되어 있는 키를 간단한 계산을 통해 해시테이블 크기에 맞게 해시값을 계산한다.

- `n` : 키의 숫자를 의미
- `m` : 배열의 버킷 수 또는 크기(사이즈)를 의미
- `h(x) = n % m` : 해시함수로 나머지 연산으로 대표적인 함수

해시함수가 균등한 결과를 보장하더라도 함수 계산 자체에 긴 시간이 소요되면 해싱의 장점인 연산의 신속성을
잃게된다. 따라서 단순하면서도 동시에 키들을 균등하게 변환하는 해시함수가 바람직하다.

## 2. Collision(충돌)

![hashtable-collision](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-collision.png?raw=true)

**위의 그림과 같이 서로 다른 키값에 대해서 해싱함수에 의해 주어진 버킷이 같은 경우를 충돌(Collision)이라고 한다.**

### 2.1 Closed Addressing(폐쇄주소방식) - Chaining

![hashtable-collision-chaining](https://github.com/walbatrossw/java-data-structures/blob/master/ch11-hashtables/img/hashtable-collision-chaining.gif?raw=true)

폐쇠주소방식은 키에 대한 해시값에 대응되는 곳에만 키를 저장한다. 따라서 충돌이 발생한 키들은 한 위치에 모여 저장되는데 이를 구현하는 대표적인 방법이 체이닝(Chaining)이다.

체이닝은 키를 해시값에 대응되는 연결리스트에 저장하는 해시방식으로 연결리스트로 구현되어 참조값을 차지하는 공간이 추가로 필요하다. 개방주소방식과 같이 empty원소를 찾는 오버헤드와 군집화가 없으며 구현이 간결하여 실제로 가장 많이 활용되는 방식이다.

### 2.2 Open Addressing(개방주소방식) - Linear Probing

개방주소방식은 해시테이블 전체를 열린 공간으로 가정하여 충돌된 키를 일정한 방식에 따라 찾아낸 emepty 원소에 저장한다. 대표적인 방법은 선형조사(Linear Probing)와 이차조사(Quadratic Probing), 랜덤조사(Random probing) 등이 있다.

![hashtable-collision-linear-probing]()

선형조사는 충돌이 일어난 원소에서부터 순차적으로 검색하여 처음 발견한 empty 원소에 충돌이 일어난 키를 저장한다. 즉 `h(x) = i`라면 해시테이블에 `a[i]`, `a[i+1]`, `a[i+2]`, ... ,`a[i+j]`를 차례로 검색하여 첫 번째로 찾아낸 empty 원소에 키를 저장하는 방식이다.

선형조사는 순차탐색으로 empty 원소를 찾아 충돌된 키를 저장하므로 해시테이블의 키들이 빈틈없이 뭉쳐지는 현상이 발생한다. 이를 군칩화(Primary Clustering)이라고 하는데 탐색, 삽입, 삭제 연산시 군집된 키들을 순차적으로 방문해야하는 문제점을 일으킨다. 이러한 군집화는 해시테이블에 empty원소 수가 적을수록 더 심화되며 해시성능을 저하시킨다.

## 3.

## 4. Hashtable 구현

### 4.1

### 4.2

### 4.3
