import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GetIfSumExistsInArray {

    public static void main(String args[]) {


        List<Integer> test1 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Simple: " + hassumsimple(4, test1));
        System.out.println("Complex: " + hassumcomplex(4, test1));

        List<Integer> test2 = Arrays.asList(45, 23, 56, 64, 75, 96);
        System.out.println("Simple: " + hassumsimple(4, test2));
        System.out.println("Complex: " + hassumcomplex(4, test2));

        List<Integer> test3 = Arrays.asList(0, 0, 0, 0, 0, 0);
        System.out.println("Simple: " + hassumsimple(4, test3));
        System.out.println("Complex: " + hassumcomplex(4, test3));

        List<Integer> test4 = Arrays.asList(9, 6, 4, 3, 2, 1);
        System.out.println("Simple: " + hassumsimple(4, test4));
        System.out.println("Complex: " + hassumcomplex(4, test4));

        List<Integer> test5 = Arrays.asList(1, 2, 3, 4, 5, 6);
        System.out.println("Simple: " + hassumsimple(44, test5));
        System.out.println("Complex: " + hassumcomplex(44, test5));

    }

    public static boolean hassumsimple(int x, List<Integer> arr) {

        for (int i = 0; i < arr.size(); ++i) {
            for(int j = arr.size()-1; j > i; --j) {
                if(arr.get(i) + arr.get(j) == x) {
                    return true;
                }
            }
        }
        return false;
    }

    public static boolean hassumcomplex(int sumtofind, List<Integer> arr) {

        List<Integer> current = new ArrayList<>();
        List<List<Integer> > solution = new ArrayList<>();
        gettwos(arr, 0, current, solution);
//        System.out.println("finished solution: " + solution);

        for(List<Integer> sublist : solution){
            if(sublist.get(0) + sublist.get(1) == sumtofind) {
                return true;
            }
        }
        return false;
    }

    private static void gettwos(List<Integer> superarr, int index, List<Integer> current, List<List<Integer> > solution) {
        if(current.size() == 2) {
//            System.out.println("Found solution: "+ current);
            solution.add(new ArrayList<>(current));
//            System.out.println("Solution: " + solution);
            return;
        }

//        System.out.println("current solution: " + solution);
        if (index == superarr.size()) return;

        Integer x = superarr.get(index);
//        System.out.println("adding: " + x + " to current: " + current );
        current.add(x);

        gettwos(superarr, index+1, current, solution);

//        System.out.println("removing: " + x + " from current: " + current );
        current.remove(x);
        gettwos(superarr, index+1, current, solution);

    }

}
