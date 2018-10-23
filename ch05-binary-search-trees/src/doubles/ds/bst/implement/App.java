package doubles.ds.bst.implement;

import doubles.ds.bst.Tree;

public class App {
    public static void main(String[] args) {
        Tree<Integer> bst = new BinarySearchTree<>();
        bst.insert(41);
        bst.insert(20);
        bst.insert(11);
        bst.insert(29);
        bst.insert(32);
        bst.insert(65);
        bst.insert(50);
        bst.insert(91);
        bst.insert(72);
        bst.insert(99);

        bst.traversal();
        bst.delete(41);
        bst.traversal();

    }
}
