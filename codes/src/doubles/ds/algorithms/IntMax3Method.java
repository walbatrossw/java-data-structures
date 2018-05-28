package doubles.ds.algorithms;

// 3개의 정수값 비교 메서드
public class IntMax3Method {
    public static void main(String[] args) {

        System.out.println("max(1, 2, 3) : " + max3(1, 2, 3));
        System.out.println("max(4, 3, 1) : " + max3(4, 3, 1));
        System.out.println("max(2, 7, 10) : " + max3(2, 7, 10));

    }

    private static int max3(int a, int b, int c) {
        int max = a;
        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        return max;
    }
}
