package doubles.data.structure.list.array;

import java.util.Arrays;
import java.util.NoSuchElementException;

@SuppressWarnings("unchecked")
public class ArrayList<T> {

    private T arr[];    // 리스트 항목을 저장할 배열
    private int size;   // 리스트 항목 수

    // 생성자
    public ArrayList() {
        this.arr = (T[]) new Object[1]; // 최초로 1개의 원소를 가진 배열 생성
        this.size = 0;                  // 배열 항목수를 0으로 초기화
    }

    // 탐색
    public T get(int index) {
        if (isEmpty())
            throw new NoSuchElementException();
        return arr[index];
    }

    // 삽입 : 배열 마지막에 추가
    public void add(T newItem) {
        if (size == arr.length)
            resize(2 * arr.length);
        arr[size++] = newItem;
        System.out.println(Arrays.toString(arr));
    }

    // 삽입 : 배열 처음, 중간에 추가
    public void add(T newItem, int index) {
        if (size == arr.length)
            resize(2 * arr.length);
        for (int i = size - 1; i >= index; i--)
            arr[i + 1] = arr[i];
        arr[index] = newItem;
        size++;
        System.out.println(Arrays.toString(arr));
    }

    // 삭제
    public T remove(int index) {
        if (isEmpty())
            throw new NoSuchElementException();
        T removedItem = arr[index]; //삭제할 요소를 저장
        for (int i = index; i < size; i++) {
            System.out.println(i);
            arr[i] = arr[i + 1];
        }
        size--;
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);
        System.out.println(Arrays.toString(arr));
        return removedItem;
    }

    // 배열이 비어있는지 확인
    private boolean isEmpty() {
        return size == 0;
    }

    // 배열 사이즈 변경
    private void resize(int newSize) {
        Object[] newArr = new Object[newSize];
        for (int i = 0; i < size; i++)
            newArr[i] = arr[i];
        arr = (T[]) newArr;
    }

    public T[] getArr() {
        return arr;
    }

    public int getSize() {
        return size;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
