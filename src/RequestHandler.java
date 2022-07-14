
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestHandler {

    public RequestHandler() {
        run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] request = line.split(", ");
            switch (request[0]){
                case "print":
                    printTasks(Integer.parseInt(request[1]));
                case "printf":
                    printFilteredTasks(Integer.parseInt(request[1]), request[2]);
                case "chstatus":
                    changeStatus(Integer.parseInt(request[1]), request[2]);
            }
        }
        scanner.close();
    }



    public void printTasks(int userId){
        FileLoader data = data();
        List<Task> tasks = new ArrayList<>();
        for (Task task:data.getTasksStore()) {
            if (task.getUserID() == userId) {
                tasks.add(task);

            }
        }
        System.out.println(data.represent(tasks));
    }

    public void printFilteredTasks(int userId, String filter){
        FileLoader data = data();
        List<Task> tasks = new ArrayList<>();
        for (Task task:data.getTasksStore()) {
            if (task.getUserID() == userId) {
                if (task.getStatus().equals(filter))
                    tasks.add(task);
            }
        }
        System.out.println(data.represent(tasks));
    }

    public void changeStatus(int taskId, String newStatus) {
        FileLoader data = data();
        for (Task task:data.getTasksStore()) {
            if (task.getId() == taskId) {
                task.setStatus(newStatus);
            }
        }
    }

    public FileLoader data(){
        FileLoader data = new FileLoader();
        return data;
    }

}
