package doubles.datastructure.lists.array;

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

    // 요소 탐색
    public T get(int index) {
        if (isEmpty())
            throw new NoSuchElementException();
        return arr[index];
    }

    // 요소 삽입 : 배열 마지막에 추가
    public void add(T newItem) {

        // 배열의 공간이 부족할 경우, 배열의 크기를 2배로 확장
        if (isFull())
            resize(2 * arr.length);

        // 새로운 요소 삽입
        arr[size++] = newItem;

        System.out.println(Arrays.toString(arr));
    }

    // 요소 삽입 : 배열 처음, 중간에 추가
    public void add(T newItem, int index) {

        // 배열의 공간이 부족할 경우, 배열의 크기를 2배로 확장
        if (isFull())
            resize(2 * arr.length);

        // 한칸씩 뒤로 이동
        for (int i = size - 1; i >= index; i--)
            arr[i + 1] = arr[i];

        // 새로운 요소 삽입
        arr[index] = newItem;

        size++;

        System.out.println(Arrays.toString(arr));
    }

    // 삭제
    public T remove(int index) {

        if (isEmpty())
            throw new NoSuchElementException();

        T removedItem = arr[index]; //삭제할 요소를 저장

        // 요소들을 한칸씩 앞으로 이동
        for (int i = index; i < size - 1; i++) {
            arr[i] = arr[i + 1];
        }

        size--;

        arr[size] = null;

        // 배열에 항목들이 1/4만 차지할 경우, 배열을 1/2 크기로 축소
        if (size > 0 && size == arr.length / 4)
            resize(arr.length / 2);

        System.out.println(Arrays.toString(arr));
        return removedItem;
    }

    // 배열이 비어있는지 확인
    private boolean isEmpty() {
        return size == 0;
    }

    // 배열이 가득 찼는지 확인
    private boolean isFull() {
        return size == arr.length;
    }

    // 배열 크기 변경
    private void resize(int newSize) {
        // newSize 크기의 배열 생성
        Object[] newArr = new Object[newSize];
        // 배열 arr의 각 요소들을 새로운 배열 newArr 요소들에 복사
        for (int i = 0; i < size; i++)
            newArr[i] = arr[i];
        // 배열 newArr을 배열 arr로
        arr = (T[]) newArr;
    }

    @Override
    public String toString() {
        return "ArrayList{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
}
