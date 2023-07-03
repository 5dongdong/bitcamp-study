package util;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class ArrayList implements List {
    private static final int DEFAULT_SIZE = 3;

    private Object[] list = new Object[DEFAULT_SIZE];
    private int length;

    @Override
    // 컴파일러에게 다음 메서드가 수퍼클래스의 메서드를 재정의한 것인지?
    // 또는 인터페이스의 메서드를 구현한 것인지?
    // 검사해달라는 표시다.
    public boolean add(Object obj) {
        if (this.length == list.length) {
            increase();
        }
        this.list[this.length++] = obj;
        return true;
    }

    private void increase() {
        Object[] arr = new Object[list.length + (list.length >> 1)];
        for (int i = 0; i < list.length; i++) {
            arr[i] = list[i];
        }
        list = arr;
        // System.out.println("배열 확장: " + list.length);
    }

    @Override
    public Object[] toArray() {
        Object[] arr = new Object[this.length];
        for (int i = 0; i < this.length; i++) {
            arr[i] = this.list[i];
        }
        return arr;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public Object get(int index) {
        if (!isValid(index)) {
            return null;
        }
        return this.list[index];
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public boolean remove(Object obj) {
        int deletedIndex = indexOf(obj);
        if (deletedIndex == -1) {
            return false;
        }

        for (int i = deletedIndex; i < this.length - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list[--this.length] = null;
        return true;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object remove(int index) {
        if (!isValid(index)) {
            return null;
        }

        Object old = this.list[index];

        for (int i = index; i < this.length - 1; i++) {
            this.list[i] = this.list[i + 1];
        }
        this.list[--this.length] = null;

        return old;
    }

    @Override
    public int size() {
        return this.length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    private boolean isValid(int index) {
        return index >= 0 && index < this.length;
    }

    public int indexOf(Object obj) {
        for (int i = 0; i < this.length; i++) {
            Object item = this.list[i];
            if (item.equals(obj)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator listIterator() {
        return null;
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }
}
