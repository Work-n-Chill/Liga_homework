import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Setter
@Getter
public class FileLoader {

    private final Path usersPath = Paths.get("users.csv");
    private final Path tasksPath = Paths.get("tasks.csv");

    private List<User> usersStore = new ArrayList<>();
    private List<Task> tasksStore = new ArrayList<>();

    public FileLoader() {
        load(usersPath, usersStore);
        load(tasksPath, tasksStore);
    }

    private void load(Path storePath, List store) {
        try {
            if (Files.exists(storePath) && Files.isReadable(storePath)) {
                List<String> o = new ArrayList<>();
                for (String s : Files.readString(storePath, StandardCharsets.UTF_8).split(", ")) {
                    String valueOf = String.valueOf(s);
                    o.add(valueOf);
                }
                store = o;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void flush(Path storePath, List store) {
        try {
            Files.writeString(
                    storePath,
                    represent(store)
            );
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String represent(List store) {
        return (String) store.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));
    }


    public void addTask(String data, List store) {
        store.add(new Task(data.split(", ")));
    }
    public void addUser(String data, List store) {
        store.add(new User(data.split(", ")));
    }
/*
    public void remove(int num) {
        store.remove(num);
    }
*/

}
