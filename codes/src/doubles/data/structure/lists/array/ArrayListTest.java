package doubles.data.structure.lists.array;

public class ArrayListTest {

    public static void main(String[] args) {

        ArrayList<String> sportsList = new ArrayList<>();

        //System.out.println(sportsList.get(0));

        sportsList.add("Baseball");
        sportsList.add("Basketball");
        sportsList.add("Football");
        sportsList.add("Volleyball");
        sportsList.add("Tennis");
        sportsList.add("Bowling");
        sportsList.add("Golf");
        sportsList.add("Swimming");


        System.out.println("sportsList" + sportsList.get(1));

        sportsList.remove(1);

        System.out.println(sportsList.get(1));

        sportsList.add("Go", 0);

        sportsList.remove(1);
        sportsList.remove(1);
        sportsList.remove(1);
        sportsList.remove(1);
        sportsList.remove(1);
        sportsList.remove(1);
    }

}
