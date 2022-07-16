package data;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;


public class FileLoader {

    public FileLoader() {
        load(Data.getInstance().getUsersPath(), Data.getInstance().getUsersStore(), true);
        load(Data.getInstance().getTasksPath(), Data.getInstance().getTasksStore(), false);
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
            System.out.println(o.toString());
        }
    }




}
