package example.org;

import java.sql.SQLOutput;
import java.util.*;
import java.time.LocalTime;
public class Main {
    public static void Task1(){
        Scanner sc = new Scanner(System.in);
        int choose;
        int numAdd;
        int indRemove;
        int numCheck;
        int indSet;
        int numSet;
        System.out.println("Введи числа через пробіл:");
        String nums = sc.nextLine();

        List<Integer> numbers = Arrays.stream(nums.split(" "))
                .map(Integer::parseInt)
                .toList();

        while (true) {

            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Додати число");
            System.out.println("2 - Видалити по індексу");
            System.out.println("3 - Показати список");
            System.out.println("4 - Перевірити чи є число");
            System.out.println("5 - Замінити по індексу");
            System.out.println("6 - Вийти");
            System.out.print("Вибір: ");

            choose = sc.nextInt();

            switch (choose) {

                case 1:
                    System.out.print("Введи число для додавання: ");
                    numAdd = sc.nextInt();
                    numbers.add(numAdd);
                    break;

                case 2:
                    System.out.print("Введи індекс для видалення: ");
                    indRemove = sc.nextInt();
                    numbers.remove(indRemove);
                    break;

                case 3:
                    System.out.println("Список: " + numbers);
                    break;

                case 4:
                    System.out.print("Введи число для перевірки: ");
                    numCheck = sc.nextInt();
                    System.out.println(numbers.contains(numCheck));
                    break;

                case 5:
                    System.out.print("Введи індекс: ");
                    indSet = sc.nextInt();
                    System.out.print("Введи нове значення: ");
                    numSet = sc.nextInt();
                    numbers.set(indSet, numSet);
                    break;

                case 6:
                    System.out.println("Вихід...");
                    return;

                default:
                    System.out.println("Невірний вибір!");
            }
        }
    }
    public static void Task2(){
        Scanner sc = new Scanner(System.in);
        int choose;
        String login;
        String password;
        String newLogin;
        String newPassword;

        Map<String, String> map = new HashMap<>();
        while (true){
            System.out.println("\n=== МЕНЮ ===");
            System.out.println("1 - Додати користувача");
            System.out.println("2 - Видалити користувача");
            System.out.println("3 - Перевірити чи є користувача");
            System.out.println("4 - Замінити логін");
            System.out.println("5 - Замінити пароль");
            System.out.println("6 - Вийти");
            System.out.print("Вибір: ");

            choose = sc.nextInt();
            sc.nextLine();
            switch (choose){
                case 1:
                    System.out.print("Введи логін: ");
                    login = sc.nextLine();
                    System.out.println("Введи пароль: ");
                    password = sc.nextLine();
                    map.put(login, password);
                    break;
                case 2:
                    System.out.print("Введи логін: ");
                    login = sc.nextLine();
                    map.remove(login);
                    break;
                case 3:
                    System.out.print("Введи логін: ");
                    login = sc.nextLine();
                    System.out.println(map.containsKey(login));
                    break;
                case 4:
                    System.out.print("Введи логін: ");
                    login = sc.nextLine();

                    System.out.print("Введи новий логін: ");
                    newLogin = sc.nextLine();

                    if (map.containsKey(login)) {
                        String value = map.remove(login);
                        map.put(newLogin, value);
                    }
                    break;
                case 5:
                    System.out.print("Введи логін: ");
                    login = sc.nextLine();
                    System.out.print("Введи новий пароль: ");
                    newPassword = sc.nextLine();
                    map.put(login, newPassword);
                    break;
                case 6:
                    return;



            }
        }
    }
    public static void Task3(){
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Clients> requestQueue = new PriorityQueue<>((a, b) -> b.getPriority() - a.getPriority());
        Queue<String> logQueue = new ArrayDeque<>();
        while (true) {

            System.out.println("\n1 - Додати клієнта");

            System.out.println("2 - Обробити запит");

            System.out.println("3 - Показати лог");

            System.out.println("4 - Вихід");

            System.out.print("Вибір: ");

            int choice = sc.nextInt();

            sc.nextLine();

            switch (choice) {

                case 1:

                    System.out.print("Ім'я клієнта: ");

                    String name = sc.nextLine();

                    System.out.print("Пріоритет (1-10): ");

                    int priority = sc.nextInt();

                    sc.nextLine();

                    requestQueue.add(new Clients(name, priority));

                    System.out.println("Клієнт доданий");

                    break;

                case 2:

                    if (requestQueue.isEmpty()) {

                        System.out.println("Черга пуста");

                        break;

                    }

                    Clients client = requestQueue.poll();

                    String log = "User: " + client.getName() +

                            ", Priority: " + client.getPriority() +

                            ", Time: " + LocalTime.now();

                    logQueue.add(log);

                    System.out.println("Оброблено: " + log);

                    break;

                case 3:

                    System.out.println("\n=== LOGS ===");

                    for (String l : logQueue) {

                        System.out.println(l);

                    }

                    break;

                case 4:

                    return;

            }

        }

    }

    public static void main(String [] args){

        Task1();
        Task2();
        Task3();
    }



}
