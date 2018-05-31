package doubles.ds.arrays;

public class Int2DArray {
    public static void main(String[] args) {

        int[][] x = new int[2][4];  // 2차원 배열 선언

        x[0][1] = 37;
        x[0][3] = 12;
        x[1][2] = 49;

        // 배열에 저장한 값 출력
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.println("x[" + i + "]" + "[" + j + "] = " + x[i][j]);
            }
        }
    }
}
