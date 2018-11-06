package doubles.ds.rbt.integer;

public class App {
    public static void main(String[] args) {
        Tree redBlackTree = new RedBlackTree();
        redBlackTree.insert(1);
        redBlackTree.traverse();
        redBlackTree.insert(2);
        redBlackTree.traverse();
        redBlackTree.insert(3);
        redBlackTree.traverse();
        redBlackTree.insert(4);
        redBlackTree.traverse();

    }
}
