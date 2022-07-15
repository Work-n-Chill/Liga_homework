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
        split[0] = String.valueOf(id);
        split[1] = name;
    }
    public String info(){
        return (id+ " , " + name);
    }
}
