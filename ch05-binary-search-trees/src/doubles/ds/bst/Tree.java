package doubles.ds.bst;

import doubles.ds.bst.implement.Node;

public interface Tree<T> {

    public void traversal();
    public void insert(T data);
    public void delete(T data);
    public T getMaxValue();
    public T getMinValue();

}
