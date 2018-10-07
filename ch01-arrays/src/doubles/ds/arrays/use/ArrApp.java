package doubles.ds.arrays.use;

public class ArrApp {
    public static void main(String[] args) {

        // 배열 선언
        int[] nums = new int[5];

        // 배열에 값 저장
        for (int i = 0; i < nums.length; i++) {
            nums[i] = i;
        }

        // O(1) 시간복잡도, random index
        int num = nums[0];
        System.out.println(num);

        // O(N) Linear Search(선형 탐색) --> O(LogN) Binary Tree(이진트리) --> O(1) HashTable(해쉬)
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 4) {
                System.out.println("index found : " + i);
            }
        }
    }
}
