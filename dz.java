import java.util.*;

public class PhoneBook {
    private static Map<String, Set<String>> phoneBook = new HashMap<>();
    
    private static Scanner scanner = new Scanner(System.in);
  
    private static void displayItems() {
        if (phoneBook.isEmpty()) {
            System.out.println("\nТелефонная книга пуста.\n");
        } else {
            List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
            sortedEntries.sort((entry1, entry2) -> Integer.compare(entry2.getValue().size(), entry1.getValue().size()));
            hr();
            System.out.println("Записи в телефонной книге:\n");
            for (Map.Entry<String, Set<String>> entry : sortedEntries) {
                System.out.println(entry.getKey() + ": " + entry.getValue());
            }
        }
        waitEnter();
    }

    private static void addItem() {
        hr();
        System.out.print("ДОБАВЛЕНИЕ ЗАПИСИ\n\n");
        System.out.print("Введите имя: ");
        String name = scanner.nextLine();
        System.out.print("Введите номер телефона: ");
        String phoneNumber = scanner.nextLine();
        phoneBook.computeIfAbsent(name, k -> new HashSet<>()).add(phoneNumber);
        System.out.println("\nЗапись добавлена: " + name + ": " + phoneNumber);
        waitEnter();
    }
    
    private static void waitEnter() {
        System.out.print("\nНажмите ENTER и продолжим... ");
        scanner.nextLine();
        clearConsole();
    }
    private static void hr() {
        System.out.println("\n********************************");
    }
    public static void clearConsole() {
        for (int i = 0; i < 20; i++) {
            System.out.println();
        }
    }
    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            hr();
            System.out.println("Телефонная книга:\n");
            System.out.println("1. Просмотреть записи");
            System.out.println("2. Добавить запись");
            System.out.println("3. Выйти");
            System.out.print("\nВыберите действие: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            clearConsole();

            switch (choice) {
                case 1:
                    displayItems();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    running = false;
                    break;
                default:
                    System.out.println("\nЗапрос не правильный! Попробуйте снова.\n");
            }
        }
        System.out.println("\nРабота приложения завершена.\n");
    }
}
