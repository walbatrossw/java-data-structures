package doubles.ds.hashtable.implement.chainig;

public class HashItem {

    private int key;    // 키
    private int value;  // 값
    private HashItem nextHashItem; // 다음 항목

    // 생성자
    public HashItem(int key, int value) {
        this.key = key;
        this.value = value;
    }

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

    public HashItem getNextHashItem() {
        return nextHashItem;
    }

    public void setNextHashItem(HashItem nextHashItem) {
        this.nextHashItem = nextHashItem;
    }

}
