import java.util.Arrays;

public class MySet<T> {
    private Object[] arr;
    private int size;
    private Boolean isArrayChange;
    public MySet() {
        size=0;
        arr = new Object[size];
        isArrayChange = false;
    }
    public void add(Object value){
        Object[] duplicate = new Object[++size];
        System.arraycopy(arr, 0, duplicate, 0, arr.length);
        if (!contains(value)) {
            duplicate[size - 1] = value;
            isArrayChange = true;
            arr = duplicate;
        } else {
            size--;
            isArrayChange = false;
        }
    }

    @Override
    public String toString() {
        return "MySet{" +
                "arr=" + Arrays.toString(arr) +
                ", size=" + size +
                '}';
    }
    public boolean contains(Object value){
        int i = 0;
        while (i <arr.length) {
            if(arr[i]==value)
                return true;
            i++;
        }
        return false;
    }
    public boolean isEmpty(){
        return size == 0 && arr.length == 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        arr = new Object[0];
        size=0;
    }

    public boolean addAll(MySet<T> set) {
        int i = 0;
        while (i <set.size) {
            this.add(set.arr[i]);
            i++;
        }
        return isArrayChange;
    }

    public boolean containAll(MySet<T> set) {
        int i = 0;
        while (i <set.arr.length) {
            if(!this.contains(set.arr[i]))
                return false;
            i++;
        }
        return  true;
    }

    public boolean equals(MySet<T> o) {
        return this == o || size == o.size && this.containAll(o);
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (int i = 0; i <size ; i++) {
            result+=(int)arr[i]*(i==0?1:i);
        }
        return result*31;
    }
}
