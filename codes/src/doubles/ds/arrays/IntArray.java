package doubles.ds.arrays;

// int형 배열 선언, 생성
public class IntArray {
    public static void main(String[] args) {
        int[] a = new int[5];

        a[1] = 37;
        a[2] = 20;
        a[3] = 44;
        a[4] = a[1] * 3;

        for (int i = 0; i < a.length; i++) {
            System.out.println("a[" + i + "] = "+ a[i]);
        }
    }
}
