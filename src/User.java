import lombok.*;
import java.util.*;


@AllArgsConstructor
@Getter
@Setter
public class User {
    private int id;
    private String name;
    private List<Task> tasks;

    public User(String[] split) {
        id = Integer.parseInt(split[0]);
        name = split[1];
    }

    @Override
    public String toString() {
        return (id+ ", " + name);
    }
}
