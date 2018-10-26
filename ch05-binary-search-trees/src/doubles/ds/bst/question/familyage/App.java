package doubles.ds.bst.question.familyage;

public class App {
    public static void main(String[] args) {
        Tree<Person> bst = new BinarySearchTree<>();
        bst.insert(new Person("Adam",47));
        bst.insert(new Person("Kevin",21));
        bst.insert(new Person("Joe",55));
        bst.insert(new Person("Arnold",20));
        bst.insert(new Person("Noel",34));
        bst.insert(new Person("Marko",68));
        bst.insert(new Person("Susan",23));
        bst.insert(new Person("Rose",38));

        System.out.println(bst.getAgesSum());

    }
}
