package App.util;

public interface List {

    int add(Object value);

    Object get(int index);

    Object[]toArray();

    boolean remove(Object value);

    Object remove(int index);

    int size();
}
