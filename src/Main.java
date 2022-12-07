import frequency.*;
import task.TaskService;
import task.Type;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Main {
    private final static DateTimeFormatter TASK_DATE_TIME_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy-HH:mm");
    private final static DateTimeFormatter TASK_DATE_FORMATTER =
            DateTimeFormatter.ofPattern("dd.MM.yyyy");

    public static void main(String[] args) {
        TaskService taskService = new TaskService();
        try (Scanner scanner = new Scanner(System.in)) {
            label:
            while (true) {
                printMenu();
                System.out.println("Выберите пункт меню: ");
                if (scanner.hasNextInt()) {
                    int menu = scanner.nextInt();
                    switch (menu) {
                        case 1:
                            inputTask(scanner, taskService);
                            break;
                        case 2:
                            removeTask(scanner, taskService);
                            break;
                        case 3:
                            getTasksForDate(scanner, taskService);
                            break;
                        case 4:
                            printAllTasks(scanner, taskService);
                            break;
                        case 0:
                            break label;
                    }
                } else {
                    scanner.next();
                    System.out.println("Выберите пункт меню из списка!");
                }
            }
        }
    }

    private static void inputTask(Scanner scanner, TaskService taskService) {
        try {
            System.out.println("Введите название задачи: ");
            String taskHeader = scanner.next();
            System.out.println("Введите описание задачи: ");
            String taskInfo = scanner.next();
            System.out.println("Введите дату и время в формате \"д.мм.гггг-чч:мм\": ");
            String createDateTime = scanner.next();
            LocalDateTime taskDateTime = LocalDateTime.parse(createDateTime, TASK_DATE_TIME_FORMATTER);
            Type taskType = createTaskType(scanner);
            IFrequency taskFrequency = createFrequency(scanner);
            taskService.addTask(taskHeader, taskInfo, taskDateTime, taskType, taskFrequency);
            System.out.print("Задача успешно создана!");
        } catch (Exception e) {
            System.out.print("Некорректно введены данные!");
        }
    }

    private static void removeTask(Scanner scanner, TaskService taskService) {
        try {
            printAllTasks(scanner,taskService);
            System.out.println("Введите id задачи которую хотите удалить: ");
            Integer taskId = scanner.nextInt();
            taskService.deleteTask(taskId);
            System.out.print("Задача успешно удалена!");
        } catch (NumberFormatException e) {
            System.out.print("Задан неверный id задачи!\n");
        }
    }

    private static void printMenu() {
        System.out.println(
                "\n1.Добавить задачу\n" +
                        "2. Удалить задачу\n" +
                        "3. Получить задачи на указанный день\n" +
                        "4. Получить все задачи\n" +
                        "0. Выход\n"

        );
    }

    private static Type createTaskType(Scanner scanner) {
        System.out.println("Выберите тип задачи\n 1. Личная\n 2.Рабочая");
        while (true) {
            System.out.println("Введите тип задачи: ");
            String typeSelection = scanner.next();
            switch (typeSelection) {
                case "1":
                    return Type.PERSONAL_TASK;
                case "2":
                    return Type.WORKING_TASK;
                default:
                    System.out.print("Введен неправильный тип задачи!");
                    break;
            }
        }
    }

    private static IFrequency createFrequency(Scanner scanner) {
        System.out.println("Выберите тип повтора\n 1. Однократная\n 2.Ежедневная\n " +
                "3.Еженедельная\n 4.Ежемесячная\n 5.Ежегодная");
        while (true) {
            System.out.println("Введите тип повтора: ");
            String frequencySelection = scanner.next();
            switch (frequencySelection) {
                case "1":
                    return new OneTimeFrequency();
                case "2":
                    return new EveryDayFrequency();
                case "3":
                    return new EveryWeekFrequency();
                case "4":
                    return new EveryMonthFrequency();
                case "5":
                    return new EveryYearFrequency();
                default:
                    System.out.println("Введен неправильный тип повтора!");
                    break;
            }
        }
    }

    private static void getTasksForDate(Scanner scanner, TaskService taskService) {
        try {
            System.out.println("Введите дату на которую хотите получить задачи(д.мм.гггг): ");
            String createDate = scanner.next();
            LocalDate wantedDate = LocalDate.parse(createDate, TASK_DATE_FORMATTER);
            taskService.allTasksForDate(wantedDate);
        } catch (Exception e) {
            System.out.print("Некорректно введены данные!");
        }
    }

    private static void printAllTasks(Scanner scanner, TaskService taskService) {
        System.out.println("Полный список задач: ");
        taskService.allTask();
    }

}