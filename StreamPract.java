package playground;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamPract {
    // Stream: An API used to chain operations on a collections, lists, etc.
    // Specialized for handling one element at a time
    // Doesn't store all elements (kindof like iterator)

    public static void main(String[] args) {
        // A Stream pipeline consists 3 main operations
        // 1. Source (.stream() or other method to create)
        // 2. Intermediate op. (all methods returning a Stream)
        // 3. Terminal op. (Creating a side effect. All methods returning non-Stream)

        // Source and Terminal op. are REQUIRED

        // Note: Stream is lazy: Computation is only carried out after Terminal op. is started.
        // Intermediate steps are optimized, and actual orders are NOT guaranteed
        // Avoid side effects in intermediate steps as actual orders are NOT guaranteed
        // The results from Stream are guaranteed to be stable, though, with orders shown in chaining

        // Stream is single-used. Can't re-use a second time

        // Stream could be ordered or unordered, causing non-deterministic behaviour for dropWhile, takeWhile, etc.

        // Example:
        System.out.println("\nExample: ");
        List<Integer> testList = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8));
        testList.stream() // All Collections have .stream methods.
                // Map is not in Collections, but .entrySet, .keySet and .Values are
                .limit(8) // Limit to 4 first items
                .filter(s -> (s % 2 == 0)) // filter even values
                .map(s -> (s * s)) // Map each element into its square
                .forEach(System.out::println);

        // Other way to make stream
        System.out.println("\nExample 2: ");
        String[] stringArr = {"One", "Two", "Three"};
        var firstStream = Arrays.stream(stringArr)
                .sorted(Collections.reverseOrder());
        var secondSteam = Stream.of("five", "six", "seven")
                .map(String::toUpperCase);

        // All operations start here, after concat and terminal operations
        // The operations specified on firstStream and secondStream are separate
        // The operation on concat is applied onto both
        Stream.concat(firstStream, secondSteam)
                .map(s -> ("Concat-" + s))
                .forEach(System.out::println);

        // Primitive and infinite Stream
        System.out.println("\nPrimitive and Potentially infinite Stream");

        IntStream.iterate(1, n -> 2 * n) // Generate a stream starting at `seed`
                // and apply lambda to create next elem
                .limit(20)
                .forEach(System.out::println);

        Stream.generate(() -> "hi")
                .limit(5)
                .forEach(System.out::println);
        // Range in java
        int[] rangeExample = IntStream.range(1, 10).toArray();
        System.out.println(Arrays.toString(rangeExample));

        // Terminal operations
        // Matching and Searching: allMatch, anyMatch, findAny, findFirst, noneMatch
        // Transformations and Type reductions: collect (mutable result), reduce, toArray, toList
        // Statistical Reductions: average, count, max, min, sum, summaryStatistics (all above func gathered in an obj)
        // Processing: forEach, forEachOrdered
        // Conversion: toList (immutable list, in Java 16), toArray
        System.out.println("Terminal operations:");

        // Typed toArray
        var check = Stream
                .iterate(1, n -> n+1)
                .limit(25)
                .toArray(Integer[]::new);
        System.out.println(Arrays.toString(check));


        // collect method
        // Collectors are used extensively
        // Consists of supplier (creation of new result container), accumulator (incorporate new data
        // into a result container), combining 2 result containers into one (combiner),
        // performing an optional final transform (finisher);
        // Check out Collectors' interface: https://docs.oracle.com/javase/8/docs/api/java/util/stream/Collector.html
        // Usually, the Collectors class is sufficient

        // toList with Collectors
        var checkList = Stream
                .iterate(1, n -> n+1)
                .limit(25)
                .collect(Collectors.toList());
        System.out.println(checkList);

        // collect(supplier, accumulator, combiner)
        Set<Integer> testSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6, 7)); // Note: Highly inefficient initialisation
        Set<Integer> sortSet = testSet.stream()
                .filter((s) -> s%2 == 0)
                .collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        System.out.println(sortSet);

        // reduce method: Simplest type: reduce(identity, accumulator)
        // Reducing everything to one value
        int combined = sortSet.stream()
                .reduce(0, Integer::sum);
        System.out.println("Reduced to: " + combined);

    }

}
