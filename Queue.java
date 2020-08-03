
public interface Queue<T> {
    
    boolean insert(T item);

    T remove();

    boolean isEmpty();

    boolean isFull();
}
