import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * Created by Travis Zeng on 2017/5/2.
 */
public class KeyboardRow {
    public static void main(String[] args) {
        String[] a = {"asdasd","qweqwewq","slkjlaabbb"};
        String[] nb = Stream.of(a).filter(s -> s.toLowerCase().matches("[qwertyuiop]*|[asdfghjkl]*|[zxcvbnm]*")).toArray(String[]::new);
        for (String n:nb
             ) {
            System.out.println(n);
        }
    }
}
