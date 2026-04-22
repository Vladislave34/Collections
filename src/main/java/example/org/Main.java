package example.org;


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


        static double SIMULATION_TIME = 24 * 60; // 24 години (в хвилинах)

        static int MAX_QUEUE_LIMIT = 50;

        static Random random = new Random();

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            System.out.println("Введіть середній час між пасажирами (хв): ");

            double passengerMean = scanner.nextDouble();

            System.out.println("Введіть середній час між катерами (хв): ");

            double boatMean = scanner.nextDouble();

            System.out.println("Тип зупинки (1 - кінцева, 0 - проміжна): ");

            int stopType = scanner.nextInt();

            runSimulation(passengerMean, boatMean, stopType);

        }

        static void runSimulation(double passengerMean, double boatMean, int stopType) {

            Queue<Passenger> queue = new LinkedList<>();

            double currentTime = 0;

            double nextPassenger = getNextTime(passengerMean);

            double nextBoat = getNextTime(boatMean);

            double totalWaitTime = 0;

            int served = 0;

            int maxQueue = 0;

            while (currentTime < SIMULATION_TIME) {

                if (nextPassenger < nextBoat) {

                    currentTime = nextPassenger;

                    queue.add(new Passenger(currentTime));

                    maxQueue = Math.max(maxQueue, queue.size());

                    nextPassenger += getNextTime(passengerMean);

                } else {

                    currentTime = nextBoat;

                    int seats = getRandomSeats(stopType);

                    while (seats > 0 && !queue.isEmpty()) {

                        Passenger p = queue.poll();

                        totalWaitTime += (currentTime - p.arrivalTime);

                        served++;

                        seats--;

                    }

                    nextBoat += getNextTime(boatMean);

                }

            }

            // Результати

            System.out.println("\n===== РЕЗУЛЬТАТИ =====");

            if (served > 0) {

                System.out.println("Середній час очікування: " + (totalWaitTime / served) + " хв");

            } else {

                System.out.println("Немає обслужених пасажирів");

            }

            System.out.println("Максимальна черга: " + maxQueue);



            findOptimalBoatInterval(passengerMean);

        }

        // Експоненційний розподіл

        static double getNextTime(double mean) {

            return -mean * Math.log(1 - random.nextDouble());

        }

        // Випадкова кількість місць

        static int getRandomSeats(int stopType) {

            if (stopType == 1) {

                return 20 + random.nextInt(30); // 20–50 (кінцева)

            } else {

                return 5 + random.nextInt(20);  // 5–25 (проміжна)

            }

        }

        // Пошук інтервалу катерів

        static void findOptimalBoatInterval(double passengerMean) {

            System.out.println("\n===== ПІДБІР ІНТЕРВАЛУ =====");

            for (double boatMean = 1; boatMean <= 60; boatMean += 1) {

                Queue<Passenger> queue = new LinkedList<>();

                double currentTime = 0;

                double nextPassenger = getNextTime(passengerMean);

                double nextBoat = getNextTime(boatMean);

                int maxQueue = 0;

                while (currentTime < SIMULATION_TIME) {

                    if (nextPassenger < nextBoat) {

                        currentTime = nextPassenger;

                        queue.add(new Passenger(currentTime));

                        maxQueue = Math.max(maxQueue, queue.size());

                        nextPassenger += getNextTime(passengerMean);

                    } else {

                        currentTime = nextBoat;

                        int seats = 20 + random.nextInt(30);

                        while (seats > 0 && !queue.isEmpty()) {

                            queue.poll();

                            seats--;

                        }

                        nextBoat += getNextTime(boatMean);

                    }

                }

                if (maxQueue <= MAX_QUEUE_LIMIT) {

                    System.out.println("Оптимальний інтервал: " + boatMean + " хв (макс черга = " + maxQueue + ")");

                    return;

                }

            }

            System.out.println("Не знайдено інтервалу для обмеження черги");

        }





}
