import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class findsets {
    public static void main(String args[]) {
        List<Integer> superSet = new ArrayList<>();
        superSet.add(1);
        superSet.add(2);
        superSet.add(3);
        superSet.add(4);
//        superSet.add(5);
//        superSet.add(6);
//        superSet.add(7);
        System.out.println(getSubsets(superSet,3));
    }


    private static void getSubsets(List<Integer> superSet, int setSizeLimit, int idx, Set<Integer> current,List<Set<Integer>> solution) {
        //if set list is at max size, set the solution and return it
        if (current.size() == setSizeLimit) {
            solution.add(new HashSet<>(current));
            return;
        }
        // at the end of the superset, stop
        if (idx == superSet.size()) return;

        // this is the meat of the algorithm
        // get the item at the index
        Integer x = superSet.get(idx);

        // add it to the current set
        current.add(x);

        getSubsets(superSet, setSizeLimit, idx+1, current, solution);
        current.remove(x);

        getSubsets(superSet, setSizeLimit, idx+1, current, solution);
    }

    public static List<Set<Integer>> getSubsets(List<Integer> superSet, int setSizeLimit) {
        List<Set<Integer>> res = new ArrayList<>();
        getSubsets(superSet, setSizeLimit, 0, new HashSet<Integer>(), res);
        return res;
    }
}