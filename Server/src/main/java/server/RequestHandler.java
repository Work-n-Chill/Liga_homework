package server;

import data.*;


import java.util.Scanner;

public class RequestHandler {

    public RequestHandler() {
        run();
    }

    private void run() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(" You can use these commands: \n "+
                "print (all + id/ f + id + status) \n " +
                "add (+ id + header + body + userId + date (+ status)) \n " +
                "rm (+id) \n " +
                "update (+ id + status + newStatus/ +id + newTaskInfo) \n " +
                "save \n "+
                "clean");
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            String[] request = line.split(" ");
            if (request[0].equals("print")) {
                printTasks(line);
            } else if (request[0].equals("add")) {
                add(line);
            } else if (request[0].equals("rm")) {
                removeTask(line);
            } else if (request[0].equals("update")) {
                updateTask(line);
            } else if (request[0].equals("save")) {
                new FileSaver();
            } else if (request[0].equals("clean")) {
                new DataCleaner();
            } else {
                System.out.printf("it works, but wrong");
            }

        }
        scanner.close();
    }



    public void printTasks(String line){
        String[] request = line.split(" ");
        Data data = Data.getInstance();
        //List<data.Task> tasks = new ArrayList<>();
        if (request[1].equals("all")) {
            for (Task task:data.getTasksStore()) {
                if (task.getUserID() == Integer.parseInt(request[2])) {
                    System.out.println(task.toString());
                }
            }
        } else if (request[1].equals("f")){
            for (Task task:data.getTasksStore()) {
                if (task.getUserID() == Integer.parseInt(request[2])) {
                    if (task.getStatus().equals(request[3]))
                        System.out.println(task.toString());
                }
            }
        } else {
            System.out.println("smth is wrong");
        }
    }

    public void add(String line) {
        Data data = Data.getInstance();
        String substring = line.substring(4);
        String[] request = substring.split(" ");
        data.addTask(request);
    }

    public void removeTask(String line) {
        Data data = Data.getInstance();
        String[] request = line.split(" ");
        int id = Integer.parseInt(request[1]);
        int i = 0;
        for (Task task:data.getTasksStore()) {
            if (task.getId() == (id)) {
                break;
            }
            i++;
        }
        data.getTasksStore().remove(i);
    }

    public void updateTask(String line) {
        Data data = Data.getInstance();
        String[] request = line.split(" ");

        for (Task task:data.getTasksStore()) {
            if (task.getId() == (Integer.parseInt(request[1]))) {
                if (request[2].equals("status")) {
                    task.setStatus(request[3]);
                } else {
                    task.changeTask(line.substring(7).split(" "));
                }
            }
        }
    }

}
