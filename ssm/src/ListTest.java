import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ListTest {

    public static void main(String[] args) {

        Set<String> ids = new HashSet<>();
        ids.add("9");
        ids.add("8");

        Set<String>strings = new HashSet<>();
        strings.add("3");
        strings.add("4");

        ids.removeAll(strings);

        System.out.println("success");

    }
}
