package doubles.ds.arrays.questions.anagram;

import java.util.Arrays;

public class AnagramProblem {

    public boolean solve(char[] s1, char[] s2) {

        // 비교할 문자 배열의 길이가 같이 않으면 메서드 종료
        if (s1.length != s2.length) {
            return false;
        }

        // 문자 배열 정렬
        Arrays.sort(s1);
        Arrays.sort(s2);

        // 문자 배열 비교, 같지 않으면 메서드 종료
        for (int i = 0; i < s1.length; i++) {
            if (s1[i] != s2[i]) {
                return false;
            }
        }

        return true;
    }

}
