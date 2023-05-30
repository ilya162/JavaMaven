package Lesson18;

public class ParametrizeClass {
    public static void main(String[] args) {
        ParamClass<String, Integer> aClass = new ParamClass('0', 123);
        aClass.print();

    }
}

class ParamClass<T, R> {
    private T value;
    private R val;


    public ParamClass(T value, R val) {
        this.value = value;
        this.val = val;
    }

    public R print() {
        System.out.println(value);
        return val;

    }
}
