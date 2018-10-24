package doubles.ds.bst.implement;

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

        System.out.println("=============================");

        System.out.println(bst.getMinValue());
        System.out.println(bst.getMaxValue());

        System.out.println("=============================");

        Tree<Person> bst2 = new BinarySearchTree<>();
        bst2.insert(new Person("Kim" , 23));
        bst2.insert(new Person("Lee" , 25));
        bst2.insert(new Person("Park" , 28));
        bst2.insert(new Person("Choi" , 29));
        bst2.insert(new Person("Yoon" , 32));
        bst2.insert(new Person("Lim" , 21));
        bst2.insert(new Person("Ahn" , 33));
        bst2.traversal();
    }
}
