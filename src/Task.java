import lombok.*;
import java.util.*;

@AllArgsConstructor
@Getter
@Setter
public class Task {
    private int id;
    private String header;
    private String body;
    private int userID;
    private String deadline;
    private String status;

    public Task(int id, String header, String body,int userID, String deadline) {
        this.id = id;
        this.header = header;
        this.body = body;
        this.userID = userID;
        this.deadline = deadline;
        this.status = "новая";
    }

    public Task(String[] split) {
        id = Integer.parseInt(split[0]);
        header = split[1];
        body = split[2];
        userID = Integer.parseInt(split[3]);
        deadline = split[4];
        status = "новая";
    }

    public String info(){
        return (id+ " , " + header + " , " + body + " , "+ userID + " , "+ deadline+ " , "+ status);
    }
}
