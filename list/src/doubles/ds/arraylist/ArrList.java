package doubles.ds.arraylist;

import java.util.NoSuchElementException;

public class ArrList<E> {

    private E a[];  // 리스트의 항목을 저장할 배열
    private int size;   // 리스트의 항목 수

    // 생성자
    public ArrList() {
        this.a = (E[]) new Object[1];
        size = 0;
    }

    // 리스트 항목 읽기
    public E peek(int index) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return a[index];
    }

    // 리스트 항목 삽입 : 특정 인덱스
    public void add(E newItem, int index) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        for (int i = size - 1; i >= index; i--) {
            a[i + 1] = a[i];
        }
        a[index] = newItem;
        size++;
    }

    // 리스트 항목 삽입 : 마지막
    public void addLast(E newItem) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = newItem;
    }

    // 리스트 항목 삽입 : 첫번째
    public void addFirst(E newItem) {
        add(newItem, 0);
    }

    // 리스트 항목 삭제
    public E delete(int index) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = a[index];
        for (int i = index; i < size; i++) {
            a[i] = a[i + 1];
        }
        size--;
        if (size > 0 && size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    // 리스트 항목 삭제 : 첫번째
    public E delelteFirst() {
        return delete(0);
    }

    // 리스트 항목 삭제 : 마지막
    public E deleteLast() {
        return delete(a.length);
    }

    // 사이즈 반환
    public int getSize() {
        return size;
    }

    // 배열 공백 여부 확인
    private boolean isEmpty() {
        return size == 0;
    }

    // 배열 크기 변환
    private void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++) {
            t[i] = a[i];
        }
        a = (E[]) t;
    }

    // 리스트 출력
    public void printList() {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

}
