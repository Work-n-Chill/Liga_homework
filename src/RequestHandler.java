
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RequestHandler {

    public RequestHandler() {
        run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" You can use these commands: print+id, printf+id+status, chstatus+id+newStatus");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] request = line.split(" ");
            if (request[0].equals("printf")) {
                printFilteredTasks(line);
            } else if (request[0].equals("print")) {
                printTasks(line);
            } else if (request[0].equals("chstatus")) {
                changeStatus(line);
            } else {
                System.out.printf("it works, but wrong");
            }
        }
        scanner.close();
    }



    public void printTasks(String line){
        String[] request = line.split(" ");
        FileLoader data = data();
        List<Task> tasks = new ArrayList<>();
        for (Task task:data.getTasksStore()) {
            if (task.getUserID() == Integer.parseInt(request[1])) {
                System.out.println(task.info());
                //tasks.add(task);

            }
        }
        //data.represent(tasks);
    }

    public void printFilteredTasks(String line){
        String[] request = line.split(" ");
        FileLoader data = data();
        List<Task> tasks = new ArrayList<>();
        for (Task task:data.getTasksStore()) {
            if (task.getUserID() == Integer.parseInt(request[1])) {
                if (task.getStatus().equals(request[2]))
                    tasks.add(task);
            }
        }
        data.represent(tasks);
    }

    public void changeStatus(String line) {
        String[] request = line.split(" ");
        FileLoader data = data();
        for (Task task:data.getTasksStore()) {
            if (task.getId() == Integer.parseInt(request[1])) {
                task.setStatus(request[2]);
            }
        }
    }

    public FileLoader data(){
        FileLoader data = new FileLoader();
        return data;
    }

}
