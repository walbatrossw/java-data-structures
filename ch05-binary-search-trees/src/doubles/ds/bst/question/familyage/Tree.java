package doubles.ds.bst.question.familyage;

public interface Tree<T> {

    public int getAgesSum();
    public void insert(T data); // ����
    public T getMinValue();     // �ּҰ�
    public T getMaxValue();     // �ִ밪
    public void traversal();    // ��ȸ
    public void delete(T data); // ����

}
