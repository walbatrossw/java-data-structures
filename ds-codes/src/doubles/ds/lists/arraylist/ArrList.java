package doubles.ds.lists.arraylist;

import java.util.NoSuchElementException;

public class ArrList<T> {

    private T[] arr;    // 리스트의 항목들을 저장할 배열
    private int size;   // 리스트의 항목수

    // 생성자
    public ArrList() {
        this.arr = (T[]) new Object[1];  // 최초 1개의 원소를 가진 배열 생성
        this.size = 0;
    }

    // 리스트 특정 인덱스의 데이터 가져오기
    public T get(int index) {

        // 사이즈가 0이면 예외 발생
        if (isEmpty()) {
            throw new NoSuchElementException();
        }

        return arr[index];
    }

    // 리스트 마지막에 데이터 추가
    public void addLast(T newData) {

        // 배열이 차있으면 배열 사이즈 확장
        if (isFull()) {
            resize(2 * arr.length);
        }

        // 데이터 추가
        arr[size++] = newData;
    }

    // 리스트 특정 인덱스에 데이터 추가
    public void add(T newData, int index) {

        // 배열이 차있으면 배열 사이즈 확장
        if (isFull()) {
            resize(2 * arr.length);
        }

        // 배열의 끝에서부터 특정 인덱스까지 한 칸씩 뒤로 데이터 이동
        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        // 특정 인덱스에 데이터 추가
        arr[index] = newData;
        size++;
    }

    // 리스트 특정 인덱스 데이터 삭제
    public T remove(int index) {

        // 리스트가 비어있으면 예외 발생
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        // 삭제할 데이터
        T removeToData = arr[index];
        size--;
        // 특정 인덱스부터 배열 끝까지 데이터를 한 칸씩 앞으로 이동
        for (int i = index; i < size; i++) {
            arr[i] = arr[i + 1];
        }
        // 배열의 항목들이 1/4만 차지한다면
        if (size > 0 && size == arr.length / 4) {
            // 크기를 1/2로 축소
            resize(arr.length / 2);
        }
        return removeToData;
    }

    // 리스트 배열 사이즈 변환
    private void resize(int newSize) {
        // 새로운 크기의 배열 생성
        Object[] newArr = new Object[newSize];

        for (int i = 0; i < size; i++) {
            newArr[i] = arr[i]; // 기존의 배열 데이터를 새로운 배열에 복사
        }
        arr = (T[]) newArr; // 새로운 배열을 다시 기존 배열에 복사
    }

    // 리스트 사이즈
    public int size() {
        return this.size;
    }

    // 리스트가 차있는지 확인
    private boolean isFull() {
        return this.size == arr.length;
    }

    // 리스트 공백 확인
    private boolean isEmpty() {
        return this.size == 0;
    }

    // toString 메서드
    @Override
    public String toString() {
        String text = "[";
        for (int i = 0; i < size; i++) {
            text += arr[i];
            if (i < size - 1)
                text += ",";
        }
        return text + "]";
    }
}
