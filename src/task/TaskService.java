package task;

import frequency.IFrequency;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

public class TaskService {

    private final Map<Integer, Task> taskPool = new HashMap<>();

    public void addTask(String header, String info, LocalDateTime dateTime, Type type, IFrequency frequency) {
        Task task = new Task(header, info, dateTime, type, frequency);
        taskPool.put(taskPool.size() + 1, task);
    }

    public void deleteTask(Integer id) {
        taskPool.remove(id);
    }

    public void allTask() {
        for (Integer key : taskPool.keySet()) {
            System.out.println(key + ". " + taskPool.get(key).getHeader());
        }
    }

    public void allTasksForDate(LocalDate localDate) {
        for (Integer key : taskPool.keySet()) {
            if (taskPool.get(key).getDateTime().toLocalDate().equals(localDate)) {
                System.out.println(key + ". " + taskPool.get(key).getHeader());
            }
        }
    }
}

