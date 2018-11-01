package doubles.ds.avltree.implement.integer;

public class App {
    public static void main(String[] args) {
        Tree avlTree = new AVLTree();
        avlTree.insert(1);
        avlTree.insert(2);
        avlTree.insert(3);
        avlTree.insert(4);
        avlTree.insert(5);
        avlTree.insert(6);
        avlTree.insert(7);
        avlTree.traverse();
        avlTree.delete(4);
        avlTree.traverse();
    }
}
