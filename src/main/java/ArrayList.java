public class ArrayList implements List {
    private static final int NOT_FOUND = -1;

    private int size;
    private Object[] array;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int capacity) {
        array = new Object[capacity];
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return (size == 0);
    }

    public boolean contains(Object item) {
        return indexOf(item) != NOT_FOUND;
    }

    public int indexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (item.equals(array[i])) {
                return i;
            }
        }
        return NOT_FOUND;
    }

    public boolean add(Object item) {
        extendArrayAsNeeded();
        array[size] = item;
        size++;
        return true;
    }

    public void add(int index, Object item) {
        extendArrayAsNeeded();
        for (int i = size + 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = item;
        size++;
    }

    public void set(int index, Object item) {
        array[index] = item;
    }

    public Object get(int index) {
        return array[index];
    }

    public void remove(int index) {
        array[index] = null;
    }

    public int lastIndexOf(Object item) {
        for (int i = 0; i < size; i++) {
            if (array[i] == item)
                return i;
        }
        return -1;
    }

    public List subList(int from, int to) {
        checkForRange(from, to);
        List result = new ArrayList(to - from);
        for (int i = 0; i < size; i++) {
            result.add(array[i]);
        }
        return result;
    }

    private void checkForRange(int from, int to) {
        if ((from < 0) || (from >= to) || (to >= size)) {
            throw new IndexOutOfBoundsException();
        }
    }

    private void setArray(Object[] array) {
        this.array = array;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
    }

    private void extendArrayAsNeeded() {
        if (size == array.length) {
            int newsize = (size + 1) * 3 / 2;
            Object[] newarray = new Object[newsize];
            for (int i = 0; i < size; i++) {
                newarray[i] = array[i];
            }
            setArray(newarray);
        }
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
}
