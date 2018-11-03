package doubles.ds.avltree.implement.generic;

public class App {
    public static void main(String[] args) {
        Tree<String> avlTree = new AVLTree<>();
        avlTree.insert("A");
        avlTree.insert("B");
        avlTree.insert("C");
        avlTree.insert("D");
        avlTree.insert("E");
        avlTree.traverse();

        avlTree.delete("D");
        avlTree.traverse();
    }
}
