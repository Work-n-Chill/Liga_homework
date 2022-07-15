import lombok.Getter;
import lombok.Setter;

import java.io.BufferedReader;
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

    private final Path usersPath = Paths.get("D:\\Загрузки\\Task tracker\\src\\users.csv");
    private final Path tasksPath = Paths.get("D:\\Загрузки\\Task tracker\\src\\tasks.csv");

    private List<User> usersStore = new ArrayList<>();
    private List<Task> tasksStore = new ArrayList<>();

    public FileLoader() {
        load(usersPath, usersStore, true);
        load(tasksPath, tasksStore, false);
    }

    private void load(Path storePath, List store, boolean user) {

        try (BufferedReader br = Files.newBufferedReader(storePath)) {
            String DELIMITER = ", ";
            String line;
            while ((line = br.readLine()) != null) {
                String[] parts = line.split(DELIMITER);
                if (user){
                    store.add(new User(parts));
                } else {
                    store.add(new Task(parts));
                }

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void represent(List<Task> store) {
        for (Task o: store){
            System.out.println(o.info());
        }
    }




    public void addTask(String[] data, List store) {
        store.add(new Task(data));
    }
    public void addUser(String[] data, List store) {
        store.add(new User(data));
    }


}
