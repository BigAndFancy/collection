import java.util.NoSuchElementException;

public class LinkedList implements List,Deque {
    private static class Node {
        private Object item;
        private Node prev;
        private Node next;
    }

    private Node first;
    private Node last;
    private int size;

    private static final int NOT_FOUND = -1;

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size==0);
    }

    public boolean contains(Object item) {
        return indexOf(item) != NOT_FOUND;
    }

    public boolean add(Object item) {
        Node newNode = new Node();

        newNode.item = item;
        newNode.prev=last;
        if (last != null){
            last.next=newNode;
        }else {
            first=newNode;
        }
        last=newNode;

        size++;
        return true;
    }


    public boolean remove(Object item) {
        boolean t = false;
        for (int i = 0; i < size; i++) {
            if (array[i] == item) {
                t = true;
                array[i] = null;
                break;
            } else t = false;
        }
        return t;
    }

    public void clear() {
        for (int i=0;i<size;i++){
            array[i]=null;
        }
    }

    public void addFirst(Object item) {
        Node newNode = new Node();

        newNode.item = item;
        newNode.next = first;
        if (first != null) {
            first.prev = newNode;
        } else {
            last = newNode;
        }
        first = newNode;

        size++;
    }

    public void addLast(Object item) {
        Node newNode = new Node();

        newNode.item = item;
        newNode.prev=last;
        if (last != null){
            last.next=newNode;
        }else {
            first=newNode;
        }
        last=newNode;

        size++;
    }

    private void checkForEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
    }


}
