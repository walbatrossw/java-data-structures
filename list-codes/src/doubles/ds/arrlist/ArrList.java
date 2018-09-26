package doubles.ds.arrlist;

import java.util.NoSuchElementException;

public class ArrList<E> {

    private E a[];      // 리스트 항목들을 저장할 배열
    private int size;   // 리스트의 항목 수

    // 생성자
    public ArrList() {
        this.a = (E[]) new Object[1]; // 최초 1개의 원소를 가진 배열 생성
        this.size = 0;   // 항목 수를 0으로 초기화
    }

    // k번재 항목을 리턴, 단순 읽기
    public E peek(int k) {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        return a[k];
    }

    public void insertLast(E newItem) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        a[size++] = newItem;
    }

    public void insert(E newItem, int k) {
        if (size == a.length) {
            resize(2 * a.length);
        }
        for (int i = size - 1; i >= k; i--) {
            a[i + 1] = a[i];
        }
        a[k] = newItem;
        size++;
    }

    private void resize(int newSize) {
        Object[] t = new Object[newSize];
        for (int i = 0; i < size; i++) {
            t[i] = a[i];
        }
        a = (E[]) t;
    }

    public E delete(int k) {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        E item = a[k];
        for (int i = k; i < size; i++) {
            a[i] = a[i + 1];
        }
        size--;
        if (size > 0 && size == a.length / 4) {
            resize(a.length / 2);
        }
        return item;
    }

    private boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
