package doubles.ds.bst.question.kthsmallestelementfind;

public class App {
    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();
        bst.insert(2);
        bst.insert(55);
        bst.insert(67);
        bst.insert(12);
        bst.insert(11);

        System.out.println(bst.getKthSmallest(bst.getRoot(), 4));
    }
}
