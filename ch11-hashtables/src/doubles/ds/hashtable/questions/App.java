package doubles.ds.hashtable.questions;

public class App {

    // Two sum problem
    // 정렬되지 않은 정수 배열에서 2개의 정수를 합해 특정 값(s)이 나오는 쌍을 모두 구하시오.
    // ex) [1, 2, 3, 4], s = 5 --> [1, 4], [2, 3]

    public static void main(String[] args) {

        int[] nums = {3, 5, 2, -4, 8, 11};
        int s = 7;

        TwoSumNaive twoSumNaive = new TwoSumNaive(nums, s);
        twoSumNaive.solve();

        TwoSumHashMap twoSumHashMap = new TwoSumHashMap(nums, s);
        twoSumHashMap.solve();
    }

}
