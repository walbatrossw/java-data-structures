package doubles.ds.hashtable.implement.linearprobing;

public class HashItem {

    private int key;    // 키
    private int value;  // 값

    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

    // getter, setter
    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
