package doubles.ds.arrays;

// 배열 복제
public class CloneArray {

    public static void main(String[] args) {

        int[] a = {1, 2, 3, 4, 5};
        int[] b = a.clone();    // 배열 복제

        b[3] = 0;   // 배열 b의 요소 중에서 인덱스 3에 0대입

        System.out.print("a = ");

        for (int i = 0; i < a.length; i++) {
            System.out.print(" " + a[i]);
        }
        System.out.print("\nb = ");

        for (int i = 0; i < b.length; i++) {
            System.out.print(" " + b[i]);
        }
    }

}
