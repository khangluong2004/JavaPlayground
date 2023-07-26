package playground;


import java.util.function.*;

@FunctionalInterface
interface CustomBiFunc<T, U, R>{
    abstract R run(T a, U b);
}

public class Functional {
    // Experimenting with 4 popular functional interfaces
    // Consumer, Predicate, Function, Supplier

    public static void main(String[] args) {
        // Consumer: Accept 1 arg type <T>, return nothing
        Consumer<String> consumerPract = System.out::println;
        consumerPract.accept("Customer test");

        // Predicate: Accept 1 arg type <T>, return true/ false
        Predicate<Integer> checkLess = n -> (n < 10);
        System.out.println(checkLess.test(12));

        // Function: Accept 1 arg type T, return type R
        Function<Integer, String> funcLess = n -> {
            if (n < 10){
                return "Less than 10";
            }
            return "Not less than 10";
        };
        System.out.println(funcLess.apply(123));

        // Supplier: No arg, return type T
        Supplier<String> supply = () -> "Supplier test";
        supply.get();

        // Customized interface
        CustomBiFunc<Integer, Integer, Integer> checkCustom = (a, b) -> (a + b);
        System.out.print(checkCustom.run(1, 2));
    }


}
