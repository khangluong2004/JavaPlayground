package playground;

public class Overload {
    // Method overloading:
    // Require unique signature: method name, param types, order of params.
    
    public int sum(int a, int b, int c){
        return a + b + c;
    }
    
    public int sum(int a, int b){
        return sum(a, b, 0);
    }

    public double sum(double a, double b){
        return a + b;
    }

    public static void main(String[] args){

    }


}
