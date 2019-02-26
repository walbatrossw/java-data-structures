package doubles.ds.hashtable.questions;

public class TwoSumNaive {

    private int[] nums;
    private int s;

    public TwoSumNaive(int[] nums, int s) {
        this.nums = nums;
        this.s = s;
    }

    public void solve() {
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if (nums[i] + nums[j] == s) {
                    System.out.println("HashMap solution : " + nums[i] + " + " + nums[j] + " = " + s);
                }
            }
        }
    }

}
