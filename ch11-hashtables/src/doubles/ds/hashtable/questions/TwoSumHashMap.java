package doubles.ds.hashtable.questions;

import java.util.HashMap;
import java.util.Map;

public class TwoSumHashMap {

    private int[] nums;
    private int s;
    private Map<Integer, Integer> hashTable;

    public TwoSumHashMap(int[] nums, int s) {
        this.nums = nums;
        this.s = s;
        this.hashTable = new HashMap<>();
    }

    public void solve() {

        for (int i = 0; i < nums.length; i++) {
            int reminder = s - nums[i];
            if (hashTable.containsValue(reminder)) {
                System.out.println("Naive solution : " + nums[i] + " + " + reminder + " = " + s);
            }
            hashTable.put(i, nums[i]);
        }

    }

}
