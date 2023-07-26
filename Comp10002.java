package playground;
import java.util.*;


class Comp1002{

    // Lecture 1: Search pattern
    public static HashMap<String, List<Integer>> findRepeat(String in_str, int m){
        HashMap<String, List<Integer>> startPost = new HashMap<String, List<Integer>>();

        for (int i=0; i < in_str.length() - m; i++){
            String curSeq = in_str.substring(i, i + m);

            if (!startPost.containsKey(curSeq)){
                startPost.put(curSeq, new LinkedList<Integer>());
            }
            
            List<Integer> curPost  = startPost.get(curSeq);
            curPost.add(i);
        }

        // System.out.println(startPost);

        Set<String> keys = new HashSet<>(startPost.keySet());
        for (String cur: keys){
            if (startPost.get(cur).size() == 1){
                startPost.remove(cur);
            }
        }

        return startPost;
    }

    public static void main(String[] args) {

        System.out.println(findRepeat("a", 5));
    }
}