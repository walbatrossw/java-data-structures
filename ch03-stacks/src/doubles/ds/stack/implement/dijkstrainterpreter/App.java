package doubles.ds.stack.implement.dijkstrainterpreter;

public class App {
    public static void main(String[] args) {
        Algorithm algorithm = new Algorithm();
        algorithm.interpreterExpression("( ( 1 + 2 ) * ( 3 + 4 ) )");
        algorithm.result();

    }
}
