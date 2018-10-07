package doubles.ds.arrays.arraylist;

import java.util.NoSuchElementException;

public class ArrayList<E> {

    private E arr[];      // 리스트에 항목을 저장할 배열
    private int size;   // 리스트의 항목 수

    public ArrayList() {
        arr = (E[]) new Object[1]; // 최초 1개의 원소를 가진 배열 생성
        size = 0;
    }

    // 특정 인덱스의 요소 탐색
    public E peek(int index) {
        if (size == 0) {
            throw new NoSuchElementException(); // underflow 경우 프로그램 정지
        }
        return arr[index];
    }

    // 삽입 연산 : 마지막
    public void addLast(E newItem) {
        // 배열의 빈공간이 없으면 배열의 크기 2배 확장
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        arr[size++] = newItem; // 새로운 데이터 삽입, 사이즈 증가
        System.out.println("added : " + newItem);
    }

    // 삽입 연산 : 특정 인덱스
    public void add(E newItem, int index) {
        // 배열의 빈공간이 없으면 배열의 크기 2배 확장
        if (size == arr.length) {
            resize(2 * arr.length);
        }
        // 특정인덱스부터 한칸씩 뒤로 이동
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }
        // 새로운 데이터 삽입
        arr[index] = newItem;
        size++; // 배열 사이즈 증가
        System.out.println("added : " + newItem);
    }

    public void addFirst(E newItem) {
        add(newItem, 0);
    }

    // 삭제 연산 : 특정 인덱스
    public void remove(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = arr[index];
        // 특정 인덱스부터 데이터를 한칸씩 앞으로 이동
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        size--;
        // 배열에 저장된 항목들이 1/4만 차지한다면 배열을 1/2 크기로 축소
        if (size > 0 && size == arr.length / 4) {
            resize(arr.length / 2);
        }
        System.out.println("removed : " + item);
    }

    // 삭제 연산 : 첫번째
    public void removeFirst() {
        remove(0);
    }

    // 삭제 연산 : 마지막
    public void removeLast() {
        remove(size - 1);
    }

    // 배열 공백확인
    private boolean isEmpty() {
        return size == 0;
    }

    // 배열 크기 조절
    private void resize(int newSize) {
        // newSize 크기의 새로운 배열 생성
        Object[] newArr = new Object[newSize];
        // 기존의 배열의 데이터를 새로운 배열에 복사
        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i];
        }
        arr = (E[]) newArr; // 새로운 벼열을 기존의 배열에 복사
    }

    // 리스트 출력
    public void printList() {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}
