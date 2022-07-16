import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileSaver {

    public FileSaver(){
        save(Data.getInstance().getUsersPath(), Data.getInstance().getUsersStore());
        save(Data.getInstance().getTasksPath(), Data.getInstance().getTasksStore());
    }

    private void save(Path storePath, List store) {
        try (BufferedWriter br = Files.newBufferedWriter(storePath)) {
            for (Object value : store) {
                br.write(value.toString() + "\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
