package doubles.ds.algorithms;

// 3개의 정수값 중 최소값 구하는 메서드 작성하기
public class IntMin3Method {
    public static void main(String[] args) {

        System.out.println("min(1, 2, 3) : " + min3(-1, 12, -20));
        System.out.println("min(4, 3, 1) : " + min3(100, 33, 43));
        System.out.println("min(2, 7, 10) : " + min3(29, -7, 100));

    }

    private static int min3(int a, int b, int c) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        return min;
    }
}
