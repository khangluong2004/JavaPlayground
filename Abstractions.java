package playground;

// Interface
interface HelloInterface{
    public abstract void hello();
}

// Abstract class
// Could implement interfaces
abstract class AbstractPract{
    int num;
    public AbstractPract(int num){
        this.num = num;
    }
    public static void nonAbstract(){
        System.out.println("Non abstract");
    }

    public abstract void abstractMeth();
}

// Generics
class Generics<T, U> extends AbstractPract implements HelloInterface{
    T att1;
    U att2;

    public Generics(int num, T att1, U att2){
        super(num);
        this.att1 = att1;
        this.att2 = att2;
    }

    @Override
    public void hello() {
        System.out.println("Hello world");
    }

    @Override
    public void abstractMeth() {
        System.out.println(this.num);
    }

    public void printGenerics(){
        System.out.println(this.att1);
        System.out.println(this.att2);
    }
}

public class Abstractions {
    public static void main(String[] args) {
        Generics<String, Integer> checkGenerics = new Generics<String, Integer>(1, "abc", 5);
        checkGenerics.hello();
        checkGenerics.printGenerics();
        checkGenerics.abstractMeth();
    }
}
