package data;

import lombok.Getter;
import lombok.Setter;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class Data {
    private static Data instance;

    private final Path usersPath = Paths.get("users.csv");
    private final Path tasksPath = Paths.get("tasks.csv");

    private List<User> usersStore = new ArrayList<>();
    private List<Task> tasksStore = new ArrayList<>();

    private Data (){}

    public static Data getInstance(){
        if (instance == null){
            instance = new Data();
        }
        return instance;
    }

    public void addTask(String[] data) {
        Data.getInstance().getTasksStore().add(new Task(data));
    }
    public void addUser(String[] data) {
        Data.getInstance().getUsersStore().add(new User(data));
    }
}
