import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class View {
    public void printMap(Map<String, Integer> map, String title) {
        System.out.println(title);
        for (Map.Entry<String, Integer> element : map.entrySet()) {
            System.out.print(element.getKey() + " : " + element.getValue() + ", ");
        }
        System.out.println("");
    }
    public void printInt(Integer number, String title) {
        System.out.println(title);
        System.out.println(number);
    }

    public void printString(String string) {
    }

    public void printSet(Set<String> set, String title) {
        System.out.println(title);
        for (String element : set) {
            System.out.print(element + ", ");
        }
        System.out.println("");
    }
}
