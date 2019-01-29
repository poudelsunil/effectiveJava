public class StaticFactoryMethodOverPublicConstructor {
    public static void main(String...args){
        MyBoolean myBoolean = MyBoolean.valueOf(true);

        System.out.println(myBoolean);
    }
}

class MyBoolean{
    private final boolean value;
    static final MyBoolean TRUE = new MyBoolean(true);
    static final MyBoolean FALSE = new MyBoolean(false);

    private MyBoolean(boolean value) {
        this.value = value;
    }

    public static MyBoolean valueOf(boolean b){
        return b ? TRUE : FALSE;
    }

    @Override
    public String toString() {
        return "MyBoolean{" +
                "value=" + value +
                '}';
    }
}
