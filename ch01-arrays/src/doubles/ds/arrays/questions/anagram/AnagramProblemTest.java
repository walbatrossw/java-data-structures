package doubles.ds.arrays.questions.anagram;

public class AnagramProblemTest {
    public static void main(String[] args) {

        char[] s1 = {'r', 'e', 's', 't', 'f', 'u', 'l'};
        char[] s2 = {'f', 'l', 'u', 's', 't', 'e', 'r'};

        AnagramProblem anagramProblem = new AnagramProblem();
        System.out.println(anagramProblem.solve(s1, s2));

    }
}
