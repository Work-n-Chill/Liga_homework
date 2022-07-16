import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.util.List;

public class DataCleaner {
    public DataCleaner(){
        clean(Data.getInstance().getUsersPath());
        clean(Data.getInstance().getTasksPath());
        clean(Data.getInstance().getUsersStore());
        clean(Data.getInstance().getTasksStore());
    }

    public void clean(Path storePath) {
        try {
            new PrintWriter(String.valueOf(storePath)).close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void clean(List store){
        store.clear();
    }
}
