package doubles.ds.algorithms;

// 4개의 정수값 중 최대값 구하는 메서드 작성하기
public class IntMax4Method {
    public static void main(String[] args) {
        System.out.println("최대값 : " + max4(1, 2, 3, 4));
        System.out.println("최대값 : " + max4(2, 3, 5, 1));
        System.out.println("최대값 : " + max4(9, 2, 4, 7));
        System.out.println("최대값 : " + max4(10, 12, 1, 22));
    }

    private static int max4(int a, int b, int c, int d) {
        int max = a;

        if (b > max) {
            max = b;
        }
        if (c > max) {
            max = c;
        }
        if (d > max) {
            max = d;
        }

        return max;
    }
}
