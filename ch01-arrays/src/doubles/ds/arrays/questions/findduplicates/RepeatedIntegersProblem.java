package doubles.ds.arrays.questions.findduplicates;

public class RepeatedIntegersProblem {

    public void solve(int[] array) {

        // 배열 수행
        for (int i = 0; i < array.length; i++) {
            // 양수이면, 음수로 변환
            if (array[Math.abs(array[i])] > 0) {
                // 음수 변환
                array[Math.abs(array[i])] = -array[Math.abs(array[i])];
            // 음수이면, 중복된 요소 출력
            } else {
                System.out.println("중복된 요소 : " + Math.abs(array[i]));
            }
        }
    }

}
