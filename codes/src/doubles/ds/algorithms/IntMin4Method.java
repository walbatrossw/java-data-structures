package doubles.ds.algorithms;

// 4개의 정수값 중 최소값 구하는 메서드 작성하기
public class IntMin4Method {
    public static void main(String[] args) {

        System.out.println("min(1, 2, 3) : " + min4(-1, 12, -20, -11));
        System.out.println("min(4, 3, 1) : " + min4(100, 33, 43, 1));
        System.out.println("min(2, 7, 10) : " + min4(29, -7, 100, 4));

    }

    private static int min4(int a, int b, int c, int d) {
        int min = a;
        if (b < min) {
            min = b;
        }
        if (c < min) {
            min = c;
        }
        if (d < min) {
            min = d;
        }
        return min;
    }
}
