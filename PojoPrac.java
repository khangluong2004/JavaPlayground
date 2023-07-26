package playground;

public class PojoPrac{
    public static void main(String[] args) {
        Pojo new_obj = new Pojo(5);
        System.out.println(new_obj.get_x());
    }
}

class Pojo {
    // Private attributes for encapsulation
    private int x;

    // Constructor
    public Pojo(int init_x){
        x = init_x;
    }

    // Overload constructor
    public Pojo(int init_x, int extra){
        this(init_x);
        System.out.println(extra);
    }
    
    // Setter
    public void set_x(int set_x){
        x = set_x;
    }

    // Getter
    public int get_x(){
        return x;
    }
    
}
