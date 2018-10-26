package doubles.ds.bst.implement;

public interface Tree<T> {

    public void insert(T data); // ����
    public T getMinValue();     // �ּҰ�
    public T getMaxValue();     // �ִ밪
    public void traversal();    // ��ȸ
    public void delete(T data); // ����

}
