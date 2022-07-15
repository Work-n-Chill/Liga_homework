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
    private Date deadline;
    private String status;

    public Task(int id, String header, String body,int userID, Date deadline) {
        this.id = id;
        this.header = header;
        this.body = body;
        this.userID = userID;
        this.deadline = deadline;
        this.status = "новая";
    }

    public Task(String[] split) {
        split[0] = String.valueOf(id);
        split[1] = header;
        split[2] = body;
        split[3] = String.valueOf(userID);
        split[4] = String.valueOf(deadline);
    }

    public String info(){
        return (id+ " , " + header + " , " + body + " , "+ userID + " , "+ deadline+ " , "+ status);
    }
}
