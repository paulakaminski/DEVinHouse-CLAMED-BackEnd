import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import java.util.List;
import java.util.ArrayList;

public class aula05hashSet {
    public static void main(String[] args) {
        Set<String> stringSet = new HashSet<>();

        stringSet.add("a");
        stringSet.add("a");
        stringSet.add("b");
        stringSet.add("c");
        stringSet.add("c");
        stringSet.forEach(itemSet -> System.out.println(itemSet));
        System.out.println(stringSet.contains("c"));

        HashSet hashSet = new HashSet<>();
    }
}
